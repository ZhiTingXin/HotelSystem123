package Test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import VO.OrderVO;
import blservice.Order_blservice;
import blservice.impl.Order_bl;
import main.ClientRunner;
import other.OrderState;
import util.DateUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderTester {
 
	ClientRunner  Client = new ClientRunner();
	Order_blservice orderdate = new Order_bl();
	@Test
	public void test001addOrder(){
		OrderVO orderVO = new OrderVO();
		orderVO.setEntryTime(DateUtil.parse_1("2016-12-12"));
		orderVO.setHotelID("123456");
		orderVO.setUserID("151250170");
		orderVO.setLastime(10);
		orderVO.setOrderState(OrderState.ABNOMAL);
		orderVO.setOriginalPrice(123);
		orderVO.setPrice(1235);
		OrderVO orderVO1 = new OrderVO();
		orderVO1.setEntryTime(DateUtil.parse_1("2016-12-12"));
		orderVO1.setHotelID("123456");
		orderVO1.setUserID("151250170");
		orderVO1.setLastime(10);
		orderVO1.setOrderState(OrderState.ABNOMAL);
		orderVO1.setOriginalPrice(123);
		orderVO1.setPrice(1235);
		OrderVO orderVO2 = new OrderVO();
		orderVO2.setEntryTime(DateUtil.parse_1("2016-12-12"));
		orderVO2.setHotelID("123456");
		orderVO2.setUserID("151250170");
		orderVO2.setLastime(10);
		orderVO2.setOrderState(OrderState.UNFINISHED);
		orderVO2.setOriginalPrice(123);
		orderVO2.setPrice(1235);
		OrderVO orderVO3 = new OrderVO();
		orderVO3.setEntryTime(DateUtil.parse_1("2016-12-12"));
		orderVO3.setHotelID("123456");
		orderVO3.setUserID("151250170");
		orderVO3.setLastime(10);
		orderVO3.setOrderState(OrderState.FINISHED);
		orderVO3.setOriginalPrice(123);
		orderVO3.setPrice(1235);
		OrderVO orderVO4 = new OrderVO();
		orderVO4.setEntryTime(DateUtil.parse_1("2016-12-12"));
		orderVO4.setHotelID("123456");
		orderVO4.setUserID("14567880");
		orderVO4.setLastime(165);
		orderVO4.setOrderState(OrderState.ABNOMAL);
		orderVO4.setOriginalPrice(123);
		orderVO4.setPrice(1235);
		
		OrderVO orderVO5 = new OrderVO();
		orderVO5.setEntryTime(DateUtil.parse_1("2016-12-12"));
		orderVO5.setHotelID("123456");
		orderVO5.setUserID("14567880");
		orderVO5.setLastime(10);
		orderVO5.setOrderState(OrderState.ASSESSED);
		orderVO5.setOriginalPrice(123);
		orderVO5.setPrice(1235);
		orderdate.generateOrder(orderVO);
		orderdate.generateOrder(orderVO1);
		orderdate.generateOrder(orderVO2);
		orderdate.generateOrder(orderVO3);
		orderdate.generateOrder(orderVO4);
		assertEquals(true,orderdate.generateOrder(orderVO5));
	}
	@Test
	public void test001getstate(){
		
	}
	
}
