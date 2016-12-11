package data.dao.impl;

import java.util.ArrayList;

import PO.AdviceFeedBackPO;
import data.dao.AdviceFeedbackDao;
import other.hibernateUtil;

public class AdviceFeedbackDaoImpl implements AdviceFeedbackDao {


	public boolean addAdvice(AdviceFeedBackPO advice) {
		try{
			hibernateUtil.add(advice);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		    return false;
		}
	}
	public boolean updateAdvice(AdviceFeedBackPO advice) {
		try{
			hibernateUtil.update(advice);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		    return false;
		}
	}
	public ArrayList<AdviceFeedBackPO> getAdvices(String userId,String type) {
		ArrayList<AdviceFeedBackPO> list = null;
		try{
			list = (ArrayList<AdviceFeedBackPO>) hibernateUtil.findbySome("AdviceFeedBackPO", type, userId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<AdviceFeedBackPO> getAllAdvices() {
		ArrayList<AdviceFeedBackPO> list =null;
		try {
			list = (ArrayList<AdviceFeedBackPO>)hibernateUtil.getAll("advicefeedbackpo", AdviceFeedBackPO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
