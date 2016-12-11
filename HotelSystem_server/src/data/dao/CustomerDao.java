package data.dao;

import java.util.ArrayList;

import PO.CustomerPO;

public interface CustomerDao {
	public boolean addCustomer(CustomerPO customer);
	public boolean deleteCustomer(CustomerPO customer);
	public boolean updateCustomer(CustomerPO customer);
	public CustomerPO findCustomer(String customerID);
    public ArrayList<CustomerPO> getAllCustomers();
}
