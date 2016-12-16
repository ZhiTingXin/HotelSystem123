package VO;

import PO.RoomPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;
import other.RoomType;

public class HotelRoomInfoVO {
	private RoomType roomType;
	private int roomNum;
	private int roomRemain;
	private int roomPrice;
	private String id;
	private String hotelid;
	public HotelRoomInfoVO(){
		super();
		this.id = IdGernerateServiceImpl.gernerateId();
	}
	public HotelRoomInfoVO(RoomPO hotelRoomInfo) {
		super();
		this.roomNum = hotelRoomInfo.getNumber();
		this.roomPrice = hotelRoomInfo.getPrice();
		this.roomRemain = hotelRoomInfo.getRemainNum();
		this.roomType = hotelRoomInfo.getType();
		this.id = hotelRoomInfo.getId();
		this.id = hotelRoomInfo.getHotelId();
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

	public int getRoomRemain() {
		return roomRemain;
	}

	public void setRoomRemain(int roomRemain) {
		this.roomRemain = roomRemain;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	public StringProperty getRoomNumProperty() {
		return new SimpleStringProperty(String.valueOf(roomNum));
	}

	public StringProperty getRoomRemainProperty() {
		return new SimpleStringProperty(String.valueOf(roomRemain));
	}

	public StringProperty getRoomPriceProperty() {
		return new SimpleStringProperty(String.valueOf(roomPrice));
	}

	public StringProperty getRoomTypeProperty() {
		if (this.roomType == RoomType.doublePersonRoom) {
			return new SimpleStringProperty("双人间");
		}
		if (this.roomType == RoomType.bigBedRoom) {
			return new SimpleStringProperty("大床房");
		}
		if (this.roomType == RoomType.singlePersonRoom) {
			return new SimpleStringProperty("单人间");
		}
		if (this.roomType == RoomType.multiPersonRoom) {
			return new SimpleStringProperty("多人间");
		} else
			return null;
	}
}