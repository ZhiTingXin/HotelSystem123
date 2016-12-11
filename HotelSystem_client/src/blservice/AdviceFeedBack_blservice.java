package blservice;

import java.util.ArrayList;

import VO.AdviceFeedBackVO;

public interface AdviceFeedBack_blservice {

	public ArrayList<AdviceFeedBackVO> getAllAdvice(String userID);

	public boolean addAdviceFeedBack(AdviceFeedBackVO advicefeedbackvo);

	public boolean modifyAdviceFeedBack(AdviceFeedBackVO advicefeedbackvo);

	public ArrayList<AdviceFeedBackVO> getUnprocessedAdvice(String systemstaffId);

    public ArrayList<AdviceFeedBackVO> getProcessedAdvice(String systemstaffId);
	
}
