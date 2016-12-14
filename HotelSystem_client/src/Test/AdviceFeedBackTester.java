//package Test;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import VO.AdviceFeedBackVO;
//import blservice.AdviceFeedBack_blservice;
//import blservice.impl.AdviceFeedBack_bl;
//import main.ClientRunner;
//import other.AdviceFeedBackState;
//import util.DateUtil;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class AdviceFeedBackTester {
//
//  ClientRunner clientRunner = new ClientRunner();
//  AdviceFeedBack_blservice adviceFeedBack_blservice = new AdviceFeedBack_bl();
//  
//  @Test
//  public void test001Add(){
//	   String send = "2013-10-12";
//	   String rep = "2015-10-12";
//	   AdviceFeedBackVO adviceFeedBackVO = new AdviceFeedBackVO("151250170",AdviceFeedBackState.PROCESSED,"网站容易崩溃",
//			   "123456",DateUtil.parse_1(send),DateUtil.parse_1(rep),"知道了");
//	   AdviceFeedBackVO adviceFeedBackVO1 = new AdviceFeedBackVO("151250170",AdviceFeedBackState.PROCESSED,"网站容易崩溃",
//			   "123457",DateUtil.parse_1(send),DateUtil.parse_1(rep),"知道了");
//	   AdviceFeedBackVO adviceFeedBackVO2 = new AdviceFeedBackVO("151250170",AdviceFeedBackState.PROCESSED,"网站容易崩溃",
//			   "123458",DateUtil.parse_1(send),DateUtil.parse_1(rep),"知道了");
//	   AdviceFeedBackVO adviceFeedBackVO3 = new AdviceFeedBackVO("151250160",AdviceFeedBackState.PROCESSED,"网站容易崩溃",
//			   "123459",DateUtil.parse_1(send),DateUtil.parse_1(rep),"知道了");
//	   adviceFeedBack_blservice.addAdviceFeedBack(adviceFeedBackVO3);
//	   adviceFeedBack_blservice.addAdviceFeedBack(adviceFeedBackVO2);
//	   adviceFeedBack_blservice.addAdviceFeedBack(adviceFeedBackVO1);
//       assertEquals(true,adviceFeedBack_blservice.addAdviceFeedBack(adviceFeedBackVO));
//  }
//  @Test
//  public void test002modify(){
//	  String send = "2013-10-12";
//	   String rep = "2015-10-12";
//	   AdviceFeedBackVO adviceFeedBackVO = new AdviceFeedBackVO("151250170",AdviceFeedBackState.UNPROCESSED,"网站容易崩溃吗",
//			   "123456",DateUtil.parse_1(send),DateUtil.parse_1(rep),"知道了");
//	   assertEquals(true, adviceFeedBack_blservice.modifyAdviceFeedBack(adviceFeedBackVO));
//  }
//  @Test
//  public void test003GetAlluserid(){
//	  String userid = "151250170";
//	  ArrayList<AdviceFeedBackVO> adviceFeedBackVOs = adviceFeedBack_blservice.getAllAdvice(userid);
//	  assertEquals(3,adviceFeedBackVOs.size());
//  }
//  @Test
//  public void test004getunprocessed(){
//	  ArrayList<AdviceFeedBackVO> adviceFeedBackVOs = adviceFeedBack_blservice.getUnprocessedAdvice();
//	  assertEquals(1, adviceFeedBackVOs.size());
//  }
//}
