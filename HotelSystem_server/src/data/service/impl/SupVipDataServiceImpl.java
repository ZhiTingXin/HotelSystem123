package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.SuperVipPO;
import data.dao.DataFactory;
import data.dao.SuperVipDao;
import data.dao.impl.DataFactoryImpl;
import data.service.SuperVipDataService;

public class SupVipDataServiceImpl implements SuperVipDataService {

	private DataFactory dataFactory;
	private SuperVipDao dao;
	public SupVipDataServiceImpl(){
		dataFactory = new DataFactoryImpl();
		dao = dataFactory.getSuovipdao();
	}
	public boolean addSupVip(SuperVipPO po) throws RemoteException {
		return dao.addSupVip(po);
	}

	public boolean modifySupVip(SuperVipPO po) throws RemoteException {
		return dao.modifySupVip(po);
	}

	public ArrayList<SuperVipPO> getStrict(String disstrict) throws RemoteException {
		return dao.getStrict(disstrict);
	}
	public boolean deleteSupVip(SuperVipPO po) throws RemoteException {
		return dao.delSupVip(po);
	}

}
