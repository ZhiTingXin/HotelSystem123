package data.dao;

import java.util.ArrayList;

import PO.HotelStrategyPO;

public interface HotelStrategyDao {

	public boolean add(HotelStrategyPO hotelstrategy);
	public boolean delete(HotelStrategyPO hotelstrategy);
	public boolean modify(HotelStrategyPO hotelstartegy);
	public HotelStrategyPO get(String hotelstrategyId);
	public ArrayList<HotelStrategyPO> getAll(String hotelId);
	
}
