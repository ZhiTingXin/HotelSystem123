package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.Label;

public interface LabelDataService extends Remote{

	public boolean addLabel(Label label)throws RemoteException;
	
	public boolean delLabel(Label label)throws RemoteException;
	
	public ArrayList<Label> getLabels(String hotelid)throws RemoteException;
}
