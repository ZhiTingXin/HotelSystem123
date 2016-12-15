package PO;

import java.io.Serializable;

import VO.HotelStrategyVO;

public class HotelStrategyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String strategyName;
	private String hotelStrategyInfo;
	private String hotelID;

	/**
	 * 
	 *  hotelStrategyInfo 酒店促销策略的基本内容
	 *  hotelID 酒店的id
	 */
	public HotelStrategyPO(){}
	public HotelStrategyPO(HotelStrategyVO hotelStrategyVO){
	   super();
	   this.hotelID = hotelStrategyVO.getHotelId();
	   this.hotelStrategyInfo = hotelStrategyVO.getStrategyInfo();
	   this.strategyName = hotelStrategyVO.getStrategyName();
	   this.id = hotelStrategyVO.getId();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHotelStrategyInfo() {
		return hotelStrategyInfo;
	}
	public void setHotelStrategyInfo(String hotelStrategyInfo) {
		this.hotelStrategyInfo = hotelStrategyInfo;
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getStrategyName() {
		return strategyName;
	}
	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}
	
}
