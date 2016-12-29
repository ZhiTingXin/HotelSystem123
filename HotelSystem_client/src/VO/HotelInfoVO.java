package VO;

import java.util.ArrayList;

import PO.HotelPO;
import blservice.Hotel_blservice;
import blservice.Room_blService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;

public class HotelInfoVO {
	private String hotelID;
	private String hotelName;
	private String hotelDistrict;
	private String city;
	private String hotelStaffId;
	private String hotelAddress;
	private String hotelDiscription;
	private String rank;
	private String image;

	public HotelInfoVO() {
		super();
		this.hotelID = IdGernerateServiceImpl.gernerateId();
	}

	// ���췽��

	// *********used
	public HotelInfoVO(HotelPO hotelInfo) {
		super();
		this.city = hotelInfo.getCity();
		this.hotelAddress = hotelInfo.getHotelAddress();
		this.hotelDiscription = hotelInfo.getHotelDiscription();
		this.hotelDistrict = hotelInfo.getHotelStrict();
		this.hotelID = hotelInfo.getHotelId();
		this.hotelStaffId = hotelInfo.getHotelStaffId();
		this.hotelName = hotelInfo.getHotelName();
		this.rank = hotelInfo.getGrade();
		this.image = hotelInfo.getImage();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// �����񷽷�
	public StringProperty getHotelNameProperty() {
		return new SimpleStringProperty(this.hotelName);
	}

	public StringProperty getHotelAddressProperty() {
		return new SimpleStringProperty(this.hotelAddress);
	}

	public StringProperty getHotelDiscriptionProperty() {
		return new SimpleStringProperty(this.hotelDiscription);
	}

	public StringProperty getHotelRankProperty(Hotel_blservice service) {
		// TODO Auto-generated method stub
		return new SimpleStringProperty(String.valueOf(service.getHotelGrade(hotelID)));
	}

	public StringProperty getHotelPriceProperty(Room_blService service) {
		// TODO Auto-generated method stub
		ArrayList<HotelRoomInfoVO> roomInfo = service.getAllRoom(this.getHotelID());
		int count = 0;
		int min = roomInfo.get(0).getRoomPrice();
		int max = roomInfo.get(0).getRoomPrice();
		while (count < roomInfo.size()) {
			int price = roomInfo.get(count).getRoomPrice();
			if (price < min) {
				min = price;
			}
			if (price > max) {
				max = price;
			}
			count++;
		}
		return new SimpleStringProperty(String.valueOf(min) + "~" + String.valueOf(max));
	}

}
