package blservice;

import java.util.ArrayList;

import VO.SystemStrategyVO;
import VO.VipVO;
import other.SystemStrategyType;

public interface SystemStrategy_blservice {
	
	public ArrayList<SystemStrategyVO> getAllSystemStrategys();
	
	public ArrayList<SystemStrategyVO> getSystemStrategy(SystemStrategyType systemStrategyType);
	
	public boolean modifySystemStrategy(SystemStrategyVO systemstrategyvo);
	
	public boolean makeSystemStrategy(SystemStrategyVO systemstrategyvo);
	
	public boolean deleteSystemStrategy(SystemStrategyVO systemStrategyVO);
	
	public ArrayList<VipVO> getVipMemberVOList();//获取vip会员的vipVO 所谓的VIP 会员就是达到四级会员升级为VIP 会员
}
