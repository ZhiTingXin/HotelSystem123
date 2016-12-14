package blservice.impl;

import java.util.ArrayList;

import PO.CustomerPO;
import PO.HotelPO;
import PO.HotelStaffPO;
import PO.OrderPO;
import PO.SystemManagerPO;
import PO.SystemStaffPO;
import RMI.RemoteHelper;
import VO.CustomerVO;
import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.UserManagement_blservice;
import data.service.CustomerDataService;
import data.service.HotelDataService;
import data.service.HotelStaffDataService;
import data.service.OrderDataService;
import data.service.SystemStaffDataService;

public class UserManagement_bl implements UserManagement_blservice {

	public CustomerVO getCustomer(String customerId) {
		CustomerVO customerVO = null;
		try {
			CustomerPO customerPO = RemoteHelper.getInstance().getCustomerDataService().findCustomer(customerId);
			customerVO = new CustomerVO(customerPO);
			return customerVO;
		} catch (Exception e) {
			e.printStackTrace();
			return customerVO;
		}
	}

	public HotelStaffVO getHotelStaff(String hotelStaffId) {
		HotelStaffVO hotelStaffVO = null;
		try {
			HotelStaffPO hotelStaffPO = RemoteHelper.getInstance().getHotelStaffDataService().findHotelStaff(hotelStaffId);
			hotelStaffVO = new HotelStaffVO(hotelStaffPO);
			return hotelStaffVO;
		} catch (Exception e) {
			e.printStackTrace();
			return hotelStaffVO;
		}
		
	}

	public SystemStaffVO getSystemStaff(String systemStaffId) {
		SystemStaffVO staffVO = null;
		try {
			SystemStaffPO staffPO = RemoteHelper.getInstance().getSystemStaffDataService().findStaff(systemStaffId);
			staffVO = new SystemStaffVO(staffPO);
			return staffVO;
		} catch (Exception e) {
			e.printStackTrace();
			return staffVO;
		}
	}

	public SystemManagerVO getSystemManager(String systemManagerId) {
		SystemManagerVO systemManagerVO = null;
		try {
			SystemManagerPO systemManagerPO = RemoteHelper.getInstance().getSystemManagerDataService()
					.findManager(systemManagerId);
			systemManagerVO = new SystemManagerVO(systemManagerPO);
			return systemManagerVO;
		} catch (Exception e) {
			e.printStackTrace();
			return systemManagerVO;
		}
	}

	public boolean modifyCustomer(CustomerVO customerVO) {
		try {
			CustomerPO customerPO = new  CustomerPO(customerVO);
			return RemoteHelper.getInstance().getCustomerDataService().updateCustomer(customerPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyHotelStaff(HotelStaffVO hotelStaffVO) {
		try {
			HotelStaffPO hotelStaffPO = new HotelStaffPO(hotelStaffVO);
			return RemoteHelper.getInstance().getHotelStaffDataService().updateStaff(hotelStaffPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifySystemStaff(SystemStaffVO systemStaffVO) {
		try {
			SystemStaffPO systemStaffPO = new SystemStaffPO(systemStaffVO);
			return RemoteHelper.getInstance().getSystemStaffDataService().updateStaff(systemStaffPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addSystemStaff(SystemStaffVO staffVO) {
		try {
		     SystemStaffPO staffPO = new SystemStaffPO(staffVO);
		     return RemoteHelper.getInstance().getSystemStaffDataService().addStaff(staffPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addHotel(HotelInfoVO hotelInfoVO) {
		try {
			HotelPO hotelPO = new HotelPO(hotelInfoVO);
			return RemoteHelper.getInstance().getHotelDataService().add(hotelPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addHotelStaff(HotelStaffVO hotelStaffVO) {
		try {
			HotelStaffPO hotelStaffPO = new HotelStaffPO(hotelStaffVO);
			return RemoteHelper.getInstance().getHotelStaffDataService().addStaff(hotelStaffPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<CustomerVO> getAllCustomer() {
		try {
			ArrayList<CustomerPO> list = RemoteHelper.getInstance().getCustomerDataService().getAllCustomers();
			ArrayList<CustomerVO> arrayList = new ArrayList<CustomerVO>();
			for(int i=0;i<list.size();i++){
				CustomerVO customerVO = new CustomerVO(list.get(i));
				arrayList.add(customerVO);
			}
			return arrayList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public ArrayList<HotelStaffVO> getAllHotelStaff() {
		HotelStaffDataService hotelStaffDataService = RemoteHelper.getInstance().getHotelStaffDataService();
		try {
			ArrayList<HotelStaffPO> hotelStaffPOs = hotelStaffDataService.getAllHotelStaffs();
			ArrayList<HotelStaffVO> hotelStaffVOs = new  ArrayList<HotelStaffVO>();
			for(HotelStaffPO po:hotelStaffPOs){
				hotelStaffVOs.add(new HotelStaffVO(po));
			}
			return hotelStaffVOs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<SystemStaffVO> getAllSystemStaff() {
		SystemStaffDataService service = RemoteHelper.getInstance().getSystemStaffDataService();
		try {
			ArrayList<SystemStaffPO> staffPOs = service.getAllSystemStaffs();
			ArrayList<SystemStaffVO> staffVOs = new ArrayList<SystemStaffVO>();
			for(SystemStaffPO po:staffPOs){
				staffVOs.add(new SystemStaffVO(po));
			}
			return staffVOs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getCustomerNum() {
		CustomerDataService dataService = RemoteHelper.getInstance().getCustomerDataService();
		try{
			ArrayList<CustomerPO> customerPOs = dataService.getAllCustomers();
			return customerPOs.size();
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int getHotelStaffNum() {
		HotelDataService hotelDataService = RemoteHelper.getInstance().getHotelDataService();
		try {
			ArrayList<HotelPO> hotelPOs = hotelDataService .getAllHotels();
			return hotelPOs.size();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getSystemStaffNum() {
		SystemStaffDataService service = RemoteHelper.getInstance().getSystemStaffDataService();
		try{
			ArrayList<SystemStaffPO> staffPOs = service.getAllSystemStaffs();
			return staffPOs.size();
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getTodayOrderNumberNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOrderNumber() {
		OrderDataService orderDataService = RemoteHelper.getInstance().getOrderDataService();
		try {
			ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>)orderDataService.getAllOrders();
			return orderPOs.size();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
