package blservice.impl;

import java.rmi.RemoteException;

import PO.LoginPO;
import RMI.RemoteHelper;
import blservice.Login_blservice;
import data.service.LoginDataService;

public class Login_bl implements Login_blservice {
	LoginDataService dataService = RemoteHelper.getInstance().getLoginDataService();
	
	public boolean comfirm(String user_id, String user_password) {
		try {
			return dataService.confirm(user_id, user_password);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

//	public boolean addUser(String user_id, String user_password,) {
//		try {
//			if()
//			return dataService.add(new LoginPO(user_id,user_password));
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	public boolean modifyPassword(String user_id, String user_password) {
//		try {
//			return dataService.update(new LoginPO(user_id,user_password));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//
//	}

}
