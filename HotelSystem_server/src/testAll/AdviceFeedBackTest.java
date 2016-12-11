//package testAll;
//
//import static org.junit.Assert.*;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import PO.AdviceFeedBackPO;
//import data.service.AdviceFeedBackDataService;
//import data.service.impl.AdviceFeedBackDataServiceImpl;
//import other.AdviceFeedBackState;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class AdviceFeedBackTest {
//	
//	private AdviceFeedBackDataService adviceFeedBackDataService = new AdviceFeedBackDataServiceImpl();
//	
//	@Test
//	public void test001()throws Exception{
//		AdviceFeedBackPO adviceFeedBackPO = new AdviceFeedBackPO(AdviceFeedBackState.PROCESSED,
//				"Õ¯’æ»’≥£±¿¿£","151250170", "151250265");
//	    adviceFeedBackPO.setAdviceId("151");
//		assertEquals(true,adviceFeedBackDataService.addAdvice(adviceFeedBackPO));
//	}
//	@Test
//	public void test002()throws Exception{
//		AdviceFeedBackPO adviceFeedBackPO = new AdviceFeedBackPO(AdviceFeedBackState.PROCESSED,
//				"Õ¯’æ»’≥£±¿¿£","151250170", "151250265");
//		adviceFeedBackPO.setAdviceId("151");
//		adviceFeedBackPO.setState(AdviceFeedBackState.UNPROCESSED);
//		assertEquals(true, adviceFeedBackDataService.updateAdvice(adviceFeedBackPO));
//	}
//	@Test
//	public void test003()throws Exception{
//		String id = "151250170";
//		assertEquals(AdviceFeedBackState.UNPROCESSED, adviceFeedBackDataService.getAdvices(id, "userid").get(0).getState());
//	}
//}
