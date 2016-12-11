package PO;

import VO.SystemStaffVO;

public class SystemStaffPO {
	private String id;

	private String staffName;

	private String phone;
	
	private String businessDistrict;

	public SystemStaffPO() {
	}

	public SystemStaffPO(SystemStaffVO systemStaffVO){
		super();
		this.id = systemStaffVO.getId();
		this.staffName = systemStaffVO.getUsername();
		this.phone = systemStaffVO.getPhone();
		this.businessDistrict = systemStaffVO.getBusinessDistrict();
	}
	public SystemStaffPO(String id, String staffName, String phone) {
		super();
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
