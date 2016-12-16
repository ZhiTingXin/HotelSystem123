package data.dao.impl;

import java.util.ArrayList;
import PO.RoomPO;
import data.dao.RoomDao;
import other.hibernateUtil;

public class RoomDaoImpl implements RoomDao{

	public ArrayList<RoomPO> getAllRoomPO(String hotelid){
	      ArrayList<RoomPO> roomPOs = (ArrayList<RoomPO>)hibernateUtil.getAll("roompo", RoomPO.class);
	      ArrayList<RoomPO> roomPOs2 = new ArrayList<RoomPO>();
	      for(RoomPO p:roomPOs){
	    	  if(p.getHotelId().equals(hotelid)){
	    		  roomPOs2.add(p);
	    	  }
	      }
	      return roomPOs2;
	}

	public RoomPO findRoomPO(String roomID){
		return (RoomPO)hibernateUtil.findById(RoomPO.class, roomID);
	}

	public boolean modify(RoomPO roomPO){
		try {
			hibernateUtil.update(roomPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean addRoom(RoomPO roomPO){
		hibernateUtil.add(roomPO);
		return true;
	}

}
