package blservice.impl;

import java.util.ArrayList;
import PO.AssessmentPO;
import RMI.RemoteHelper;
import VO.AssementVO;
import blservice.Assessment_blService;
import data.service.AssessmentDataService;

public class Assessment_bl implements Assessment_blService {

	AssessmentDataService dataService = RemoteHelper.getInstance().getAssessmentDataService();

	/**
	 * @param assementVO
	 * @return 添加评价信息
	 */
	public boolean addAssessment(AssementVO assementVO) {
		try {
			AssessmentPO assessmentPO = new AssessmentPO(assementVO);
			dataService.addAssessment(assessmentPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 酒店id
	 * @return 返回对于酒店的所有评价
	 */
	public ArrayList<AssementVO> getAllHotelAss(String hotelid) {
		ArrayList<AssementVO> assementVOs = new ArrayList<AssementVO>();
		try {
			ArrayList<AssessmentPO> arrayList = dataService.getAllAssement(hotelid);
			for (AssessmentPO po : arrayList) {
				assementVOs.add(new AssementVO(po));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assementVOs;
	}

	/**
	 * @param 客户id
	 * @return 返回客户的所有评价
	 */
	public ArrayList<AssementVO> getUserAss(String userId) {
		ArrayList<AssementVO> arrayList = new ArrayList<AssementVO>();
		try {
			ArrayList<AssessmentPO> assessmentPOs = dataService.getUserASS(userId);
			for (AssessmentPO assessmentPO : assessmentPOs) {
				arrayList.add(new AssementVO(assessmentPO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	/**
	 * @param
	 * @return 删除评价
	 */
	public boolean delAss(AssementVO assementVO) {
		try {
			AssessmentPO assessmentPO = new AssessmentPO(assementVO);
			dataService.deleAssessment(assessmentPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 订单号
	 * @return 获得订单对应的评价
	 */
	public AssementVO getAss(String orderid) {
		try {
			AssessmentPO assessmentPO = dataService.getAssessment(orderid);
			AssementVO assementVO = new AssementVO(assessmentPO);
			return assementVO;
		} catch (Exception e) {
			e.printStackTrace();
			return new AssementVO();
		}
	}
}
