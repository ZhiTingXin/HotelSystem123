package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.OrderPO;
import data.dao.DataFactory;
import data.dao.OrderDao;
import data.dao.impl.DataFactoryImpl;
import data.service.OrderDataService;

public class OrderDataServiceImpl implements OrderDataService{

	private DataFactory dataFactory;
	private OrderDao orderDao;
	
	public OrderDataServiceImpl(){
		dataFactory = new DataFactoryImpl();
		orderDao = dataFactory.getOrderDao();
	}
	public boolean add(OrderPO order) throws RemoteException {
		return orderDao.add(order);
	}

	public boolean update(OrderPO order) throws RemoteException {
		return orderDao.update(order);
	}

	public boolean dalete(OrderPO order) throws RemoteException {
		return orderDao.dalete(order);
	}

	public OrderPO findorder(String orderId) throws RemoteException {
		return orderDao.findorder(orderId);
	}

	public ArrayList<OrderPO> findOrders(String userId, String type) throws RemoteException {
		return orderDao.findOrders(userId, type);
	}
	public ArrayList<OrderPO> getAllOrders() throws RemoteException {
		return orderDao.getAllOrders();
	}
	public ArrayList<OrderPO> getAllHotelOrders(String hotelid) throws RemoteException {
		return orderDao.getAllHotelOrders(hotelid);
	}


}
