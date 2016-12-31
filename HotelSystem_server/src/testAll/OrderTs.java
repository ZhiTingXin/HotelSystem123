package testAll;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.OrderPO;
import data.service.OrderDataService;
import data.service.impl.OrderDataServiceImpl;
import other.OrderState;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderTs {
	OrderDataService orderDataService= new OrderDataServiceImpl();
	OrderPO orderPO = new OrderPO();
	
	@Test
	public void test001a()throws Exception{
		orderPO.setId("123");
		orderPO.setHotelId("12345");
		orderPO.setEntryTime(LocalDate.now());
		orderPO.setGretime(LocalDate.now());
		orderPO.setStatus(OrderState.ABNOMAL);
		assertEquals(true,orderDataService.add(orderPO));
	}
	@Test
	public void test002b()throws Exception{
		orderPO.setId("123");
		orderPO.setStatus(OrderState.FINISHED);
		assertEquals(true, orderDataService.update(orderPO));
	}
	@Test
	public void test003c()throws Exception{
		OrderPO order = orderDataService.findorder("123");
		assertEquals(OrderState.FINISHED,order.getStatus());
	}
	@Test
	public void test004d()throws Exception{
		orderPO.setId("123");
		assertEquals(true, orderDataService.dalete(orderPO));
	}
	
}
