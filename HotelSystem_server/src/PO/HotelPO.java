package PO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="hotel")
public class HotelPO implements Serializable {
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
	
	//Hotel的构造方法
	public HotelPO(){
	}
	@Id
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
