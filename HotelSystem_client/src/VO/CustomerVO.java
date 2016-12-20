package VO;

import java.time.LocalDate;

import PO.CustomerPO;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;
import other.memberState;

public class CustomerVO {

	private String id;
	private String userName;
	private String password;
	private int credit;
	private LocalDate birthday;
	private String companyName;
	private String phone;
	private int memberGrade;
	private memberState memberState;
	public CustomerVO(){
		super();
		this.id = IdGernerateServiceImpl.gernerateId();
	}
	
	public CustomerVO(CustomerPO customerPO) {
		super();
		this.id = customerPO.getId();
		this.userName = customerPO.getUserName();
		this.phone = customerPO.getPhone();
		this.credit = customerPO.getCredit();
		this.birthday = customerPO.getBirthday();
		this.memberGrade = customerPO.getMemberGrade();
		this.memberState = customerPO.getState();
		this.companyName = customerPO.getCompanyName();
	}
	
	public void setMemberState(memberState memberState) {
		this.memberState = memberState;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	public StringProperty getIDstringProperty(){
		return new SimpleStringProperty(id);
	}
	
	public StringProperty getUserNamePriperty(){
		return new SimpleStringProperty(userName);
	}
	public StringProperty getUserTypePriperty(){
		return new SimpleStringProperty("¿Í»§");
	}
	public StringProperty getCreditProperty(){
		return new SimpleStringProperty(String.valueOf(credit));
	}
}
