package testAll;

import static org.junit.Assert.*;

import javax.enterprise.inject.New;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.SystemStaffPO;
import data.service.SystemStaffDataService;
import data.service.impl.SystemStaffDataServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SystemStaffTest {
    
	SystemStaffDataService temstaff = new SystemStaffDataServiceImpl();
	@Test
	public void test001add()throws Exception{
		SystemStaffPO staffPO = new SystemStaffPO();
		staffPO.setId("123456");
		staffPO.setBusinessDistrict("nanjing");
		staffPO.setPhone("1595163255");
		staffPO.setUsername("xinzhiting");
		assertEquals(true,temstaff.addStaff(staffPO));
	}
	@Test
	public void test002update()throws Exception{
		SystemStaffPO staffPO = new SystemStaffPO();
		staffPO.setBusinessDistrict("beijing");
		staffPO.setId("123456");
		staffPO.setPhone("15951926228");
		staffPO.setUsername("bubing");
		assertEquals(true, temstaff.updateStaff(staffPO));
	}
	@Test
	public void test003find()throws Exception{
		String id = "123456";
		assertEquals("beijing",temstaff.findStaff(id).getBusinessDistrict());
	}
	@Test
	public void test004del()throws Exception{
		SystemStaffPO staffPO = new SystemStaffPO();
		staffPO.setBusinessDistrict("beijing");
		staffPO.setId("123456");
		staffPO.setPhone("15951926228");
		staffPO.setUsername("bubing");
		assertEquals(true, temstaff.deleteStaff(staffPO));
	}
}
