package data.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.Label;
import data.dao.DataFactory;
import data.dao.LabelDao;
import data.dao.impl.DataFactoryImpl;
import data.service.LabelDataService;

public class LabelDataServiceImpl implements LabelDataService{

	private DataFactory dataFactory;
	private LabelDao labelDao;
	public LabelDataServiceImpl(){
		dataFactory = new DataFactoryImpl();
		labelDao = dataFactory.getlabelDao();
	}
	public boolean addLabel(Label label) {
		return labelDao.addLabel(label);
	}

	public boolean delLabel(Label label) {
		return labelDao.delLabel(label);
	}
	public ArrayList<Label> getLabels(String hotelid) throws RemoteException {
		return labelDao.getLabels(hotelid);
	}

}
