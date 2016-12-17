package testAll;

import java.time.LocalDate;
import java.util.ArrayList;

import PO.ClassToGreId;
import PO.RoomPO;
import PO.SuperVipPO;
import PO.SystemManagerPO;
import data.dao.AdviceFeedbackDao;
import data.dao.OrderDao;
import data.dao.RoomDao;
import data.dao.impl.AdviceFeedbackDaoImpl;
import data.dao.impl.OrderDaoImpl;
import data.dao.impl.RoomDaoImpl;
import data.service.HotelStrategyDataService;
import data.service.IdGernerateService;
import data.service.RoomDataService;
import data.service.SuperVipDataService;
import data.service.impl.HotelStrategyDataServiceImpl;
import data.service.impl.IdGernerateServiceImpl;
import data.service.impl.RoomDataServiceImpl;
import data.service.impl.SupVipDataServiceImpl;
import other.hibernateUtil;

//import PO.AdviceFeedBackPO;
//import data.service.AdviceFeedBackDataService;
//import data.service.impl.AdviceFeedBackDataServiceImpl;
//import other.AdviceFeedBackState;

public class tes {

	public static void main(String [] args)throws Exception{
//		AdviceFeedBackDataService adviceFeedBackDataService = new AdviceFeedBackDataServiceImpl();
//		AdviceFeedBackPO adviceFeedBackPO = new  AdviceFeedBackPO();
//		adviceFeedBackPO.setAdviceFeedBack_content("adua64565");
//		adviceFeedBackPO.setState(AdviceFeedBackState.PROCESSED);
////		adviceFeedBackPO.setSystemStaffId("151250170");
//		adviceFeedBackPO.setUserId("151250169");
//		adviceFeedBackDataService.updateAdvice(adviceFeedBackPO);
//		CustomerPO customerPO = new CustomerPO();
//		customerPO.setBirthday(new Date());
//		customerPO.setCredit(0);
//		customerPO.setId("151250179");
//		customerPO.setMemberGrade(5);
//		customerPO.setPhone("15851266554");
//		customerPO.setUserName("xinzhiting");
//		hibernateUtil.add(customerPO);
//		ArrayList<CustomerPO> list2 = (ArrayList<CustomerPO>)hibernateUtil.getAll("customer",CustomerPO.class);
//		for(int i=0;i<list2.size();i++){
//			System.out.println(list2.get(i).getId());
//		}
//		for(CustomerPO customerPO:list){
//			
//		}
//		ArrayList<CustomerPO> list  = (ArrayList<CustomerPO>)hibernateUtil.findbySome("CustomerPO", "userName", "xinzhiting");
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getId());
//		}
//		LoginPO loginPO = new  LoginPO("gh1jg","ghgh");
//		LoginDataService loginDataService = new LoginDataServiceImpl();
//		loginDataService.add(loginPO);
//		ClassToGreId classToGreId = new ClassToGreId();
//		classToGreId.setId("123");
//		classToGreId.setNeverChanged("1");
//		hibernateUtil.add(classToGreId);
//		IdGernerateService idGernerateService = new IdGernerateServiceImpl();
//		String id = idGernerateService.gernerateId();
//		LoginDataService a = new LoginDataServiceImpl();
//		String string = "151250170";
//		System.out.println(a.findByID(string).getUserType());
//		IdGernerateServiceImpl aGernerateServiceImpl = new IdGernerateServiceImpl();
//		SystemManagerPO systemManagerPO = new SystemManagerPO();
//		systemManagerPO.setManagerID(aGernerateServiceImpl.gernerateId());
//		systemManagerPO.setManagerName("xinzhiting");
//		hibernateUtil.add(systemManagerPO);
//		LocalDate localDate = LocalDate.now();
//		System.out.println(localDate);
//		RoomDataService dataService = new RoomDataServiceImpl();
//		RoomDao dao = new  RoomDaoImpl();
//		String id = "377";
//		System.out.println(dao.getAllRoomPO(id).size());
//		String hotelId = "377";
//		HotelStrategyDataService dataService = new HotelStrategyDataServiceImpl();
//		System.out.println(dataService.getAll(hotelId).size());
//		RoomPO roomPO = new RoomPO();
//		roomPO.setHotelId("377");
//		roomPO.setId("123");
//		hibernateUtil.add(roomPO);
		
//		System.out.println(((RoomPO)hibernateUtil.findById(RoomPO.class, "123")).getHotelId());
		
//		ArrayList<RoomPO> roomPOs = (ArrayList<RoomPO>)hibernateUtil.getAll("roompo", RoomPO.class);
//		System.out.println(roomPOs.size());
//		RoomDao dao = new RoomDaoImpl();
//		System.out.println(dao.getAllRoomPO("377").size());
//		RoomDataService roomDataService = new RoomDataServiceImpl();
//		AdviceFeedbackDao adviceFeedbackDao = new AdviceFeedbackDaoImpl();
//		System.out.println(roomDataService.getAllRoomPO("377").get(0).getHotelId());
//		System.out.println(adviceFeedbackDao.getAdvices());
//		OrderDao orderDao =new OrderDaoImpl();
//		System.out.println(orderDao);
//		String aString = "����У��";
//		String aString2 = "����";
//		System.out.println(aString.contains(aString2));
		SuperVipPO superVipPO = new SuperVipPO();
		superVipPO.setDiscount(0.3);
		superVipPO.setId("23");
		superVipPO.setDistrict("nanjing");
		superVipPO.setVipgrade(5);
		SuperVipDataService service = new SupVipDataServiceImpl();
		service.addSupVip(superVipPO);
	}
}
