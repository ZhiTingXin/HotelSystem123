package blservice;

import java.util.ArrayList;
import VO.HotelRoomInfoVO;

public interface Room_blService {
	public ArrayList<HotelRoomInfoVO> getAllRoom(String hotelid);
	public HotelRoomInfoVO findRoom(String roomID);
    public boolean modify(HotelRoomInfoVO room);
    public boolean addRoom(HotelRoomInfoVO room);
}
