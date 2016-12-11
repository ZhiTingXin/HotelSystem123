package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelStrategyPO;
import RMI.RemoteHelper;
import VO.HotelStrategyVO;
import blservice.HotelStrategy_blservice;
import data.service.HotelDataService;
import data.service.HotelStrategyDataService;

public class HotelStrategy_bl implements HotelStrategy_blservice {
	HotelStrategyDataService dataService = RemoteHelper.getInstance().getHotelStrategyDataService();
	
	HotelDataService hoteldataservice;
	public boolean makeHotelStrategy(HotelStrategyVO hotelstrategy) {
		try {
			return dataService.add(new HotelStrategyPO(hotelstrategy));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean modifyHotelStrategy(HotelStrategyVO hotelstrategy) {
		try {
			return dataService.modify(new HotelStrategyPO(hotelstrategy));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteHotelStrategy(String hotelStrategyId) {
		try {
			HotelStrategyPO hPo = dataService.get(hotelStrategyId);
			return dataService.delete(hPo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public HotelStrategyVO getHotelStrategy(String hotelStrategyId) {
		try {
			HotelStrategyPO hPo = dataService.get(hotelStrategyId);
			HotelStrategyVO hVo = new HotelStrategyVO(hPo);
			return hVo;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<HotelStrategyVO> getListOfHotelStrategys(String hotel_id) {
		ArrayList<HotelStrategyVO> voList = new ArrayList<>();
		try {
			ArrayList<HotelStrategyPO> poList = dataService.getAll(hotel_id);
			for(HotelStrategyPO po : poList){
				voList.add(new HotelStrategyVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return voList;
	}
	

}
