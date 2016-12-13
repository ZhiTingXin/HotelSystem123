package Test;

import PO.LoginPO;
import RMI.RemoteHelper;
import blservice.IdGernerateService;
import blservice.impl.IdGernerateServiceImpl;
import data.service.LoginDataService;
import main.ClientRunner;

public class gernerateID {
   public static void main(String [] args)throws Exception{
	   ClientRunner clientRunner = new ClientRunner();
	   LoginDataService loginDataService = RemoteHelper.getInstance().getLoginDataService();
	   LoginPO login = new LoginPO("abcdskdj", "mdade");
	   loginDataService.add(login);
   }
}
