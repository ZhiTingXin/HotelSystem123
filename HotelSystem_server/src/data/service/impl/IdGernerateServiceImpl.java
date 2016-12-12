package data.service.impl;

import java.rmi.RemoteException;

import PO.ClassToGreId;
import data.service.IdGernerateService;
import other.hibernateUtil;

public class IdGernerateServiceImpl implements IdGernerateService{

	public String gernerateId() throws RemoteException {
		String ID = new String();
		try{
			ClassToGreId id = (ClassToGreId)hibernateUtil.findById(ClassToGreId.class, "1");
		    ID =Integer.toString(Integer.parseInt(id.getId())+1);
		    id.setId(ID);
		    hibernateUtil.update(id);
			return ID;
		}catch (Exception e) {
			return ID;
		}
	}

}
