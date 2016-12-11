package blservice;

import VO.VipStrategyVO;

public interface VipStrategy_blService {

	public boolean makeVipStrategy(VipStrategyVO vipstrategy);
	
	public boolean modifyVipStrategy(VipStrategyVO vipstrategy);
	
	public VipStrategyVO getVipStrategy();
}
