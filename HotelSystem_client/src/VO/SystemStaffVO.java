package VO;

import PO.SystemStaffPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;

public class SystemStaffVO {

	private String id;
	private String username;
	private String businessDistrict;
	private String password;
	private String phone;
	private String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public SystemStaffVO() {
		super();
		this.id = IdGernerateServiceImpl.gernerateId();
	}

	public SystemStaffVO(SystemStaffPO userPO) {
		super();
		this.id = userPO.getId();
		this.username = userPO.getStaffName();
		this.businessDistrict = userPO.getBusinessDistrict();
		this.phone = userPO.getPhone();
	}

	public SystemStaffVO(String id,String name, String district){
		this.id = id;
		this.username = name;
		this.businessDistrict = district;
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
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}

	/**
	 * UI 
	 */
	public StringProperty getSystemStaffIDProperty() {
		return new SimpleStringProperty(this.id);
	}
	public StringProperty getSystemSatffNameProperty() {
		return new SimpleStringProperty(this.username);
	}
	public StringProperty getSystemStaffIdentity() {
		return new SimpleStringProperty("网站营销人员");
	}
	public StringProperty getSystemStaffDistrict() {
		return new SimpleStringProperty(this.businessDistrict);
	}
}
