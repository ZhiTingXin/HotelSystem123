package presentation.controller.hotelController;

import java.util.ArrayList;

import VO.HotelInfoVO;
import VO.HotelRoomInfoVO;
import VO.HotelStaffVO;
import blservice.Hotel_blservice;
import blservice.Room_blService;
import blservice.impl.Hotel_bl;
import blservice.impl.Room_blServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import other.RoomType;

//需要改***********************************
//

public class HotelStaffHotelInfoModifyController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button save;
	@FXML
	private Button back;
	@FXML
	private ImageView hotelPicture1;
	@FXML
	private ImageView hotelPicture2;
	@FXML
	private Button changePicture1;
	@FXML
	private Button changePicture2;
	@FXML
	private TextField hotelName;
	@FXML
	private TextField address;
	// @FXML
	// private Label district;
	@FXML
	private TextArea description;
	@FXML
	private MenuButton roomTypeButton;
	@FXML
	private MenuItem doubleRoomButton;
	@FXML
	private MenuItem singleRoomButton;
	@FXML
	private MenuItem bigRoomButton;
	@FXML
	private MenuItem multiRoomButton;
	@FXML
	private Label roomNum;
	@FXML
	private TextField roomPriceField;

	@FXML
	private Button plus;
	@FXML
	private Button minus;

	private Main mainScene;
	private HotelStaffVO hotelStaff;
	private HotelInfoVO hotel;
	private ArrayList<HotelRoomInfoVO> roomInfo;
	private Hotel_blservice service;
	private Room_blService roomServcie;
	private RoomType roomType;

	public HotelStaffHotelInfoModifyController() {

	}

	public void HotelStaffHotelInfoModifyShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.hotelName.setText(this.hotel.getHotelName());
		this.address.setText(this.hotel.getHotelAddress());
		this.description.setText(this.hotel.getHotelDiscription());

		this.roomTypeButton.setText("双人间");
		this.roomNum.setText(String.valueOf(this.roomInfo.get(0).getRoomNum()));
		this.roomPriceField.setText(String.valueOf(this.roomInfo.get(0).getRoomPrice()));

	}

	public void initialize(Main main, HotelStaffVO hotelStaff, HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.hotel = hotel;
		this.hotelStaff = hotelStaff;
		this.service = new Hotel_bl();
		this.roomServcie = new Room_blServiceImpl();

		this.roomInfo = this.roomServcie.getAllRoom(this.hotel.getHotelID());

		this.roomType = RoomType.doublePersonRoom;

		this.HotelStaffHotelInfoModifyShow();
	}

	public void handleSave() {
		if (this.roomType.equals(RoomType.doublePersonRoom)) {

			this.roomInfo.get(0).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));

		}
		if (this.roomType.equals(RoomType.singlePersonRoom)) {
			this.roomInfo.get(2).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		if (this.roomType.equals(RoomType.bigBedRoom)) {
			this.roomInfo.get(1).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		if (this.roomType.equals(RoomType.multiPersonRoom)) {
			this.roomInfo.get(3).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		this.hotel.setHotelName(this.hotelName.getText());
		this.hotel.setHotelAddress(this.address.getText());
		this.hotel.setHotelDiscription(this.description.getText());

		this.service.modifyHotelInfo(hotel);
		this.mainScene.showHotelStaffHotelInfoViewScene(hotelStaff, hotel);
	}

	public void handleBack() {
		this.mainScene.showHotelStaffHotelInfoViewScene(hotelStaff, hotel);
	}

	public void handleChangePicture1() {

	}

	public void handleChangePicture2() {

	}

	public void handleMenuDoubleRoom() {
		if (this.roomType.equals(RoomType.doublePersonRoom)) {
			this.roomInfo.get(0).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));

		}
		if (this.roomType.equals(RoomType.singlePersonRoom)) {
			this.roomInfo.get(2).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		if (this.roomType.equals(RoomType.bigBedRoom)) {
			this.roomInfo.get(1).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		if (this.roomType.equals(RoomType.multiPersonRoom)) {
			this.roomInfo.get(3).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		this.roomType = RoomType.doublePersonRoom;
		this.roomTypeButton.setText("双人间");
		this.roomNum.setText(String.valueOf(this.roomInfo.get(0).getRoomNum()));
		this.roomPriceField.setText(String.valueOf(this.roomInfo.get(0).getRoomPrice()));

	}

	public void handleMenuSingleRoom() {
		if (this.roomType.equals(RoomType.doublePersonRoom)) {
			this.roomInfo.get(0).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));

		}
		if (this.roomType.equals(RoomType.singlePersonRoom)) {
			this.roomInfo.get(2).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		if (this.roomType.equals(RoomType.bigBedRoom)) {
			this.roomInfo.get(1).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		if (this.roomType.equals(RoomType.multiPersonRoom)) {
			this.roomInfo.get(3).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		this.roomType = RoomType.singlePersonRoom;
		this.roomTypeButton.setText("单人间");
		this.roomNum.setText(String.valueOf(this.roomInfo.get(2).getRoomNum()));
		this.roomPriceField.setText(String.valueOf(this.roomInfo.get(2).getRoomPrice()));
	}

	public void handleMenuBigRoom() {
		if (this.roomType.equals(RoomType.doublePersonRoom)) {
			this.roomInfo.get(0).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));

		}
		if (this.roomType.equals(RoomType.singlePersonRoom)) {
			this.roomInfo.get(2).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		if (this.roomType.equals(RoomType.bigBedRoom)) {
			this.roomInfo.get(1).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		if (this.roomType.equals(RoomType.multiPersonRoom)) {
			this.roomInfo.get(3).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		this.roomType = RoomType.bigBedRoom;
		this.roomTypeButton.setText("大床房");
		this.roomNum.setText(String.valueOf(this.roomInfo.get(1).getRoomNum()));
		this.roomPriceField.setText(String.valueOf(this.roomInfo.get(1).getRoomPrice()));
	}

	public void handleMenuMultiRoom() {
		if (this.roomType.equals(RoomType.doublePersonRoom)) {
			this.roomInfo.get(0).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));

		}
		if (this.roomType.equals(RoomType.singlePersonRoom)) {
			this.roomInfo.get(2).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		if (this.roomType.equals(RoomType.bigBedRoom)) {
			this.roomInfo.get(1).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		if (this.roomType.equals(RoomType.multiPersonRoom)) {
			this.roomInfo.get(3).setRoomPrice(Integer.parseInt(this.roomPriceField.getText()));
		}
		this.roomType = RoomType.multiPersonRoom;
		this.roomTypeButton.setText("多人间");
		this.roomNum.setText(String.valueOf(this.roomInfo.get(3).getRoomNum()));
		this.roomPriceField.setText(String.valueOf(this.roomInfo.get(3).getRoomPrice()));
	}

	public void handlePlus() {
		if (this.roomType.equals(RoomType.doublePersonRoom)) {
			this.roomInfo.get(0).setRoomNum(this.roomInfo.get(0).getRoomNum() + 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(0).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.singlePersonRoom)) {
			this.roomInfo.get(2).setRoomNum(this.roomInfo.get(2).getRoomNum() + 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(2).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.bigBedRoom)) {
			this.roomInfo.get(1).setRoomNum(this.roomInfo.get(1).getRoomNum() + 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(1).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.multiPersonRoom)) {
			this.roomInfo.get(3).setRoomNum(this.roomInfo.get(3).getRoomNum() + 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(3).getRoomNum()));
		}
	}

	public void handleMinus() {

		if (this.roomType.equals(RoomType.doublePersonRoom)) {
			this.roomInfo.get(0).setRoomNum(this.roomInfo.get(0).getRoomNum() - 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(0).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.singlePersonRoom)) {
			this.roomInfo.get(2).setRoomNum(this.roomInfo.get(2).getRoomNum() - 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(2).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.bigBedRoom)) {
			this.roomInfo.get(1).setRoomNum(this.roomInfo.get(1).getRoomNum() - 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(1).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.multiPersonRoom)) {
			this.roomInfo.get(3).setRoomNum(this.roomInfo.get(3).getRoomNum() - 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(3).getRoomNum()));
		}

	}

}
