package blservice;

import other.UserType;

public interface Login_blservice {

	public boolean comfirm(String user_id, String user_password);

	public UserType assertUserType(String userIdInField);

	public boolean isOnlineConfirm(String userId);

	public void login(String userId);
}
