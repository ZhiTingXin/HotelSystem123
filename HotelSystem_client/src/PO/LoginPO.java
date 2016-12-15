package PO;

import java.io.Serializable;

import other.UserType;

public class LoginPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String userPassword;
	private UserType userType;
	
	//构造方法
	public LoginPO(){
	}
	public LoginPO(String id,String password){
		super();
		this.id = id;
		this.userPassword =password;
	}
	public LoginPO(String Id,String password,UserType type){
		super();
		this.id = Id;
		this.userType = type;
		this.userPassword = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
}
