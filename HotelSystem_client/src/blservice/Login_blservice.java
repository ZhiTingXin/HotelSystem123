package blservice;

import VO.CustomerVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;
import other.UserType;

public interface Login_blservice {

	public boolean comfirm (String user_id, String user_password);
	public UserType assertUserType(String userIdInField);

	public CustomerVO getCustomer(String customerID);
	public HotelStaffVO getHotelStaff(String hotelStaffID);
	public SystemManagerVO getSystemManager(String systemManagerID);
	public SystemStaffVO getSystemStaff(String systemStaffID);
}

