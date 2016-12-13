package blservice.impl;

import RMI.RemoteHelper;
import blservice.IdGernerateService;

public class IdGernerateServiceImpl implements IdGernerateService{
	
	public String gernerateId() {
		try{
			return RemoteHelper.getInstance().getIdGernerateService().gernerateId();
		}catch (Exception e) {
			return new String();
		}
	}


}
