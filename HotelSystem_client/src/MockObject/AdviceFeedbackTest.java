package MockObject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import VO.AdviceFeedBackVO;
import other.AdviceFeedBackState;
import presentation.controller.adviceFeedBackController.AdviceReplyController;
import presentation.controller.adviceFeedBackController.AdvicefeedbackController;

public class AdviceFeedbackTest{

	@Test
	public void testAddAdvice(){
		MockAdviceFeedback advice = new MockAdviceFeedback("建议修改网站的某些功能", AdviceFeedBackState.PROCESSED, "15");
		AdvicefeedbackController con = new AdvicefeedbackController();
		boolean s = con.addAdviceFeedBack(advice);
		
		assertEquals(true,s);
	}
	@Test
	public void testGetAdvice(){
		AdvicefeedbackController con = new AdvicefeedbackController();
		String userID = "151250170";
		ArrayList<AdviceFeedBackVO> advice = con.getAllAdvice(userID);
		AdviceFeedBackVO ad = advice.get(0);
		assertEquals("网站经常会出现卡顿",ad.getAdviceFeedBack_content());
	}
	@Test
	public void testModifyAdvice(){
		AdvicefeedbackController con = new AdvicefeedbackController();
		MockAdviceFeedback advice = new MockAdviceFeedback("建议修改网站的某些功能", AdviceFeedBackState.PROCESSED, "15");
		assertEquals(false,con.modifyAdviceFeedBack(advice));
		
	}
	@Test
	public void testGetProcessed(){
		AdviceReplyController con = new AdviceReplyController();
		String systemstaffId="151250170";
		ArrayList<AdviceFeedBackVO> ads = con.getProcessedAdvice(systemstaffId);
		AdviceFeedBackVO ad = ads.get(0);
		assertEquals("网站不够美观",ad.getAdviceFeedBack_content());
	}
	@Test
	public void testGetUnprocessed(){
		AdviceReplyController con = new AdviceReplyController();
		String systemstaffId="151250170";
		ArrayList<AdviceFeedBackVO> ads = con.getUnprocessedAdvice(systemstaffId);
		AdviceFeedBackVO ad = ads.get(0);
		assertEquals("网站太水了",ad.getAdviceFeedBack_content());
	}
	@Test
	public void testAdd(){
		AdviceReplyController con = new AdviceReplyController();
		MockAdviceFeedback ad = new MockAdviceFeedback("网站风格不好",AdviceFeedBackState.PROCESSED,"12");
		assertEquals(true,con.addAdviceFeedback(ad));
	}
//	@Test
//	public void testSetstate(){
//		AdviceReplyController con = new AdviceReplyController();
//		String adID= "12";
//		assertEquals(true,con.setStateOfAdvice(adID));
//	}
}
