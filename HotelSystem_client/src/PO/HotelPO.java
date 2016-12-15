package PO;

import java.io.Serializable;

import VO.HotelInfoVO;

public class HotelPO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
     * hotelId酒店的id
     * hotelStaffId 酒店工作人员的id
     * hotelStrict 酒店的商圈地址
     */
	private String grade;
	private String hotelId;
	private String hotelStaffId;
	private String hotelStrict;
	private String hotelName;
	private String hotelDiscription;
	private String hotelAddress;
	
	//VO > PO structure
	public HotelPO(HotelInfoVO hotelInfoVO){
		super();
		this.hotelId = hotelInfoVO.getHotelID();
		this.hotelStaffId = hotelInfoVO.getHotelStaffId();
		this.hotelStrict = hotelInfoVO.getHotelDistrict();
		this.hotelName = hotelInfoVO.getHotelName();
		this.hotelAddress = hotelInfoVO.getHotelAddress();
		this.hotelDiscription = hotelInfoVO.getHotelDiscription();
		this.grade = hotelInfoVO.getRank();
	}
	
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelStaffId() {
		return hotelStaffId;
	}
	public void setHotelStaffId(String hotelStaffId) {
		this.hotelStaffId = hotelStaffId;
	}
	public String getHotelStrict() {
		return hotelStrict;
		
	}
	public void setHotelStrict(String hotelStrict) {
		this.hotelStrict = hotelStrict;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getGrade() {
		return grade;
	}
	public void setGrade(String gra){
		this.grade = gra;
	}

	public String getHotelDiscription() {
		return hotelDiscription;
	}

	public void setHotelDiscription(String hotelDiscription) {
		this.hotelDiscription = hotelDiscription;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
}
