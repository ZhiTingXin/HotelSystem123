package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelPO;
import PO.OrderPO;
import RMI.RemoteHelper;
import VO.HotelInfoVO;
import blservice.Hotel_blservice;
import data.service.HotelDataService;
import data.service.OrderDataService;
import other.OrderState;

public class Hotel_bl implements Hotel_blservice {

	OrderDataService orderDataService = RemoteHelper.getInstance().getOrderDataService();
	HotelDataService dataService = RemoteHelper.getInstance().getHotelDataService();

	@Override
	public HotelInfoVO getHotelInfo(String hotelId) {
		try {
			/*
			 * 得到PO
			 */
			HotelPO hotelPO = dataService.find(hotelId);
			HotelInfoVO hotelVO = new HotelInfoVO(hotelPO);
			return hotelVO;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean modifyHotelInfo(HotelInfoVO hotelInfo) {
		HotelPO hotelPO = new HotelPO(hotelInfo);
		try {
			boolean a = dataService.update(hotelPO);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<HotelInfoVO> getListOfHotel(String strict) {

		try {
			ArrayList<HotelPO> poList = dataService.getHotels(strict);
			ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
			for (HotelPO po : poList) {
				hotelInfoVOs.add(new HotelInfoVO(po));
			}
			return hotelInfoVOs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<HotelInfoVO> getAllHotel() {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
		try {
			ArrayList<HotelPO> hotelPOs = dataService.getAllHotels();
			for (HotelPO po : hotelPOs) {
				hotelInfoVOs.add(new HotelInfoVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelInfoVOs;
	}

	@Override
	public boolean addHotel(HotelInfoVO hotel) {
		HotelPO hotelPO = new HotelPO(hotel);
		try {
			dataService.add(hotelPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<HotelInfoVO> getListOfHotelPrefer(String userId) {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
		try {
			ArrayList<OrderPO> orderPOList = (ArrayList<OrderPO>) orderDataService.findOrders(userId, "userId");
			// 遍历完成的订单
			for (OrderPO po : orderPOList) {
				if (po.getStatus().equals(OrderState.FINISHED)) {
					HotelInfoVO hotelInfoVO = getHotelInfo(po.getHotelId());
					hotelInfoVOs.add(hotelInfoVO);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelInfoVOs;
	}

	@Override
	public ArrayList<HotelInfoVO> getHotelFromName(String text) {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
		try {
			ArrayList<HotelPO> hotelPOs = dataService.getAllHotels();
			for (HotelPO po : hotelPOs) {
				if (po.getHotelName().contains(text)) {
					HotelInfoVO hotelInfoVO = getHotelInfo(po.getHotelId());
					hotelInfoVOs.add(hotelInfoVO);
				}
			}
			return hotelInfoVOs;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getHotelName(String hotelID) {
		Hotel_bl hotel_bl = new Hotel_bl();
		HotelInfoVO hotel = hotel_bl.getHotelInfo(hotelID);
		return hotel.getHotelName();

	}

}
