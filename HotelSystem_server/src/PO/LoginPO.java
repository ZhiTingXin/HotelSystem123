package PO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import other.UserType;

@Entity
@Table(name = "login")
public class LoginPO implements Serializable {

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
	public LoginPO(String Id,String password,UserType type){
		super();
		this.id = Id;
		this.userType = type;
		this.userPassword = password;
	}
	@Id
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
