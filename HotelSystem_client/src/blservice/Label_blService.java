package blservice;

import java.util.ArrayList;

import VO.LabelVO;

public interface Label_blService {

	public boolean addLabel(LabelVO labelVO);
	
	public boolean delLabel(LabelVO labelVO);
	
	public ArrayList<LabelVO> getHotelLabels(String hotelid);
	
}
