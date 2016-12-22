package Test;

import PO.LoginPO;
import PO.SystemManagerPO;
import RMI.RemoteHelper;
import main.ClientRunner;
import other.PassWordMd5;
import other.UserType;

public class SystemManagerTester {

	public static void main(String [] args){
		ClientRunner clientRunner  = new ClientRunner();
		SystemManagerPO systemManagerPO = new SystemManagerPO();
		systemManagerPO.setManagerId("12345");
		systemManagerPO.setManagerName("xinzhiting");
		LoginPO loginPO = new LoginPO();
		loginPO.setId("12345");
		loginPO.setUserPassword(PassWordMd5.EncryptionStr16("123", PassWordMd5.MD5, PassWordMd5.UTF8));
		loginPO.setUserType(UserType.SYSTEMMANAGER);
		try{
		RemoteHelper.getInstance().getSystemManagerDataService().addManager(systemManagerPO);
		RemoteHelper.getInstance().getLoginDataService().add(loginPO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
