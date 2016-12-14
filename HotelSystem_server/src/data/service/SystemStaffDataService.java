package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.SystemStaffPO;

public interface SystemStaffDataService extends Remote{
	public boolean addStaff(SystemStaffPO staffPO)throws RemoteException;
	public boolean updateStaff(SystemStaffPO staffPO)throws RemoteException;
	public boolean deleteStaff(SystemStaffPO staffPO)throws RemoteException;
	public SystemStaffPO findStaff(String staffID)throws RemoteException;
	public ArrayList<SystemStaffPO> getAllSystemStaffs() throws RemoteException;
}
