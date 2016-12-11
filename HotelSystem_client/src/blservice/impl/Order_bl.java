package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelPO;
import PO.OrderPO;
import RMI.RemoteHelper;
import VO.OrderVO;
import blservice.Order_blservice;
import data.service.HotelDataService;
import data.service.OrderDataService;
import other.OrderState;

public class Order_bl implements Order_blservice{
	OrderDataService dataService = RemoteHelper.getInstance().getOrderDataService();
	HotelDataService hotelDataService = RemoteHelper.getInstance().getHotelDataService();
	
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
			ArrayList<OrderPO> poList = dataService.findOrders(userID, "customer");
			ArrayList<OrderVO> voList = new ArrayList<OrderVO>();
			
			for(OrderPO po : poList){
				voList.add(new OrderVO(po));
			}
			
			return voList;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean changeState(OrderPO order_info) {
		try {
			return dataService.update(order_info);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public ArrayList<OrderVO> getUnfinishedOrders(String userID) {
		ArrayList<OrderVO> voList = getOrdersOfUsers(userID);
		ArrayList<OrderVO> UnfinishedVoList = new ArrayList<OrderVO>();
		
		for(OrderVO vo : voList){
			if(vo.getOrderState().equals(OrderState.UNFINISHED))
				UnfinishedVoList.add(vo);
		}
		return UnfinishedVoList;
	}

	public ArrayList<OrderVO> getAbnomalOrders(String userID) {
		ArrayList<OrderVO> voList = getOrdersOfUsers(userID);
		ArrayList<OrderVO> abnomalVoList = new ArrayList<OrderVO>();
		
		for(OrderVO vo : voList){
			if(vo.getOrderState().equals(OrderState.UNFINISHED))
				abnomalVoList.add(vo);
		}
		return abnomalVoList;
	}

	//不明确   change 什么没传
	public boolean changeCredit(String userID, String orderID) {
		
		return false;
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
			ArrayList<OrderPO> orderPOs = dataService.getAllOrders();
			for(OrderPO po : orderPOs){
				String hotelID = po.getHotelId();
				HotelPO hotelPO = hotelDataService.find(hotelID);
				String hotelName = hotelPO.getHotelName();
				
				if(hotelName.equals(text)){
					orderVOs.add(new OrderVO(po));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return orderVOs;
	}

	@Override
	public String getOrderOriginalPrice(OrderVO order) {
		String hotelID = order.getHotelID();
		HotelPO hotelPO;
		try {
			hotelPO = hotelDataService.find(hotelID);
			String price = hotelPO.getPrice();
			return price;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	//简单实现
	public String getOrderPrice(OrderVO order, String id) {
		String hotelID = order.getHotelID();
		HotelPO hotelPO;
		try {
			hotelPO = hotelDataService.find(hotelID);
			String price = hotelPO.getPrice();
			return price;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	//今天的时间
	public ArrayList<OrderVO> getOrderOfToday(String hotelId) {
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
		try {
			ArrayList<OrderPO> allOrders = dataService.getAllOrders();
			for(OrderPO po : allOrders){
				if(po.getHotelId().equals(hotelId)&&po.getEntryTime().equals("")){
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
			ArrayList<OrderPO> orderPOs = dataService.getAllOrders();
			for (OrderPO po : orderPOs){
				if(po.getStatus().equals(OrderState.UNFINISHED))
					orderVOs.add(new OrderVO(po));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderVOs;
	}

	@Override
	public ArrayList<OrderVO> getHotelAbnormalOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
		try {
			ArrayList<OrderPO> orderPOs = dataService.getAllOrders();
			for (OrderPO po : orderPOs){
				if(po.getStatus().equals(OrderState.ABNOMAL))
					orderVOs.add(new OrderVO(po));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderVOs;
	}

	@Override
	public ArrayList<OrderVO> getHotelDoneOrderList(String hotelID) {
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
		try {
			ArrayList<OrderPO> orderPOs = dataService.getAllOrders();
			for (OrderPO po : orderPOs){
				if(po.getStatus().equals(OrderState.FINISHED))
					orderVOs.add(new OrderVO(po));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderVOs;
	}




}
