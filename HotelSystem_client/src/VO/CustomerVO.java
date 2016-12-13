package VO;

import java.time.LocalDate;

import PO.CustomerPO;
import other.memberState;

public class CustomerVO {

	private String id;

	private String userName;
	private String password;

	private int credit;

	private LocalDate birthday;

	private String companyName;

	private int memberGrade;
	private memberState memberState;

	public void setMemberState(memberState memberState) {
		this.memberState = memberState;
	}
	public CustomerVO(){}

//	public CustomerVO() {
//		this.id = "123456";
//		this.birthday = LocalDate.of(1995, 11, 19);
//		this.companyName = "NJU";
//		this.credit = 100;
//		this.userName = "William";
//		this.password = "William123456";
//		this.memberGrade = 1;
//		this.memberState = memberState.NORMAL_MEMBER;
//	}

	public CustomerVO(CustomerPO customerPO) {
		super();
		this.id = customerPO.getId();
		this.userName = customerPO.getUserName();
		this.credit = customerPO.getCredit();
		//this.birthday = customerPO.getBirthday();
		this.memberGrade = customerPO.getMemberGrade();
	}

	public CustomerVO(String id, String userName, int credit) {

		this.id = id;
		this.userName = userName;
		this.credit = credit;

	}

	public CustomerVO(String id, String name, int memberGrade, LocalDate date, String companyName, int credit){
		this.id = id;
		this.userName = name;
		this.memberGrade = memberGrade;
		this.birthday = date;
		this.companyName= companyName;
		this.credit = credit;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
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

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public memberState getMemberState() {
		return this.memberState;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
}
