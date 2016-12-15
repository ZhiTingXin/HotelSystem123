package blservice.impl;

import java.rmi.RemoteException;

import RMI.RemoteHelper;
import blservice.Login_blservice;
import data.service.LoginDataService;
import other.UserType;

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

	@Override
	public UserType assertUserType(String userIdInField) {
		try {
		 UserType type = dataService.findByID(userIdInField).getUserType();
		 return type;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
