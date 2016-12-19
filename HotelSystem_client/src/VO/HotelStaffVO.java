package VO;

import PO.HotelStaffPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;

public class HotelStaffVO {
	
	private String id;
	private String username;
	private String hotelId;
	private String hotelName;
    private String phone;
	private String password;

	public HotelStaffVO() {
	   id = IdGernerateServiceImpl.gernerateId();
	}
    
	public HotelStaffVO(HotelStaffPO userPO) {
		super();
		this.id = userPO.getId();
		this.username = userPO.getUsername();
		this.hotelId = userPO.getHotelId();
		this.phone = userPO.getPhone();
		this.hotelName = userPO.getHotelName();
	}
	
	public HotelStaffVO(String id,String name,String hotelID,String hotelName){
		this.id = id;
		this.username = name;
		this.hotelId = hotelID;
		this.hotelName = hotelName;
	}

	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(String id) {
		this.hotelId = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public StringProperty getHotelStaffIdProperty() {
		return new SimpleStringProperty(id);
	}
	
	public StringProperty getHotelStaffNameProperty(){
		return new SimpleStringProperty(username);
	}
	
	public StringProperty getHotelStaffTypeProperty(){
		return new SimpleStringProperty("酒店工作人员");
	}
	
	public StringProperty getHotelNameProperty(){
		return new SimpleStringProperty(hotelName);
	}
}
