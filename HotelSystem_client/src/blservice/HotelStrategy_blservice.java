package blservice;

import java.util.ArrayList;

import VO.HotelStrategyVO;

public interface HotelStrategy_blservice {
	public boolean makeHotelStrategy(HotelStrategyVO hotelstrategy);

	public boolean modifyHotelStrategy(HotelStrategyVO hotelstrategy);

	public boolean deleteHotelStrategy(String hotelStrategyId);

	public HotelStrategyVO getHotelStrategy(String HotelStrategyId);
	
	public ArrayList<HotelStrategyVO>getListOfHotelStrategys(String hotel_id);
	
}
