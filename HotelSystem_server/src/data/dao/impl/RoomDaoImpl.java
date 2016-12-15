package data.dao.impl;

import java.util.List;

import PO.RoomPO;
import data.dao.RoomDao;
import other.hibernateUtil;

public class RoomDaoImpl implements RoomDao{

	public List<RoomPO> getAllRoomPO(String hotelid){
		return hibernateUtil.getAll("RoomPO", RoomPO.class);
	}

	public RoomPO findRoomPO(String roomID){
		return (RoomPO)hibernateUtil.findById(RoomPO.class, roomID);
	}

	public boolean modify(RoomPO roomPO){
		hibernateUtil.update(roomPO);
		return true;
	}

	public boolean addRoom(RoomPO roomPO){
		hibernateUtil.add(roomPO);
		return true;
	}

}
