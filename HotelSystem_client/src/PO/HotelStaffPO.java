package PO;

import java.io.Serializable;

import VO.HotelStaffVO;

public class HotelStaffPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String username;
	private String phone;
	private String hotelId;
    private String hotelName;

	public HotelStaffPO() {
	}
	
	public HotelStaffPO(HotelStaffVO hotelStaffVO){
		super();
		this.hotelId = hotelStaffVO.getHotelId();
		this.username = hotelStaffVO.getUsername();
		this.phone = hotelStaffVO.getPhone();
		this.id = hotelStaffVO.getId();
		this.hotelName = hotelStaffVO.getHotelName();
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

}
