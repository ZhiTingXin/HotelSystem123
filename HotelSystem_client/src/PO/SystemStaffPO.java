package PO;

import java.io.Serializable;

import VO.SystemStaffVO;

public class SystemStaffPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String staffName;

	private String phone;

	private String image;
	
	public SystemStaffPO() {
	}

	public SystemStaffPO(SystemStaffVO systemStaffVO) {
		super();
		this.id = systemStaffVO.getId();
		this.image = systemStaffVO.getImage();
		this.staffName = systemStaffVO.getUsername();
		this.phone = systemStaffVO.getPhone();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

}
