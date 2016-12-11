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
		try{
		    HotelStrategyPO strategyPO = new HotelStrategyPO(hotelstrategy);
		    return RemoteHelper.getInstance().getHotelStrategyDataService().add(strategyPO);
		}catch (Exception e) {
			e.printStackTrace();
		    return false;
		}
	}

	public boolean modifyHotelStrategy(HotelStrategyVO hotelstrategy) {
		try {
			HotelStrategyPO strategyPO = new HotelStrategyPO(hotelstrategy);
			return RemoteHelper.getInstance().getHotelStrategyDataService().modify(strategyPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteHotelStrategy(HotelStrategyVO strategyVO) {
		try {
			HotelStrategyPO strategyPO = new HotelStrategyPO(strategyVO);
			return RemoteHelper.getInstance().getHotelStrategyDataService().delete(strategyPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public HotelStrategyVO getHotelStrategy(String HotelStrategyId) {
		try {
			HotelStrategyPO hotelStrategyPO = RemoteHelper.getInstance().
					getHotelStrategyDataService().get(HotelStrategyId);
			return new HotelStrategyVO(hotelStrategyPO);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<HotelStrategyVO> getListOfHotelStrategys(String hotel_id) {
		try{
			ArrayList<HotelStrategyPO> hotelStrategyPOs = RemoteHelper.getInstance().getHotelStrategyDataService()
					.getAll(hotel_id);
			ArrayList<HotelStrategyVO> hotelStrategyVOs = new ArrayList<HotelStrategyVO>();
			for(int i=0;i<hotelStrategyPOs.size();i++){
				HotelStrategyVO strategyVO = new HotelStrategyVO(hotelStrategyPOs.get(i));
				hotelStrategyVOs.add(strategyVO);
			}
			return hotelStrategyVOs;
		}catch (Exception e) {
			return null;
		}
	}
	

}
