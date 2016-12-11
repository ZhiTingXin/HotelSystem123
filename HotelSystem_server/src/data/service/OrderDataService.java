package data.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import PO.OrderPO;

public interface OrderDataService extends Remote {
	public boolean add(OrderPO order)throws RemoteException;
	public boolean update(OrderPO order)throws RemoteException;
	public boolean dalete(OrderPO order)throws RemoteException;
	public OrderPO findorder(String orderId)throws RemoteException;
	public List<OrderPO> findOrders(String userId,String type)throws RemoteException;
}
