package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelPO;
import PO.HotelStaffPO;
import PO.HotelStrategyPO;
import PO.Label;
import PO.OrderPO;
import PO.RoomPO;
import RMI.RemoteHelper;
import VO.HotelInfoVO;
import VO.HotelRoomInfoVO;
import VO.HotelStaffVO;
import VO.HotelStrategyVO;
import VO.OrderVO;
import blservice.Hotel_blservice;
import data.service.HotelDataService;
import data.service.HotelStrategyDataService;
import data.service.OrderDataService;
import data.service.RoomDataService;
import other.OrderState;

public class Hotel_bl implements Hotel_blservice {

	HotelDataService dataService = RemoteHelper.getInstance().getHotelDataService();
	RoomDataService roomDataService = RemoteHelper.getInstance().getRoomDataService();
	OrderDataService orderDataService = RemoteHelper.getInstance().getOrderDataService();
	HotelStrategyDataService hotelStrategyDataService = RemoteHelper.getInstance().getHotelStrategyDataService();
	public HotelInfoVO getHotelInfo(String hotelId) {
		try {
			HotelPO hotelPO = dataService.find(hotelId);
			ArrayList<HotelStrategyPO> hotelStrategyPOs = hotelStrategyDataService.getAll(hotelId);
			ArrayList<OrderPO> orderPOs = orderDataService.getAllHotelOrders(hotelId);
			/*
			 * 目前底层还没有label的实现
			 */
			ArrayList<Label> labels = new ArrayList<Label>();
			ArrayList<RoomPO> roomPOs = roomDataService.getAllRoomPO(hotelId);
			ArrayList<HotelStrategyVO> hotelStrategyVOs = new ArrayList<HotelStrategyVO>();
			ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
			ArrayList<HotelRoomInfoVO> roomInfoVOs = new ArrayList<HotelRoomInfoVO>();
			for(HotelStrategyPO hotelStrategyPO:hotelStrategyPOs){
				hotelStrategyVOs.add(new HotelStrategyVO(hotelStrategyPO));
			}
			for(RoomPO room:roomPOs){
				roomInfoVOs.add(new HotelRoomInfoVO(room));
			}
			for(OrderPO po:orderPOs){
				orderVOs.add(new OrderVO(po));
			}
			HotelInfoVO hotelVO = new HotelInfoVO(hotelPO, orderVOs, hotelStrategyVOs, roomInfoVOs, labels);
			
			return hotelVO;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean modifyHotelInfo(HotelInfoVO hotelInfo){
		HotelPO hotelPO = new HotelPO(hotelInfo);
		try {
			boolean processResult = dataService.update(hotelPO);
			return processResult;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<HotelInfoVO> getListOfHotel(String strict,String type) {
		ArrayList<HotelPO> poList = null; 
		try {
			poList = dataService.getHotels(strict, type);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
		ArrayList<HotelInfoVO> voList = new ArrayList<HotelInfoVO>();
		for(HotelPO po : poList){
			voList.add(new HotelInfoVO(po));
		}
		
		return voList;
	}

	public boolean addHotel(HotelInfoVO hotel) {
		HotelPO hotelPO = new HotelPO(hotel);
		try {
			return dataService.add(hotelPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addHotelStaff(HotelStaffVO hotelStaff) {
		HotelStaffPO hotelStaffPO = new HotelStaffPO(hotelStaff);
		try {
			return RemoteHelper.getInstance().getHotelStaffDataService().addStaff(hotelStaffPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<HotelInfoVO> getListOfHotelPrefer(String userId) {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<>();
		try {
			ArrayList<OrderPO> orderPOList = (ArrayList<OrderPO>)orderDataService.findOrders(userId, "userId");
			//遍历完成的订单
			for(OrderPO po : orderPOList){
				if(po.getStatus().equals(OrderState.FINISHED)){
					HotelPO hotelPO = dataService.find(po.getHotelId());
					hotelInfoVOs.add(new HotelInfoVO(hotelPO));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		return hotelInfoVOs;
	}

	
	@Override
	public ArrayList<HotelInfoVO> getAllHotel() {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<>();
		try {
			ArrayList<HotelPO> hotelPOs = dataService.getAllHotels();
			for(HotelPO po : hotelPOs){
				hotelInfoVOs.add(new HotelInfoVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelInfoVOs;
	}


	@Override
	public String getHotelGradeAssessment(String hotelID) {
		try {
			HotelPO hotelPO = dataService.find(hotelID);
			return hotelPO.getGrade();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String[] getHotelTagAssessment(String hotelID) {
		return null;
	}

	@Override
	public ArrayList<HotelInfoVO> getHotelFromName(String text) {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<>();
		try {
			ArrayList<HotelPO> hotelPOs = dataService.getAllHotels();
			for(HotelPO po : hotelPOs){
				if(po.getHotelName().equals(text))
					hotelInfoVOs.add(new HotelInfoVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return hotelInfoVOs;
	}

	@Override
	public String getHotelRoomPrice(String hotelID) {
		String roomAndPrice = null;
		ArrayList<RoomPO> roomPOs = null; 
		try {
			roomPOs = RemoteHelper.getInstance().getRoomDataService().getAllRoomPO();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(RoomPO roomPO: roomPOs){
			if(roomPO.getHotelId().equals(hotelID))
				roomAndPrice = roomAndPrice+","+roomPO.getType()+"_"+roomPO.getPrice();
		}
		return roomAndPrice;
	}

	@Override
	public String genarateHotelID() {
		try {
			return RemoteHelper.getInstance().getIdGernerateService().gernerateId();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String genarateHotelStaffID() {
		try {
			return RemoteHelper.getInstance().getIdGernerateService().gernerateId();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
