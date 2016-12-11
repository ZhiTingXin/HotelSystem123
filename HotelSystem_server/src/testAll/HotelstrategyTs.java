package testAll;


import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.HotelStrategyPO;
import data.service.HotelStrategyDataService;
import data.service.impl.HotelStrategyDataServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelstrategyTs {
     HotelStrategyDataService hotel = new HotelStrategyDataServiceImpl();
	@Test
	public void test001add()throws Exception{
		 HotelStrategyPO hotst = new HotelStrategyPO();
		hotst.setHotelID("123456");
		hotst.setHotelStrategyInfo("æ∆µÍ11‘¬ŒÂ’€");
		hotst.setId("123");
		assertEquals(true,hotel.add(hotst));
	}
	@Test
	public void test002update()throws Exception{
		HotelStrategyPO host = new HotelStrategyPO("æ∆µÍ11‘¬∞À’€”≈ª›","123456");
		host.setId("123");
		assertEquals(true, hotel.modify(host));
	}
	@Test
	public void test003find() throws Exception{
		String di = "123456";
		assertEquals("æ∆µÍ11‘¬∞À’€”≈ª›", hotel.getAll(di).get(0).getHotelStrategyInfo());
	}
	@Test
	public void test004del()throws Exception{
		 HotelStrategyPO hotst = new HotelStrategyPO();
		 hotst.setHotelID("123456");
		 hotst.setHotelStrategyInfo("æ∆µÍ11‘¬ŒÂ’€");
		 hotst.setId("123");
		assertEquals(true, hotel.delete(hotst));
	}
}
