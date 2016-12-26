package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.SuperVipPO;

public interface SuperVipDataService extends Remote{

    public boolean addSupVip(SuperVipPO po)throws RemoteException;
	
	public boolean modifySupVip(SuperVipPO po)throws RemoteException;
	
	public boolean deleteSupVip(SuperVipPO po)throws RemoteException;
	
	public ArrayList<SuperVipPO> getStrict(String city,String disstrict)throws RemoteException;
	
    public int getSuperNum() throws RemoteException;
}
