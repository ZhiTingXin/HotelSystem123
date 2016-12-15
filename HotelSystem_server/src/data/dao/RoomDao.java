package data.dao;

import java.util.List;

import PO.RoomPO;

public interface RoomDao {
	public List<RoomPO> getAllRoomPO(String hotel);
	public RoomPO findRoomPO(String roomID);
    public boolean modify(RoomPO roomPO);
    public boolean addRoom(RoomPO roomPO);
}
