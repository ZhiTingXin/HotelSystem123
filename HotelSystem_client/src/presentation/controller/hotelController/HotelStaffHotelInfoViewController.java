package presentation.controller.hotelController;

import java.util.ArrayList;

import VO.HotelInfoVO;
import VO.HotelRoomInfoVO;
import VO.HotelStaffVO;
import blservice.HotelStrategy_blservice;
import blservice.Hotel_blservice;
import blservice.Label_blService;
import blservice.Room_blService;
import blservice.impl.HotelStrategy_bl;
import blservice.impl.Room_blServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import other.RoomType;

//scene������Ҫ�� û��scene
//***************************
public class HotelStaffHotelInfoViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button modifyHotelInfo;// �޸ľƵ���Ϣ
	@FXML
	private Button back;
	@FXML
	private ImageView hotelPicture1;
	@FXML
	private ImageView hotelPicture2;
	@FXML
	private Label hotelName;
	@FXML
	private Label address;
	@FXML
	private Label district;
	@FXML
	private Label description;
	@FXML
	private Label strategy;
	@FXML
	private Label grade;// �Ƶ��Ǽ�
	@FXML
	private Label RoomNumber;
	// @FXML
	// private Label tag;// �Ƶ��ǩ
	@FXML
	private Label restRoomNumber;// ʣ��ͷ�����
	@FXML
	private Label price;

	private Main mainScene;
	private HotelInfoVO hotel;
	private HotelStaffVO hotelStaff;
	private Hotel_blservice hotelService;
	private Room_blService roomService;
	private Label_blService labelService;
	private HotelStrategy_blservice hotelStrategyService;
	private ArrayList<HotelRoomInfoVO> roomInfo;

	public HotelStaffHotelInfoViewController() {
	}

	public void HotelStaffHotelInfoViewShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.hotelName.setText(this.hotel.getHotelName());

		if (this.hotel.getHotelAddress() != null || this.hotel.getHotelAddress().equals("")) {
			this.address.setText(this.hotel.getHotelAddress());
		} else {
			this.address.setText("��ȱ");
		}
		if (this.hotel.getHotelDistrict() != null || this.hotel.getHotelDistrict().equals("")) {
			this.district.setText(this.hotel.getHotelDistrict());
		} else {
			this.district.setText("��ȱ");
		}
		if (this.hotel.getHotelDiscription() != null || this.hotel.getHotelDiscription().equals("")) {
			this.description.setText(this.hotel.getHotelDiscription());
		} else {
			this.description.setText("��ȱ");
		}

		// ��ǩ����
		// this.tag.setText(getTagString());
		this.strategy.setText(getStrategyString());
		this.grade.setText(this.hotel.getRank());
		// ����۸񷽷�
		this.price.setText(this.getRoomPrice());
		this.restRoomNumber.setText(this.getRoomRemain());
		this.RoomNumber.setText(this.getRoomNumber());

	}

	public void initialize(Main main, HotelStaffVO hotelStaff, HotelInfoVO hotel) {
		
		this.mainScene = main;
		this.hotel = hotel;
		this.hotelStaff = hotelStaff;
		this.roomService = new Room_blServiceImpl();
		// this.labelService = new Label_blServiceImpl();
		this.hotelStrategyService = new HotelStrategy_bl();
		this.roomInfo = roomService.getAllRoom(this.hotel.getHotelID());
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

		this.HotelStaffHotelInfoViewShow();
	}

	public void handleBack() {
		this.mainScene.showHotelStaffMainScene(hotelStaff);
	}

	public void handleModify() {
		this.mainScene.showHotelStaffHotelInfoModifyScene(hotelStaff, hotel);
	}

	// �Ƶ����������ʾ����
	private String getStrategyString() {
		String strategyInfo = "";
		int count = 0;
		if (this.hotelStrategyService.getListOfHotelStrategys(this.hotel.getHotelID()).size() > 0) {
			while (count < this.hotelStrategyService.getListOfHotelStrategys(this.hotel.getHotelID()).size()) {
				strategyInfo += this.hotelStrategyService.getListOfHotelStrategys(this.hotel.getHotelID()).get(count)
						.getStrategyInfo();
				count++;
			}
			return strategyInfo;
		}
		return "���޲���";
	}

	// // �Ƶ��ǩ��ʾ����
	// private String getTagString() {
	// String tagInfo = "";
	// int count = 0;
	// while (count <
	// this.labelService.getHotelLabels(this.hotel.getHotelID()).size()) {
	// tagInfo +=
	// this.labelService.getHotelLabels(this.hotel.getHotelID()).get(count).getLabel().toString();
	// count++;
	// }
	// return tagInfo;
	// }

	// ����������ʾ����
	private String getRoomNumber() {
		String doubleRoomInfo = "˫�˼䣺" + String.valueOf(this.roomInfo.get(0).getRoomNum());
		String bigRoomInfo = "�󴲷���" + String.valueOf(this.roomInfo.get(1).getRoomNum());
		String singleRoomInfo = "���˼䣺" + String.valueOf(this.roomInfo.get(2).getRoomNum());
		String multiRoomInfo = "���˼䣺" + String.valueOf(this.roomInfo.get(3).getRoomNum());
		return doubleRoomInfo + ";" + bigRoomInfo + ";" + singleRoomInfo + ";" + multiRoomInfo;
	}

	// ����۸���ʾ����
	private String getRoomPrice() {
		String doubleRoomInfo = "˫�˼䣺" + String.valueOf(this.roomInfo.get(0).getRoomPrice());
		String bigRoomInfo = "�󴲷���" + String.valueOf(this.roomInfo.get(1).getRoomPrice());
		String singleRoomInfo = "���˼䣺" + String.valueOf(this.roomInfo.get(2).getRoomPrice());
		String multiRoomInfo = "���˼䣺" + String.valueOf(this.roomInfo.get(3).getRoomPrice());
		return doubleRoomInfo + ";" + bigRoomInfo + ";" + singleRoomInfo + ";" + multiRoomInfo;
	}

	private String getRoomRemain() {
		String doubleRoomInfo = "˫�˼䣺" + String.valueOf(this.roomInfo.get(0).getRoomRemain());
		String bigRoomInfo = "�󴲷���" + String.valueOf(this.roomInfo.get(1).getRoomRemain());
		String singleRoomInfo = "���˼䣺" + String.valueOf(this.roomInfo.get(2).getRoomRemain());
		String multiRoomInfo = "���˼䣺" + String.valueOf(this.roomInfo.get(3).getRoomRemain());
		return doubleRoomInfo + ";" + bigRoomInfo + ";" + singleRoomInfo + ";" + multiRoomInfo;
	}
}
