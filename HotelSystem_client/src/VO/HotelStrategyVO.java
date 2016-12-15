package VO;

import PO.HotelStrategyPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;

public class HotelStrategyVO {

	public String hotelId;
	private String id;
	private String strategyInfo;
	private String strategyName;
	public HotelStrategyVO(HotelStrategyPO hotelStrategy) {
		super();
		strategyName = hotelStrategy.getStrategyName();
		hotelId = hotelStrategy.getHotelID();
		id = hotelStrategy.getId();
		strategyInfo = hotelStrategy.getHotelStrategyInfo();
	}

	public HotelStrategyVO() {
		id = IdGernerateServiceImpl.gernerateId();
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

	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public StringProperty getNameProperty() {
		return new SimpleStringProperty(this.id);
	}

	public StringProperty getInfoProperty() {
		return new SimpleStringProperty(this.strategyInfo);
	}
}
