package blservice.impl;

import PO.CustomerPO;
import PO.LoginPO;
import RMI.RemoteHelper;
import VO.CustomerVO;
import blservice.Register_blservice;
import other.PassWordMd5;
import other.UserType;

public class Register_bl implements Register_blservice {

	/**
	 * @param 用户信息
	 * 
	 * @return 注册一个用户
	 */
	public boolean addRegister(CustomerVO customerVO) {
		LoginPO loginPO = new LoginPO(customerVO.getId(),
				PassWordMd5.EncryptionStr16(customerVO.getPassword(), PassWordMd5.MD5, PassWordMd5.UTF8),
				UserType.CUSTOMER);
		CustomerPO customerPO = new CustomerPO(customerVO);
		try {
			boolean a = RemoteHelper.getInstance().getLoginDataService().add(loginPO);
			boolean b = RemoteHelper.getInstance().getCustomerDataService().addCustomer(customerPO);
			return (a && b);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
