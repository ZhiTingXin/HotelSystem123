package PO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class LoginPO {

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
	
}
