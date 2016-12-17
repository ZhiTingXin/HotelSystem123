package presentation.controller.hotelController;

import VO.HotelInfoVO;
import VO.HotelStaffVO;
import blservice.HotelStrategy_blservice;
import blservice.Hotel_blservice;
import blservice.Label_blService;
import blservice.Room_blService;
import blservice.impl.HotelStrategy_bl;
import blservice.impl.Label_blServiceImpl;
import blservice.impl.Room_blServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;

//scene界面需要改 没连scene
//***************************
public class HotelStaffHotelInfoViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button modifyHotelInfo;// 修改酒店信息
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
	private Label grade;// 酒店星级
	@FXML
	private Label tag;// 酒店标签
	@FXML
	private Label restRoomNumber;// 剩余客房数量
	@FXML
	private Label price;

	private Main mainScene;
	private HotelInfoVO hotel;
	private HotelStaffVO hotelStaff;
	private Hotel_blservice hotelService;
	private Room_blService roomService;
	private Label_blService labelService;
	private HotelStrategy_blservice hotelStrategyService;

	public HotelStaffHotelInfoViewController() {
	}

	public void HotelStaffHotelInfoViewShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.hotelName.setText(this.hotel.getHotelName());
		this.address.setText(this.hotel.getHotelAddress());
		this.district.setText(this.hotel.getHotelDistrict());
		this.description.setText(this.hotel.getHotelDiscription());

		// 标签方法
		this.tag.setText(getTagString());
		this.strategy.setText(getStrategyString());
		this.grade.setText(this.hotel.getRank());
		// 房间价格方法
		this.price.setText(this.getRoomPrice());

	}

	public void initialize(Main main, HotelStaffVO hotelStaff, HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.hotel = hotel;
		this.hotelStaff = hotelStaff;
		this.roomService = new Room_blServiceImpl();
		this.labelService = new Label_blServiceImpl();
		this.hotelStrategyService = new HotelStrategy_bl();
		this.HotelStaffHotelInfoViewShow();
	}

	public void handleBack() {
		this.mainScene.showHotelStaffMainScene(hotelStaff);
	}

	public void handleModify() {
		this.mainScene.showHotelStaffHotelInfoModifyScene(hotelStaff, hotel);
	}

	// 酒店促销策略显示方法
	private String getStrategyString() {
		String strategyInfo = "";
		int count = 0;
		while (count < this.hotelStrategyService.getListOfHotelStrategys(this.hotel.getHotelID()).size()) {
			strategyInfo += this.hotelStrategyService.getListOfHotelStrategys(this.hotel.getHotelID()).get(count)
					.getStrategyInfo();
			count++;
		}
		return strategyInfo;
	}

	// 酒店标签显示方法
	private String getTagString() {
		String tagInfo = "";
		int count = 0;
		while (count < this.labelService.getHotelLabels(this.hotel.getHotelID()).size()) {
			tagInfo += this.labelService.getHotelLabels(this.hotel.getHotelID()).get(count).getLabel().toString();
			count++;
		}
		return tagInfo;
	}

	// 房间价格显示方法
	private String getRoomPrice() {
		String doubleRoomInfo = "双人间："
				+ String.valueOf(this.roomService.getAllRoom(this.hotel.getHotelID()).get(0).getRoomPrice());
		String bigRoomInfo = "大床房："
				+ String.valueOf(this.roomService.getAllRoom(this.hotel.getHotelID()).get(1).getRoomPrice());
		String singleRoomInfo = "单人间："
				+ String.valueOf(this.roomService.getAllRoom(this.hotel.getHotelID()).get(2).getRoomPrice());
		String multiRoomInfo = "多人间："
				+ String.valueOf(this.roomService.getAllRoom(this.hotel.getHotelID()).get(3).getRoomPrice());
		return doubleRoomInfo + ";" + bigRoomInfo + ";" + singleRoomInfo + ";" + multiRoomInfo;
	}
}
