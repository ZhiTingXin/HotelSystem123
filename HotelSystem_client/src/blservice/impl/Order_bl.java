package blservice.impl;

import java.awt.image.DataBufferFloat;
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.OrderPO;
import PO.PrivilegePO;
import RMI.RemoteHelper;
import VO.OrderVO;
import blservice.Order_blservice;
import data.service.OrderDataService;
import other.OrderState;
import other.RoomType;

public class Order_bl implements Order_blservice{
	OrderDataService dataService = RemoteHelper.getInstance().getOrderDataService();
	
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

//	public ArrayList<OrderVO> getHotelOrders(String userID, String hotelID) {
//		ArrayList<OrderPO> aList = new ArrayList<OrderPO>();
//		OrderPO tempPO = new OrderPO();
//		aList.add(tempPO);
//		return aList;
//	}

//	public boolean checkRoomType(String hotelID, RoomType type) {
//		return false;
//	}

//	public ArrayList<PrivilegePO> getRecommendations(String userID, String hotelID) {
//		ArrayList<PrivilegePO> aList = new ArrayList<PrivilegePO>();
//		PrivilegePO tempPO = new PrivilegePO();
//		aList.add(tempPO);
//		return aList;
//	}

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




}
