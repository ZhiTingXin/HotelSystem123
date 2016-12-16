package data.dao;

public interface DataFactory {
	public AdviceFeedbackDao getAdviceFeedbackDao();
	public CustomerDao getCustomerDao();
	public HotelDao getHotelDao();
	public HotelStaffDao getHotelStaffDao();
	public HotelStrategyDao getHotelStrategyDao();
	public LoginDao getLoginDao();
	public OrderDao getOrderDao();
	public SystemManagerDao getSystemManagerDao();
	public SystemStaffDao getSystemStaffDao();
	public SystemStrategyDao getSystemStrategyDao();
	public VipDao getVipDao();
	public RoomDao getRoomDao();
	public AssessmentDao getAssessmentDao();
	public LabelDao getlabelDao();
}
