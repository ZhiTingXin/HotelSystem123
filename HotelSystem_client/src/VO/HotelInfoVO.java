package VO;

import PO.HotelPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;

public class HotelInfoVO {
	private String hotelID;
	private String hotelName;
	private String hotelDistrict;
	private String hotelStaffId;
	private String hotelAddress;
	private String hotelDiscription;
	private String rank;

	public HotelInfoVO() {
       super();
       this.hotelID = IdGernerateServiceImpl.gernerateId();
	}

	// 构造方法

	// *********used
	public HotelInfoVO(HotelPO hotelInfo) {
		super();
		this.hotelAddress = hotelInfo.getHotelAddress();
		this.hotelDiscription = hotelInfo.getHotelDiscription();
		this.hotelDistrict = hotelInfo.getHotelStrict();
		this.hotelID = hotelInfo.getHotelId();
		this.hotelStaffId = hotelInfo.getHotelStaffId();
		this.hotelName = hotelInfo.getHotelName();
	    this.rank = hotelInfo.getGrade();
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelDistrict() {
		return hotelDistrict;
	}

	public void setHotelDistrict(String hotelDistrict) {
		this.hotelDistrict = hotelDistrict;
	}

	public String getHotelStaffId() {
		return hotelStaffId;
	}

	public void setHotelStaffId(String hotelStaffId) {
		this.hotelStaffId = hotelStaffId;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelDiscription() {
		return hotelDiscription;
	}

	public void setHotelDiscription(String hotelDiscription) {
		this.hotelDiscription = hotelDiscription;
	}
	
	// 界面表格方法
	public StringProperty getHotelNameProperty() {
		return new SimpleStringProperty(this.hotelName);
	}

	public StringProperty getHotelAddressProperty() {
		return new SimpleStringProperty(this.hotelAddress);
	}

	public StringProperty getHotelDiscriptionProperty() {
		return new SimpleStringProperty(this.hotelDiscription);
	}

}
