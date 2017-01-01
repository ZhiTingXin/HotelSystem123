package blservice.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import PO.CustomerPO;
import PO.HotelPO;
import PO.HotelStaffPO;
import PO.LoginPO;
import PO.OrderPO;
import PO.SystemManagerPO;
import PO.SystemStaffPO;
import RMI.RemoteHelper;
import VO.CustomerVO;
import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import VO.VipVO;
import blservice.SystemStrategy_blservice;
import blservice.UserManagement_blservice;
import blservice.VipStrategy_blService;
import data.service.CustomerDataService;
import data.service.HotelStaffDataService;
import data.service.LoginDataService;
import data.service.OrderDataService;
import data.service.SystemStaffDataService;
import other.PassWordMd5;
import other.StrategyState;
import other.SystemStrategyType;
import other.UserType;

public class UserManagement_bl implements UserManagement_blservice {

	/**
	 * @param 客户id
	 * 
	 * @return 客户的基本信息
	 */
	public CustomerVO getCustomer(String customerId) {
		try {
			SystemStrategy_blservice strategy_blservice = new SystemStrategy_bl();
			VipStrategy_blService vipStrategy_blService = new VipStrategy_blServiceImpl();
			CustomerPO customerPO = RemoteHelper.getInstance().getCustomerDataService().findCustomer(customerId);
			CustomerVO customerVO = new CustomerVO(customerPO);
			SystemStrategyVO strategyVO = strategy_blservice.getSystemStrategys(SystemStrategyType.MEMBER).get(0);
			if(strategyVO.getStrategyState()==StrategyState.open){
				ArrayList<VipVO> vipVOs = vipStrategy_blService.getVipStrategy().getVipStrategyVOList();
				for(VipVO vo:vipVOs){
					if(customerVO.getCredit()>=vo.getMincredit()&&customerVO.getCredit()<vo.getMaxcredit()){
						customerVO.setMemberGrade(vo.getVipgrade());
						break;
					}
				}
				modifyCustomer(customerVO);
			}
			return customerVO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param 酒店工作人员
	 * 
	 * @return 酒店工作人员信息
	 */
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

	/**
	 * @param 网站营销人员id
	 * 
	 * @return 网站营销人员信息
	 */
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

	/**
	 * @param 网站管理人员id
	 * 
	 * @return 网站管理人员信息
	 */
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

	/**
	 * @param 修改后的客户信息
	 * 
	 * @return 
	 * 更新客户信息
	 */
	public boolean modifyCustomer(CustomerVO customerVO) {
		try {
			CustomerPO customerPO = new  CustomerPO(customerVO);
			return RemoteHelper.getInstance().getCustomerDataService().updateCustomer(customerPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 修改后的酒店工作人员信息
	 * 
	 * @return 
	 * 更新酒店工作人员信息
	 */
	public boolean modifyHotelStaff(HotelStaffVO hotelStaffVO) {
		try {
			HotelStaffPO hotelStaffPO = new HotelStaffPO(hotelStaffVO);
			return RemoteHelper.getInstance().getHotelStaffDataService().updateStaff(hotelStaffPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 修改后的网站营销人员信息
	 * 
	 * @return 更新网站营销人员信息
	 */
	public boolean modifySystemStaff(SystemStaffVO systemStaffVO) {
		try {
			SystemStaffPO systemStaffPO = new SystemStaffPO(systemStaffVO);
			return RemoteHelper.getInstance().getSystemStaffDataService().updateStaff(systemStaffPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 网站营销工作人员信息
	 * 
	 * @return 添加网站营销工作人员
	 */
	public boolean addSystemStaff(SystemStaffVO staffVO) {
		try {
		     SystemStaffPO staffPO = new SystemStaffPO(staffVO);
		     boolean a = RemoteHelper.getInstance().getSystemStaffDataService().addStaff(staffPO);
		     LoginPO login = new LoginPO(staffVO.getId(), PassWordMd5.
		    		 EncryptionStr16(staffVO.getPassword(),PassWordMd5.MD5,PassWordMd5.UTF8), UserType.SYSTEMSTAFF);
		     boolean b = RemoteHelper.getInstance().getLoginDataService().add(login);
		     return a&&b;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 酒店基本信息
	 * 
	 * @return 添加酒店 
	 */
	public boolean addHotel(HotelInfoVO hotelInfoVO) {
		try {
			HotelPO hotelPO = new HotelPO(hotelInfoVO);
			return RemoteHelper.getInstance().getHotelDataService().add(hotelPO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 酒店工作人员信息
	 * 
	 * @return 添加酒店工作人员
	 */
	public boolean addHotelStaff(HotelStaffVO hotelStaffVO) {
		try {
			HotelStaffPO hotelStaffPO = new HotelStaffPO(hotelStaffVO);
			LoginPO loginPO = new LoginPO(hotelStaffVO.getId(),PassWordMd5.EncryptionStr16(hotelStaffVO.getPassword(),PassWordMd5.MD5,PassWordMd5.UTF8),UserType.HOTELSTAFF);
			boolean a = RemoteHelper.getInstance().getHotelStaffDataService().addStaff(hotelStaffPO);
			boolean b = RemoteHelper.getInstance().getLoginDataService().add(loginPO);
			return a&&b;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 
	 * 
	 * @return 
	 * 得到所有的客户信息
	 */
	public ArrayList<CustomerVO> getAllCustomer() {
		ArrayList<CustomerVO> arrayList = new ArrayList<CustomerVO>();
		try {
			ArrayList<CustomerPO> list = RemoteHelper.getInstance().getCustomerDataService().getAllCustomers();
			for(int i=0;i<list.size();i++){
				CustomerVO customerVO = new CustomerVO(list.get(i));
				arrayList.add(customerVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	/**
	 * @param 
	 * 
	 * @return 
	 * 返回所有的酒店工作人员信息
	 */
	public ArrayList<HotelStaffVO> getAllHotelStaff() {
		HotelStaffDataService hotelStaffDataService = RemoteHelper.getInstance().getHotelStaffDataService();
		ArrayList<HotelStaffVO> hotelStaffVOs = new  ArrayList<HotelStaffVO>();
		try {
			ArrayList<HotelStaffPO> hotelStaffPOs = hotelStaffDataService.getAllHotelStaffs();
			for(HotelStaffPO po:hotelStaffPOs){
				hotelStaffVOs.add(new HotelStaffVO(po));
			}
			return hotelStaffVOs;
		} catch (Exception e) {
			e.printStackTrace();
			return hotelStaffVOs;
		}
	}

	/**
	 * @param 
	 * 
	 * @return 
	 * 返回所有的网站营销人员信息
	 */
	public ArrayList<SystemStaffVO> getAllSystemStaff() {
		SystemStaffDataService service = RemoteHelper.getInstance().getSystemStaffDataService();
		ArrayList<SystemStaffVO> staffVOs = new ArrayList<SystemStaffVO>();
		try {
			ArrayList<SystemStaffPO> staffPOs = service.getAllSystemStaffs();
			for(SystemStaffPO po:staffPOs){
				staffVOs.add(new SystemStaffVO(po));
			}
			return staffVOs;
		} catch (Exception e) {
			e.printStackTrace();
			return staffVOs;
		}
	}

	/**
	 * @param 
	 * 
	 * @return 
	 * 网站注册客户的数量
	 */
	public int getCustomerNum() {
		
			ArrayList<CustomerVO> customerVOs = getAllCustomer();
			return customerVOs.size();
		
	}

	/**
	 * @param 
	 * 
	 * @return 
	 * 网站注册酒店的数量
	 */
	public int getHotelStaffNum() {
			ArrayList<HotelStaffVO> hotelStaffVOs = getAllHotelStaff();
			return hotelStaffVOs.size();
	}

	/**
	 * @param 
	 * 
	 * @return 
	 * 网站营销人员的数量
	 */
	public int getSystemStaffNum() {
			ArrayList<SystemStaffVO> staffPOs = getAllSystemStaff();
			return staffPOs.size();
	}

	/**
	 * @param 
	 * 
	 * @return 
	 * 返回今日订单数量
	 */
	public int getTodayOrderNumberNum() {
		LocalDate localDate  = LocalDate.now();
		int num = 0;
		try{
	    ArrayList<OrderPO> orderPOs = (ArrayList<OrderPO>)RemoteHelper.getInstance()
	    		.getOrderDataService().getAllOrders();
	    for(OrderPO po:orderPOs){
	    	if(localDate.equals(po.getGretime())){
	    		num ++;
	    	}
	    }
	    return num;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * @param 
	 * 
	 * @return 
	 * 返回所有订单的数量
	 */
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
	
	public boolean deleSystemStaff(SystemStaffVO vo){
		SystemStaffDataService service = RemoteHelper.getInstance().getSystemStaffDataService();
		LoginDataService loginDataService = RemoteHelper.getInstance().getLoginDataService();
		try {
			SystemStaffPO staffPO = new SystemStaffPO(vo);
			LoginPO loginPO = new LoginPO();
			loginPO.setId(vo.getId());
			service.deleteStaff(staffPO);
			loginDataService.delete(loginPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 删除用户
	 */
	public boolean deleCustomer(CustomerVO vo) {
	    CustomerDataService service = RemoteHelper.getInstance().getCustomerDataService();
		LoginDataService loginDataService = RemoteHelper.getInstance().getLoginDataService();
		try {
			CustomerPO customerPO = new CustomerPO(vo);
			LoginPO loginPO = new LoginPO();
			loginPO.setId(vo.getId());
			service.deleteCustomer(customerPO);
			loginDataService.delete(loginPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
