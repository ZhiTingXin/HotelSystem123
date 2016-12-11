package blservice.impl;

import java.util.ArrayList;

import PO.SystemStrategyPO;
import RMI.RemoteHelper;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import other.SystemStrategyType;

public class SystemStrategy_bl implements SystemStrategy_blservice{

	public ArrayList<SystemStrategyVO> getAllSystemStrategys() {
		try{
			ArrayList<SystemStrategyPO> arrayList = RemoteHelper.getInstance().getSystemStrategyDataService()
					.getAllStrategys();
			ArrayList<SystemStrategyVO> list = new ArrayList<SystemStrategyVO>();
			for(int i=0;i<arrayList.size();i++){
				SystemStrategyVO strategyVO = new SystemStrategyVO(arrayList.get(i));
				list.add(strategyVO);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SystemStrategyVO getSystemStrategy(String systemStrategy_Name) {
		SystemStrategyVO systemStrategyVO =null;
		try{
			SystemStrategyPO systemStrategyPO =
					RemoteHelper.getInstance().getSystemStrategyDataService().getSstrategy(systemStrategy_Name);
		    systemStrategyVO = new SystemStrategyVO(systemStrategyPO);
		    return systemStrategyVO;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean modifySystemStrategy(SystemStrategyVO systemstrategyvo) {
		try {
			SystemStrategyPO systemStrategyPO = new SystemStrategyPO(systemstrategyvo);
			return RemoteHelper.getInstance().getSystemStrategyDataService().modify(systemStrategyPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean makeSystemStrategy(SystemStrategyVO systemstrategyvo) {
		try {
			SystemStrategyPO systemStrategyPO = new SystemStrategyPO(systemstrategyvo);
			return RemoteHelper.getInstance().getSystemStrategyDataService().add(systemStrategyPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSystemStrategy(SystemStrategyVO systemStrategyVO) {
		try {
			SystemStrategyPO strategyPO = new SystemStrategyPO(systemStrategyVO);
			return RemoteHelper.getInstance().getSystemStrategyDataService().delete(strategyPO);
		} catch (Exception e) {
		     e.printStackTrace();
		     return false;
		}
	}

	public ArrayList<SystemStrategyVO> getSystemStrategys(SystemStrategyType systemStrategyType) {
	    try{
	    	ArrayList<SystemStrategyVO> strategyVOs = new ArrayList<SystemStrategyVO>();
	    	ArrayList<SystemStrategyPO> strategyPOs = RemoteHelper.getInstance().getSystemStrategyDataService().getSystemStrategys(systemStrategyType);
	    	for (int i = 0; i < strategyPOs.size(); i++) {
				SystemStrategyVO strategyVO = new  SystemStrategyVO(strategyPOs.get(i));
				strategyVOs.add(strategyVO);
				return strategyVOs;
			}
	    }catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}

}
