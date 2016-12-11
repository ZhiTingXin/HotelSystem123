package data.service.impl;

import java.rmi.RemoteException;

import PO.SystemManagerPO;
import data.dao.DataFactory;
import data.dao.SystemManagerDao;
import data.dao.impl.DataFactoryImpl;
import data.service.SystemManagerDataService;

public class SystemManagerDataServiceImpl implements SystemManagerDataService{

	private DataFactory dataFactory;
	private SystemManagerDao systemManagerDao;
	
	public SystemManagerDataServiceImpl(){
		dataFactory = new DataFactoryImpl();
		systemManagerDao = dataFactory.getSystemManagerDao();
	}
	public SystemManagerPO findManager(String managerID) throws RemoteException {
		
		return systemManagerDao.findManager(managerID);
	}

	public boolean addManager(SystemManagerPO managerPO) throws RemoteException {
		
		return systemManagerDao.addManager(managerPO);
	}

	public boolean deleteManager(SystemManagerPO systemManagerPO) throws RemoteException {
		
		return systemManagerDao.deleteManager(systemManagerPO);
	}

	public boolean updateManager(SystemManagerPO managerPO) throws RemoteException {
		return systemManagerDao.updateManager(managerPO);
	}


}
