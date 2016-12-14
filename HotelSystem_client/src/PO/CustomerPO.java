package PO;

import java.io.Serializable;
import java.time.LocalDate;

import VO.CustomerVO;

public class CustomerPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String userName;
	private String phone;
	private int credit;
	private int memberGrade;
	private LocalDate birthday;
	public String companyName;
	
	public CustomerPO() {
	}

	public CustomerPO(CustomerVO customerVO){
		super();
		this.birthday = customerVO.getBirthday();
		this.id = customerVO.getId();
		this.userName = customerVO.getUsername();
		//�Ƿ���Ҫ�绰����
		this.companyName = customerVO.getCompanyName();
		this.credit = customerVO.getCredit();
		this.memberGrade = customerVO.getMemberGrade();
	}
	public CustomerPO(String id, String username, String phone, int credit, int memberGrade,LocalDate birthday) {
		super();
		this.id = id;
		this.userName = username;
		this.phone = phone;
		this.credit = credit;
		this.memberGrade = memberGrade;
		this.birthday = birthday;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
