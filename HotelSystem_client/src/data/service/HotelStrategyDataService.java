package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelStrategyPO;

public interface HotelStrategyDataService extends Remote {
	public boolean add(HotelStrategyPO hotelstrategy)throws RemoteException;
	public boolean delete(HotelStrategyPO hotelstrategy)throws RemoteException;
	public boolean modify(HotelStrategyPO hotelstartegy)throws RemoteException;
	public HotelStrategyPO get(String hotelstrategyId)throws RemoteException;
	public ArrayList<HotelStrategyPO> getAll(String hotelId)throws RemoteException;
}
