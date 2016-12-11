package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelStaffPO;
import data.dao.DataFactory;
import data.dao.HotelStaffDao;
import data.dao.impl.DataFactoryImpl;
import data.service.HotelStaffDataService;

public class HotelStaffDataServiceImpl implements HotelStaffDataService{

	private DataFactory dataFactory;
	private HotelStaffDao hotelStaffDao;
	
	public HotelStaffDataServiceImpl(){
		dataFactory = new DataFactoryImpl();
		hotelStaffDao = dataFactory.getHotelStaffDao();
	}
	public boolean addStaff(HotelStaffPO staffPO) throws RemoteException {
		return hotelStaffDao.addStaff(staffPO);
	}

	public boolean updateStaff(HotelStaffPO staffPO) throws RemoteException {
		return hotelStaffDao.updateStaff(staffPO);
	}

	public boolean deleteStaff(HotelStaffPO staffPO) throws RemoteException {
		return hotelStaffDao.deleteStaff(staffPO);
	}

	public HotelStaffPO findHotelStaff(String staffID) throws RemoteException {
		return hotelStaffDao.findStaff(staffID);
	}
	public ArrayList<HotelStaffPO> getAllHotelStaffs() throws RemoteException {
		return hotelStaffDao.getAllHotelStaffs();
	}

	
}
