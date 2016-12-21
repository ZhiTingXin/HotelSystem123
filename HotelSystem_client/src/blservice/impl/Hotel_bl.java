package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import PO.HotelPO;
import PO.OrderPO;
import PO.RoomPO;
import RMI.RemoteHelper;
import VO.HotelInfoVO;
import blservice.Hotel_blservice;
import data.service.HotelDataService;
import data.service.OrderDataService;
import other.OrderState;

public class Hotel_bl implements Hotel_blservice {

	OrderDataService orderDataService = RemoteHelper.getInstance().getOrderDataService();
	HotelDataService dataService = RemoteHelper.getInstance().getHotelDataService();

	/**
	 * 
	 * @param hotelId
	 * @return
	 * 通过hotel的id来检索酒店
	 */
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
    /**
     * 
     * @param hotelInfo
     * @return
     * 修改酒店的信息，返回是否成功修改酒店的信息
     */
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
    /**
     * 
     * @param strict
     * @return
     * 返回商圈内的全部酒店
     */
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

	/**
	 * 
	 * @return
	 * 返回所有的酒店的信息
	 */
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

	/**
	 * 
	 * @param hotel
	 * @return
	 * 添加酒店信息，返回是否添加成功
	 */
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

	/**
	 * 
	 * @param userId用户id
	 * @return
	 * 之前用户完成入住的酒店
	 */
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
	/**
	 * 
	 * @param text根据酒店名称的字段搜索酒店
	 * 
	 * @return 返回所有酒店名称中含有该字段的酒店
	 */

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

	/**
	 * 
	 * @param 
	 * 酒店的星级
	 * @return
	 * 所有符合条件的酒店
	 */
	@Override
	public ArrayList<HotelInfoVO> getHotelFromGrade(double grade) {
		try{
			ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
			ArrayList<HotelPO> hotelPOs = RemoteHelper.getInstance().getHotelDataService().getAllHotels();
			for(HotelPO po:hotelPOs){
				if(Double.valueOf(po.getGrade())>=grade){
					hotelInfoVOs.add(new HotelInfoVO(po));
				}
			}
			return hotelInfoVOs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    /**
     * 
     * @param minPrice
     * @param maxPrice
     * @return
     * 存在价位在这个范围内的所有酒店
     */
	@Override
	public ArrayList<HotelInfoVO> getHotelFromPrice(int minPrice, int maxPrice) {
		try {
			ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
			ArrayList<HotelPO> hotelPOs = RemoteHelper.getInstance().getHotelDataService().getAllHotels();
			for(HotelPO po:hotelPOs){
				ArrayList<RoomPO> roomPOs = RemoteHelper.getInstance().getRoomDataService()
						.getAllRoomPO(po.getHotelId());
				for(RoomPO roomPO:roomPOs){
					if(roomPO.getPrice()<=maxPrice&&roomPO.getPrice()>=minPrice){
						hotelInfoVOs.add(new HotelInfoVO(po));
						break;
					}
				}
			}
			return hotelInfoVOs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
