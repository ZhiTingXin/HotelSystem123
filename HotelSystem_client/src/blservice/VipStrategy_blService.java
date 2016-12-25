package blservice;

import VO.VipStrategyVO;

public interface VipStrategy_blService {

	public boolean makeVipStrategy(VipStrategyVO vipstrategy);

	public boolean modifyVipStrategy(VipStrategyVO vipstrategy);

	public VipStrategyVO getVipStrategy();

	//返回4级，5级的会员
	public VipStrategyVO getVipstrategy(String city,String district);
	
	public boolean makeSuperVipStrategy(VipStrategyVO vipStrategyVO);

	public boolean modifuSuperVipStrategy(VipStrategyVO vipStrategyVO);
	
	public boolean deleteSuperVipStrategy(String city,String district);
	
}
