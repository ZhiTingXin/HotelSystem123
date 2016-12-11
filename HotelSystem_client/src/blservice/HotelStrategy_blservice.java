package blservice;

import java.util.ArrayList;

import VO.HotelStrategyVO;

public interface HotelStrategy_blservice {
	public boolean makeHotelStrategy(HotelStrategyVO hotelstrategy);

	public boolean modifyHotelStrategy(HotelStrategyVO hotelstrategy);

	public boolean deleteHotelStrategy(HotelStrategyVO strategyVO);

	public HotelStrategyVO getHotelStrategy(String HotelStrategyId);
	
	public ArrayList<HotelStrategyVO>getListOfHotelStrategys(String hotel_id);
	
}
