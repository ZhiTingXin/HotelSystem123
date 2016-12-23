package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelStrategyPO;
import RMI.RemoteHelper;
import VO.HotelStrategyVO;
import blservice.HotelStrategy_blservice;
import data.service.HotelStrategyDataService;

public class HotelStrategy_bl implements HotelStrategy_blservice {
	
	HotelStrategyDataService dataService = RemoteHelper.getInstance().getHotelStrategyDataService();
	
	/**
	 * @param 酒店促销策略的信息
	 * @return
	 * 是否成功添加促销策略
	 */
	public boolean makeHotelStrategy(HotelStrategyVO hotelstrategy) {
		try {
			return dataService.add(new HotelStrategyPO(hotelstrategy));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param 修改后的促销策略信息
	 * @return
	 * 返回是否修改成功
	 */
	public boolean modifyHotelStrategy(HotelStrategyVO hotelstrategy) {
		try {
			return dataService.modify(new HotelStrategyPO(hotelstrategy));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param id
	 * @return
	 * 返回是否删除促销策略信息成功
	 */
	public boolean deleteHotelStrategy(String hotelStrategyId) {
		try {
			HotelStrategyPO hPo = dataService.get(hotelStrategyId);
			return dataService.delete(hPo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param id
	 * @return
	 * 返回酒店促销策略的信息
	 */
	public HotelStrategyVO getHotelStrategy(String hotelStrategyId) {
		try {
			HotelStrategyPO hPo = dataService.get(hotelStrategyId);
			HotelStrategyVO hVo = new HotelStrategyVO(hPo);
			return hVo;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param 酒店id
	 * @return
	 * 所有的酒店的促销策略
	 */
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
