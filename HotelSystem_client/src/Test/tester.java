package Test;

import VO.HotelInfoVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
import main.ClientRunner;

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
		// logofUserVO.setContent("�쳣����" + order.getOrderID());
		// logofUserVO.setDateTime(LocalDateTime.now());
		// logofUserVO.setUserid(order.getUserID());
		// logService.addLogOfUser(logofUserVO);
		Hotel_blservice hotelService = new Hotel_bl();
		HotelInfoVO hotel = hotelService.getHotelInfo("446");
		//
		// Room_blService roomService = new Room_blServiceImpl();
		// ArrayList<HotelRoomInfoVO> roomInfo =
		// roomService.getAllRoom(hotel.getHotelID());
		// roomInfo.get(1).setRoomRemain(roomInfo.get(1).getRoomRemain() - 2);
		// roomService.modify(roomInfo.get(1));
		hotel.setImage("src/Img/(DY1IDA7`$XISIJ1{ULJWN7.JPG;" + "src/Img/1.JPG;");
		hotelService.modifyHotelInfo(hotel);

	}
}
