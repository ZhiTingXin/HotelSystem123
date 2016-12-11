package VO;

import PO.SystemManagerPO;

public class SystemManagerVO {
	public String getUserName() {
		return systemmanager_Name;
	}

	public String getId() {
		return systemmanager_Id;
	}

	private String password;
	private String systemmanager_Name;
	private String systemmanager_Id;

	public SystemManagerVO() {
		this.systemmanager_Name = "Tim";
		this.systemmanager_Id = "400001";
		this.password = "Tim400001";
	}

	public SystemManagerVO(SystemManagerPO systemManagerPO) {
		this.systemmanager_Id = systemManagerPO.getId();
		this.systemmanager_Name = systemManagerPO.getManagerName();
	}

	public void setUsername(String name) {
		// TODO Auto-generated method stub
		this.systemmanager_Name = name;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	public void setPassword(String newPasswordInField) {
		// TODO Auto-generated method stub
		this.password = newPasswordInField;
	}

	
}
