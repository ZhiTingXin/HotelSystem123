package MockObject;

import VO.AdviceFeedBackVO;
import other.AdviceFeedBackState;

public class MockAdviceFeedback extends AdviceFeedBackVO {
    String advice_con;
    AdviceFeedBackState state;
    String adviceID;
	public MockAdviceFeedback(String advice,AdviceFeedBackState state1,String adviceid){
		advice_con =advice;
		state = state1;
		adviceID =adviceid;
	}
	
	public String getAdviceId(){
		return adviceID;
	}
}
