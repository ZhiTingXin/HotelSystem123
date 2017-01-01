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
import util.ImageUtil;

//��Ҫ��***********************************
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
	private ImageView hotelPicture;
	@FXML
	private Button picLeftButton;
	@FXML
	private Button picRightButon;

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
	private Room_blService roomService;
	private RoomType roomType;
	private String ImagePath;
	private String[] pathSplit;
	private int picShown;

	public HotelStaffHotelInfoModifyController() {

	}

	public void HotelStaffHotelInfoModifyShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
		this.hotelName.setText(this.hotel.getHotelName());
		this.address.setText(this.hotel.getHotelAddress());
		this.description.setText(this.hotel.getHotelDiscription());

		this.roomTypeButton.setText("˫�˼�");
		this.roomNum.setText(String.valueOf(this.roomInfo.get(0).getRoomNum()));
		this.roomPriceField.setText(String.valueOf(this.roomInfo.get(0).getRoomPrice()));
		// ͼƬ��ʾ����
		this.showPic();

	}

	public void initialize(Main main, HotelStaffVO hotelStaff, HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.hotel = hotel;
		this.hotelStaff = hotelStaff;
		this.service = new Hotel_bl();
		this.roomService = new Room_blServiceImpl();

		this.ImagePath = this.hotel.getImage();
		this.pathSplit = this.ImagePath.split(";");
		this.picShown = 0;

		this.roomInfo = this.roomService.getAllRoom(this.hotel.getHotelID());
		if (roomInfo.size() == 0 || roomInfo == null) {
			this.roomInfo = new ArrayList<HotelRoomInfoVO>();
			this.roomInfo.add(new HotelRoomInfoVO());
			this.roomInfo.add(new HotelRoomInfoVO());
			this.roomInfo.add(new HotelRoomInfoVO());
			this.roomInfo.add(new HotelRoomInfoVO());
			this.roomInfo.get(0).setHotelid(this.hotel.getHotelID());
			this.roomInfo.get(1).setHotelid(this.hotel.getHotelID());
			this.roomInfo.get(2).setHotelid(this.hotel.getHotelID());
			this.roomInfo.get(3).setHotelid(this.hotel.getHotelID());
			this.roomInfo.get(0).setRoomType(RoomType.doublePersonRoom);
			this.roomInfo.get(1).setRoomType(RoomType.bigBedRoom);
			this.roomInfo.get(2).setRoomType(RoomType.singlePersonRoom);
			this.roomInfo.get(3).setRoomType(RoomType.multiPersonRoom);
			this.roomService.addRoom(this.roomInfo.get(0));
			this.roomService.addRoom(this.roomInfo.get(1));
			this.roomService.addRoom(this.roomInfo.get(2));
			this.roomService.addRoom(this.roomInfo.get(3));

		}

		this.roomType = RoomType.doublePersonRoom;

		this.HotelStaffHotelInfoModifyShow();
	}

	@FXML
	private void handleSave() {
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
		this.roomService.modify(roomInfo.get(0));
		this.roomService.modify(roomInfo.get(1));
		this.roomService.modify(roomInfo.get(2));
		this.roomService.modify(roomInfo.get(3));

		this.service.modifyHotelInfo(hotel);
		this.mainScene.showHotelStaffHotelInfoViewScene(hotelStaff, hotel);
	}

	@FXML
	private void handleBack() {
		this.mainScene.showHotelStaffHotelInfoViewScene(hotelStaff, hotel);
	}

	@FXML
	private void handleChangePicture1() {

	}

	@FXML
	private void handleChangePicture2() {

	}

	@FXML
	private void handleMenuDoubleRoom() {
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
		this.roomTypeButton.setText("˫�˼�");
		this.roomNum.setText(String.valueOf(this.roomInfo.get(0).getRoomNum()));
		this.roomPriceField.setText(String.valueOf(this.roomInfo.get(0).getRoomPrice()));

	}

	@FXML
	private void handleMenuSingleRoom() {
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
		this.roomTypeButton.setText("���˼�");
		this.roomNum.setText(String.valueOf(this.roomInfo.get(2).getRoomNum()));
		this.roomPriceField.setText(String.valueOf(this.roomInfo.get(2).getRoomPrice()));
	}

	@FXML
	private void handleMenuBigRoom() {
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
		this.roomTypeButton.setText("�󴲷�");
		this.roomNum.setText(String.valueOf(this.roomInfo.get(1).getRoomNum()));
		this.roomPriceField.setText(String.valueOf(this.roomInfo.get(1).getRoomPrice()));
	}

	@FXML
	private void handleMenuMultiRoom() {
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
		this.roomTypeButton.setText("���˼�");
		this.roomNum.setText(String.valueOf(this.roomInfo.get(3).getRoomNum()));
		this.roomPriceField.setText(String.valueOf(this.roomInfo.get(3).getRoomPrice()));
	}

	@FXML
	private void handlePlus() {
		if (this.roomType.equals(RoomType.doublePersonRoom)) {
			this.roomInfo.get(0).setRoomNum(this.roomInfo.get(0).getRoomNum() + 1);
			this.roomInfo.get(0).setRoomRemain(this.roomInfo.get(0).getRoomRemain() + 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(0).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.singlePersonRoom)) {
			this.roomInfo.get(2).setRoomNum(this.roomInfo.get(2).getRoomNum() + 1);
			this.roomInfo.get(2).setRoomRemain(this.roomInfo.get(2).getRoomRemain() + 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(2).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.bigBedRoom)) {
			this.roomInfo.get(1).setRoomNum(this.roomInfo.get(1).getRoomNum() + 1);
			this.roomInfo.get(1).setRoomRemain(this.roomInfo.get(1).getRoomRemain() + 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(1).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.multiPersonRoom)) {
			this.roomInfo.get(3).setRoomNum(this.roomInfo.get(3).getRoomNum() + 1);
			this.roomInfo.get(3).setRoomRemain(this.roomInfo.get(3).getRoomRemain() + 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(3).getRoomNum()));
		}
	}

	@FXML
	private void handleMinus() {

		if (this.roomType.equals(RoomType.doublePersonRoom)) {
			this.roomInfo.get(0).setRoomNum(this.roomInfo.get(0).getRoomNum() - 1);
			this.roomInfo.get(0).setRoomRemain(this.roomInfo.get(0).getRoomRemain() - 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(0).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.singlePersonRoom)) {
			this.roomInfo.get(2).setRoomNum(this.roomInfo.get(2).getRoomNum() - 1);
			this.roomInfo.get(2).setRoomRemain(this.roomInfo.get(2).getRoomRemain() - 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(2).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.bigBedRoom)) {
			this.roomInfo.get(1).setRoomNum(this.roomInfo.get(1).getRoomNum() - 1);
			this.roomInfo.get(1).setRoomRemain(this.roomInfo.get(1).getRoomRemain() - 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(1).getRoomNum()));
		}
		if (this.roomType.equals(RoomType.multiPersonRoom)) {
			this.roomInfo.get(3).setRoomNum(this.roomInfo.get(3).getRoomNum() - 1);
			this.roomInfo.get(3).setRoomRemain(this.roomInfo.get(3).getRoomRemain() - 1);
			this.roomNum.setText(String.valueOf(this.roomInfo.get(3).getRoomNum()));
		}

	}

	@FXML
	private void handlePicLeft() {
		if (picShown > 0) {
			this.picShown -= 1;
			this.showPic();
		}
	}

	@FXML
	private void handlePicRight() {
		if (picShown < this.pathSplit.length - 1) {
			this.picShown += 1;
			this.showPic();
		}
	}

	private void showPic() {
		// TODO Auto-generated method stub
		this.hotelPicture.setImage(ImageUtil.setImage(this.pathSplit[this.picShown]));
	}

	@FXML
	private void handleChangePicture() {
		this.pathSplit[this.picShown] = ImageUtil.setImagePath(hotelPicture);
		this.ImagePath = "";
		for (String splitpath : pathSplit) {
			ImagePath += splitpath + ";";
		}
		this.hotel.setImage(ImagePath);
	}
}
