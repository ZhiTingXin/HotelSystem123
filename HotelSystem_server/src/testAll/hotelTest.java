package testAll;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import PO.HotelPO;
import data.service.HotelDataService;
import data.service.impl.HotelDataServiceImpl;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class hotelTest {
	HotelDataService hotelDataService = new HotelDataServiceImpl();
	@Test
	public void test001add() throws Exception{
		HotelPO hotel = new HotelPO();
		hotel.setHotelId("1121234");
		hotel.setHotelStaffId("213213");
		hotel.setCity("nanjing");
		hotel.setHotelName("金陵大酒店");
		assertEquals(true,hotelDataService.add(hotel));
	}
	
	@Test
	public void test002Find()throws Exception{
		HotelPO hotel = hotelDataService.find("1121234");
		assertEquals("nanjing", hotel.getCity());
	}
	@Test
	public void test003update()throws Exception{
		HotelPO hotel = hotelDataService.find("1121234");
		hotel.setHotelName("南京大学");
		hotelDataService.update(hotel);
	}
	@Test
	public void test004Del()throws Exception{
		HotelPO hotel = new HotelPO();
		hotel.setHotelId("1121234");
		assertEquals(true, hotelDataService.del(hotel));
	}
	
}
