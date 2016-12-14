//package testAll;
//
//import static org.junit.Assert.assertEquals;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import PO.AdviceFeedBackPO;
//import data.service.AdviceFeedBackDataService;
//import data.service.impl.AdviceFeedBackDataServiceImpl;
//import data.service.impl.IdGernerateServiceImpl;
//import other.AdviceFeedBackState;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class AdviceFeedBackTest {
//	
//	private AdviceFeedBackDataService adviceFeedBackDataService = new AdviceFeedBackDataServiceImpl();
//	
//	@Test
//	public void test001()throws Exception{
//		AdviceFeedBackPO adviceFeedBackPO = new AdviceFeedBackPO(new IdGernerateServiceImpl().gernerateId(),
//				AdviceFeedBackState.PROCESSED,"Õ¯’æ±¿¿£","151250");
//		assertEquals(true,adviceFeedBackDataService.addAdvice(adviceFeedBackPO));
//	}
//	@Test
//	public void test002()throws Exception{
//		AdviceFeedBackPO adviceFeedBackPO = new AdviceFeedBackPO();
//		adviceFeedBackPO.setAdviceId("129");
//		adviceFeedBackPO.setState(AdviceFeedBackState.UNPROCESSED);
//		assertEquals(true, adviceFeedBackDataService.updateAdvice(adviceFeedBackPO));
//	}
//	@Test
//	public void test003()throws Exception{
//		String id = "151250";
//		assertEquals(AdviceFeedBackState.UNPROCESSED, adviceFeedBackDataService.getAdvices(id, "userid").get(0).getState());
//	}
//}
