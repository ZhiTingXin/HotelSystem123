package VO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import PO.OrderPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.OrderState;
import other.RoomType;

public class OrderVO {
	private String hotelID;
	private double price;
	private double originalPrice;
	private LocalDate entryTime;
	private String orderID;
	private String userID;
	private String userName;
	private int lastime;
	private OrderState orderState;
	private RoomType roomType;
	private int roomNum;
	private LocalDateTime revocationTime;

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
		lastime = orderPO.getLastTime();
		orderState = orderPO.getStatus();
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public LocalDate getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDate entryTime) {
		this.entryTime = entryTime;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getLastime() {
		return lastime;
	}

	public void setLastime(int lastime) {
		this.lastime = lastime;
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

	public LocalDateTime getRevocationTime() {
		return revocationTime;
	}

	public void setRevocationTime(LocalDateTime revocationTime) {
		this.revocationTime = revocationTime;
	}

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
		return new SimpleStringProperty(this.roomType.toString() + "*" + String.valueOf(this.getRoomNum()));
	}
	
}
