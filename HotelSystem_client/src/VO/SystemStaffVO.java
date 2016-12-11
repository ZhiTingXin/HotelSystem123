package VO;

import PO.SystemStaffPO;

public class SystemStaffVO {

	private String id;

	private String username;

	private String businessDistrict;
	private String password;
	private String phone;

	public SystemStaffVO() {
		this.id = "300001";
		this.username = "Bill";
		this.businessDistrict = "�½ֿ���Ȧ";
		this.password = "bill300001";
	}

	public SystemStaffVO(SystemStaffPO userPO) {
		super();
		this.id = userPO.getId();
//		this.username = userPO.getUsername();
		this.businessDistrict = userPO.getBusinessDistrict();
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

	public String getBusinessDistrict() {
		return businessDistrict;
	}

	public void setBusinessDistrict(String businessDistrict) {
		this.businessDistrict = businessDistrict;
	}
	
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}

}
