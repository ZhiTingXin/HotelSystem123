package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.OrderPO;
public interface OrderDao {

	public boolean add(OrderPO order);
	public boolean update(OrderPO order);
	public boolean dalete(OrderPO order);
	public OrderPO findorder(String orderId);
	public ArrayList<OrderPO> findOrders(String userId,String type);
	public ArrayList<OrderPO> getAllOrders();
	public ArrayList<OrderPO> getAllHotelOrders(String hotelid)throws RemoteException;
}

