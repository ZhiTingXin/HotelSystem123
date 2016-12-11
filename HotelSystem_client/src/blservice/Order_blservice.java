package blservice;

import java.util.ArrayList;

import PO.PrivilegePO;
import VO.OrderVO;
import other.OrderState;
import other.RoomType;

public interface Order_blservice {
	public OrderState getState(String orderID);

	public OrderVO getOrder(String orderID);

	public ArrayList<OrderVO> getOrdersOfUsers(String userID);

	public boolean changeState(OrderVO order_info);

	public ArrayList<OrderVO> getUnfinishedOrders(String userID);

	public ArrayList<OrderVO> getAbnomalOrders(String userID);

	// public ArrayList<OrderVO> getHotelOrders(String userID,String hotelID);
	// public boolean checkRoomType(String hotelID, RoomType type);
	// public ArrayList<PrivilegePO> getRecommendations(String userID, String
	// hotelID);
	public boolean generateOrder(OrderVO Order);

	public boolean changeState(String orderID);

	public boolean changeCredit(String userID, String orderID);

	public ArrayList<OrderVO> getOrderFromInput(String text);

	public String getOrderOriginalPrice(OrderVO order);

	public String getOrderPrice(OrderVO order, String id);

	public ArrayList<OrderVO> getOrderOfToday(String hotelId);

}
