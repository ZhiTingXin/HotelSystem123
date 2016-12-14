package data.service;

import java.rmi.RemoteException;
import java.util.List;

import PO.RoomPO;

public interface RoomDataService {
	public List<RoomPO> getAllRoomPO(String hotelid) throws RemoteException;
	public RoomPO findRoomPO(String roomID) throws RemoteException;
    public boolean modify(RoomPO roomPO)throws RemoteException;
    public boolean addRoom(RoomPO roomPO) throws RemoteException;
}
