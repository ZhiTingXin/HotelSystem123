package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import RMI.RemoteHelper;




public class ClientRunner {
	private RemoteHelper remoteHelper;
	private Main main;
	
	public ClientRunner() {
		linkToServer();
	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/DataRemoteObject"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} 
	}
//	public static void main(String[] args){
//		ClientRunner cr = new ClientRunner();
//		cr.main.launch(args);
//	}
}
