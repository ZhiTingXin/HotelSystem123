package Test;

import java.rmi.RemoteException;

import PO.LoginPO;
import PO.SystemManagerPO;
import RMI.RemoteHelper;
import VO.HotelInfoVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
import main.ClientRunner;
import other.PassWordMd5;
import other.UserType;

public class tester {
	public static void main(String[] args) {
		ClientRunner runner = new ClientRunner();
		// Order_blservice orderService = new Order_bl();
		// OrderVO order = orderService.getOrder("455");
		// order.setOrderState(OrderState.ABNOMAL);
		// orderService.changeState(order);
		// LogofUserVO log = new LogofUserVO();
		// LogOfUser_blServce logService = new LogOfUser_blServceImpl();
		// LogofUserVO logofUserVO = new LogofUserVO();
		// logofUserVO.setChange((int) (-order.getPrice() * 0.5));
		// logofUserVO.setContent("“Ï≥£∂©µ•" + order.getOrderID());
		// logofUserVO.setDateTime(LocalDateTime.now());
		// logofUserVO.setUserid(order.getUserID());
		// logService.addLogOfUser(logofUserVO);
//		Hotel_blservice hotelService = new Hotel_bl();
//		HotelInfoVO hotel = hotelService.getHotelInfo("446");
//		//
//		// Room_blService roomService = new Room_blServiceImpl();
//		// ArrayList<HotelRoomInfoVO> roomInfo =
//		// roomService.getAllRoom(hotel.getHotelID());
//		// roomInfo.get(1).setRoomRemain(roomInfo.get(1).getRoomRemain() - 2);
//		// roomService.modify(roomInfo.get(1));
//		hotel.setImage("src/Img/(DY1IDA7`$XISIJ1{ULJWN7.JPG;" + "src/Img/1.JPG;");
//		hotelService.modifyHotelInfo(hotel);
		SystemManagerPO systemManagerPO = new SystemManagerPO();
		systemManagerPO.setManagerId("12345");
		systemManagerPO.setManagerName("chen");
		systemManagerPO.setImage("src/Img/default.png");
		systemManagerPO.setPhone("1237514785");
		LoginPO loginPO = new LoginPO();
		loginPO.setId("12345");
		loginPO.setUserPassword(PassWordMd5.EncryptionStr16("123", PassWordMd5.MD5, PassWordMd5.UTF8));
		loginPO.setUserType(UserType.SYSTEMMANAGER);
		try {
			RemoteHelper.getInstance().getLoginDataService().add(loginPO);
			RemoteHelper.getInstance().getSystemManagerDataService().addManager(systemManagerPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
