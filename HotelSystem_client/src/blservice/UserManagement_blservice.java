package blservice;

import java.util.ArrayList;
import VO.CustomerVO;
import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;

public interface UserManagement_blservice {
	
	public CustomerVO getCustomer(String customerId);
	//new
	public ArrayList<CustomerVO> getAllCustomer();
	
	public HotelStaffVO getHotelStaff(String hotelStaffId);
	//new 
	public ArrayList<HotelStaffVO> getAllHotelStaff();
	
	public SystemStaffVO getSystemStaff(String systemStaffId);
	//new
	public ArrayList<SystemStaffVO> getAllSystemStaff();
	
	public SystemManagerVO getSystemManager(String systemManagerId);
	//网站管理人员修改用户信息
	public boolean modifyCustomer(CustomerVO customerVO);
	
	public boolean modifyHotelStaff(HotelStaffVO hotelStaffVO);
	
	public boolean modifySystemStaff(SystemStaffVO systemStaffVO);
	
	public boolean addSystemStaff(SystemStaffVO staffVO);
	
	public boolean addHotel(HotelInfoVO hotelInfoVO);
	
    public boolean addHotelStaff(HotelStaffVO hotelStaffVO);
    
    //新增
    public int getCustomerNum();//获取客户数量
    public int getHotelStaffNum();
    public int getSystemStaffNum();
    public int getTodayOrderNumberNum();
    public int getOrderNumber();
}
