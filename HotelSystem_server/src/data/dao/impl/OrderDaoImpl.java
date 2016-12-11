package data.dao.impl;

import java.util.List;

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
		OrderPO order = null;
		try{
			order =(OrderPO)hibernateUtil.findById(OrderPO.class, orderId);
			return order;
		}catch(Exception e){
			e.printStackTrace();
			return order;
		}
	}

	//获取某个用户的所有订单
	public List<OrderPO> findOrders(String userId,String type) {
		List<OrderPO> orderL = null;
		try{
		   orderL =hibernateUtil.findbySome("OrderPO",type,userId);
		   return orderL;
		}catch(Exception e){
			e.printStackTrace();
			return orderL;
		}
	}

	
}
