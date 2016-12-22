package blservice.impl;

import java.util.ArrayList;

import PO.RoomPO;
import RMI.RemoteHelper;
import VO.HotelRoomInfoVO;
import blservice.Room_blService;
import data.service.RoomDataService;

public class Room_blServiceImpl implements Room_blService{

	RoomDataService roomDataService = RemoteHelper.getInstance().getRoomDataService();
	@Override
	public ArrayList<HotelRoomInfoVO> getAllRoom(String hotelid) {
		ArrayList<HotelRoomInfoVO> roomInfoVOs = new ArrayList<HotelRoomInfoVO>();
		try{
		ArrayList<RoomPO>  roomPOs = roomDataService.getAllRoomPO(hotelid);
		for(RoomPO po:roomPOs){
			roomInfoVOs.add(new HotelRoomInfoVO(po));
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return roomInfoVOs;
	}

	@Override
	public HotelRoomInfoVO findRoom(String roomID) {
		try{
			RoomPO roomPO = roomDataService.findRoomPO(roomID);
			return new HotelRoomInfoVO(roomPO);
		}catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	}

	@Override
	public boolean modify(HotelRoomInfoVO room) {
	    try{
	    	RoomPO roomPO = new RoomPO(room);
	    	roomDataService.modify(roomPO);
	    	return true;
	    }catch (Exception e) {
	    	 e.printStackTrace();
			 return false;
		}
	}

	@Override
	public boolean addRoom(HotelRoomInfoVO room) {
		try{
	    	RoomPO roomPO = new RoomPO(room);
	    	roomDataService.addRoom(roomPO);
	    	return true;
	    }catch (Exception e) {
	    	 e.printStackTrace();
			 return false;
		}
	}

}
