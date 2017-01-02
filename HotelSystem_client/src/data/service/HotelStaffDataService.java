package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelStaffPO;

public interface HotelStaffDataService extends Remote{
	
	public boolean addStaff(HotelStaffPO staffPO)throws RemoteException;
	
	public boolean updateStaff(HotelStaffPO staffPO)throws RemoteException;
	
	public boolean deleteStaff(HotelStaffPO staffPO)throws RemoteException;
	
	public HotelStaffPO findHotelStaff(String staffID)throws RemoteException;
	
	public ArrayList<HotelStaffPO> getAllHotelStaffs()throws RemoteException;
	
}
