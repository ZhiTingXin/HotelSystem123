package VO;

import PO.HotelRoomInfoPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.RoomType;

public class HotelRoomInfoVO {

	public HotelRoomInfoVO(HotelRoomInfoPO hotelRoomInfo) {
		// TODO Auto-generated constructor stub
	}

	public HotelRoomInfoVO(RoomType roomType, int roomNum, int roomRemain, int roomPrice) {
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.roomPrice = roomPrice;
		this.roomRemain = roomRemain;
	}

	RoomType roomType;
	int roomNum;
	int roomRemain;
	int roomPrice;

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