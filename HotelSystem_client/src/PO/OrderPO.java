package PO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
	private double price;
	private RoomType roomType;
    private LocalDate gretime;
	private int num_Room;
	private double originalPrice;
	private String userName;
	private LocalDateTime revocationTime;

	public OrderPO() {
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
		gretime = orderVO.getGretime();
		userName = orderVO.getUserName();
		originalPrice = orderVO.getOriginalPrice();
		revocationTime = orderVO.getRevocationTime();
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getRevocationTime() {
		return revocationTime;
	}

	public void setRevocationTime(LocalDateTime revocationTime) {
		this.revocationTime = revocationTime;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice(){
		return price;
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

	public LocalDate getGretime() {
		return gretime;
	}

	public void setGretime(LocalDate gretime) {
		this.gretime = gretime;
	}

}