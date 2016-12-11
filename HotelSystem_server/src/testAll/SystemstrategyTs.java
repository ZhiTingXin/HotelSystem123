package testAll;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.SystemStrategyPO;
import data.service.SystemStrategyDataService;
import data.service.impl.SystemStrategyDataServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SystemstrategyTs {
    SystemStrategyDataService daa =  new SystemStrategyDataServiceImpl();
    SystemStrategyPO systemstrategy = new SystemStrategyPO("双十12一大促", 0.5, new Date(), new Date());
    
	@Test
	public void test001add()throws Exception{
		assertEquals(true,daa.add(systemstrategy));
	}
	@Test 
	public void test002upda()throws Exception{
		systemstrategy.setDiscount(0.8);
		assertEquals(true, daa.modify(systemstrategy));
	}
	@Test
	public void test003find()throws Exception{
		String name = "双十12一大促";
		assertEquals("双十12一大促", daa.getSstrategy(name).getSystemStrategy_name());
	}
	@Test
	public void test004del()throws Exception{
		assertEquals(true, daa.delete(systemstrategy));
	}
}
