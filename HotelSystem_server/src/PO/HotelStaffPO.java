package PO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "hotelstaff")
public class HotelStaffPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String username;

	private String phone;
	
	private String hotelId;


	public HotelStaffPO() {
	}


	public HotelStaffPO(String id, String username, String phone, String hotelId) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.hotelId = hotelId;
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

	public String getHotelName() {
		return hotelId;
	}

	public void setHotelName(String hotelId) {
		this.hotelId = hotelId;
	}

}
