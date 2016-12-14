package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelPO;

public interface HotelDataService extends Remote{
	public boolean add(HotelPO hotel)throws RemoteException;
	public boolean del(HotelPO hotel)throws RemoteException;
	public HotelPO find(String hotelId)throws RemoteException;
    public boolean update(HotelPO hotel)throws RemoteException;
	public ArrayList<HotelPO> getHotels(String strict,String type) throws RemoteException;
	public ArrayList<HotelPO> getAllHotels()throws RemoteException;
}
