package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AdviceFeedBackPO;
import RMI.RemoteHelper;
import VO.AdviceFeedBackVO;
import blservice.AdviceFeedBack_blservice;
import data.service.AdviceFeedBackDataService;
import other.AdviceFeedBackState;

public class AdviceFeedBack_bl implements AdviceFeedBack_blservice{
	AdviceFeedBackDataService adviceFeedBackDataService =	RemoteHelper.getInstance().getAdviceFeedBackDataService();
	public ArrayList<AdviceFeedBackVO> getAllAdvice(String userID) {
		try {
			ArrayList<AdviceFeedBackPO> poList = adviceFeedBackDataService.getAdvices(userID, "userId");
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
		 AdviceFeedBackPO addPO =new AdviceFeedBackPO(advicefeedbackvo);
		
		try {
			return adviceFeedBackDataService.addAdvice(addPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyAdviceFeedBack(AdviceFeedBackVO advicefeedbackvo) {
		 AdviceFeedBackPO addPO =new AdviceFeedBackPO(advicefeedbackvo);
		try {
			return adviceFeedBackDataService.updateAdvice(addPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<AdviceFeedBackVO> getUnprocessedAdvice() {
		try {
			ArrayList<AdviceFeedBackPO> poList = adviceFeedBackDataService.getAllAdvices();
			ArrayList<AdviceFeedBackVO> voList = new ArrayList<AdviceFeedBackVO>();
			
			for(AdviceFeedBackPO po : poList){
				if(po.getState()==(AdviceFeedBackState.UNPROCESSED)){
					voList.add(new AdviceFeedBackVO(po));
				}
			}
			
			return voList;
			
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<AdviceFeedBackVO> getProcessedAdvice() {
		try {
			ArrayList<AdviceFeedBackPO> poList = adviceFeedBackDataService.getAllAdvices();
			ArrayList<AdviceFeedBackVO> voList = new ArrayList<AdviceFeedBackVO>();
			
			for(AdviceFeedBackPO po : poList){
				if(po.getState()==(AdviceFeedBackState.PROCESSED)){
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
