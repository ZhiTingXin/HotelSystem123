package other;

import RMI.RemoteHelper;

public class IdGernerateServiceImpl{
	
	public  static String gernerateId() {
		try{
			return RemoteHelper.getInstance().getIdGernerateService().gernerateId();
		}catch (Exception e) {
			return new String();
		}
	}


}
