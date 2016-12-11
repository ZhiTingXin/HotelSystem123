package data.service;

import java.rmi.RemoteException;

import PO.SystemManagerPO;

public interface SystemManagerDataService {
	public SystemManagerPO findManager(String managerID)throws RemoteException;
	public boolean addManager(SystemManagerPO managerPO)throws RemoteException;
	public boolean deleteManager(SystemManagerPO systemManagerPO)throws RemoteException;
	public boolean updateManager(SystemManagerPO managerPO)throws RemoteException;
}
