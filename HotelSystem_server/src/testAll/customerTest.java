package testAll;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

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
		customerPO.setCredit(0);
		customerPO.setId("151250170");
		customerPO.setMemberGrade(5);
		customerPO.setPhone("15851266554");
		customerPO.setUserName("xinzhiting");
		assertEquals(true,customerDataService.addCustomer(customerPO));
	}
	@Test
	public void test002up()throws Exception{
		CustomerPO customerPO = new CustomerPO();
		customerPO.setId("151250170");
		customerPO.setUserName("xinzhiting");
		customerPO.setBirthday(LocalDate.now());
		customerPO.setCompanyName("ºã´ó¼¯ÍÅ");
		customerPO.setCredit(300);
		customerPO.setMemberGrade(2);
		assertEquals(true, customerDataService.updateCustomer(customerPO));
	}
	@Test
	public void test003find() throws Exception{
		String id = "151250170";
		assertEquals("xinzhiting",customerDataService.findCustomer(id).getUserName());
	}
	@Test
	public void test004del() throws Exception{
		CustomerPO customerPO = new CustomerPO();
		customerPO.setId("151250170");
		assertEquals(true, customerDataService.deleteCustomer(customerPO));
	}
}
