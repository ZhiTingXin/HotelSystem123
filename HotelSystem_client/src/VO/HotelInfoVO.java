package VO;

import java.util.ArrayList;

import PO.HotelPO;
import PO.HotelStrategyPO;
import PO.Label;
import PO.Rank;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.RoomType;

public class HotelInfoVO {
	String hotelID;
	String hotelName;
	String hotelDistrict;
	String hotelStaffId;
	String hotelAddress;
	String hotelDiscription;

	HotelRoomInfoVO[] roomInfo;
	ArrayList<HotelStrategyPO> hotelStrategy;
	ArrayList<String> assessmentList;
	ArrayList<Rank> rankList;
	ArrayList<Label> labelList;
	String[] orderListId;

	public HotelInfoVO() {
		super();
		this.hotelID = "500001";
		this.hotelName = "Nanjing Hotel";
		this.hotelDistrict = "新街口商圈";
		this.hotelStaffId = "200001";
		this.hotelAddress = "上海路63号";
		this.hotelDiscription = "  欢迎光临金陵饭店！我们将竭诚为您服务！";
		this.roomInfo = new HotelRoomInfoVO[4];
		roomInfo[0] = new HotelRoomInfoVO(RoomType.doublePersonRoom, 20, 15, 198);
		roomInfo[1] = new HotelRoomInfoVO(RoomType.bigBedRoom, 25, 12, 198);
		roomInfo[2] = new HotelRoomInfoVO(RoomType.singlePersonRoom, 45, 8, 120);
		roomInfo[3] = new HotelRoomInfoVO(RoomType.multiPersonRoom, 64, 33, 75);

	}

//	public HotelInfoVO(String hotelID) {
//		super();
//		if (hotelID == "500001") {
//			this.hotelID = "500001";
//			this.hotelName = "Nanjing Hotel";
//			this.hotelDistrict = "新街口商圈";
//			this.hotelStaffId = "200001";
//			this.hotelAddress = "上海路63号";
//			this.hotelDiscription = "  欢迎光临金陵饭店！我们将竭诚为您服务！";
//			this.roomInfo = new HotelRoomInfoVO[4];
//			roomInfo[0] = new HotelRoomInfoVO(RoomType.doublePersonRoom, 20, 15, 198);
//			roomInfo[1] = new HotelRoomInfoVO(RoomType.bigBedRoom, 25, 12, 198);
//			roomInfo[2] = new HotelRoomInfoVO(RoomType.singlePersonRoom, 45, 8, 120);
//			roomInfo[3] = new HotelRoomInfoVO(RoomType.multiPersonRoom, 64, 33, 75);
//		}
//		if (hotelID == "500002") {
//			this.hotelID = "500002";
//			this.hotelName = "Hamoney Hotel";
//			this.hotelDistrict = "新街口商圈";
//			this.hotelStaffId = "200002";
//			this.hotelAddress = "汉口路199号";
//			this.hotelDiscription = "welcome！";
//			this.roomInfo = new HotelRoomInfoVO[4];
//			roomInfo[0] = new HotelRoomInfoVO(RoomType.doublePersonRoom, 20, 15, 198);
//			roomInfo[1] = new HotelRoomInfoVO(RoomType.bigBedRoom, 25, 12, 198);
//			roomInfo[2] = new HotelRoomInfoVO(RoomType.singlePersonRoom, 45, 8, 120);
//			roomInfo[3] = new HotelRoomInfoVO(RoomType.multiPersonRoom, 64, 33, 75);
//		}
//		if (hotelID == "500003") {
//			this.hotelID = "500003";
//			this.hotelName = "NEW YOUNG HOTEL";
//			this.hotelDistrict = "新街口商圈";
//			this.hotelStaffId = "200003";
//			this.hotelAddress = "北京东路111号";
//			this.hotelDiscription = "豪华套房只为年轻的你服务！";
//			this.roomInfo = new HotelRoomInfoVO[4];
//			roomInfo[0] = new HotelRoomInfoVO(RoomType.doublePersonRoom, 20, 15, 198);
//			roomInfo[1] = new HotelRoomInfoVO(RoomType.bigBedRoom, 25, 12, 198);
//			roomInfo[2] = new HotelRoomInfoVO(RoomType.singlePersonRoom, 45, 8, 120);
//			roomInfo[3] = new HotelRoomInfoVO(RoomType.multiPersonRoom, 64, 33, 75);
//		}
//		if (hotelID == "500004") {
//			this.hotelID = "500004";
//			this.hotelName = "8090Hotel";
//			this.hotelDistrict = "新街口商圈";
//			this.hotelStaffId = "200004";
//			this.hotelAddress = "珠江路73号";
//			this.hotelDiscription = "约不约？！";
//			this.roomInfo = new HotelRoomInfoVO[4];
//			roomInfo[0] = new HotelRoomInfoVO(RoomType.doublePersonRoom, 20, 15, 198);
//			roomInfo[1] = new HotelRoomInfoVO(RoomType.bigBedRoom, 25, 12, 198);
//			roomInfo[2] = new HotelRoomInfoVO(RoomType.singlePersonRoom, 45, 8, 120);
//			roomInfo[3] = new HotelRoomInfoVO(RoomType.multiPersonRoom, 64, 33, 75);
//		}
//	}

	public HotelInfoVO(String ID, String Name, String Address, String Discription) {
		this.hotelName = Name;
		this.hotelID = ID;
		this.hotelAddress = Address;
		this.hotelDiscription = Discription;
	}

	// 构造方法
	
	//*********used
	public HotelInfoVO(HotelPO hotelInfo) {
		// TODO Auto-generated constructor stub
	}

	public String[] getOrderListId() {
		return orderListId;
	}

	public void setOrderListId(String[] orderListId) {
		this.orderListId = orderListId;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelDistrict() {
		return hotelDistrict;
	}

	public void setHotelDistrict(String hotelDistrict) {
		this.hotelDistrict = hotelDistrict;
	}

	public String getHotelStaffId() {
		return hotelStaffId;
	}

	public void setHotelStaffId(String hotelStaffId) {
		this.hotelStaffId = hotelStaffId;
	}

	public HotelRoomInfoVO[] getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(HotelRoomInfoVO[] roomInfo) {
		this.roomInfo = roomInfo;
	}

	public ArrayList<HotelStrategyPO> getHotelStrategy() {
		return hotelStrategy;
	}

	public void setHotelStrategy(ArrayList<HotelStrategyPO> hotelStrategy) {
		this.hotelStrategy = hotelStrategy;
	}

	public ArrayList<String> getAssessmentList() {
		return assessmentList;
	}

	public void setAssessmentList(ArrayList<String> assessmentList) {
		this.assessmentList = assessmentList;
	}

	public ArrayList<Rank> getRankList() {
		return rankList;
	}

	public void setRankList(ArrayList<Rank> rankList) {
		this.rankList = rankList;
	}

	public ArrayList<Label> getLabelList() {
		return labelList;
	}

	public void setLabelList(ArrayList<Label> labelList) {
		this.labelList = labelList;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelDiscription() {
		return hotelDiscription;
	}

	public void setHotelDiscription(String hotelDiscription) {
		this.hotelDiscription = hotelDiscription;
	}

	// 界面表格方法
	public StringProperty getHotelNameProperty() {
		return new SimpleStringProperty(this.hotelName);
	}

	public StringProperty getHotelAddressProperty() {
		return new SimpleStringProperty(this.hotelAddress);
	}

	public StringProperty getHotelDiscriptionProperty() {
		return new SimpleStringProperty(this.hotelDiscription);
	}
}
