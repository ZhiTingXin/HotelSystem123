package VO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import PO.OrderPO;
import blservice.impl.Hotel_bl;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;
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
	private LocalDate gretime;

	public OrderVO() {
		super();
		this.orderID = IdGernerateServiceImpl.gernerateId();
		this.gretime = LocalDate.now();
	}

	// structure method po > vo
	public OrderVO(OrderPO orderPO) {
		hotelID = orderPO.getHotelId();
		price = orderPO.getPrice();
		originalPrice = orderPO.getOriginalPrice();
		entryTime = orderPO.getEntryTime();
		orderID = orderPO.getId();
		userID = orderPO.getUserId();
		userName = orderPO.getUserName();
		lastime = orderPO.getLastTime();
		orderState = orderPO.getStatus();
		roomType = orderPO.getRoomType();
		roomNum = orderPO.getNum_Room();
		revocationTime = orderPO.getRevocationTime();
		gretime = orderPO.getGretime();
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

	public LocalDate getGretime() {
		return gretime;
	}

	public void setGretime(LocalDate gretime) {
		this.gretime = gretime;
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
		return new SimpleStringProperty(util.DateUtil.format(entryTime));
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

	public StringProperty getHotelNameProperty() {
		// TODO Auto-generated method stub
		return new SimpleStringProperty(Hotel_bl.getHotelName(this.hotelID));
	}

}
