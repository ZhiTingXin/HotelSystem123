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
	 * @param �Ƶ�������Ե���Ϣ
	 * @return
	 * �Ƿ�ɹ���Ӵ�������
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
	 * @param �޸ĺ�Ĵ���������Ϣ
	 * @return
	 * �����Ƿ��޸ĳɹ�
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
	 * �����Ƿ�ɾ������������Ϣ�ɹ�
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
	 * ���ؾƵ�������Ե���Ϣ
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
	 * @param �Ƶ�id
	 * @return
	 * ���еľƵ�Ĵ�������
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
