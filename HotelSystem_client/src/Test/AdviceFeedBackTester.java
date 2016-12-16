package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import VO.AdviceFeedBackVO;
import blservice.AdviceFeedBack_blservice;
import blservice.impl.AdviceFeedBack_bl;
import main.ClientRunner;
import other.AdviceFeedBackState;
import util.DateUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdviceFeedBackTester {

  ClientRunner clientRunner = new ClientRunner();
  AdviceFeedBack_blservice adviceFeedBack_blservice = new AdviceFeedBack_bl();
  
  @Test
  public void test001Add(){
	   AdviceFeedBackVO adviceFeedBackVO = new AdviceFeedBackVO();
	   adviceFeedBackVO.setAdviceFeedBack_content("Õ¯’æ»’≥£±¿¿£");
	   adviceFeedBackVO.setReplyContent("lizojie");
	   adviceFeedBackVO.setUserID("151250");
	   AdviceFeedBackVO adviceFeedBackVO1 = new AdviceFeedBackVO();
	   adviceFeedBackVO1.setAdviceFeedBack_content("Õ¯’æ»’≥£±¿¿£");
	   adviceFeedBackVO1.setReplyContent("lizojie");
	   adviceFeedBackVO1.setUserID("151250");
	   AdviceFeedBackVO adviceFeedBackVO2 = new AdviceFeedBackVO();
	   adviceFeedBackVO2.setAdviceFeedBack_content("Õ¯’æ»’≥£±¿¿£");
	   adviceFeedBackVO2.setReplyContent("lizojie");
	   adviceFeedBackVO2.setUserID("151250");
	   AdviceFeedBackVO adviceFeedBackVO3 = new AdviceFeedBackVO();
	   adviceFeedBackVO3.setAdviceFeedBack_content("Õ¯’æ»’≥£±¿¿£");
	   adviceFeedBackVO3.setReplyContent("lizojie");
	   adviceFeedBackVO3.setUserID("151250");
	   adviceFeedBackVO3.setState(AdviceFeedBackState.UNPROCESSED);
	   adviceFeedBack_blservice.addAdviceFeedBack(adviceFeedBackVO3);
	   adviceFeedBack_blservice.addAdviceFeedBack(adviceFeedBackVO2);
	   adviceFeedBack_blservice.addAdviceFeedBack(adviceFeedBackVO1);
       assertEquals(true,adviceFeedBack_blservice.addAdviceFeedBack(adviceFeedBackVO));
  }
  @Test
  public void test002modify(){
	  String send = "2013-10-12";
	   ArrayList<AdviceFeedBackVO> adviceFeedBackVOs = adviceFeedBack_blservice.getAllAdvice("151250");
	   adviceFeedBackVOs.get(0).setReplyTime(DateUtil.parse_1(send));
	   assertEquals(true, adviceFeedBack_blservice.modifyAdviceFeedBack(adviceFeedBackVOs.get(0)));
  }
  @Test
  public void test003GetAlluserid(){
	  String userid = "151250170";
	  ArrayList<AdviceFeedBackVO> adviceFeedBackVOs = adviceFeedBack_blservice.getAllAdvice(userid);
	  assertEquals(0,adviceFeedBackVOs.size());
  }
  @Test
  public void test004getunprocessed(){
	  ArrayList<AdviceFeedBackVO> adviceFeedBackVOs = adviceFeedBack_blservice.getUnprocessedAdvice();
	  assertEquals(AdviceFeedBackState.UNPROCESSED, adviceFeedBackVOs.get(0).getState());
  }
}
