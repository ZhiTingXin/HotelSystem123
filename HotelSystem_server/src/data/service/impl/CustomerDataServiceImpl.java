package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.CustomerPO;
import data.dao.CustomerDao;
import data.dao.DataFactory;
import data.dao.impl.DataFactoryImpl;
import data.service.CustomerDataService;

public class CustomerDataServiceImpl implements CustomerDataService {

	private DataFactory dataFactory;
	private CustomerDao customerDao;
	
	public CustomerDataServiceImpl(){
		dataFactory = new DataFactoryImpl();
		customerDao = dataFactory.getCustomerDao();
	}
	public boolean addCustomer(CustomerPO customer) throws RemoteException {
		return customerDao.addCustomer(customer);
	}

	public boolean deleteCustomer(CustomerPO customer) throws RemoteException {
		return customerDao.deleteCustomer(customer);
	}

	public boolean updateCustomer(CustomerPO customer) throws RemoteException {
		return customerDao.updateCustomer(customer);
	}

	public CustomerPO findCustomer(String customerID) throws RemoteException {
		return customerDao.findCustomer(customerID);
	}
	public ArrayList<CustomerPO> getAllCustomers() throws RemoteException {
		return customerDao.getAllCustomers();
	}


}
