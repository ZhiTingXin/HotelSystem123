package testAll;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.CustomerPO;
import data.service.CustomerDataService;
import data.service.impl.CustomerDataServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class customerTest {

	private CustomerDataService customerDataService = new CustomerDataServiceImpl();
	
	@Test
	public void test001add()throws Exception{
		CustomerPO customerPO = new CustomerPO();
		customerPO.setBirthday(new Date());
		customerPO.setCredit(0);
		customerPO.setId("151250170");
		customerPO.setMemberGrade(5);
		customerPO.setPhone("15851266554");
		customerPO.setUserName("xinzhiting");
		assertEquals(true,customerDataService.addCustomer(customerPO));
	}
	@Test
	public void test002up()throws Exception{
		CustomerPO customerPO = new CustomerPO("151250170", "zhiting xin", "15125017023", 0, 5);
		assertEquals(true, customerDataService.updateCustomer(customerPO));
	}
	@Test
	public void test003find() throws Exception{
		String id = "151250170";
		assertEquals("zhiting xin",customerDataService.findCustomer(id).getUserName());
	}
	@Test
	public void test004del() throws Exception{
		CustomerPO customerPO = new CustomerPO("151250170", "zhiting xin", "15125017023", 0, 5);
		assertEquals(true, customerDataService.deleteCustomer(customerPO));
	}
}
