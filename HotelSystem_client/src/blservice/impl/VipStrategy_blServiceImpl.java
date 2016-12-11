package blservice.impl;

import java.util.ArrayList;

import PO.VipPO;
import RMI.RemoteHelper;
import VO.VipStrategyVO;
import VO.VipVO;
import blservice.VipStrategy_blService;
import data.service.VipDataService;

public class VipStrategy_blServiceImpl implements VipStrategy_blService{

	VipDataService vipDataService = RemoteHelper.getInstance().getVipDataService();
	public boolean makeVipStrategy(VipStrategyVO vipstrategy) {
		try {
			ArrayList<VipVO> vipVOs = vipstrategy.getVipStrategyVOList();
			for(int i=0;i<vipVOs.size();i++){
				VipPO vipPO = new VipPO(vipVOs.get(i));
				if(!vipDataService.makeVip(vipPO)){
					return false;
				}
			}
			return true;
		} catch (Exception e) {
		    return false;
		}
	}

	public boolean modifyVipStrategy(VipStrategyVO vipstrategy) {
		try {
			ArrayList<VipVO> vipVOs = vipstrategy.getVipStrategyVOList();
			for(int i=0;i<vipVOs.size();i++){
				VipPO vipPO = new VipPO(vipVOs.get(i));
				if(!vipDataService.updateVip(vipPO)){
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public VipStrategyVO getVipStrategy() {
		try {
			ArrayList<VipVO> vipVOs = new ArrayList<VipVO>();
			ArrayList<VipPO> vips = vipDataService.getAllVips();
			for(int i=0;i<vips.size();i++){
				VipVO vipVO = new VipVO(vips.get(i));
				vipVOs.add(vipVO);
			}
			return new VipStrategyVO(vipVOs);
		} catch (Exception e) {
			return null;
		}
	}

}
