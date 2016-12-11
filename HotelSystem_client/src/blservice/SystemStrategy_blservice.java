package blservice;

import java.util.ArrayList;

import VO.SystemStrategyVO;
import VO.VipStrategyVO;
import VO.VipVO;
import other.SystemStrategyType;
import other.memberState;

public interface SystemStrategy_blservice {
	 
//	public ArrayList<SystemStrategyVO> getAllSystemStrategys(String systemStaffID);
//	
//	public SystemStrategyVO getSystemStrategy(String systemStrategy_Name);
//	
//	public boolean deleteSystemStrategy(String systemStrategy_Name);
//	
//	public boolean modifySystemStrategy(SystemStrategyVO systemstrategyvo);
//	
//	public SystemStrategyVO makeSystemStrategy(SystemStrategyVO systemstrategyvo);
	
//	public SystemStrategy1VO makeSystemStrategy1(SystemStrategy1VO systemstrategy);
//
//	public boolean modifySystemStrategy1(SystemStrategy1VO systemstrategy);
	public ArrayList<SystemStrategyVO> getAllSystemStrategys();
	
	public ArrayList<SystemStrategyVO> getSystemStrategy(SystemStrategyType systemStrategyType);
	
	public boolean modifySystemStrategy(SystemStrategyVO systemstrategyvo);
	
	public boolean makeSystemStrategy(SystemStrategyVO systemstrategyvo);
	
	public boolean deleteSystemStrategy(SystemStrategyVO systemStrategyVO);
	//12.08 新增
	public ArrayList<VipVO> getVipStrategyVOList();//获取会员信息
	public boolean modifyVipStrategyVOList(VipStrategyVO vipStrategyVO);
	public boolean makeVipStrategyVOList(VipStrategyVO vipStrategyVO);
	public ArrayList<VipVO> getVipMemberVOList();//获取vip会员的vipVO 所谓的VIP 会员就是达到四级会员升级为VIP 会员
}
