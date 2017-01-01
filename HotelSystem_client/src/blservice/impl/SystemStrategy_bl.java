package blservice.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import PO.SystemStrategyPO;
import RMI.RemoteHelper;
import VO.CustomerVO;
import VO.SystemStrategyVO;
import VO.VipVO;
import blservice.SystemStrategy_blservice;
import blservice.VipStrategy_blService;
import other.StrategyState;
import other.SystemStrategyType;

public class SystemStrategy_bl implements SystemStrategy_blservice {

	/**
	 * @param
	 * 
	 * @return 返回所有的网站营销策略
	 */
	public ArrayList<SystemStrategyVO> getAllSystemStrategys() {
		ArrayList<SystemStrategyVO> list = new ArrayList<SystemStrategyVO>();
		try {
			ArrayList<SystemStrategyPO> arrayList = RemoteHelper.getInstance().getSystemStrategyDataService()
					.getAllStrategys();
			for (int i = 0; i < arrayList.size(); i++) {
				SystemStrategyVO strategyVO = new SystemStrategyVO(arrayList.get(i));
				list.add(strategyVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * @param 网站营销策略的信息
	 * 
	 * @return 修改网站营销策略
	 */
	public boolean modifySystemStrategy(SystemStrategyVO systemstrategyvo) {
		try {
			SystemStrategyPO systemStrategyPO = new SystemStrategyPO(systemstrategyvo);
			return RemoteHelper.getInstance().getSystemStrategyDataService().modify(systemStrategyPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 网站营销策略信息
	 * 
	 * @return 添加网站营销策略
	 */
	public boolean makeSystemStrategy(SystemStrategyVO systemstrategyvo) {
		try {
			SystemStrategyPO systemStrategyPO = new SystemStrategyPO(systemstrategyvo);
			return RemoteHelper.getInstance().getSystemStrategyDataService().add(systemStrategyPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 网站营销策略信息
	 * 
	 * @return 删除网站营销策略
	 */
	public boolean deleteSystemStrategy(SystemStrategyVO systemStrategyVO) {
		try {
			SystemStrategyPO strategyPO = new SystemStrategyPO(systemStrategyVO);
			return RemoteHelper.getInstance().getSystemStrategyDataService().delete(strategyPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 网站营销策略的类型
	 * 
	 * @return 类型对应的所有的网站营销策略
	 */
	public ArrayList<SystemStrategyVO> getSystemStrategys(SystemStrategyType systemStrategyType) {
		ArrayList<SystemStrategyVO> strategyVOs = new ArrayList<SystemStrategyVO>();
		try {
			ArrayList<SystemStrategyPO> strategyPOs = RemoteHelper.getInstance().getSystemStrategyDataService()
					.getSystemStrategys(systemStrategyType);
			for (int i = 0; i < strategyPOs.size(); ++i) {
				SystemStrategyVO strategyVO = new SystemStrategyVO(strategyPOs.get(i));
				strategyVOs.add(strategyVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strategyVOs;

	}

	@Override
	public String showholidayDeals(CustomerVO customer) {
		// TODO Auto-generated method stub
		String strategyDiscription = "";
		ArrayList<SystemStrategyVO> strategyVOs = this.getAllSystemStrategys();
		for (SystemStrategyVO vo : strategyVOs) {
			if (vo.getStrategyState() != null && vo.getStrategyState().equals(StrategyState.open)) {
				LocalDate now = LocalDate.now();
				if (vo.getBegin_date() != null
						&& (vo.getBegin_date().isBefore(now) || vo.getBegin_date().isEqual(now))) {
					if (vo.getEnd_date() != null
							&& (vo.getEnd_date().isAfter(LocalDate.now()) || vo.getEnd_date().isEqual(now))) {
						strategyDiscription += vo.getSystemStrategyName() + ":" + String.valueOf(vo.getDiscount())
								+ "折；";
					}
				}
			}
		}
		return strategyDiscription;
	}

	@Override
	public String showMemberDeals(CustomerVO customer) {
		// TODO Auto-generated method stub
		String strategyDiscription = "";

		VipStrategy_blService vipService = new VipStrategy_blServiceImpl();
		ArrayList<VipVO> strategyVOs = vipService.getVipStrategy().getVipStrategyVOList();
		int credit = customer.getCredit();
		for (VipVO vipvo : strategyVOs) {
			if (credit <= vipvo.getMaxcredit() && credit > vipvo.getMincredit()) {
				strategyDiscription += "会员优惠" + String.valueOf(vipvo.getDiscount()) + "折；";
			}
		}
		return strategyDiscription;
	}

}
