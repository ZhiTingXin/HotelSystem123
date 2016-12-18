package testAll;

import PO.ClassToGreId;
import PO.LoginPO;
import PO.RoomPO;
import PO.SystemManagerPO;
import data.service.LoginDataService;
import data.service.impl.LoginDataServiceImpl;
import other.RoomType;
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
//		String aString = "仙林校区";
//		String aString2 = "仙林";
//		System.out.println(aString.contains(aString2));
//		SuperVipPO superVipPO = new SuperVipPO();
//		superVipPO.setDiscount(0.3);
//		superVipPO.setId("23");
//		superVipPO.setDistrict("nanjing");
//		superVipPO.setVipgrade(5);
//		SuperVipDataService service = new SupVipDataServiceImpl();
//		service.addSupVip(superVipPO);
//		HotelPO hot = new HotelPO();
//		hot.setHotelId("123456");
//		hot.setGrade("3");
//		hot.setHotelAddress("仙林校区");
//		hot.setHotelDiscription("酒店属于社区最好的酒店");
//		hot.setHotelName("我们是没名字酒店");
//		hot.setHotelStrict("南京");
//		hot.setHotelStaffId("151250170");
//		HotelPO hot1 = new HotelPO();
//		hot1.setHotelId("12345");
//		hot1.setGrade("3");
//		hot1.setHotelAddress("仙林校区");
//		hot1.setHotelDiscription("酒店属于社区最好的酒店");
//		hot1.setHotelName("我们是没名字酒店");
//		hot1.setHotelStrict("南京");
//		hot1.setHotelStaffId("151250170");
//		HotelPO hot2 = new HotelPO();
//		hot2.setHotelId("1234567");
//		hot2.setGrade("3");
//		hot2.setHotelAddress("仙林校区");
//		hot2.setHotelDiscription("酒店属于社区最好的酒店");
//		hot2.setHotelName("我们是没名字酒店");
//		hot2.setHotelStrict("南京");
//		hot2.setHotelStaffId("151250170");
//		HotelPO hot3 = new HotelPO();
//		hot3.setHotelId("1234");
//		hot3.setGrade("3");
//		hot3.setHotelAddress("仙林校区");
//		hot3.setHotelDiscription("酒店属于社区最好的酒店");
//		hot3.setHotelName("我们是没名字酒店");
//		hot3.setHotelStrict("南京");
//		hot3.setHotelStaffId("151250170");
//		hibernateUtil.add(hot);
//		hibernateUtil.add(hot1);
//		hibernateUtil.add(hot2);
//		hibernateUtil.add(hot3);
//		RoomPO room = new RoomPO();
//		room.setHotelId("123456");
//		room.setId("1");
//		room.setNumber(50);
//		room.setPrice(5);
//		room.setRemainNum(8);
//		room.setType(RoomType.bigBedRoom);
//		RoomPO room1 = new RoomPO();
//		room1.setHotelId("12345");
//		room1.setId("6");
//		room1.setNumber(50);
//		room1.setPrice(5);
//		room1.setRemainNum(8);
//		room1.setType(RoomType.bigBedRoom);
//		RoomPO room2 = new RoomPO();
//		room2.setHotelId("1234");
//		room2.setId("2");
//		room2.setNumber(50);
//		room2.setPrice(5);
//		room2.setRemainNum(8);
//		room2.setType(RoomType.bigBedRoom);
//		RoomPO room3 = new RoomPO();
//		room3.setHotelId("12345");
//		room3.setId("3");
//		room3.setNumber(50);
//		room3.setPrice(5);
//		room3.setRemainNum(8);
//		room3.setType(RoomType.multiPersonRoom);
//		RoomPO room4 = new RoomPO();
//		room4.setHotelId("123456");
//		room4.setId("4");
//		room4.setNumber(50);
//		room4.setPrice(5);
//		room4.setRemainNum(8);
//		room4.setType(RoomType.singlePersonRoom);
//		hibernateUtil.add(room4);
//		hibernateUtil.add(room3);
//		hibernateUtil.add(room2);
//		hibernateUtil.add(room1);
//		hibernateUtil.add(room);
//		
		LoginDataService loginDataService = new LoginDataServiceImpl();
		String string = "124";
		LoginPO loginPO = loginDataService.findByID(string);
		System.out.println(loginPO.getUserPassword());
//		ClassToGreId al = new ClassToGreId("123");
//		hibernateUtil.add(al);
//		SystemManagerPO managerPO = new SystemManagerPO();
//		managerPO.setManagerID("122");
//		managerPO.setManagerName("辛志庭");
//		hibernateUtil.add(managerPO);
	}
}
