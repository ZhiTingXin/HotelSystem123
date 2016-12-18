package Test;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.LoginPO;
import PO.SystemManagerPO;
import RMI.RemoteHelper;
import VO.CustomerVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.Login_blservice;
import blservice.UserManagement_blservice;
import blservice.impl.Login_bl;
import blservice.impl.UserManagement_bl;
import data.service.LoginDataService;
import data.service.SystemManagerDataService;
import main.ClientRunner;
import other.UserType;
import util.DateUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserManagerTester {

	ClientRunner client = new ClientRunner();
	UserManagement_blservice use = new UserManagement_bl();
//	@Test
//	public void test001addhotelstaff(){
//		HotelStaffVO hotelStaffVO = new HotelStaffVO();
//		hotelStaffVO.setHotelId("1234566");
//		hotelStaffVO.setHotelName("½ðÁê´ó¾Æµê");
//		hotelStaffVO.setPassword("dadauh");
//		hotelStaffVO.setPhone("15263452626");
//		hotelStaffVO.setUsername("Ìï¹óËÉÐ¡½ã");
//		HotelStaffVO hotelStaffVO1 = new HotelStaffVO();
//		hotelStaffVO1.setHotelId("1234566");
//		hotelStaffVO1.setHotelName("½ðÁê´ó¾Æµê");
//		hotelStaffVO1.setPassword("dadauh");
//		hotelStaffVO1.setPhone("15263452626");
//		hotelStaffVO1.setUsername("Ìï¹óËÉÐ¡½ã");
//		HotelStaffVO hotelStaffVO2 = new HotelStaffVO();
//		hotelStaffVO2.setHotelId("1234566");
//		hotelStaffVO2.setHotelName("½ðÁê´ó¾Æµê");
//		hotelStaffVO2.setPassword("dadauh");
//		hotelStaffVO2.setPhone("15263452626");
//		hotelStaffVO2.setUsername("Ìï¹óËÉÐ¡½ã");
//		HotelStaffVO hotelStaffVO3 = new HotelStaffVO();
//		hotelStaffVO3.setHotelId("1234566");
//		hotelStaffVO3.setHotelName("½ðÁê´ó¾Æµê");
//		hotelStaffVO3.setPassword("dadauh");
//		hotelStaffVO3.setPhone("15263452626");
//		hotelStaffVO3.setUsername("Ìï¹óËÉÐ¡½ã");
//		HotelStaffVO hotelStaffVO4 = new HotelStaffVO();
//		hotelStaffVO4.setHotelId("1234566");
//		hotelStaffVO4.setHotelName("½ðÁê´ó¾Æµê");
//		hotelStaffVO4.setPassword("dadauh");
//		hotelStaffVO4.setPhone("15263452626");
//		hotelStaffVO4.setUsername("Ìï¹óËÉÐ¡½ã");
//		use.addHotelStaff(hotelStaffVO4);
//		use.addHotelStaff(hotelStaffVO3);
//		use.addHotelStaff(hotelStaffVO2);
//		use.addHotelStaff(hotelStaffVO1);
//		assertEquals(true,use.addHotelStaff(hotelStaffVO));
//	}
//	@Test
//	public void test002addSystemstaff(){
//		SystemStaffVO systemStaffVO = new SystemStaffVO();
//		systemStaffVO.setBusinessDistrict("ÐÂ½Ö¿Ú");
//		systemStaffVO.setPassword("123456");
//		systemStaffVO.setPhone("15951926228");
//		systemStaffVO.setUsername("²½±ø´óË§¸ç");
//		SystemStaffVO systemStaffVO1 = new SystemStaffVO();
//		systemStaffVO1.setBusinessDistrict("ÐÂ½Ö¿Ú");
//		systemStaffVO1.setPassword("123456");
//		systemStaffVO1.setPhone("15951926228");
//		systemStaffVO1.setUsername("²½±ø´óË§¸ç");
//		use.addSystemStaff(systemStaffVO1);
//		assertEquals(true, use.addSystemStaff(systemStaffVO));
//	}
//	@Test
//	public void test003getcustomer(){
//		String id = "151250549";
//		assertEquals("Ð»ÕñÓî", use.getCustomer(id).getUsername());
//	}
//	
//	@Test
//	public void test004getallcus(){
//		ArrayList<CustomerVO> customerVOs = use.getAllCustomer();
//		assertEquals(DateUtil.parse_1("2015-02-12"),customerVOs.get(1).getBirthday());
//	}
//	@Test
//	public void test005gethotelstaff(){
//		String hotelstaffid = "207";
//		assertEquals("Ìï¹óËÉÐ¡½ã", use.getHotelStaff(hotelstaffid).getUsername());
//	}
//	@Test
//	public void test006getallhotelstaff(){
//		ArrayList<HotelStaffVO> hotelStaffVOs = use.getAllHotelStaff();
//		assertEquals("ÐÁÖ¾Í¥",hotelStaffVOs.get(0).getUsername());
//	}
//	@Test
//	public void test007getsys(){
//		String id = "223";
//		assertEquals("²½±ø´óË§¸ç", use.getSystemStaff(id).getUsername());
//	}
//	@Test
//	public void test008getallsysstaff(){
//		ArrayList<SystemStaffVO> hotelStaffVOs = use.getAllSystemStaff();
//		assertEquals("²½±ø´óË§¸ç",hotelStaffVOs.get(1).getUsername());
//	}
//	@Test
//	public void test009Modifyc(){
//		String id = "151250";
//		CustomerVO customerVO = use.getCustomer(id);
//		LocalDate birthday = DateUtil.parse_1("2016-10-12");
//		customerVO.setBirthday(birthday);
//		assertEquals(true, use.modifyCustomer(customerVO));
//	}
//	@Test
//	public void test0010modifyho(){
//		String id = "205";
//		HotelStaffVO hotelStaffVO = use.getHotelStaff(id);
//		hotelStaffVO.setUsername("ÐÁÖ¾Í¥");
//		assertEquals(true, use.modifyHotelStaff(hotelStaffVO));
//	}
//	@Test
//	public void test0011modifysys(){
//		String id = "222";
//		SystemStaffVO systemStaffVO = use.getSystemStaff(id);
//		systemStaffVO.setUsername("xinzhiting");
//		assertEquals(true, use.modifySystemStaff(systemStaffVO));
//	}
//	@Test
//	public void test0012getnumofc(){
//		int nu = use.getCustomerNum();
//		assertEquals(2, nu);
//	}
//	@Test
//	public void test0013getnumofh(){
//		assertEquals(15, use.getHotelStaffNum());
//	}
//	@Test
//	public void test0014getnumofs(){
//		assertEquals(2, use.getSystemStaffNum());
//	}
//	@Test
//	public void test0015getnumofo(){
//		assertEquals(27, use.getOrderNumber());
//	}
	@Test
	public void test0016getmanager(){
	    LoginDataService loginDataService = RemoteHelper.getInstance().getLoginDataService();
//		String id = "252";
//		SystemManagerVO systemManagerVO = use.getSystemManager(id);
//		assertEquals("xinzhiting",systemManagerVO.getUserName());
		SystemManagerVO systemManagerVO = new SystemManagerVO();
		systemManagerVO.setPassword("123");
		LoginPO login = new LoginPO(systemManagerVO.getId(),"123",UserType.SYSTEMMANAGER);
		try {
			loginDataService.add(login);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		systemManagerVO.setUsername("ÐÁÖ¾Í¥");
		SystemManagerPO managerPO = new SystemManagerPO(systemManagerVO);
		SystemManagerDataService service = RemoteHelper.getInstance().getSystemManagerDataService();
		try {
			service.addManager(managerPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
