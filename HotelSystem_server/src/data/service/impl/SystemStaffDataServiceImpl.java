package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.SystemManagerPO;
import PO.SystemStaffPO;
import data.dao.DataFactory;
import data.dao.SystemStaffDao;
import data.dao.impl.DataFactoryImpl;
import data.service.SystemManagerDataService;
import data.service.SystemStaffDataService;

public class SystemStaffDataServiceImpl implements SystemStaffDataService{

	private DataFactory dataFactory;
	private SystemStaffDao staffDao;
	
	public SystemStaffDataServiceImpl(){
		dataFactory = new DataFactoryImpl();
		staffDao = dataFactory.getSystemStaffDao();
	}
	public boolean addStaff(SystemStaffPO staffPO) throws RemoteException {
		return staffDao.addStaff(staffPO);
	}

	public boolean updateStaff(SystemStaffPO staffPO) throws RemoteException {
		return staffDao.updateStaff(staffPO);
	}

	public boolean deleteStaff(SystemStaffPO staffPO) throws RemoteException {
		return staffDao.deleteStaff(staffPO);
	}

	public SystemStaffPO findStaff(String staffID) throws RemoteException {
		return staffDao.findStaff(staffID);
	}
	public ArrayList<SystemStaffPO> getAllSystemStaffs() throws RemoteException {
		return staffDao.getAllSystemStaffs();
	}	


}
