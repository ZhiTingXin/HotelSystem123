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
	// NEW 
	public String genarateHotelID();
	public String genarateHotelStaffID();

	public boolean addHotel(HotelInfoVO hotel);

	public boolean addHotelStaff(HotelStaffVO hotelStaff);

	public ArrayList<HotelInfoVO> getListOfHotelPrefer(String userId);

	public String getHotelGradeAssessment(String hotelID);

	public String[] getHotelTagAssessment(String hotelID);

	public ArrayList<HotelInfoVO> getHotelFromName(String text);
	
	public String getHotelRoomPrice(String hotelID);

}
