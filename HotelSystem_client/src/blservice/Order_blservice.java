package blservice;

import java.util.ArrayList;
import VO.OrderVO;
import other.OrderState;

public interface Order_blservice {
	public OrderState getState(String orderID);

	public OrderVO getOrder(String orderID);

	public ArrayList<OrderVO> getOrdersOfUsers(String userID);

	public boolean changeState(OrderVO order_info);

	public ArrayList<OrderVO> getUnfinishedOrders(String userID);

	public ArrayList<OrderVO> getAbnomalOrders(String userID);

	public boolean generateOrder(OrderVO Order);
	
	public boolean changeCredit(String userID, String orderID);

	public ArrayList<OrderVO> getOrderFromInput(String text);

	public String getOrderOriginalPrice(OrderVO order);

	public String getOrderPrice(OrderVO order);
	
	public ArrayList<OrderVO> getAllOrders(String hotelId);

	public ArrayList<OrderVO> getOrderOfToday(String hotelId);

	public ArrayList<OrderVO> getHotelUndoOrderList(String hotelID);
	
	public ArrayList<OrderVO> getHotelAbnormalOrderList(String hotelID);
	
	public ArrayList<OrderVO> getHotelFinishedOrderList(String hotelID);
	
	public ArrayList<OrderVO> getAllHotelOrders(String hotelid);
}
