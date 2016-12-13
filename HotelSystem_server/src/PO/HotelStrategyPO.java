package PO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HotelStrategyPO")
public class HotelStrategyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String hotelStrategyInfo;
	String hotelID;

	/**
	 * 
	 *  hotelStrategyInfo �Ƶ�������ԵĻ�������
	 *  hotelID �Ƶ��id
	 */
	public HotelStrategyPO(){}
	public HotelStrategyPO(String hotelStrategyInfo,String hotelID) {
		super();
		this.hotelStrategyInfo = hotelStrategyInfo;
		this.hotelID = hotelID;
	}
	@Id
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
	
}
