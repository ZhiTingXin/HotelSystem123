package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.OrderPO;

public interface OrderDataService extends Remote {
	
	public boolean add(OrderPO order)throws RemoteException;
	
	public boolean update(OrderPO order)throws RemoteException;
	
	public boolean dalete(OrderPO order)throws RemoteException;
	
	public OrderPO findorder(String orderId)throws RemoteException;
	
	public ArrayList<OrderPO> findOrders(String userId,String type)throws RemoteException;
	
	public ArrayList<OrderPO> getAllOrders()throws RemoteException;
	
	public ArrayList<OrderPO> getAllHotelOrders(String hotelid)throws RemoteException;
}
