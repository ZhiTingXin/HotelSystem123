package blservice;

import java.util.ArrayList;

import VO.AssementVO;

public interface Assessment_blService {

	public boolean addAssessment(AssementVO assementVO);
	
	public ArrayList<AssementVO> getAllHotelAss(String hotelid);
	
	public ArrayList<AssementVO> getUserAss(String userId);
	
	public boolean delAss(AssementVO assementVO);
	
	public AssementVO getAss(String orderid);
}
