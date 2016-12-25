package blservice.impl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import PO.CustomerPO;
import PO.HotelPO;
import PO.OrderPO;
import PO.RoomPO;
import RMI.RemoteHelper;
import VO.HotelRoomInfoVO;
import VO.OrderVO;
import VO.VipVO;
import blservice.Order_blservice;
import blservice.Room_blService;
import blservice.VipStrategy_blService;
import data.service.CustomerDataService;
import data.service.HotelDataService;
import data.service.OrderDataService;
import other.OrderState;
import other.RoomType;

public class Order_bl implements Order_blservice {

	OrderDataService dataService = RemoteHelper.getInstance().getOrderDataService();
	HotelDataService hotelDataService = RemoteHelper.getInstance().getHotelDataService();
	CustomerDataService customerDataService = RemoteHelper.getInstance().getCustomerDataService();
	VipStrategy_blService vipService = new VipStrategy_blServiceImpl();

	/**
	 * @param 订单的id
	 * @return 订单的状态
	 */
	public OrderState getState(String orderID) {
		try {
			OrderPO orderPO = dataService.findorder(orderID);
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
			OrderVO orderVO = new OrderVO(orderPO);
			return orderVO;
		} catch (RemoteException e) {
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
	public void changeRoomRemain(String orderID) {
		// TODO Auto-generated method stub
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
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) dataService.getAllOrders();
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
			ArrayList<OrderPO> allOrders = (ArrayList<OrderPO>) dataService.getAllOrders();
			for (OrderPO po : allOrders) {
				LocalDate date = LocalDate.now();
				if (po.getHotelId().equals(hotelId) && po.getEntryTime().equals(date)) {
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
	 * @return 酒店中尚未执行的订单
	 */
	public ArrayList<OrderVO> getHotelUndoOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) dataService.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus() != null && po.getStatus().equals(OrderState.UNFINISHED))
					if (po.getHotelId().equals(hotelID)) {
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
	 * @return 酒店中所有的异常订单的信息
	 */
	public ArrayList<OrderVO> getHotelAbnormalOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) dataService.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus() != null && po.getStatus().equals(OrderState.ABNOMAL)) {
					if (po.getHotelId().equals(hotelID))
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
	 * @return 返回酒店已经完成的订单信息
	 */
	public ArrayList<OrderVO> getHotelFinishedOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) dataService.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus() != null
						&& (po.getStatus().equals(OrderState.FINISHED) || po.getStatus().equals(OrderState.ASSESSED))) {
					if (po.getHotelId().equals(hotelID))

						orderVOs.add(new OrderVO(po));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	// TODO 还没用确定具体的方法
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
		if (order.getStatus() != null && order.getStatus() == OrderState.ABNOMAL) {
			credit = customer.getCredit() - (int) (order.getPrice());
		} else if (order.getStatus() == OrderState.FINISHED) {
			credit = customer.getCredit() + (int) (order.getPrice() * 0.5);
		} else if (order.getStatus() == OrderState.ASSESSED) {
			credit = customer.getCredit() + (int) (order.getPrice() * 0.5);
		} else if (order.getStatus() == OrderState.REVACATION) {
			credit = customer.getCredit() - (int) (order.getPrice() * 0.5);
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

	// TODO
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
					oprice = po.getPrice() * order.getRoomNum()*order.getLastime();
				}
			}

			ArrayList<VipVO> vipVOs = vipService.getVipStrategy().getVipStrategyVOList();
			int credit = customerDataService.findCustomer(order.getUserID()).getCredit();
			double discount_vip = 1;
			for (VipVO vipvo : vipVOs) {
				if (credit <= vipvo.getMaxcredit() && credit > vipvo.getMincredit()) {
					discount_vip = vipvo.getDiscount();
				}
			}
			oprice = oprice * discount_vip;
			price = String.valueOf(oprice);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return price;
	}

	/**
	 * @param 酒店id
	 * @return 返回酒店的所有的订单信息
	 */
	public ArrayList<OrderVO> getAllOrders(String hotelId) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = dataService.getAllHotelOrders(hotelId);
			for (OrderPO po : orderPOs) {
				orderVOs.add(new OrderVO(po));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	// TODO 可以告诉我为什么方法的实现是一样的吗
	public ArrayList<OrderVO> getAllHotelOrders(String hotelid) {
		ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderPOs = dataService.getAllHotelOrders(hotelid);
			for (OrderPO po : orderPOs) {
				orderVOs.add(new OrderVO(po));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

}
