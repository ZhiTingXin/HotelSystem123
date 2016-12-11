package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.VipPO;
import data.dao.DataFactory;
import data.dao.VipDao;
import data.dao.impl.DataFactoryImpl;
import data.service.VipDataService;

public class VipDataServiceImpl implements VipDataService{
	
	private DataFactory dataFactory;
	private VipDao vipDao;
	public VipDataServiceImpl(){
		dataFactory = new DataFactoryImpl();
		vipDao = dataFactory.getVipDao();
	}
	public boolean makeVip(VipPO vipPO) throws RemoteException {
		try {
			vipDao.makeVip(vipPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public VipPO getVip(int grade) throws RemoteException {
		try {
			return vipDao.getVip(grade);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateVip(VipPO vipPO) throws RemoteException {
	try {
		return vipDao.updateVip(vipPO);
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}
	public ArrayList<VipPO> getAllVips() throws RemoteException {
		try{
			return vipDao.getAllVips();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
