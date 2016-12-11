package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AdviceFeedBackPO;
import PO.HotelPO;
import PO.HotelRoomInfoPO;
import PO.HotelStaffPO;
import PO.Label;
import PO.OrderPO;
import PO.Rank;
import RMI.RemoteHelper;
import VO.HotelInfoVO;
import VO.HotelStaffVO;
import blservice.Hotel_blservice;
import data.service.HotelDataService;
import data.service.OrderDataService;
import other.OrderState;

public class Hotel_bl implements Hotel_blservice {

	HotelDataService dataService = RemoteHelper.getInstance().getHotelDataService();
	OrderDataService orderDataService = RemoteHelper.getInstance().getOrderDataService();
	
	public HotelInfoVO getHotelInfo(String hotelId) {
		try {
			HotelPO hotelPO = dataService.find(hotelId);
			HotelInfoVO hotelVO = new HotelInfoVO(hotelPO);
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<HotelInfoVO> getListOfHotel(String strict,String type) {
		ArrayList<HotelPO> poList = null; 
		try {
			poList = dataService.getHotels(strict, type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean addHotelStaff(HotelStaffVO hotelStaff) {
		HotelStaffPO hotelStaffPO = new HotelStaffPO(hotelStaff);
		try {
			return RemoteHelper.getInstance().getHotelStaffDataService().addStaff(hotelStaffPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<HotelInfoVO> getListOfHotelPrefer(String userId) {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<>();
		try {
			ArrayList<OrderPO> orderPOList = orderDataService.findOrders(userId, "userId");
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
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hotelInfoVOs;
	}

}
