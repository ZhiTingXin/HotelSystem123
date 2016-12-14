package VO;

import PO.SystemManagerPO;
import other.IdGernerateServiceImpl;

public class SystemManagerVO {
	
	private String password;
	private String systemmanager_Name;
	private String systemmanager_Id;
	
	public SystemManagerVO() {
		super();
		this.systemmanager_Id = IdGernerateServiceImpl.gernerateId();
	}

	public SystemManagerVO(SystemManagerPO systemManagerPO) {
		this.systemmanager_Id = systemManagerPO.getManagerId();
		this.systemmanager_Name = systemManagerPO.getManagerName();
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String newPasswordInField) {
		this.password = newPasswordInField;
	}

	
}
