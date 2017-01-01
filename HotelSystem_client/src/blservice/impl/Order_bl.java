package blservice.impl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import PO.CustomerPO;
import PO.HotelPO;
import PO.OrderPO;
import PO.RoomPO;
import RMI.RemoteHelper;
import VO.HotelRoomInfoVO;
import VO.LogofUserVO;
import VO.OrderVO;
import VO.SystemStrategyVO;
import VO.VipVO;
import blservice.LogOfUser_blServce;
import blservice.Order_blservice;
import blservice.Room_blService;
import blservice.SystemStrategy_blservice;
import blservice.VipStrategy_blService;
import data.service.CustomerDataService;
import data.service.HotelDataService;
import data.service.OrderDataService;
import other.OrderState;
import other.RoomType;
import other.StrategyState;

public class Order_bl implements Order_blservice {

	OrderDataService dataService = RemoteHelper.getInstance().getOrderDataService();
	HotelDataService hotelDataService = RemoteHelper.getInstance().getHotelDataService();
	CustomerDataService customerDataService = RemoteHelper.getInstance().getCustomerDataService();
	VipStrategy_blService vipService = new VipStrategy_blServiceImpl();
	LogOfUser_blServce logOfUser_blServce = new LogOfUser_blServceImpl();
	SystemStrategy_blservice systemStrategyService = new SystemStrategy_bl();

