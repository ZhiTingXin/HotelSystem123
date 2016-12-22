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
import other.PassWordMd5;

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
			LoginPO loginPO1 = RemoteHelper.getInstance().getLoginDataService().findByID(userId);
			LoginPO loginPO  = new LoginPO(userId,PassWordMd5.EncryptionStr16(password, PassWordMd5.MD5,PassWordMd5.UTF8),loginPO1.getUserType());
			return RemoteHelper.getInstance().getLoginDataService().update(loginPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
