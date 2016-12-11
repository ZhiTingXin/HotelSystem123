package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AdviceFeedBackPO;
import RMI.RemoteHelper;
import VO.AdviceFeedBackVO;
import blservice.AdviceFeedBack_blservice;
import data.service.AdviceFeedBackDataService;
import other.AdviceFeedBackState;
import other.OrderState;

public class AdviceFeedBack_bl implements AdviceFeedBack_blservice{
	AdviceFeedBackDataService adviceFeedBackDataService =	RemoteHelper.getInstance().getAdviceFeedBackDataService();
	public ArrayList<AdviceFeedBackVO> getAllAdvice(String userID) {
		try {
			ArrayList<AdviceFeedBackPO> poList = adviceFeedBackDataService.getAdvices(userID, "type");
			ArrayList<AdviceFeedBackVO> voList = new ArrayList<AdviceFeedBackVO>();
			for(int i = 0; i<poList.size(); i++){
				voList.add(new AdviceFeedBackVO(poList.get(i)));
			}
			
			return voList;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addAdviceFeedBack(AdviceFeedBackVO advicefeedbackvo) {
		AdviceFeedBackState state1 = advicefeedbackvo.getState();
		String adviceFeedBack_content = advicefeedbackvo.getAdviceFeedBack_content();
		 AdviceFeedBackPO addPO =new AdviceFeedBackPO(state1,adviceFeedBack_content);
		
		try {
			return adviceFeedBackDataService.addAdvice(addPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyAdviceFeedBack(AdviceFeedBackVO advicefeedbackvo) {
		AdviceFeedBackState state1 = advicefeedbackvo.getState();
		String adviceFeedBack_content = advicefeedbackvo.getAdviceFeedBack_content();
		 AdviceFeedBackPO addPO =new AdviceFeedBackPO(state1,adviceFeedBack_content);
		
		try {
			return adviceFeedBackDataService.updateAdvice(addPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<AdviceFeedBackVO> getUnprocessedAdvice(String systemstaffId) {
		try {
			ArrayList<AdviceFeedBackPO> poList = adviceFeedBackDataService.getAdvices(systemstaffId, "null");
			ArrayList<AdviceFeedBackVO> voList = new ArrayList<AdviceFeedBackVO>();
			
			for(AdviceFeedBackPO po : poList){
				if(po.getState().equals(AdviceFeedBackState.UNPROCESSED)){
					voList.add(new AdviceFeedBackVO(po));
				}
			}
			
			return voList;
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<AdviceFeedBackVO> getProcessedAdvice(String systemstaffId) {
		try {
			ArrayList<AdviceFeedBackPO> poList = adviceFeedBackDataService.getAdvices(systemstaffId, "null");
			ArrayList<AdviceFeedBackVO> voList = new ArrayList<AdviceFeedBackVO>();
			
			for(AdviceFeedBackPO po : poList){
				if(po.getState().equals(AdviceFeedBackState.PROCESSED)){
					voList.add(new AdviceFeedBackVO(po));
				}
			}
			
			return voList;
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
