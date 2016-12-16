package data.dao.impl;

import java.util.ArrayList;
import PO.OrderPO;
import data.dao.OrderDao;
import other.hibernateUtil;

public class OrderDaoImpl implements OrderDao{

	public OrderDaoImpl(){
		
	}
	public boolean add(OrderPO order) {
		try{
			hibernateUtil.add(order);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(OrderPO order) {
		try{
			hibernateUtil.update(order);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean dalete(OrderPO order) {
		try{
			hibernateUtil.delete(order);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public OrderPO findorder(String orderId) {
		OrderPO order = new OrderPO();
		try{
			order =(OrderPO)hibernateUtil.findById(OrderPO.class, orderId);
			return order;
		}catch(Exception e){
			e.printStackTrace();
			return order;
		}
	}

	//获取某个用户的所有订单
	public ArrayList<OrderPO> findOrders(String userId,String type) {
		ArrayList<OrderPO> orderL = new ArrayList<OrderPO>();
		try{
			ArrayList<OrderPO> order = ( ArrayList<OrderPO>) hibernateUtil.getAll("orderpo", OrderPO.class);
		   for(OrderPO po:order){
			   if(po.getUserId().equals(userId))
			   orderL.add(po);
		   }
		   return orderL;
		}catch(Exception e){
			e.printStackTrace();
			return orderL;
		}
	}
	public ArrayList<OrderPO> getAllOrders() {
		try {
			return (ArrayList<OrderPO>)hibernateUtil.getAll("orderpo", OrderPO.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
