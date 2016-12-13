package PO;

import java.io.Serializable;

public class LoginPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String userPassword;
	
	//构造方法
	public LoginPO(){
	}
	public LoginPO(String Id,String password){
		super();
		this.id = Id;
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
	
}
