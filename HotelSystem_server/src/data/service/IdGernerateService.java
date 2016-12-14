package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IdGernerateService extends Remote {

	public String gernerateId()throws RemoteException;
}
