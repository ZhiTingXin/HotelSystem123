package VO;

import java.util.ArrayList;

import PO.HotelPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;

public class HotelInfoVO {
	private String hotelID;
	private String hotelName;
	private String hotelDistrict;
	private String hotelStaffId;
	private String hotelAddress;
	private String hotelDiscription;
	private String rank;
	private ArrayList<HotelRoomInfoVO> rooms;
	private ArrayList<HotelStrategyVO> hotelStrategy;
	private ArrayList<LabelVO> labelList;
	private ArrayList<OrderVO> orderVOs;
	private ArrayList<AssementVO> assmentVOs;

	public HotelInfoVO() {
       super();
       this.hotelID = IdGernerateServiceImpl.gernerateId();
	}

	// 构造方法

	// *********used
	public HotelInfoVO(HotelPO hotelInfo, ArrayList<OrderVO> orderVOs, ArrayList<HotelStrategyVO> hotelStrategyVOs,
			ArrayList<HotelRoomInfoVO> roomInfoVOs, ArrayList<LabelVO> labels,ArrayList<AssementVO> arrayList) {
		super();
		this.orderVOs = orderVOs;
		this.rooms = roomInfoVOs;
		this.hotelAddress = hotelInfo.getHotelAddress();
		this.hotelDiscription = hotelInfo.getHotelDiscription();
		this.hotelDistrict = hotelInfo.getHotelStrict();
		this.hotelID = hotelInfo.getHotelId();
		this.hotelStaffId = hotelInfo.getHotelStaffId();
		this.hotelName = hotelInfo.getHotelName();
		this.hotelStrategy = hotelStrategyVOs;
		this.labelList = labels;
		this.assmentVOs = arrayList;
	    this.rank = hotelInfo.getGrade();
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
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

	public ArrayList<HotelRoomInfoVO> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<HotelRoomInfoVO> rooms) {
		this.rooms = rooms;
	}

	public ArrayList<HotelStrategyVO> getHotelStrategy() {
		return hotelStrategy;
	}

	public void setHotelStrategy(ArrayList<HotelStrategyVO> hotelStrategy) {
		this.hotelStrategy = hotelStrategy;
	}

	public ArrayList<LabelVO> getLabelList() {
		return labelList;
	}

	public void setLabelList(ArrayList<LabelVO> labelList) {
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

	// 调用界面方法
	public HotelRoomInfoVO[] getHotelRoomInfo() {
		HotelRoomInfoVO[] list = new HotelRoomInfoVO[4];
		list[0] = new HotelRoomInfoVO();
		list[1] = new HotelRoomInfoVO();
		list[2] = new HotelRoomInfoVO();
		list[3] = new HotelRoomInfoVO();
		int count=0;
		while(count<this.rooms.size()){
			list[count]=rooms.get(count);
			count++;
		}
		return list;
	}

	public ArrayList<AssementVO> getAssmentVOs() {
		return assmentVOs;
	}

	public void setAssmentVOs(ArrayList<AssementVO> assmentVOs) {
		this.assmentVOs = assmentVOs;
	}
}
