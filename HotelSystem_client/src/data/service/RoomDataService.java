package data.service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.RoomPO;

public interface RoomDataService {
	public ArrayList<RoomPO> getAllRoomPO() throws RemoteException;
	public RoomPO findRoomPO(String roomID) throws RemoteException;
}
