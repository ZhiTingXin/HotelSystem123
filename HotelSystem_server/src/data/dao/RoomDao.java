package data.dao;

import java.util.ArrayList;
import PO.RoomPO;

public interface RoomDao {
	public ArrayList<RoomPO> getAllRoomPO(String hotel);
	public RoomPO findRoomPO(String roomID);
    public boolean modify(RoomPO roomPO);
    public boolean addRoom(RoomPO roomPO);
}
