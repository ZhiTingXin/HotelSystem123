package blservice.impl;

import java.util.ArrayList;

import PO.SystemStrategyPO;
import RMI.RemoteHelper;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import other.SystemStrategyType;

public class SystemStrategy_bl implements SystemStrategy_blservice{

	/**
	 * @param 
	 * 
	 * @return 
	 * �������е���վӪ������
	 */
	public ArrayList<SystemStrategyVO> getAllSystemStrategys() {
		ArrayList<SystemStrategyVO> list = new ArrayList<SystemStrategyVO>();
		try{
			ArrayList<SystemStrategyPO> arrayList = RemoteHelper.getInstance().getSystemStrategyDataService()
					.getAllStrategys();
			for(int i=0;i<arrayList.size();i++){
				SystemStrategyVO strategyVO = new SystemStrategyVO(arrayList.get(i));
				list.add(strategyVO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @param ��վӪ�����Ե���Ϣ
	 * 
	 * @return 
	 * �޸���վӪ������
	 */
	public boolean modifySystemStrategy(SystemStrategyVO systemstrategyvo) {
		try {
			SystemStrategyPO systemStrategyPO = new SystemStrategyPO(systemstrategyvo);
			return RemoteHelper.getInstance().getSystemStrategyDataService().modify(systemStrategyPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param ��վӪ��������Ϣ
	 * 
	 * @return 
	 * �����վӪ������
	 */
	public boolean makeSystemStrategy(SystemStrategyVO systemstrategyvo) {
		try {
			SystemStrategyPO systemStrategyPO = new SystemStrategyPO(systemstrategyvo);
			return RemoteHelper.getInstance().getSystemStrategyDataService().add(systemStrategyPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param ��վӪ��������Ϣ
	 * 
	 * @return 
	 * ɾ����վӪ������
	 */
	public boolean deleteSystemStrategy(SystemStrategyVO systemStrategyVO) {
		try {
			SystemStrategyPO strategyPO = new SystemStrategyPO(systemStrategyVO);
			return RemoteHelper.getInstance().getSystemStrategyDataService().delete(strategyPO);
		} catch (Exception e) {
		     e.printStackTrace();
		     return false;
		}
	}

	/**
	 * @param ��վӪ�����Ե�����
	 * 
	 * @return ���Ͷ�Ӧ�����е���վӪ������
	 */
	public ArrayList<SystemStrategyVO> getSystemStrategys(SystemStrategyType systemStrategyType) {
		ArrayList<SystemStrategyVO> strategyVOs = new ArrayList<SystemStrategyVO>();
	    try{
	    	ArrayList<SystemStrategyPO> strategyPOs = RemoteHelper.getInstance().getSystemStrategyDataService().getSystemStrategys(systemStrategyType);
	    	for (int i = 0; i < strategyPOs.size(); ++i) {
				SystemStrategyVO strategyVO = new  SystemStrategyVO(strategyPOs.get(i));
				strategyVOs.add(strategyVO);
			}
	    }catch (Exception e) {
		    e.printStackTrace();
		}
	    return strategyVOs;

	}
}
