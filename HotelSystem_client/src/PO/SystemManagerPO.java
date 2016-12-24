package PO;

import java.io.Serializable;

import VO.SystemManagerVO;

public class SystemManagerPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String managerID;
	private String managerName;
    private String image;
    private String phone;
    
    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	public SystemManagerPO(){}
	public SystemManagerPO(SystemManagerVO systemManagerVO){
		super();
		this.managerID = systemManagerVO.getId();
		this.managerName = systemManagerVO.getUserName();
		this.image = systemManagerVO.getImage();
		this.phone = systemManagerVO.getPhone();
	}
	
	public String getManagerId() {
		return managerID;
	}

	public void setManagerId(String managerID) {
		this.managerID = managerID;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
