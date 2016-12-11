package blservice.impl;

import PO.CustomerPO;
import PO.HotelStaffPO;
import PO.LoginPO;
import PO.SystemManagerPO;
import PO.SystemStaffPO;
import RMI.RemoteHelper;
import VO.CustomerVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.UserInfo_blservice;

public class UserInfo_bl implements UserInfo_blservice{

	public boolean modifyCustomer(CustomerVO customerVO) {
		CustomerPO customerPO = new CustomerPO(customerVO);
		try{
			return RemoteHelper.getInstance().getCustomerDataService().updateCustomer(customerPO);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyHotelStaff(HotelStaffVO hotelStaffVO) {
		try{
		HotelStaffPO hotelStaffPO = new HotelStaffPO(hotelStaffVO);
		return RemoteHelper.getInstance().getHotelStaffDataService().updateStaff(hotelStaffPO);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifySystemStaff(SystemStaffVO systemStaffVO) {
		try{
			SystemStaffPO systemStaffPO = new SystemStaffPO(systemStaffVO);
			return RemoteHelper.getInstance().getSystemStaffDataService().updateStaff(systemStaffPO);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifySystemManager(SystemManagerVO systemManagerVO) {
		try {
			SystemManagerPO systemManagerPO = new SystemManagerPO(systemManagerVO);
			return RemoteHelper.getInstance().getSystemManagerDataService().updateManager(systemManagerPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyPassword(String userId, String password) {
		try {
			LoginPO loginPO  = new LoginPO(userId, password);
			return RemoteHelper.getInstance().getLoginDataService().update(loginPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
