package data.dao.impl;

import java.util.ArrayList;

import PO.HotelStaffPO;
import data.dao.HotelStaffDao;
import other.hibernateUtil;

public class HotelStaffDaoImpl implements HotelStaffDao{

	public boolean addStaff(HotelStaffPO staffPO) {
		try{
			hibernateUtil.add(staffPO);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateStaff(HotelStaffPO staffPO) {
		try{
			hibernateUtil.update(staffPO);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	}

	public boolean deleteStaff(HotelStaffPO staffPO) {
		try{
			hibernateUtil.delete(staffPO);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	}

	public HotelStaffPO findStaff(String staffID) {
		try{
			return (HotelStaffPO)hibernateUtil.findById(HotelStaffPO.class, staffID);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

	public ArrayList<HotelStaffPO> getAllHotelStaffs() {
		ArrayList<HotelStaffPO> list = null;
		try{
			list = (ArrayList<HotelStaffPO>)hibernateUtil.getAll("hotelstaff", HotelStaffPO.class);
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return list;
	}

}
