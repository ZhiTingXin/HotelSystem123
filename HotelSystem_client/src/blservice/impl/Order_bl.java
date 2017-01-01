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
import VO.VipVO;
import blservice.LogOfUser_blServce;
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
	LogOfUser_blServce logOfUser_blServce = new LogOfUser_blServceImpl();

	/**
	 * @param ������id
	 * @return ������״̬
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
	 * @param ����id
	 * @return ��������Ϣ
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
	 * @param �û�id
	 * @return �û������ж�����Ϣ
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
	 * @param �û�id
	 * 
	 * @return �û�δ��ɵ����ж�����Ϣ
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
	 * @param �û�id
	 * 
	 * @return �û����е��쳣������Ϣ
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
	 * @param ������Ϣ
	 * 
	 * @return �޸Ķ�����״̬
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
	 * ����ִ��ʱ�޸ľƵ�ͷ�ʣ����������
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
	 * @param ������Ϣ
	 * 
	 * @return �Ƿ����ɶ���
	 */

	// �����û��Ķ���
	public boolean generateOrder(OrderVO order) {
		try {
			// �޸ľƵ�ʣ��ͷ�����
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
	 * @param ͨ�����붩���������Ƶ������
	 * 
	 * @return ���оƵ��к��и��ֶεĶ�����Ϣ
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
	 * @param �Ƶ�id
	 * 
	 * @return ���յ����еĶ�����Ϣ
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
	 * @param �Ƶ�id
	 * 
	 * @return �Ƶ�����δִ�еĶ���
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
	 * @param �Ƶ�id
	 * 
	 * @return �Ƶ������е��쳣��������Ϣ
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
	 * @param �Ƶ�id
	 * 
	 * @return ���ؾƵ��Ѿ���ɵĶ�����Ϣ
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
	 * �޸��û�����ֵ����
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
	 * @return �ָ��û���������ֵ��һ��
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
			logofUserVO.setContent("�ɹ�����������Ϊ " + orderID + " �Ķ���");
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
	 * @param ��������Ϣ
	 * 
	 * @return �õ�������ԭʼ�۸�
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
	 * @param ������Ϣ
	 * 
	 * @return ��ö��������ۿ�֮��ļ۸�
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
	 * Ϊ��վӪ����Աʵ�ֻ��ȫ�����쳣����
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
	 * ��װ��hook��getAll����
	 * 
	 * @return
	 */
	private ArrayList<OrderPO> getAllOrders() {
		ArrayList<OrderPO> list = null;
		try {
			list = dataService.getAllOrders();
			this.orderManagementHook();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * hook������ÿ������order���ݿ��ʱ���鵱�충����������������������Ӧ��ִ��ȴδ��ִ�еĶ�������Ϊ�쳣
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
				// ���������ڽ���֮ǰ�Ķ���
				if (entryTime != null && entryTime.isBefore(today)) {
					// �һ�δ��ִ�еĶ���
					if (order.getStatus() != null && order.getStatus().equals(OrderState.UNFINISHED)) {
						// ���ø��Ķ���״̬�ķ������޸�Ϊ�쳣����
						OrderVO VO = new OrderVO(order);
						VO.setOrderState(OrderState.ABNOMAL);
						this.changeState(VO);
					}
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean changeStateBySystemStaff(OrderVO order_info) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
}
