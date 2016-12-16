package PO;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import other.memberState;

@Entity
@Table(name = "customer")
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
	
	private memberState state;
	
	public memberState getState() {
		return state;
	}

	public void setState(memberState state) {
		this.state = state;
	}

	public CustomerPO() {
	}
	
	@Id
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
	
}
