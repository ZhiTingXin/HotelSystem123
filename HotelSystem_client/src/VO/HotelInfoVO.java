package VO;

import java.util.ArrayList;

import PO.HotelPO;
import PO.HotelStrategyPO;
import PO.Label;
import PO.Rank;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HotelInfoVO {
	String hotelID;
	String hotelName;
	String hotelDistrict;
	String hotelStaffId;
	String hotelAddress;
	String hotelDiscription;

//	ArrayList<HotelRoomInfoVO> rooms;
	ArrayList<HotelStrategyPO> hotelStrategy;
	ArrayList<Rank> rankList;
	ArrayList<Label> labelList;
	ArrayList<OrderVO> orderVOs;
    HotelRoomInfoVO[] hotelRoomInfo;

	public HotelRoomInfoVO[] getHotelRoomInfo() {
		return hotelRoomInfo;
	}

	public void setHotelRoomInfo(HotelRoomInfoVO[] hotelRoomInfo) {
		this.hotelRoomInfo = hotelRoomInfo;
	}

	public HotelInfoVO() {

	}

	public HotelInfoVO(String ID, String Name, String Address, String Discription) {
		this.hotelName = Name;
		this.hotelID = ID;
		this.hotelAddress = Address;
		this.hotelDiscription = Discription;
	}

	public HotelInfoVO(String name,String district){
		this.hotelName = name;
		this.hotelDistrict = district;
	}
	// 构造方法
	
	//*********used
	public HotelInfoVO(HotelPO hotelInfo) {
		// TODO Auto-generated constructor stub
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

//	public ArrayList<HotelRoomInfoVO> getRooms() {
//		return rooms;
//	}
//
//	public void setRooms(ArrayList<HotelRoomInfoVO> rooms) {
//		this.rooms = rooms;
//	}

	public ArrayList<HotelStrategyPO> getHotelStrategy() {
		return hotelStrategy;
	}

	public void setHotelStrategy(ArrayList<HotelStrategyPO> hotelStrategy) {
		this.hotelStrategy = hotelStrategy;
	}

	public ArrayList<Label> getLabelList() {
		return labelList;
	}

	public void setLabelList(ArrayList<Label> labelList) {
		this.labelList = labelList;
	}

	public ArrayList<OrderVO> getOrderVOs() {
		return orderVOs;
	}

	public void setOrderVOs(ArrayList<OrderVO> orderVOs) {
		this.orderVOs = orderVOs;
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
