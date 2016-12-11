package PO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "systemstaff")
public class SystemStaffPO {
	@Id
	private String id;

	private String staffName;

	private String phone;
	
	private String businessDistrict;

	public SystemStaffPO() {
		super();
	}

	public SystemStaffPO(String id, String staffName, String phone) {
		this.id = id;
		this.staffName = staffName;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setUsername(String staffName) {
		this.staffName = staffName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBusinessDistrict() {
		return businessDistrict;
	}

	public void setBusinessDistrict(String businessDistrict) {
		this.businessDistrict = businessDistrict;
	}
}
