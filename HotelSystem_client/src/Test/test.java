package Test;

import VO.HotelStaffVO;
import VO.SystemManagerVO;
import blservice.UserInfo_blservice;
import blservice.UserManagement_blservice;
import blservice.impl.UserInfo_bl;
import blservice.impl.UserManagement_bl;
import main.ClientRunner;

public class test {

	public static void main(String[] args) {
		ClientRunner c = new ClientRunner();
		UserManagement_blservice userService = new UserManagement_bl();
		UserInfo_blservice service = new UserInfo_bl();
		HotelStaffVO hotelStaff = userService.getHotelStaff("187");
		hotelStaff.setImage("src/Img/default.PNG");
		service.modifyHotelStaff(hotelStaff);
		SystemManagerVO manager = userService.getSystemManager("12345");
		manager.setImage("src/Img/default.PNG");
		service.modifySystemManager(manager);
		// HotelRoomInfoVO roomInfoVO = new HotelRoomInfoVO();
		// roomInfoVO.setHotelid("12345");
		// roomInfoVO.setId("12");
		// roomInfoVO.setRoomType(RoomType.bigBedRoom);
		// Room_blService oRoom_bl = new Room_blServiceImpl();
		// oRoom_bl.addRoom(roomInfoVO);
		//// ArrayList<HotelRoomInfoVO> hotelRoomInfoVO =
		// oRoom_bl.getAllRoom("12345");
		//// for(int i=0;i<hotelRoomInfoVO.size();i++){
		//// hotelRoomInfoVO.get(i).setRoomNum(2);
		//// }
		//// for(int i=0;i<hotelRoomInfoVO.size();i++){
		//// oRoom_bl.modify(hotelRoomInfoVO.get(i));
		//// }
		// System.out.println(AdviceFeedBackState.PROCESSED.toString());
	}
}
