package data.dao;

import java.util.ArrayList;

import PO.AdviceFeedBackPO;

public interface AdviceFeedbackDao {
  
	public boolean addAdvice(AdviceFeedBackPO advice);
	
	public boolean updateAdvice(AdviceFeedBackPO advice);
	
	public ArrayList<AdviceFeedBackPO> getAdvices(String userId,String type);

	public ArrayList<AdviceFeedBackPO> getAllAdvices();
}
