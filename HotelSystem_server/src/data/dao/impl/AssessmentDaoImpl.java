package data.dao.impl;

import java.util.ArrayList;

import PO.AssessmentPO;
import data.dao.AssessmentDao;
import other.hibernateUtil;

public class AssessmentDaoImpl implements AssessmentDao{

	public boolean addAssessment(AssessmentPO assessmentPO) {
		try {
			hibernateUtil.add(assessmentPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleAssessment(AssessmentPO assessmentPO) {
		try {
			hibernateUtil.delete(assessmentPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public AssessmentPO getAssessment(String orderID) {
		try{
			AssessmentPO assessmentPO =(AssessmentPO) hibernateUtil.findById(AssessmentPO.class, orderID);
			return assessmentPO;
		}catch (Exception e) {
			return null;
		}
	}

	public ArrayList<AssessmentPO> getAllAssement(String hotelid) {
		try{
			ArrayList<AssessmentPO> arrayList = (ArrayList<AssessmentPO>)hibernateUtil.findbySome("AssessmentPO", "hotelid", hotelid);
		    return arrayList;
		}catch (Exception e) {
			return null;
		}
	}

}
