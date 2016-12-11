package testAll;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.HotelStaffPO;
import data.service.HotelStaffDataService;
import data.service.impl.HotelStaffDataServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelStafftest {

	private HotelStaffDataService staff = new HotelStaffDataServiceImpl();
	
	@Test
	public void test001add()throws Exception{
		HotelStaffPO hotelStaffPO = new HotelStaffPO("151250170", "xinzhiting", "15951926228","金陵大酒店");
		assertEquals(true,staff.addStaff(hotelStaffPO));
	}
	@Test
	public void test002up()throws Exception{
		HotelStaffPO hotelStaffPO = new HotelStaffPO("151250170", "xinzhiting", "15951926228","圆通大酒店");
		assertEquals(true , staff.updateStaff(hotelStaffPO));
	}
	@Test
	public void test003fin()throws Exception{
		String id = "151250170";
		assertEquals("圆通大酒店", staff.findHotelStaff(id).getHotelName());
	}
	@Test
	public void test004del() throws Exception{
		HotelStaffPO hotelStaffPO = new HotelStaffPO("151250170", "xinzhiting", "15951926228","圆通大酒店");
		assertEquals(true, staff.deleteStaff(hotelStaffPO));
	}
}
