package VO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import PO.OrderPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.OrderState;
import other.RoomType;
import util.DateUtil;

public class OrderVO {

	public String getOrderID() {
		return orderID;
	}

	public String getUserID() {
		return userID;
	}

	public String getHotelID() {
		return hotelID;
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getEntryTime() {
		return entryTime;
	}

	public int getLastime() {
		return lastime;
	}

	public void setLastime(int days) {
		// TODO Auto-generated method stub
		this.lastime = days;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	private String orderID;
	private String userID;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String hotelID;
	private double price;
	private double originalPrice;
	private LocalDate entryTime;
	public void setEntryTime(LocalDate entryTime) {
		this.entryTime = entryTime;
	}

	private int lastime;
	private OrderState orderState;

	private RoomType roomType;
	private int roomNum;
	private LocalDateTime revocationTime;

	public LocalDateTime getRevocationTime() {
		return revocationTime;
	}

	public void setRevocationTime(LocalDateTime revocationTime) {
		this.revocationTime = revocationTime;
	}

	public OrderVO(String orderID, String userID, String hotelID, double price, OrderState orderState) {
		this.orderID = orderID;
		this.userID = userID;
		this.hotelID = hotelID;
		this.price = price;
		this.orderState = orderState;
	}

	public OrderVO(String orderID, String userID, String hotelID, double price, LocalDate entryTime, int lastime,
			OrderState orderState) {
		this.orderID = orderID;
		this.userID = userID;
		this.hotelID = hotelID;
		this.price = price;
		this.entryTime = entryTime;
		this.lastime = lastime;
		this.orderState = orderState;
	}

	// structure method po > vo
	public OrderVO(OrderPO orderPO) {
		orderID = orderPO.getId();
		userID = orderPO.getUserId();
		hotelID = orderPO.getHotelId();
		price = orderPO.getPrice();
		entryTime = orderPO.getEntryTime();
		// lastime = orderPO.getLastTime();
		orderState = orderPO.getStatus();
	}

	// public OrderVO(String id) {
	// if (id == "123456001") {
	// this.orderID = id;
	// this.userID = "123456";
	// this.hotelID = "500001";
	// this.price = 198;
	// // this.entryTime = "2016/11/24";
	// this.lastime = 15;
	// this.orderState = OrderState.UNFINISHED;
	// this.roomType = RoomType.bigBedRoom;
	// this.roomNum = 1;
	// }
	// if (id == "123456002") {
	// this.orderID = id;
	// this.userID = "123456";
	// this.hotelID = "500002";
	// this.price = 198;
	// // this.entryTime = "2016/9/28";
	// this.lastime = 5;
	// this.orderState = OrderState.FINISHED;
	// this.roomType = RoomType.doublePersonRoom;
	// this.roomNum = 1;
	//
	// }
	// if (id == "123456003") {
	// this.orderID = id;
	// this.userID = "123456";
	// this.hotelID = "500003";
	// this.price = 198;
	// // this.entryTime = "2016/12/28";
	// this.lastime = 2;
	// this.orderState = OrderState.UNFINISHED;
	// this.roomType = RoomType.singlePersonRoom;
	// this.roomNum = 1;
	//
	// }
	// if (id == "123456004") {
	// this.orderID = id;
	// this.userID = "123456";
	// this.hotelID = "500004";
	// this.price = 198;
	// // this.entryTime = "2016/7/13";
	// this.lastime = 2;
	// this.orderState = OrderState.ABNOMAL;
	// this.roomType = RoomType.multiPersonRoom;
	// this.roomNum = 1;
	//
	// }
	//
	// }
	//
	// 表格服务方法
	public StringProperty getCustomerIDProperty() {
		return new SimpleStringProperty(this.userID);
	}

	public StringProperty getOrderIDProperty() {
		return new SimpleStringProperty(this.orderID);
	}

	public StringProperty getPriceProperty() {
		return new SimpleStringProperty(String.valueOf(this.price));
	}

	public StringProperty getOrderStateProperty() {
		if (this.orderState.equals(OrderState.ABNOMAL)) {
			return new SimpleStringProperty("异常");
		}
		if (this.orderState.equals(OrderState.FINISHED)) {
			return new SimpleStringProperty("已执行");
		}
		if (this.orderState.equals(OrderState.UNFINISHED)) {
			return new SimpleStringProperty("待执行");
		}
		return null;
	}

	public StringProperty getEntryTimeProperty() {
		return new SimpleStringProperty(this.entryTime.toString());
	}

	public StringProperty getCustomerIdProperty() {
		return new SimpleStringProperty(this.userID);
	}

	public StringProperty getHotelIDProperty() {
		return new SimpleStringProperty(this.hotelID);
	}

	public StringProperty getLastTimeProperty() {
		return new SimpleStringProperty(String.valueOf(lastime));
	}

	public StringProperty getRoomInfoProperty() {
		// TODO Auto-generated method stub
		return new SimpleStringProperty(this.roomType.toString() + "*" + String.valueOf(this.getRoomNum()));
	}
}
