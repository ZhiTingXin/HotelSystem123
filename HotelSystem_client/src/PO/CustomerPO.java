package PO;

import java.util.Date;

import VO.CustomerVO;

public class CustomerPO {
	private String id;
	
	private String userName;
	private String phone;

	private int credit;

	private int memberGrade;
	
	private Date birthday;
	
	public CustomerPO() {
	}

	public CustomerPO(CustomerVO customerVO){
		this.birthday = customerVO.getBirthday();
		this.id = customerVO.getId();
		this.userName = customerVO.getUsername();
		//是否需要电话号码
		this.credit = customerVO.getCredit();
		this.memberGrade = customerVO.getMemberGrade();
	}
	public CustomerPO(String id, String username, String phone, int credit, int memberGrade,Date birthday) {
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
