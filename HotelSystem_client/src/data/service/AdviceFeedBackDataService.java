package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import PO.AdviceFeedBackPO;

public interface AdviceFeedBackDataService extends Remote{

	public boolean addAdvice(AdviceFeedBackPO advicefeedback)throws RemoteException;
	public boolean updateAdvice(AdviceFeedBackPO advicefeedback)throws RemoteException;
	public ArrayList<AdviceFeedBackPO> getAdvices(String userId,String type)throws RemoteException;
	public ArrayList<AdviceFeedBackPO> getAllAdvices()throws RemoteException;
	
}
