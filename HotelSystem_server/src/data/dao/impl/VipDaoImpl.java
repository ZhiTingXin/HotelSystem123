package data.dao.impl;

import java.util.ArrayList;

import PO.VipPO;
import data.dao.VipDao;
import other.hibernateUtil;

public class VipDaoImpl implements VipDao{

	public boolean makeVip(VipPO vipPO) {
		try{
		    hibernateUtil.add(vipPO);
		    return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public VipPO getVip(int grade) {
		try {
			return (VipPO)hibernateUtil.findById(VipPO.class, grade);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateVip(VipPO vipPO) {
		try {
			hibernateUtil.update(vipPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<VipPO> getAllVips() {
		try {
			ArrayList<VipPO> viPos = (ArrayList<VipPO>)hibernateUtil.getAll("Vip", VipPO.class);
			return viPos;
		} catch (Exception e) {
			return null;
		}
	}

}
