package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AdviceFeedBackPO;
import RMI.RemoteHelper;
import VO.AdviceFeedBackVO;
import blservice.AdviceFeedBack_blservice;
import data.service.AdviceFeedBackDataService;
import other.AdviceFeedBackState;

/**
 * @author lenovo
 *
 */
public class AdviceFeedBack_bl implements AdviceFeedBack_blservice {

	AdviceFeedBackDataService adviceFeedBackDataService = RemoteHelper.getInstance().getAdviceFeedBackDataService();

	/**
	 * @param userID
	 * @return 返回所有的用户的反馈信息
	 */
	public ArrayList<AdviceFeedBackVO> getAllAdvice(String userID) {
		ArrayList<AdviceFeedBackVO> voList = new ArrayList<AdviceFeedBackVO>();
		try {
			ArrayList<AdviceFeedBackPO> poList = adviceFeedBackDataService.getAdvices(userID, "userId");
			voList = new ArrayList<AdviceFeedBackVO>();
			for (int i = 0; i < poList.size(); i++) {
				voList.add(new AdviceFeedBackVO(poList.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return voList;
	}

	/**
	 * @param advicefeedbackvo
	 * @return 添加反馈信息是否成功
	 */
	public boolean addAdviceFeedBack(AdviceFeedBackVO advicefeedbackvo) {
		AdviceFeedBackPO addPO = new AdviceFeedBackPO(advicefeedbackvo);

		try {
			return adviceFeedBackDataService.addAdvice(addPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param
	 * @return 修改反馈信息是否成功
	 */
	public boolean modifyAdviceFeedBack(AdviceFeedBackVO advicefeedbackvo) {
		AdviceFeedBackPO addPO = new AdviceFeedBackPO(advicefeedbackvo);
		try {
			return adviceFeedBackDataService.updateAdvice(addPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param
	 * @return 返回所有没有处理的反馈
	 */
	public ArrayList<AdviceFeedBackVO> getUnprocessedAdvice() {
		ArrayList<AdviceFeedBackVO> voList = new ArrayList<AdviceFeedBackVO>();
		try {
			ArrayList<AdviceFeedBackPO> poList = adviceFeedBackDataService.getAllAdvices();
			voList = new ArrayList<AdviceFeedBackVO>();

			for (AdviceFeedBackPO po : poList) {
				if (po.getState() == (AdviceFeedBackState.UNPROCESSED)) {
					voList.add(new AdviceFeedBackVO(po));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return voList;
	}

	/**
	 * @param
	 * @return 返回已经处理了的反馈
	 */
	public ArrayList<AdviceFeedBackVO> getProcessedAdvice() {
		ArrayList<AdviceFeedBackVO> voList = new ArrayList<AdviceFeedBackVO>();
		try {
			ArrayList<AdviceFeedBackPO> poList = adviceFeedBackDataService.getAllAdvices();
			voList = new ArrayList<AdviceFeedBackVO>();

			for (AdviceFeedBackPO po : poList) {
				if (po.getState() == (AdviceFeedBackState.PROCESSED)) {
					voList.add(new AdviceFeedBackVO(po));
				}
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return voList;
	}

}
