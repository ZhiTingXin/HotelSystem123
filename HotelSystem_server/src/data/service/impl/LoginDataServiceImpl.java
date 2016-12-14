package data.service.impl;

import java.rmi.RemoteException;

import PO.LoginPO;
import data.dao.DataFactory;
import data.dao.LoginDao;
import data.dao.impl.DataFactoryImpl;
import data.service.LoginDataService;
import other.UserType;


public class LoginDataServiceImpl implements LoginDataService{
    
	private LoginDao loginDao;
	private DataFactory dataFactory;
	
    public LoginDataServiceImpl(){
    	dataFactory = new DataFactoryImpl();
    	loginDao = dataFactory.getLoginDao();
    }
    

	public boolean confirm(String userId, String userPassword)throws RemoteException {
		return loginDao.confirm(userId, userPassword);
	}

	public boolean add(LoginPO login)throws RemoteException {
		return loginDao.add(login);
	}

	public boolean delete(LoginPO login)throws RemoteException {
		return loginDao.delete(login);
	}

	public boolean update(LoginPO login) throws RemoteException{
		return loginDao.update(login);
	}


	public LoginPO findByID(String userID) throws RemoteException {
		LoginPO loginPO = new LoginPO("151250170", "helloword", UserType.CUSTOMER);
		return loginPO;
	}
    

}
