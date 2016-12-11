package blservice;

import java.util.ArrayList;

import PO.HotelRoomInfoPO;
import VO.HotelInfoVO;
import VO.HotelStaffVO;

public interface Hotel_blservice {
	public HotelInfoVO getHotelInfo(String hotelId);

	public boolean modifyHotelInfo(HotelInfoVO hotelInfo);

	public ArrayList<HotelInfoVO> getListOfHotel(String strict, String type);

	public ArrayList<HotelInfoVO> getAllHotel();

	public boolean addHotel(HotelInfoVO hotel);

	public boolean addHotelStaff(HotelStaffVO hotelStaff);

	// public boolean addAssessment(String hotelID, String assessment);

	// public boolean addLabelAssessment(String hotelID,
	// ArrayList<Label> labelList);
	//
	// public boolean addRankAssessment(String hotelID, Rank rank);
	//
	// public boolean roomModify(String hotelId,HotelRoomInfoPO currentInfo);
	//
	public HotelRoomInfoPO getHotelRoomInfo(String hotelId);

	// public ArrayList<PO.Label> getLabelAssessment(String hotelId);
	//
	// public boolean deleteLabelAssessment(String hotelId,Label label);

	public ArrayList<HotelInfoVO> getListOfHotelPrefer(String userId);

	public String getHotelStrategy(String hotelID);

	public String getHotelGradeAssessment(String hotelID);

	public String[] getHotelTagAssessment(String hotelID);

	public ArrayList<HotelInfoVO> getHotelFromName(String text);

}
