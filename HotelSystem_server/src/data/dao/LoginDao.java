package data.dao;

import PO.LoginPO;

public interface LoginDao {

	public boolean confirm(String userId,String userPassword);
	
	public boolean add(LoginPO login);
	
	public boolean delete(LoginPO login);
	
	public boolean update(LoginPO login);
}
