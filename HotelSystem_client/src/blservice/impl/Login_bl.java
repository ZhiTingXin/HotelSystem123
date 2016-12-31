package blservice.impl;

import java.rmi.RemoteException;

import RMI.RemoteHelper;
import VO.CustomerVO;
import blservice.Login_blservice;
import blservice.UserInfo_blservice;
import blservice.UserManagement_blservice;
import data.service.LoginDataService;
import other.PassWordMd5;
import other.UserType;

public class Login_bl implements Login_blservice {

	LoginDataService dataService = RemoteHelper.getInstance().getLoginDataService();

	/**
	 * @param 用户的id，和密码
	 * @return 是否能够登录
	 */
	public boolean comfirm(String user_id, String user_password) {
		try {
			user_password = PassWordMd5.EncryptionStr16(user_password, PassWordMd5.MD5, PassWordMd5.UTF8);
			return dataService.confirm(user_id, user_password);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 用户的id
	 * @return 用户的类型
	 */
	public UserType assertUserType(String userIdInField) {
		try {
			UserType type = dataService.findByID(userIdInField).getUserType();
			return type;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isOnlineConfirm(String userId) {
		// TODO Auto-generated method stub
		UserManagement_blservice service = new UserManagement_bl();
		CustomerVO customer = service.getCustomer(userId);
		return customer.isOnline();
	}

	@Override
	public void login(String userId) {
		// TODO Auto-generated method stub
		UserInfo_blservice service = new UserInfo_bl();
		UserManagement_blservice managementService = new UserManagement_bl();
		CustomerVO customer = managementService.getCustomer(userId);
		customer.changeLoginState(true);
		service.modifyCustomer(customer);
	}

}
