package testAll;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.LoginPO;
import data.service.LoginDataService;
import data.service.impl.LoginDataServiceImpl;
import other.UserType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Testlogin {
	LoginDataService a = new LoginDataServiceImpl();
	
//	@Test
//	public void test001Add() throws RemoteException{
//		a = new LoginDataServiceImpl();
//		LoginPO login = new LoginPO("151250170","xzt970828",UserType.CUSTOMER);
//		login.setId("151250170");
//		login.setUserPassword("helloword");
//		assertEquals(true ,a.add(login));
//	}
	@Test
	public void test002Check()throws RemoteException{
		String id = "151250170";
		assertEquals(UserType.CUSTOMER,a.findByID(id).getUserType() );
	}
//	@Test
//	public void test002up()throws Exception{
//		LoginPO lo = new  LoginPO("151250170","123",UserType.CUSTOMER);
//		assertEquals(true,a.update(lo));
//	}
//	@Test
//	public void test003Cofirm()throws Exception{
//		String id = "151250170";
//		String password = "123";
//		assertEquals(true, a.confirm(id, password));
//	}
//	@Test 
//	public void test003dele()throws Exception{
//		LoginPO login = new LoginPO("151250170","helloword",UserType.HOTELSTAFF);
//		assertEquals(true,a.delete(login));
//	}
	
}
