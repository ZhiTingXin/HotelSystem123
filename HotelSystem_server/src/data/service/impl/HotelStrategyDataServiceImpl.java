package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelStrategyPO;
import data.dao.DataFactory;
import data.dao.HotelStrategyDao;
import data.dao.impl.DataFactoryImpl;
import data.service.HotelStrategyDataService;

public class HotelStrategyDataServiceImpl implements HotelStrategyDataService {

	private DataFactory dataFactory;
	private HotelStrategyDao hotelStrategyDao;
	
	public HotelStrategyDataServiceImpl(){
		dataFactory = new DataFactoryImpl();
		hotelStrategyDao = dataFactory.getHotelStrategyDao();
	}
	public boolean add(HotelStrategyPO hotelstrategy) throws RemoteException {
		return hotelStrategyDao.add(hotelstrategy);
	}

	public boolean delete(HotelStrategyPO hotelstrategy) throws RemoteException {
		return hotelStrategyDao.delete(hotelstrategy);
	}

	public boolean modify(HotelStrategyPO hotelstartegy) throws RemoteException {
		return hotelStrategyDao.modify(hotelstartegy);
	}

	public HotelStrategyPO get(String hotelstrategyId) throws RemoteException {
		return hotelStrategyDao.get(hotelstrategyId);
	}

	public ArrayList<HotelStrategyPO> getAll(String hotelId) throws RemoteException {
		return hotelStrategyDao.getAll(hotelId);
	}


}
