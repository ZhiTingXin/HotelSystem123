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
	
	private String hotelName;
	private String hotelId;
    private String image;
    
 public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public HotelStaffPO() {
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


	public String getHotelId() {
		return hotelId;
	}


	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

}
