package data.dao;

import java.util.ArrayList;

import PO.AssessmentPO;

public interface AssessmentDao {
 
	public boolean addAssessment(AssessmentPO assessmentPO);
	
	public boolean deleAssessment(AssessmentPO assessmentPO);
	
	public AssessmentPO getAssessment(String orderID);
	
	public ArrayList<AssessmentPO> getAllAssement(String hotelid);
	
	public ArrayList<AssessmentPO> getUserASS(String userid);
	
}
