package data.dao.impl;

import java.util.ArrayList;
import PO.HotelStrategyPO;
import data.dao.HotelStrategyDao;
import other.hibernateUtil;

public class HotelStrategyDaoImpl implements HotelStrategyDao {

	public boolean add(HotelStrategyPO hotelstrategy) {
		try{
			hibernateUtil.add(hotelstrategy);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(HotelStrategyPO hotelstrategy) {
		try{
			hibernateUtil.delete(hotelstrategy);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean modify(HotelStrategyPO hotelstartegy) {
		try{
			hibernateUtil.update(hotelstartegy);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public HotelStrategyPO get(String hotelstrategyId) {
		HotelStrategyPO hotelstrategy = new HotelStrategyPO();
		try{
			hotelstrategy = (HotelStrategyPO)hibernateUtil.findById(HotelStrategyPO.class, hotelstrategyId);
		    return hotelstrategy;
		}catch(Exception e){
		    return hotelstrategy;
		}
	}

	public ArrayList<HotelStrategyPO> getAll(String hotelId) {
		ArrayList<HotelStrategyPO> hotelstrategy = new ArrayList<HotelStrategyPO>();
		try{
			ArrayList<HotelStrategyPO> hotelstrategy2 = (ArrayList<HotelStrategyPO>)
					hibernateUtil.getAll("hotelstrategypo", HotelStrategyPO.class);
			for(HotelStrategyPO strategyPO:hotelstrategy2){
				if(strategyPO.getHotelID().equals(hotelId)){
					hotelstrategy.add(strategyPO);
				}
			}
			return hotelstrategy;
		}catch(Exception e){
			e.printStackTrace();
			return hotelstrategy;
		}
	}

}
