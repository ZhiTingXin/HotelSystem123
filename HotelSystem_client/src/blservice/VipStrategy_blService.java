package blservice;

import java.util.ArrayList;

import VO.VipStrategyVO;

public interface VipStrategy_blService {

	public boolean makeVipStrategy(VipStrategyVO vipstrategy);

	public boolean modifyVipStrategy(VipStrategyVO vipstrategy);

	public VipStrategyVO getVipStrategy();

	//����4����5���Ļ�Ա
	public VipStrategyVO getVipstrategy(String district);

}
