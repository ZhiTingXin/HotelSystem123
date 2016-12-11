package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AdviceFeedBackPO;
import PO.HotelPO;
import PO.HotelRoomInfoPO;
import PO.HotelStaffPO;
import PO.Label;
import PO.Rank;
import RMI.RemoteHelper;
import VO.HotelInfoVO;
import VO.HotelStaffVO;
import blservice.Hotel_blservice;
import data.service.HotelDataService;

public class Hotel_bl implements Hotel_blservice {

	HotelDataService dataService = RemoteHelper.getInstance().getHotelDataService();
	
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

//	public boolean addAssessment(String hotelID, String assessment) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public boolean addLabelAssessment(String hotelID, ArrayList<Label> labelList) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public boolean addRankAssessment(String hotelID, Rank rank) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public boolean roomModify(String hotelId, HotelRoomInfoPO currentInfo) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	
	///////need  to be added in database
	public HotelRoomInfoPO getHotelRoomInfo(String hotelId) {
		return null;
	}

//	public ArrayList<Label> getLabelAssessment(String hotelId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public boolean deleteLabelAssessment(String hotelId, Label label) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public ArrayList<HotelInfoVO> getListOfHotelPrefer(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
