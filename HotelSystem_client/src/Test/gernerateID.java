package Test;

import VO.SystemStaffVO;
import blservice.UserManagement_blservice;
import blservice.impl.UserManagement_bl;
import main.ClientRunner;

//import other.AdviceFeedBackState;
//import util.DateUtil;
//
public class gernerateID {
   public static void main(String [] args)throws Exception{
//	   /*
//	    * ע��Ĳ��Դ���
//	    */
	   ClientRunner clientRunner = new ClientRunner();
//	   Login_blservice login_blservice = new Login_bl();
//	   /*
//	    * �����޸�����
//	    */
//	   //LoginPO login = new LoginPO("abcdskd", "mdaada");
////	   String id = "151250170";
////	   System.out.println(RemoteHelper.getInstance().getLoginDataService().findByID("151250170").getUserType());
//	   /*
//	    * ����ע���û�
//	    */
//	   /*
//	    * �û��ĵ�¼����
//	    */
////	   LoginPO login = new LoginPO("abcdskd", "mdaada");
//	   System.out.println(login_blservice.comfirm("151250", "xzt123"));
//	   /*
//	    * �����������û�����
//	    */
////	   LoginDataService asd= RemoteHelper.getInstance().getLoginDataService();
////	   System.out.println(asd.test());
//	   /*
//	    * ����ע��
//	    */
////	   Register_blservice register_blservice = new Register_bl();
////	   String date  = "2015-02-12";
////	   LocalDate localDate = DateUtil.parse_1(date);
////	   CustomerVO c = new CustomerVO("151250549","л����",3,localDate,"���˾",50);
////	   System.out.println(register_blservice.addRegister(c));
//	   /*
//	    * ������ӷ���
//	    */
//	   String send = "2013-10-12";
//	   String rep = "2015-10-12";
//	   AdviceFeedBack_blservice adviceFeedBack_blservice = new AdviceFeedBack_bl();
//	   AdviceFeedBackVO adviceFeedBackVO = new AdviceFeedBackVO("151250170",AdviceFeedBackState.PROCESSED,"��վ���ױ���",
//			   "123456",DateUtil.parse_1(send),DateUtil.parse_1(rep),"֪����");
//       System.out.println(adviceFeedBack_blservice.addAdviceFeedBack(adviceFeedBackVO));
//       /*
//        * 
//        */
//	   String hotelid = "377";
//	   HotelDataService dataService = RemoteHelper.getInstance().getHotelDataService();
//	   HotelPO hotel = dataService.find(hotelid);
//	   HotelStrategyDataService dataService = RemoteHelper.getInstance().getHotelStrategyDataService();
//	   ArrayList<HotelStrategyPO> hotelStrategyPOs = dataService.getAll(hotelid);
//	   RoomDataService roomDataService = RemoteHelper.getInstance().getRoomDataService();
//	   ArrayList<RoomPO> roomPOs = roomDataService.getAllRoomPO(hotelid);
//	   System.out.println(roomPOs.size());
//	   String  string = "124";
//	   Login_blservice login_blservice = new Login_bl();
//	   UserType userType  = login_blservice.assertUserType(string);
//	   System.out.println(userType);
//	   SystemStaffVO staffVO = new SystemStaffVO();
//	   staffVO.setPassword("123");
//	   staffVO.setPhone("15951926228");
//	   staffVO.setBusinessDistrict("�½ֿ�");
//	   UserManagement_bl userManagement_bl = new UserManagement_bl();
//	   userManagement_bl.addSystemStaff(staffVO);
//	   String string = "12345";
//	   String  string2 = PassWordMd5.EncryptionStr16(string,PassWordMd5.MD5,PassWordMd5.UTF8);
//	   System.out.println(string2);
	   SystemStaffVO staffVO = new SystemStaffVO();
	   staffVO.setBusinessDistrict("�Ͼ�");
	   staffVO.setPassword("a");
	   staffVO.setPhone("12345");
	   staffVO.setUsername("chen");
	   UserManagement_blservice userManagement_blservice  = new  UserManagement_bl();
	   userManagement_blservice.addSystemStaff(staffVO);
   }
}
