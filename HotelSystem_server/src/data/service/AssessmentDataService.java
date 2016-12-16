package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AssessmentPO;

public interface AssessmentDataService extends Remote{

    public boolean addAssessment(AssessmentPO assessmentPO)throws RemoteException;
	
	public boolean deleAssessment(AssessmentPO assessmentPO)throws RemoteException;
	
	public AssessmentPO getAssessment(String orderID)throws RemoteException;
	
	public ArrayList<AssessmentPO> getAllAssement(String hotelid)throws RemoteException;
	
	public ArrayList<AssessmentPO> getUserASS(String userid)throws RemoteException;
}
