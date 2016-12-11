package blservice;

import java.sql.Date;

import other.UserType;

public interface Login_blservice {

	public boolean comfirm (String user_id, String user_password);
//	public boolean addUser(String user_id, String user_password,Date birthday);
//	public boolean modifyPassword(String user_id, String user_password);

	public UserType assertUserType(String userIdInField);
}
