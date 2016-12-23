package Test;

import java.util.ArrayList;

import VO.HotelRoomInfoVO;
import blservice.Room_blService;
import blservice.impl.Room_blServiceImpl;
import main.ClientRunner;
import other.RoomType;

public class test {

	public static void main(String [] args){
		ClientRunner clientRunner = new ClientRunner();
		HotelRoomInfoVO roomInfoVO = new HotelRoomInfoVO();
		roomInfoVO.setHotelid("12345");
		roomInfoVO.setId("12");
		roomInfoVO.setRoomType(RoomType.bigBedRoom);
		Room_blService oRoom_bl = new Room_blServiceImpl();
		oRoom_bl.addRoom(roomInfoVO);
	    ArrayList<HotelRoomInfoVO> hotelRoomInfoVO = oRoom_bl.getAllRoom("12345");
	    for(int i=0;i<hotelRoomInfoVO.size();i++){
	    	hotelRoomInfoVO.get(i).setRoomNum(2);
	    }
	    for(int i=0;i<hotelRoomInfoVO.size();i++){
	    	oRoom_bl.modify(hotelRoomInfoVO.get(i));
	    }
	}
}
