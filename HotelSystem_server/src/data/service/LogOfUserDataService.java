package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.LogofUserPO;

public interface LogOfUserDataService extends Remote{

	public boolean add(LogofUserPO log)throws RemoteException;
	
	public ArrayList<LogofUserPO> getAllLogsOfUser(String userid)throws RemoteException;
}
