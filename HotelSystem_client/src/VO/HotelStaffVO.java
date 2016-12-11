package VO;

import PO.HotelStaffPO;

public class HotelStaffVO {
	private String id;

	private String username;
	private String hotelId;
	private String hotelName;
    private String phone;
	private String password;

	public HotelStaffVO() {
		this.id = "200001";
		this.username = "Ken";
		this.hotelId = "500001";
		this.hotelName = "Nanjing Hotel";
		this.password = "Ken200001";
	}

	public HotelStaffVO(HotelStaffPO userPO) {
		super();
		this.id = userPO.getId();
		this.username = userPO.getUsername();
		this.hotelName = userPO.getHotelName();
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
