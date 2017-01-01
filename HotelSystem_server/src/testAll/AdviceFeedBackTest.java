package testAll;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.AdviceFeedBackPO;
import data.service.AdviceFeedBackDataService;
import data.service.impl.AdviceFeedBackDataServiceImpl;
import other.AdviceFeedBackState;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdviceFeedBackTest {
	
	private AdviceFeedBackDataService adviceFeedBackDataService = new AdviceFeedBackDataServiceImpl();
	
	@Test
	public void test001()throws Exception{
		AdviceFeedBackPO adviceFeedBackPO = new AdviceFeedBackPO();
		adviceFeedBackPO.setAdviceId("1234567");
		adviceFeedBackPO.setReplycontent("a");
		adviceFeedBackPO.setSenddate(LocalDate.now());
		adviceFeedBackPO.setUserId("123");
		adviceFeedBackPO.setState(AdviceFeedBackState.PROCESSED);
		adviceFeedBackPO.setAdviceFeedBack_content("Õ¯’æ±¿¿£");
		assertEquals(true,adviceFeedBackDataService.addAdvice(adviceFeedBackPO));
	}
	@Test
	public void test002()throws Exception{
		AdviceFeedBackPO adviceFeedBackPO = new AdviceFeedBackPO();
		adviceFeedBackPO.setAdviceId("123456");
		adviceFeedBackPO.setUserId("123");
		adviceFeedBackPO.setState(AdviceFeedBackState.UNPROCESSED);
		assertEquals(true, adviceFeedBackDataService.updateAdvice(adviceFeedBackPO));
	}
	@Test
	public void test003()throws Exception{
		String id = "123";
		assertEquals("123", adviceFeedBackDataService.getAdvices(id, "userid").get(0).getUserId());
	}
}
