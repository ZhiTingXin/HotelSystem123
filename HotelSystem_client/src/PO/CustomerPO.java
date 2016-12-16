package PO;

import java.io.Serializable;
import java.time.LocalDate;

import VO.CustomerVO;
import other.memberState;

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
	private memberState state;
	
	public CustomerPO() {
	}

	public CustomerPO(CustomerVO customerVO){
		super();
		this.birthday = customerVO.getBirthday();
		this.id = customerVO.getId();
		this.userName = customerVO.getUsername();
		//是否需要电话号码
		this.phone = customerVO.getPhone();
		this.companyName = customerVO.getCompanyName();
		this.credit = customerVO.getCredit();
		this.memberGrade = customerVO.getMemberGrade();
		this.state = customerVO.getMemberState();
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

	public memberState getState() {
		return state;
	}

	public void setState(memberState state) {
		this.state = state;
	}
	
}
