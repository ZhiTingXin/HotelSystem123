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
	//12.08 ����
	public ArrayList<VipVO> getVipStrategyVOList();//��ȡ��Ա��Ϣ
	public boolean modifyVipStrategyVOList(VipStrategyVO vipStrategyVO);
	public boolean makeVipStrategyVOList(VipStrategyVO vipStrategyVO);
	public ArrayList<VipVO> getVipMemberVOList();//��ȡvip��Ա��vipVO ��ν��VIP ��Ա���Ǵﵽ�ļ���Ա����ΪVIP ��Ա
}
