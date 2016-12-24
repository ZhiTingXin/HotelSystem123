package VO;

import PO.SystemManagerPO;
import other.IdGernerateServiceImpl;

public class SystemManagerVO {
	
	private String password;
	private String systemmanager_Name;
	private String systemmanager_Id;
	private String phone;
	private String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	public SystemManagerVO() {
		super();
		this.systemmanager_Id = IdGernerateServiceImpl.gernerateId();
	}

	public SystemManagerVO(SystemManagerPO systemManagerPO) {
		this.systemmanager_Id = systemManagerPO.getManagerId();
		this.systemmanager_Name = systemManagerPO.getManagerName();
		this.image = systemManagerPO.getImage();
		this.phone = systemManagerPO.getPhone();
	}
	
	public String getUserName() {
		return systemmanager_Name;
	}

	public String getId() {
		return systemmanager_Id;
	}

	public void setUsername(String name) {
		this.systemmanager_Name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String newPasswordInField) {
		this.password = newPasswordInField;
	}

	
}
