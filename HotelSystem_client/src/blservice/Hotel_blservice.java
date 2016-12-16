package blservice;

import java.util.ArrayList;
import VO.HotelInfoVO;

public interface Hotel_blservice {
	public HotelInfoVO getHotelInfo(String hotelId);

	public boolean modifyHotelInfo(HotelInfoVO hotelInfo);

	public ArrayList<HotelInfoVO> getListOfHotel(String strict);

	public ArrayList<HotelInfoVO> getAllHotel();

	public boolean addHotel(HotelInfoVO hotel);

	public ArrayList<HotelInfoVO> getListOfHotelPrefer(String userId);

	public ArrayList<HotelInfoVO> getHotelFromName(String text);
	

}
