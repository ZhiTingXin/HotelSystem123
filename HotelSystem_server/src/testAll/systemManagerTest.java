package testAll;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.SystemManagerPO;
import data.service.SystemManagerDataService;
import data.service.impl.SystemManagerDataServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class systemManagerTest {

	private SystemManagerDataService systemManagerDataService = new SystemManagerDataServiceImpl();
	@Test
	public void test001add()throws Exception{
		SystemManagerPO systemManagerPO = new SystemManagerPO("151250169", "mrs xie");
		assertEquals(true,systemManagerDataService.addManager(systemManagerPO));
	}

	@Test
	public void test002up()throws Exception{
		SystemManagerPO systemManagerPO = new SystemManagerPO("151250169", "mrs huang");
		assertEquals(true, systemManagerDataService.updateManager(systemManagerPO));
	}
	
	@Test
	public void test003fi()throws Exception{
		String id = "151250169";
		assertEquals("151250169",systemManagerDataService.findManager(id).getId());
	}
	@Test
	public void test004del()throws Exception{
		SystemManagerPO systemManagerPO = new SystemManagerPO("151250169", "mrs huang");
		assertEquals(true, systemManagerDataService.deleteManager(systemManagerPO));
	}
}
