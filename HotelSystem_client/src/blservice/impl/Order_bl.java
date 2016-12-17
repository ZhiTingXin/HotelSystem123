package blservice.impl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import PO.CustomerPO;
import PO.HotelPO;
import PO.OrderPO;
import PO.RoomPO;
import RMI.RemoteHelper;
import VO.OrderVO;
import VO.VipVO;
import blservice.Order_blservice;
import blservice.VipStrategy_blService;
import data.service.CustomerDataService;
import data.service.HotelDataService;
import data.service.OrderDataService;
import other.OrderState;

public class Order_bl implements Order_blservice {
	OrderDataService dataService = RemoteHelper.getInstance().getOrderDataService();
	HotelDataService hotelDataService = RemoteHelper.getInstance().getHotelDataService();
	CustomerDataService customerDataService = RemoteHelper.getInstance().getCustomerDataService();
	VipStrategy_blService vipService = new VipStrategy_blServiceImpl();

	public OrderState getState(String orderID) {
		try {
			OrderPO orderPO = dataService.findorder(orderID);
			return orderPO.getStatus();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

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

	public ArrayList<OrderVO> getOrdersOfUsers(String userID) {

		try {
			ArrayList<OrderPO> poList = (ArrayList<OrderPO>) dataService.findOrders(userID, "customer");
			ArrayList<OrderVO> voList = new ArrayList<OrderVO>();

			for (OrderPO po : poList) {
				voList.add(new OrderVO(po));
			}

			return voList;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean changeState(OrderPO order_info) {
		try {
			return dataService.update(order_info);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<OrderVO> getUnfinishedOrders(String userID) {
		ArrayList<OrderVO> voList = getOrdersOfUsers(userID);
		ArrayList<OrderVO> UnfinishedVoList = new ArrayList<OrderVO>();

		for (OrderVO vo : voList) {
			if (vo.getOrderState().equals(OrderState.UNFINISHED))
				UnfinishedVoList.add(vo);
		}
		return UnfinishedVoList;
	}

	public ArrayList<OrderVO> getAbnomalOrders(String userID) {
		ArrayList<OrderVO> voList = getOrdersOfUsers(userID);
		ArrayList<OrderVO> abnomalVoList = new ArrayList<OrderVO>();

		for (OrderVO vo : voList) {
			if (vo.getOrderState().equals(OrderState.UNFINISHED))
				abnomalVoList.add(vo);
		}
		return abnomalVoList;
	}

	public boolean changeState(OrderVO order_info) {
		try {
			return dataService.update(new OrderPO(order_info));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean generateOrder(OrderVO order) {
		try {
			return dataService.add(new OrderPO(order));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<OrderVO> getOrderFromInput(String text) {
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
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

	@Override
	public ArrayList<OrderVO> getOrderOfToday(String hotelId) {
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
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

	@Override
	public ArrayList<OrderVO> getHotelUndoOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) dataService.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus().equals(OrderState.UNFINISHED))
					orderVOs.add(new OrderVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	@Override
	public ArrayList<OrderVO> getHotelAbnormalOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) dataService.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus().equals(OrderState.ABNOMAL))
					orderVOs.add(new OrderVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	@Override
	public ArrayList<OrderVO> getHotelFinishedOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>) dataService.getAllOrders();
			for (OrderPO po : orderPOs) {
				if (po.getStatus().equals(OrderState.FINISHED))
					orderVOs.add(new OrderVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	// 不明确 change 什么没传
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
			credit = customer.getCredit() - (int) (order.getPrice() * 0.5);
		} else if (order.getStatus() == OrderState.FINISHED) {
			credit = customer.getCredit() + (int) (order.getPrice() * 0.5);
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
	public String getOrderOriginalPrice(OrderVO order) {
		String hotelId = order.getHotelID();
		String price = new String();
		double oprice = 0;
		try {
			ArrayList<RoomPO> roomPOs = RemoteHelper.getInstance().getRoomDataService().getAllRoomPO(hotelId);
			for (RoomPO po : roomPOs) {
				if (po.getType() == order.getRoomType()) {
					oprice = po.getPrice() * order.getRoomNum();
				}
			}
			price = String.valueOf(oprice);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return price;
	}

	@Override
	// 简单实现
	public String getOrderPrice(OrderVO order) {
		String hotelId = order.getHotelID();
		String price = new String();
		double oprice = 0;
		try {
			ArrayList<RoomPO> roomPOs = RemoteHelper.getInstance().getRoomDataService().getAllRoomPO(hotelId);
			for (RoomPO po : roomPOs) {
				if (po.getType() == order.getRoomType()) {
					oprice = po.getPrice() * order.getRoomNum();
				}
			}

			ArrayList<VipVO> vipVOs = vipService.getVipStrategy().getVipStrategyVOList();
			int credit = customerDataService.findCustomer(order.getUserID()).getCredit();
			double discount_vip = 0;
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

	@Override
	public ArrayList<OrderVO> getAllOrders(String hotelId) {
		try {
			ArrayList<OrderPO> orderPOs = dataService.getAllHotelOrders(hotelId);
			ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
			for (OrderPO po : orderPOs) {
				orderVOs.add(new OrderVO(po));
			}
			return orderVOs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<OrderVO> getAllHotelOrders(String hotelid) {
		try {
			ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
			ArrayList<OrderPO> orderPOs = dataService.getAllHotelOrders(hotelid);
			for (OrderPO po : orderPOs) {
				orderVOs.add(new OrderVO(po));
			}
			return orderVOs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
