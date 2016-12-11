package data.dao.impl;

import PO.SystemManagerPO;
import data.dao.SystemManagerDao;
import other.hibernateUtil;

public class SystemManagerDaoImpl implements SystemManagerDao{

	
	public SystemManagerPO findManager(String managerID) {
		SystemManagerPO manager = null;
		try{
			manager =(SystemManagerPO)hibernateUtil.findById(SystemManagerPO.class, managerID);
			return manager;
		}catch(Exception e){
			e.printStackTrace();
			return manager;
		}
	}

	public boolean addManager(SystemManagerPO managerPO) {
		try{
			hibernateUtil.add(managerPO);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteManager(String managerID) {
		try{
			SystemManagerPO manager = (SystemManagerPO)hibernateUtil.findById(SystemManagerPO.class, managerID);
			hibernateUtil.delete(manager);
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}

	public boolean updateManager(SystemManagerPO managerPO) {
		try{
			
			hibernateUtil.update(managerPO);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteManager(SystemManagerPO systemManagerPO) {
		try{
			hibernateUtil.delete(systemManagerPO);
			return true;
		}catch(Exception exception){
			exception.printStackTrace();
			return false;
		}
	}



}
