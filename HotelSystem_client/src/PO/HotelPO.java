package PO;

import VO.HotelInfoVO;

public class HotelPO {
    /*
     * hotelId酒店的id
     * hotelStaffId 酒店工作人员的id
     * hotelStrict 酒店的商圈地址
     */
	private String hotelId;
	private String hotelStaffId;
	private String hotelStrict;
	private String hotelName;
	
	//Hotel的构造方法
	public HotelPO(String hid,String hsid,String hstri,String hotelname){
		super();
		this.hotelId = hid;
		this.hotelStaffId = hsid;
		this.hotelStrict = hstri;
		this.hotelName = hotelname;
	}
	
	//VO > PO structure
	public HotelPO(HotelInfoVO hotelInfoVO){
		this.hotelId = hotelInfoVO.getHotelID();
		this.hotelStaffId = hotelInfoVO.getHotelStaffId();
		this.hotelStrict = hotelInfoVO.getHotelDistrict();
		this.hotelName = hotelInfoVO.getHotelName();
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
}
