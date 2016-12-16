package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AssessmentPO;
import data.dao.AssessmentDao;
import data.dao.DataFactory;
import data.dao.impl.DataFactoryImpl;
import data.service.AssessmentDataService;

public class AssemmentDataServiceImpl implements AssessmentDataService{

	private DataFactory factory;
	private AssessmentDao assessmentDao;
	
	public AssemmentDataServiceImpl(){
		factory = new DataFactoryImpl();
		assessmentDao = factory.getAssessmentDao();
	}
	public boolean addAssessment(AssessmentPO assessmentPO) throws RemoteException {
		return assessmentDao.addAssessment(assessmentPO);
	}

	public boolean deleAssessment(AssessmentPO assessmentPO) throws RemoteException {
		return assessmentDao.deleAssessment(assessmentPO);
	}

	public AssessmentPO getAssessment(String orderID) throws RemoteException {
		return assessmentDao.getAssessment(orderID);
	}

	public ArrayList<AssessmentPO> getAllAssement(String hotelid) throws RemoteException {
		return assessmentDao.getAllAssement(hotelid);
	}
	public ArrayList<AssessmentPO> getUserASS(String userid) throws RemoteException {
		return assessmentDao.getUserASS(userid);
	}

}
