package blservice;

import java.util.ArrayList;
import VO.SystemStrategyVO;
import other.SystemStrategyType;

public interface SystemStrategy_blservice {
	
	public ArrayList<SystemStrategyVO> getAllSystemStrategys();
	
	public ArrayList<SystemStrategyVO> getSystemStrategy(SystemStrategyType systemStrategyType);
	
	public boolean modifySystemStrategy(SystemStrategyVO systemstrategyvo);
	
	public boolean makeSystemStrategy(SystemStrategyVO systemstrategyvo);
	
	public boolean deleteSystemStrategy(SystemStrategyVO systemStrategyVO);
	
}
