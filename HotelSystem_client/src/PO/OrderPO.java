package PO;

import java.io.Serializable;
import java.time.LocalDate;

import VO.OrderVO;
import other.OrderState;
import other.RoomType;

public class OrderPO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String hotelId;
	private String userId;
	private OrderState status;
	private LocalDate entryTime;
	private int lastTime;
	private String orderInfo;
	private double price;
	
	//
	private RoomType roomType;

	private int num_Room;

	public OrderPO() {
	}

	public OrderPO(String Id, String htId, String userId, OrderState st, LocalDate entry, int last, String info,
			int pr,RoomType roomType,int num_Room) {
		super();
		this.id = Id;
		this.hotelId = htId;
		this.userId = userId;
		this.entryTime = entry;
		this.status = st;
		this.price = pr;
		this.orderInfo = info;
		this.lastTime = last;
		
		//
		this.roomType = roomType;
		this.num_Room = num_Room;
	}

	// structer vo >po
	public OrderPO(OrderVO orderVO) {
		id = orderVO.getOrderID();
		hotelId = orderVO.getHotelID();
		userId = orderVO.getUserID();
		entryTime = orderVO.getEntryTime();
		status = orderVO.getOrderState();
		price = orderVO.getPrice();
		lastTime = orderVO.getLastime();
		num_Room = orderVO.getRoomNum();
		roomType = orderVO.getRoomType();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public RoomType getRoomType() {
		return roomType;
	}
	
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	public int getNum_Room() {
		return num_Room;
	}
	
	public void setNum_Room(int num_Room) {
		this.num_Room = num_Room;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public OrderState getStatus() {
		return status;
	}

	public void setStatus(OrderState status) {
		this.status = status;
	}

	public LocalDate getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDate entryTime) {
		this.entryTime = entryTime;
	}

	public int getLastTime() {
		return lastTime;
	}

	public void setLastTime(int lastTime) {
		this.lastTime = lastTime;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}