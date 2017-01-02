package blservice.impl;

import java.util.ArrayList;

import PO.RoomPO;
import RMI.RemoteHelper;
import VO.HotelRoomInfoVO;
import blservice.Room_blService;
import data.service.RoomDataService;

public class Room_blServiceImpl implements Room_blService {

	RoomDataService roomDataService = RemoteHelper.getInstance().getRoomDataService();

	/**
	 * @param 酒店id
	 * 
	 * @return 返回旧电脑的所有房间信息
	 */
	public ArrayList<HotelRoomInfoVO> getAllRoom(String hotelid) {
		ArrayList<HotelRoomInfoVO> roomInfoVOs = new ArrayList<HotelRoomInfoVO>();
		try {
			ArrayList<RoomPO> roomPOs = roomDataService.getAllRoomPO(hotelid);
			for (RoomPO po : roomPOs) {
				roomInfoVOs.add(new HotelRoomInfoVO(po));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roomInfoVOs;
	}

	/**
	 * @param 房间id
	 * 
	 * @return 返回对应的房间的信息
	 */
	public HotelRoomInfoVO findRoom(String roomID) {
		try {
			RoomPO roomPO = roomDataService.findRoomPO(roomID);
			return new HotelRoomInfoVO(roomPO);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param 房间的信息
	 * 
	 * @return 修改房间信息
	 */
	public boolean modify(HotelRoomInfoVO room) {
		try {
			RoomPO roomPO = new RoomPO(room);
			roomDataService.modify(roomPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param 房间信息
	 * 
	 * @return 添加房间
	 */
	public boolean addRoom(HotelRoomInfoVO room) {
		try {
			RoomPO roomPO = new RoomPO(room);
			roomDataService.addRoom(roomPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
