//package testAll;
//
//import static org.junit.Assert.assertEquals;
//
//import java.time.LocalDate;
//
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import PO.OrderPO;
//import data.service.OrderDataService;
//import data.service.impl.OrderDataServiceImpl;
//import other.OrderState;
//import other.RoomType;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class OrderTs {
//	OrderDataService orderDataService= new OrderDataServiceImpl();
////	OrderPO orderPO = new OrderPO("123", "12313", "1331", OrderState.ABNOMAL, new LocalDate(2015, 06, 12), 12, "wujian", 123,RoomType.BIAOJIAN,3);
//	@Test
//	public void test001a()throws Exception{
//		assertEquals(true,orderDataService.add(orderPO));
//	}
//	@Test
//	public void test002b()throws Exception{
//		orderPO.setStatus(OrderState.FINISHED);
//		assertEquals(true, orderDataService.update(orderPO));
//	}
//	@Test
//	public void test003c()throws Exception{
//		OrderPO order = orderDataService.findorder(orderPO.getId());
//		assertEquals(OrderState.FINISHED,order.getStatus());
//	}
//	@Test
//	public void test004d()throws Exception{
//		assertEquals(true, orderDataService.dalete(orderPO));
//	}
//	@Test
//	public void test005f()throws Exception{
//		OrderPO order = new OrderPO();
//		order.setId("15155313");
//		assertEquals(true , orderDataService.dalete(order));
//	}
//}
