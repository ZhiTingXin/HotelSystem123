package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.LogofUserPO;
import data.dao.DataFactory;
import data.dao.LogOfUserDao;
import data.dao.impl.DataFactoryImpl;
import data.service.LogOfUserDataService;

public class LogOfUserDataServiceImpl implements LogOfUserDataService{

	private DataFactory factory;
	private LogOfUserDao logOfUserDao;
	public LogOfUserDataServiceImpl(){
		factory = new DataFactoryImpl();
		logOfUserDao = factory.getLogOfUserDao();
	}
	public boolean add(LogofUserPO log) throws RemoteException {
		return logOfUserDao.add(log);
	}

	public ArrayList<LogofUserPO> getAllLogsOfUser(String userid) throws RemoteException {
		return logOfUserDao.getLogsOfUser(userid);
	}

}
