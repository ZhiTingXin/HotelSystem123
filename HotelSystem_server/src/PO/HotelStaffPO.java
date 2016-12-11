package PO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "hotelstaff")
public class HotelStaffPO {
	@Id
	private String id;

	private String username;

	private String phone;
	
	private String hotelName;


	public HotelStaffPO() {
		super();
	}

	public HotelStaffPO(String id, String username, String phone, String hotelName) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.hotelName = hotelName;
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
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

}
