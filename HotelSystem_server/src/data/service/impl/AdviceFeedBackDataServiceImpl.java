package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import PO.AdviceFeedBackPO;
import data.dao.AdviceFeedbackDao;
import data.dao.DataFactory;
import data.dao.impl.DataFactoryImpl;
import data.service.AdviceFeedBackDataService;

public class AdviceFeedBackDataServiceImpl implements AdviceFeedBackDataService {
	
	private DataFactory dataFactory;
	private AdviceFeedbackDao adviceFeedbackDao;
			
 	public AdviceFeedBackDataServiceImpl(){
 		dataFactory = new DataFactoryImpl();
		adviceFeedbackDao = dataFactory.getAdviceFeedbackDao();
	}
	
	public boolean addAdvice(AdviceFeedBackPO advicefeedback) throws RemoteException {
	
		return adviceFeedbackDao.addAdvice(advicefeedback);
	}

	public boolean updateAdvice(AdviceFeedBackPO advicefeedback) throws RemoteException {
		return adviceFeedbackDao.updateAdvice(advicefeedback);
	}

	public ArrayList<AdviceFeedBackPO> getAdvices(String userId,String type) throws RemoteException {
		// TODO Auto-generated method stub
		return adviceFeedbackDao.getAdvices(userId, type);
	}

	public ArrayList<AdviceFeedBackPO> getAllAdvices() throws RemoteException {
		return adviceFeedbackDao.getAllAdvices();
	}


}
