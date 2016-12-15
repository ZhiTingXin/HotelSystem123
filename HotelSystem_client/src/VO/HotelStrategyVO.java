package VO;

import PO.HotelStrategyPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HotelStrategyVO {

	public String hotelId;
	private String id;
	private String strategyInfo;
	
	public HotelStrategyVO(HotelStrategyPO hotelStrategy) {
		super();
		hotelId = hotelStrategy.getHotelID();
		id = hotelStrategy.getId();
		strategyInfo = hotelStrategy.getHotelStrategyInfo();
	}

	public HotelStrategyVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getStrategyInfo() {
		return strategyInfo;
	}

	public void setStrategyInfo(String strategyInfo) {
		this.strategyInfo = strategyInfo;
	}

	public StringProperty getNameProperty() {
		return new SimpleStringProperty(this.id);
	}

	public StringProperty getInfoProperty() {
		return new SimpleStringProperty(this.strategyInfo);
	}
}
