package blservice.impl;

import java.util.ArrayList;

import PO.HotelStrategyPO;
import RMI.RemoteHelper;
import VO.HotelStrategyVO;
import blservice.HotelStrategy_blservice;
import data.service.HotelDataService;

public class HotelStrategy_bl implements HotelStrategy_blservice {
	HotelDataService dataService = RemoteHelper.getInstance().getHotelDataService();
	
	HotelDataService hoteldataservice;
	public boolean makeHotelStrategy(HotelStrategyVO hotelstrategy) {
		HotelStrategyPO strategyPO = new HotelStrategyPO(hotelstrategy);
	}

	public boolean modifyHotelStrategy(HotelStrategyVO hotelstrategy) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteHotelStrategy(String hotelStrategyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public HotelStrategyVO getHotelStrategy(String HotelStrategyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelStrategyVO> getListOfHotelStrategys(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
