package data.dao.impl;

import java.util.ArrayList;

import PO.CustomerPO;
import data.dao.CustomerDao;
import other.hibernateUtil;

public class CustomerDaoImpl implements CustomerDao{

	public boolean addCustomer(CustomerPO customer) {
		try{
			hibernateUtil.add(customer);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCustomer(CustomerPO customer) {
		try{
			hibernateUtil.delete(customer);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	}

	public boolean updateCustomer(CustomerPO customer) {
		try{
			hibernateUtil.update(customer);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	}

	public CustomerPO findCustomer(String customerID) {
		try{
			return (CustomerPO)hibernateUtil.findById(CustomerPO.class, customerID);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	}

	public ArrayList<CustomerPO> getAllCustomers() {
	    ArrayList<CustomerPO> list = null;
	    try {
			list = (ArrayList<CustomerPO>)hibernateUtil.getAll("customer", CustomerPO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
