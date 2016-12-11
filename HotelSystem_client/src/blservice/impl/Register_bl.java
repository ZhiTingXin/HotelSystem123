package blservice.impl;

import PO.CustomerPO;
import PO.LoginPO;
import RMI.RemoteHelper;
import VO.CustomerVO;
import blservice.Register_blservice;

public class Register_bl implements Register_blservice{

	public boolean addRegister(CustomerVO customerVO) {
		LoginPO loginPO = new LoginPO(customerVO.getId(), customerVO.getPassword());
		CustomerPO customerPO = new CustomerPO(customerVO);
		try {
			boolean a = RemoteHelper.getInstance().getLoginDataService().add(loginPO);
			boolean b = RemoteHelper.getInstance().getCustomerDataService().addCustomer(customerPO);
			return a&&b;
		} catch (Exception e) {
			return false;
		}
	}

}