	/**
	 * @param 订单的id
	 * @return 订单的状态
	 */
	public OrderState getState(String orderID) {
		try {
			OrderPO orderPO = dataService.findorder(orderID);
			this.orderManagementHook();
			return orderPO.getStatus();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param 订单id
	 * @return 订单的信息
	 */
	public OrderVO getOrder(String orderID) {
		try {
			OrderPO orderPO = dataService.findorder(orderID);
			this.orderManagementHook();
			OrderVO orderVO = new OrderVO(orderPO);
			return orderVO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param 用户id
	 * @return 用户的所有订单信息
	 */
	public ArrayList<OrderVO> getOrdersOfUsers(String userID) {
		ArrayList<OrderVO> voList = new ArrayList<OrderVO>();
		this.orderManagementHook();
		try {
			ArrayList<OrderPO> poList = (ArrayList<OrderPO>) dataService.findOrders(userID, "customer");

			for (OrderPO po : poList) {
				voList.add(new OrderVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return voList;
	}

	/**
	 * @param 用户id
	 * 
	 * @return 用户未完成的所有订单信息
	 */
	public ArrayList<OrderVO> getUnfinishedOrders(String userID) {
		ArrayList<OrderVO> voList = getOrdersOfUsers(userID);
		ArrayList<OrderVO> UnfinishedVoList = new ArrayList<OrderVO>();

		for (OrderVO vo : voList) {
			if (vo.getOrderState() != null && vo.getOrderState().equals(OrderState.UNFINISHED))
				UnfinishedVoList.add(vo);
		}
		return UnfinishedVoList;
	}

	/**
	 * @param 用户id
	 * 
	 * @return 用户所有的异常订单信息
	 */
	public ArrayList<OrderVO> getAbnomalOrders(String userID) {
		ArrayList<OrderVO> voList = getOrdersOfUsers(userID);
		ArrayList<OrderVO> abnomalVoList = new ArrayList<OrderVO>();

		for (OrderVO vo : voList) {
			if (vo.getOrderState() != null && vo.getOrderState().equals(OrderState.ABNOMAL))
				abnomalVoList.add(vo);
		}
		return abnomalVoList;
	}

	/**
	 * @param 订单信息
	 * 
	 * @return 修改订单的状态
	 */
	public boolean changeState(OrderVO order_info) {
		try {
			boolean b = dataService.update(new OrderPO(order_info));
			this.changeCredit(order_info.getUserID(), order_info.getOrderID());
			this.changeRoomRemain(order_info.getOrderID());
			return b;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 订单执行时修改酒店客房剩余数量方法
	 * 
	 * @param order_info
	 */
	private void changeRoomRemain(String orderID) {

		OrderVO order = this.getOrder(orderID);
		Room_blService roomService = new Room_blServiceImpl();
		ArrayList<HotelRoomInfoVO> roomInfo = roomService.getAllRoom(order.getHotelID());
		HotelRoomInfoVO roomVO = null;
		RoomType type = order.getRoomType();
		int num = order.getRoomNum();
		int remain = 0;
		if (type.equals(RoomType.doublePersonRoom)) {
			roomVO = roomInfo.get(0);
		} else if (type.equals(RoomType.bigBedRoom)) {
			roomVO = roomInfo.get(1);
		} else if (type.equals(RoomType.singlePersonRoom)) {
			roomVO = roomInfo.get(2);
		} else if (type.equals(RoomType.multiPersonRoom)) {
			roomVO = roomInfo.get(3);
		}
		remain = roomVO.getRoomRemain() + num;
		roomVO.setRoomRemain(remain);

		if (order.getOrderState() != null && order.getOrderState() == OrderState.ABNOMAL) {
			roomService.modify(roomVO);
		} else if (order.getOrderState() == OrderState.FINISHED) {
			roomService.modify(roomVO);
		} else if (order.getOrderState() == OrderState.REVACATION) {
			roomService.modify(roomVO);
		}
	}

	/**
	 * @param 订单信息
	 * 
	 * @return 是否生成订单
	 */

	// 生成用户的订单
	public boolean generateOrder(OrderVO order) {
		try {
			// 修改酒店剩余客房数量
			{
				Room_blService roomservice = new Room_blServiceImpl();
				ArrayList<HotelRoomInfoVO> roominfo = roomservice.getAllRoom(order.getHotelID());
				RoomType type = order.getRoomType();
				int num = order.getRoomNum();
				int index = 0;
				if (type.equals(RoomType.doublePersonRoom)) {
					index = 0;
				}
				if (type.equals(RoomType.bigBedRoom)) {
					index = 1;
				}
				if (type.equals(RoomType.singlePersonRoom)) {
					index = 2;
				}
				if (type.equals(RoomType.multiPersonRoom)) {
					index = 3;
				}
				int remainBefore = roominfo.get(index).getRoomRemain();
				int remainAfter = remainBefore - num;
				roominfo.get(index).setRoomRemain(remainAfter);
				roomservice.modify(roominfo.get(index));
			}
			return dataService.add(new OrderPO(order));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 通过输入订单中所属酒店的名称
	 * 
	 * @return 所有酒店中含有该字段的订单信息
	 */
	public ArrayList<OrderVO> getOrderFromInput(String text) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) this.getAllOrders();
			for (OrderPO po : orderPOs) {
				String hotelID = po.getHotelId();
				HotelPO hotelPO = hotelDataService.find(hotelID);
				String hotelName = hotelPO.getHotelName();

				if (hotelName.equals(text)) {
					orderVOs.add(new OrderVO(po));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	/**
	 * @param 酒店id
	 * 
	 * @return 今日的所有的订单信息
	 */
	public ArrayList<OrderVO> getOrderOfToday(String hotelId) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> allOrders = (ArrayList<OrderPO>) this.getAllOrders();
			for (OrderPO po : allOrders) {
				LocalDate date = LocalDate.now();
				if (po.getHotelId().equals(hotelId) && po.getEntryTime().equals(date)) {
					orderVOs.add(new OrderVO(po));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	/**
	 * @param 酒店id
	 * 
	 * @return 酒店中尚未执行的订单
	 */
	public ArrayList<OrderVO> getHotelUndoOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) this.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus() != null && po.getStatus().equals(OrderState.UNFINISHED))
					if (po.getHotelId().equals(hotelID)) {
						orderVOs.add(new OrderVO(po));
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	/**
	 * @param 酒店id
	 * 
	 * @return 酒店中所有的异常订单的信息
	 */
	public ArrayList<OrderVO> getHotelAbnormalOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) this.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus() != null && po.getStatus().equals(OrderState.ABNOMAL)) {
					if (po.getHotelId().equals(hotelID))
						orderVOs.add(new OrderVO(po));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	/**
	 * @param 酒店id
	 * 
	 * @return 返回酒店已经完成的订单信息
	 */
	public ArrayList<OrderVO> getHotelFinishedOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) this.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus() != null
						&& (po.getStatus().equals(OrderState.FINISHED) || po.getStatus().equals(OrderState.ASSESSED))) {
					if (po.getHotelId().equals(hotelID))

						orderVOs.add(new OrderVO(po));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	/**
	 * 修改用户信用值方法
	 * 
	 * @param
	 */
	public boolean changeCredit(String userID, String orderID) {
		CustomerPO customer = null;
		OrderPO order = null;
		try {
			customer = customerDataService.findCustomer(userID);
			order = dataService.findorder(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		int credit = 0;
		if (order.getStatus() == OrderState.ABNOMAL) {
			credit = customer.getCredit() - (int) (order.getPrice() / 2);
		} else if (order.getStatus() == OrderState.FINISHED) {
			credit = customer.getCredit() + (int) (order.getPrice() * 0.5);
		} else if (order.getStatus() == OrderState.REVACATION) {
			credit = customer.getCredit() - (int) (order.getPrice() * 0.5);
		} else {
			credit = customer.getCredit();
		}
		customer.setCredit(credit);
		try {
			customerDataService.updateCustomer(customer);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * @param userID
	 * @param orderID
	 * @return 恢复用户订单信用值的一半
	 */
	public boolean addHalfOfOrginalCredit(String userID, String orderID) {

		OrderPO order = null;
		CustomerPO customer = null;
		try {
			customer = customerDataService.findCustomer(userID);
			order = dataService.findorder(orderID);
			order = dataService.findorder(orderID);
			LogofUserVO logofUserVO = new LogofUserVO();
			logofUserVO.setChange((int) (order.getPrice() / 4));
			logofUserVO.setContent("成功撤销订单号为 " + orderID + " 的订单");
			logofUserVO.setUserid(userID);
			logofUserVO.setDateTime(LocalDateTime.now());
			logOfUser_blServce.addLogOfUser(logofUserVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		int a = (int) (order.getPrice() / 4);
		customer.setCredit(customer.getCredit() + a);
		try {
			customerDataService.updateCustomer(customer);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @param 订单的信息
	 * 
	 * @return 得到订单的原始价格
	 */
	public String getOrderOriginalPrice(OrderVO order) {
		String hotelId = order.getHotelID();
		String price = new String();
		double oprice = 0;
		try {
			ArrayList<RoomPO> roomPOs = RemoteHelper.getInstance().getRoomDataService().getAllRoomPO(hotelId);
			for (RoomPO po : roomPOs) {
				if (po.getType() == order.getRoomType()) {
					oprice = po.getPrice() * order.getRoomNum() * order.getLastime();
				}
			}
			price = String.valueOf(oprice);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return price;
	}

	/**
	 * @param 订单信息
	 * 
	 * @return 获得订单享受折扣之后的价格
	 */
	public String getOrderPrice(OrderVO order) {
		String hotelId = order.getHotelID();
		String price = new String();
		double oprice = 0;
		try {
			ArrayList<RoomPO> roomPOs = RemoteHelper.getInstance().getRoomDataService().getAllRoomPO(hotelId);
			for (RoomPO po : roomPOs) {
				if (po.getType() == order.getRoomType()) {
					oprice = po.getPrice() * order.getRoomNum() * order.getLastime();
				}
			}
			ArrayList<SystemStrategyVO> systemStrategyVOs = this.systemStrategyService.getAllSystemStrategys();
			ArrayList<VipVO> vipVOs = vipService.getVipStrategy().getVipStrategyVOList();
			int credit = customerDataService.findCustomer(order.getUserID()).getCredit();
			double discount_vip = 10;

			// 节日优惠和其他优惠参与计算
			for (SystemStrategyVO strategyVO : systemStrategyVOs) {
				LocalDate today = order.getEntryTime();
				if (today != null) {
					if (strategyVO.getBegin_date() != null && strategyVO.getStrategyState() != null
							&& strategyVO.getEnd_date() != null) {
						if ((strategyVO.getBegin_date().isEqual(today) || strategyVO.getBegin_date().isBefore(today))
								&& (strategyVO.getEnd_date().isEqual(today) || strategyVO.getEnd_date().isAfter(today))
								&& strategyVO.getStrategyState().equals(StrategyState.open)) {
							if (strategyVO.getDiscount() < discount_vip) {
								discount_vip = strategyVO.getDiscount();
							}
						}
					}
				}
			}
			// 会员优惠参与计算
			for (VipVO vipvo : vipVOs) {
				if (credit <= vipvo.getMaxcredit() && credit > vipvo.getMincredit()) {
					if (vipvo.getDiscount() < discount_vip)
						discount_vip = vipvo.getDiscount();
				}
			}
			oprice = oprice * discount_vip / 10;
			price = String.valueOf(oprice);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return price;
	}

	/**
	 * 为网站营销人员实现获得全部的异常订单
	 */
	public ArrayList<OrderVO> getAllAbnormalOrders() {
		ArrayList<OrderVO> abnormalOrders = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = this.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus() == OrderState.ABNOMAL) {
					abnormalOrders.add(new OrderVO(po));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return abnormalOrders;
	}

	/**
	 * 封装了hook的getAll方法
	 * 
	 * @return
	 */
	private ArrayList<OrderPO> getAllOrders() {
		ArrayList<OrderPO> list = null;
		try {
			list = dataService.getAllOrders();
			this.orderManagementHook();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * hook方法，每当调用order数据库的时候检查当天订单的完成情况，将本来昨天应当执行却未被执行的订单设置为异常
	 */
	private void orderManagementHook() {
		ArrayList<OrderPO> list = null;
		try {
			list = dataService.getAllOrders();
			LocalDate entryTime = null;
			LocalDate today = LocalDate.now();
			OrderPO order = null;
			for (int i = 0; i < list.size(); i++) {
				order = list.get(i);
				entryTime = order.getEntryTime();
				// 到达日期在今天之前的订单
				if (entryTime != null && entryTime.isBefore(today)) {
					// 且还未被执行的订单
					if (order.getStatus() != null && order.getStatus().equals(OrderState.UNFINISHED)) {
						// 调用更改订单状态的方法，修改为异常订单
						OrderVO VO = new OrderVO(order);
						VO.setOrderState(OrderState.ABNOMAL);
						this.changeState(VO);
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean changeStateBySystemStaff(OrderVO order_info) {
		try {
			boolean b = dataService.update(new OrderPO(order_info));
			this.changeCreditBySystemStaff(order_info.getUserID(), order_info.getOrderID());
			this.changeRoomRemain(order_info.getOrderID());
			return b;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean changeCreditBySystemStaff(String userID, String orderID) {
		CustomerPO customer = null;
		OrderPO order = null;
		try {
			customer = customerDataService.findCustomer(userID);
			order = dataService.findorder(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		int credit = 0;
		if (order.getStatus() == OrderState.ABNOMAL) {
			credit = customer.getCredit() - (int) (order.getPrice() / 2);
		} else if (order.getStatus() == OrderState.FINISHED) {
			credit = customer.getCredit() + (int) (order.getPrice() * 0.5);
		} else if (order.getStatus() == OrderState.REVACATION) {
			credit = customer.getCredit() + (int) (order.getPrice() * 0.5);
		} else {
			credit = customer.getCredit();
		}
		customer.setCredit(credit);
		try {
			customerDataService.updateCustomer(customer);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<OrderVO> getRevocationOrder(String hotelId) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) this.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus() != null && po.getStatus().equals(OrderState.REVACATION)) {
					if (po.getHotelId().equals(hotelId))
						orderVOs.add(new OrderVO(po));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	@Override
	public ArrayList<OrderVO> getTodayUnfinishedOrders() {
		ArrayList<OrderVO> todayOrders = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = dataService.getAllOrders();
			for (OrderPO po:orderPOs) {
				if (po.getGretime().equals(LocalDate.now())&&po.getStatus()==OrderState.UNFINISHED) {
					todayOrders.add(new OrderVO(po));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return todayOrders;
	}
}
