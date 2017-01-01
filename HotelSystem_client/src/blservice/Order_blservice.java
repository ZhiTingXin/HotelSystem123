package blservice;

import java.util.ArrayList;

import VO.OrderVO;
import other.OrderState;
import other.UserType;

public interface Order_blservice {
	public OrderState getState(String orderID);

	public OrderVO getOrder(String orderID);

	public ArrayList<OrderVO> getOrdersOfUsers(String userID);

	public boolean changeState(OrderVO order_info);

	public boolean addHalfOfOrginalCredit(String userID, String orderID);

	public ArrayList<OrderVO> getUnfinishedOrders(String userID);

	public ArrayList<OrderVO> getAbnomalOrders(String userID);

	public boolean generateOrder(OrderVO Order);

	public boolean changeCredit(String userID, String orderID);

	public ArrayList<OrderVO> getOrderFromInput(String text);

	public String getOrderOriginalPrice(OrderVO order);

	public String getOrderPrice(OrderVO order);

	public ArrayList<OrderVO> getOrderOfToday(String hotelId);

	public ArrayList<OrderVO> getHotelUndoOrderList(String hotelID);

	public ArrayList<OrderVO> getHotelAbnormalOrderList(String hotelID);

	public ArrayList<OrderVO> getHotelFinishedOrderList(String hotelID);

	public ArrayList<OrderVO> getAllAbnormalOrders();

	public boolean changeStateBySystemStaff(OrderVO orderVO);

	public boolean changeCreditBySystemStaff(String userID, String orderID);

	public ArrayList<OrderVO> getRevocationOrder(String hotelId);

}
