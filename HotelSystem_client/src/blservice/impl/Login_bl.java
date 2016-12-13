package blservice.impl;

import java.rmi.RemoteException;

import PO.CustomerPO;
import PO.HotelStaffPO;
import PO.SystemManagerPO;
import PO.SystemStaffPO;
import RMI.RemoteHelper;
import VO.CustomerVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerVO getCustomer(String customerID) {
		CustomerVO customerVO = null;
		try {
			CustomerPO customerPO = RemoteHelper.getInstance().getCustomerDataService().findCustomer(customerID);
			customerVO = new CustomerVO(customerPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return customerVO;
	}

	@Override
	public HotelStaffVO getHotelStaff(String hotelStaffID) {
		HotelStaffVO staffvo = null;
		try {
			HotelStaffPO staffpo = RemoteHelper.getInstance().getHotelStaffDataService().findStaff(hotelStaffID);
			staffvo = new HotelStaffVO(staffpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return staffvo;
	}

	@Override
	public SystemManagerVO getSystemManager(String systemManagerID) {
		SystemManagerVO staffvo = null;
		try {
			SystemManagerPO staffPO = RemoteHelper.getInstance().getSystemManagerDataService().findManager(systemManagerID);
			staffvo = new SystemManagerVO(staffPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return staffvo;
		
	}

	@Override
	public SystemStaffVO getSystemStaff(String systemStaffID) {
		SystemStaffVO staffVO = null;
		try {
			SystemStaffPO staffPO= RemoteHelper.getInstance().getSystemStaffDataService().findStaff(systemStaffID);
			staffVO = new SystemStaffVO(staffPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return staffVO;
	}

}
