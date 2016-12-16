package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.RoomPO;
import data.dao.DataFactory;
import data.dao.RoomDao;
import data.dao.impl.DataFactoryImpl;
import data.service.RoomDataService;

public class RoomDataServiceImpl implements RoomDataService{
	private DataFactory factory;
	private RoomDao roomDao;
	
	public RoomDataServiceImpl(){
		factory = new DataFactoryImpl();
		roomDao = factory.getRoomDao();
	}

	public RoomPO findRoomPO(String roomID) throws RemoteException {
		return roomDao.findRoomPO(roomID);
	}

	public boolean modify(RoomPO roomPO) throws RemoteException {
		return roomDao.modify(roomPO);
	}

	public boolean addRoom(RoomPO roomPO) throws RemoteException {
		return roomDao.addRoom(roomPO);
	}

	public ArrayList<RoomPO> getAllRoomPO(String hotelid) throws RemoteException {
		return (ArrayList<RoomPO>)roomDao.getAllRoomPO(hotelid);
	}


}
