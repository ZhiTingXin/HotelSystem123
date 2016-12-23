package blservice.impl;

import java.util.ArrayList;

import PO.SuperVipPO;
import PO.VipPO;
import RMI.RemoteHelper;
import VO.VipStrategyVO;
import VO.VipVO;
import blservice.VipStrategy_blService;
import data.service.SuperVipDataService;
import data.service.VipDataService;

public class VipStrategy_blServiceImpl implements VipStrategy_blService{

	VipDataService vipDataService = RemoteHelper.getInstance().getVipDataService();
	SuperVipDataService service = RemoteHelper.getInstance().getSuperVipDataServce();
	
	/**
	 * 制定网站会员优惠策略
	 */
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

	/**
	 * 修改网站会员优惠策略
	 */
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

	/**
	 * @param
	 * @return 返回网站会员优惠策略
	 * 
	 */
	public VipStrategyVO getVipStrategy() {
		try {
			ArrayList<VipVO> vipVOs = new ArrayList<VipVO>();
			ArrayList<VipPO> vips = vipDataService.getAllVips();
			for(int i=0;i<vips.size();i++){
				VipVO vipVO = new VipVO(vips.get(i));
				vipVOs.add(vipVO);
			}
			VipStrategyVO vipStrategyVO = new VipStrategyVO();
			vipStrategyVO.setVipStrategyVOList(vipVOs);
			return vipStrategyVO;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @param 商圈
	 * 
	 */
	//返回商圈会员优惠信息
	public VipStrategyVO getVipstrategy(String district) {
		VipStrategyVO vipStrategyVO = new VipStrategyVO();
		try {
			ArrayList<SuperVipPO> superVipPOs = service.getStrict(district);
			ArrayList<VipVO> vipVOs = new ArrayList<VipVO>();
			for(SuperVipPO po : superVipPOs){
				vipVOs.add(new VipVO(po));
			}
			vipStrategyVO.setVipStrategyVOList(vipVOs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vipStrategyVO;
	}

	/**
	 * @param 商圈会员优惠策略
	 * 
	 */
	//制定商圈会员优惠策略
	public boolean makeSuperVipStrategy(VipStrategyVO vipStrategyVO) {
		ArrayList<VipVO> list = vipStrategyVO.getVipStrategyVOList();
		try {
			for(VipVO vo:list){
				service.addSupVip(new SuperVipPO(vo));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param 商圈会员优惠策略
	 * 
	 */
	//修改商圈会员策略
	public boolean modifuSuperVipStrategy(VipStrategyVO vipStrategyVO) {
		ArrayList<VipVO> list = vipStrategyVO.getVipStrategyVOList();
		try {
			for(VipVO vo:list){
				service.modifySupVip(new SuperVipPO(vo));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param 通过商圈来删除对对应商圈会员信息
	 * @return 
	 * 返回是否删除成功
	 */
	//删除商圈会员优惠策略
	public boolean deleteSuperVipStrategy(String district) {
		VipStrategyVO vipStrategyVO = getVipstrategy(district);
		ArrayList<VipVO> vipVOs = vipStrategyVO.getVipStrategyVOList();
		try {
			for(VipVO vo:vipVOs){
				service.deleteSupVip(new SuperVipPO(vo));
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;               
		}
	}


    
}
