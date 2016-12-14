package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import PO.RoomPO;

public interface RoomDataService extends Remote{
	public ArrayList<RoomPO> getAllRoomPO(String hotelid) throws RemoteException;
	public RoomPO findRoomPO(String roomID) throws RemoteException;
    public boolean modify(RoomPO roomPO)throws RemoteException;
    public boolean addRoom(RoomPO roomPO) throws RemoteException;
}
