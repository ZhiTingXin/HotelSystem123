package data.dao.impl;

import java.util.ArrayList;

import PO.SystemStrategyPO;
import data.dao.SystemStrategyDao;
import other.SystemStrategyType;
import other.hibernateUtil;

public class SystemStrategyDaoImpl implements SystemStrategyDao{

	public boolean addSstrategy(SystemStrategyPO Sstrategy) {
		try{
			hibernateUtil.add(Sstrategy);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSstrategy(SystemStrategyPO Sstrategy) {
		try{
			hibernateUtil.delete(Sstrategy);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateSstrategy(SystemStrategyPO Sstrategy) {
		try{
			hibernateUtil.update(Sstrategy);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
}

	public SystemStrategyPO getSstrategy(String strategyName) {
		try{
			return (SystemStrategyPO)hibernateUtil.findById(SystemStrategyPO.class, strategyName);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
}

	public ArrayList<SystemStrategyPO> getAllStrategys() {
	    ArrayList<SystemStrategyPO> list = null;
	    try {
			list = (ArrayList<SystemStrategyPO>)hibernateUtil.getAll("systemstrategy",SystemStrategyPO.class);
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return list;
	}

	public ArrayList<SystemStrategyPO> getSystemStrategys(SystemStrategyType systemStrategyType) {
		try {
			ArrayList<SystemStrategyPO> systemStrategyPOs =(ArrayList<SystemStrategyPO>) hibernateUtil.findbySome("systemstrategy","SystemStrategyType",systemStrategyType);
		    return systemStrategyPOs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
