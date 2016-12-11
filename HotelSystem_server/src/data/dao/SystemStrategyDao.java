package data.dao;

import java.util.ArrayList;

import PO.SystemStrategyPO;
import other.SystemStrategyType;

public interface SystemStrategyDao {
	public boolean addSstrategy(SystemStrategyPO Sstrategy);
	public boolean deleteSstrategy(SystemStrategyPO Sstrategy);
	public boolean updateSstrategy(SystemStrategyPO Sstrategy);
	public SystemStrategyPO getSstrategy(String strategyName);
	public ArrayList<SystemStrategyPO> getAllStrategys();
	public ArrayList<SystemStrategyPO> getSystemStrategys(SystemStrategyType systemStrategyType);
}
