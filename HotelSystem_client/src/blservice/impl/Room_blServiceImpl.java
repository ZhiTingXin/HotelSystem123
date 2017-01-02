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
	 * @param �Ƶ�id
	 * 
	 * @return ���ؾɵ��Ե����з�����Ϣ
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
	 * @param ����id
	 * 
	 * @return ���ض�Ӧ�ķ������Ϣ
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
	 * @param �������Ϣ
	 * 
	 * @return �޸ķ�����Ϣ
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
	 * @param ������Ϣ
	 * 
	 * @return ��ӷ���
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
