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
		HotelStaffPO hotelStaffPO = new HotelStaffPO();
		hotelStaffPO.setId("1512521799");
		hotelStaffPO.setHotelName("½ðÁê´ó¾Æµê");
		hotelStaffPO.setPhone("15951622353");
		assertEquals(true,staff.addStaff(hotelStaffPO));
	}
	@Test
	public void test002up()throws Exception{
		HotelStaffPO hotelStaffPO = new HotelStaffPO();
		hotelStaffPO.setId("1512521799");
		hotelStaffPO.setHotelId("1512521799");
		hotelStaffPO.setHotelName("½ðÁê¾Æµê");
		hotelStaffPO.setPhone("151252222213");
		assertEquals(true , staff.updateStaff(hotelStaffPO));
	}
	@Test
	public void test003fin()throws Exception{
		String id = "1512521799";
		assertEquals("Ô²Í¨´ó¾Æµê", staff.findHotelStaff(id).getHotelName());
	}
	@Test
	public void test004del() throws Exception{
		HotelStaffPO hotelStaffPO = new HotelStaffPO();
		hotelStaffPO.setId("1512521799");
		assertEquals(true, staff.deleteStaff(hotelStaffPO));
	}
}
