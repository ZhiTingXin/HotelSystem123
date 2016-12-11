package data.dao.impl;


import PO.LoginPO;
import data.dao.LoginDao;
import other.hibernateUtil;

public class LoginDaoImpl implements LoginDao{

	public LoginDaoImpl(){
		
	}
	
	public boolean confirm(String userId, String userPassword) {
		LoginPO login =  (LoginPO)hibernateUtil.findById(LoginPO.class, userId);
		if(login!=null){
			if(login.getUserPassword().equals(userPassword)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	public boolean add(LoginPO login) {
		try{
			hibernateUtil.add(login);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(LoginPO login) {
		try{
			hibernateUtil.delete(login);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(LoginPO login) {
		try{
			hibernateUtil.update(login);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
