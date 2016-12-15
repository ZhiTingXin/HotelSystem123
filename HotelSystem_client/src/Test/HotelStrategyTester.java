package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import VO.HotelStrategyVO;
import blservice.HotelStrategy_blservice;
import blservice.impl.HotelStrategy_bl;
import main.ClientRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelStrategyTester {
 
	ClientRunner client  = new ClientRunner();
	HotelStrategy_blservice hotel = new HotelStrategy_bl();
	@Test
	public void test001make(){
		HotelStrategyVO hotelStrategyVO = new  HotelStrategyVO();
		hotelStrategyVO.setHotelId("151250");
		hotelStrategyVO.setStrategyInfo("Âú¼õÁË£¬Âú¼õÁË£¬Âú200¼õ20");
		HotelStrategyVO hotelStrategyVO1 = new  HotelStrategyVO();
		hotelStrategyVO1.setHotelId("151250");
		hotelStrategyVO1.setStrategyInfo("Âú¼õÁË£¬Âú¼õÁË£¬Âú200¼õ20");
		HotelStrategyVO hotelStrategyVO2 = new  HotelStrategyVO();
		hotelStrategyVO2.setHotelId("151250");
		hotelStrategyVO2.setStrategyInfo("Âú¼õÁË£¬Âú¼õÁË£¬Âú200¼õ20");
		HotelStrategyVO hotelStrategyVO3 = new  HotelStrategyVO();
		hotelStrategyVO3.setHotelId("151250");
		hotelStrategyVO3.setStrategyInfo("Âú¼õÁË£¬Âú¼õÁË£¬Âú200¼õ20");
		HotelStrategyVO hotelStrategyVO4 = new  HotelStrategyVO();
		hotelStrategyVO4.setHotelId("151250");
		hotelStrategyVO4.setStrategyInfo("Âú¼õÁË£¬Âú¼õÁË£¬Âú200¼õ20");
		hotel.makeHotelStrategy(hotelStrategyVO4);
		hotel.makeHotelStrategy(hotelStrategyVO3);
		hotel.makeHotelStrategy(hotelStrategyVO2);
		hotel.makeHotelStrategy(hotelStrategyVO1);
		assertEquals(true,hotel.makeHotelStrategy(hotelStrategyVO));
	}

	@Test
	public void test003getlotandmodify(){
		ArrayList<HotelStrategyVO> hotelStrategyVOs = hotel.getListOfHotelStrategys("151250");
		HotelStrategyVO hotelstrategy = hotelStrategyVOs.get(0);
		hotelstrategy.setStrategyName("Âú¼õ");
		assertEquals(true, hotel.modifyHotelStrategy(hotelstrategy));
	}
	@Test
	public void test004get(){
		HotelStrategyVO hotelStrategyVO = hotel.getHotelStrategy("199");
		assertEquals("Âú¼õ", hotelStrategyVO.getStrategyName());
	}
	@Test
	public void test005del(){
		String aString= "200";
		assertEquals(true, hotel.deleteHotelStrategy(aString));
	}
}
