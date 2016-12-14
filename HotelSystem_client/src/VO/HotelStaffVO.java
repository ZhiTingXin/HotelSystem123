package VO;

import PO.HotelStaffPO;

public class HotelStaffVO {
	
	private String id;
	private String username;
	private String hotelId;
	//可能会删除
	private String hotelName;
	//是否需要phone
    private String phone;
	private String password;

	public HotelStaffVO() {
	
	}
    
	public HotelStaffVO(HotelStaffPO userPO) {
		super();
		this.id = userPO.getId();
		this.username = userPO.getUsername();
		this.hotelId = userPO.getHotelId();
		this.phone = userPO.getPhone();
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
}
