package data.dao.impl;

import java.util.ArrayList;
import java.util.List;

import PO.SystemStaffPO;
import data.dao.SystemStaffDao;
import other.hibernateUtil;

public class SystemStaffDaoImpl implements SystemStaffDao{

	public boolean addStaff(SystemStaffPO staffPO) {
		try{
			hibernateUtil.add(staffPO);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateStaff(SystemStaffPO staffPO) {
		try{
			hibernateUtil.update(staffPO);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	}

	public boolean deleteStaff(SystemStaffPO staffPO) {
		try{
			hibernateUtil.delete(staffPO);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	}

	public SystemStaffPO findStaff(String staffID) {
		try{
			return (SystemStaffPO)hibernateUtil.findById(SystemStaffPO.class, staffID);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	}

	public ArrayList<SystemStaffPO> getAllSystemStaffs() {
		ArrayList<SystemStaffPO> list = null;
		try {
			list = (ArrayList<SystemStaffPO>)hibernateUtil.getAll("systemstaff", SystemStaffPO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
