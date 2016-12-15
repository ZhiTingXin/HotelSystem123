package Test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import blservice.Login_blservice;
import blservice.impl.Login_bl;
import main.ClientRunner;
import other.UserType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTester {
    ClientRunner ccClientRunner = new ClientRunner();
 	Login_blservice login = new Login_bl();
	@Test 
	public void test001login(){
		assertEquals(true,login.comfirm("151250","xzt123"));
	}
	@Test
	public void test002assertType(){
		assertEquals(UserType.CUSTOMER, login.assertUserType("151250"));
	}
	@Test
	public void test003login(){
		assertEquals(false, login.comfirm("152", "ada"));
	}
	@Test
	public void test004login(){
		assertEquals(false, login.assertUserType("151250170")==UserType.HOTELSTAFF);
	}
}
