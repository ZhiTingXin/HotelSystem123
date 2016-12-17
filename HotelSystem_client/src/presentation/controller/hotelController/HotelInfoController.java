package presentation.controller.hotelController;

import java.util.ArrayList;

import VO.CustomerVO;
import VO.HotelInfoVO;
import VO.HotelRoomInfoVO;
import blservice.HotelStrategy_blservice;
import blservice.Hotel_blservice;
import blservice.Label_blService;
import blservice.Room_blService;
import blservice.impl.HotelStrategy_bl;
import blservice.impl.Hotel_bl;
import blservice.impl.Label_blServiceImpl;
import blservice.impl.Room_blServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import main.Main;

public class HotelInfoController {
	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button reserveRoom;// 预定客房
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
	private TextArea description;
	@FXML
	private Label strategy;
	@FXML
	private Label grade;// 酒店星级
	@FXML
	private Label tag;// 酒店标签
	@FXML
	private TableView<HotelRoomInfoVO> roomInfoTabel;
	@FXML
	private TableColumn<HotelRoomInfoVO, String> roomType;
	@FXML
	private TableColumn<HotelRoomInfoVO, String> roomRemain;
	@FXML
	private TableColumn<HotelRoomInfoVO, String> roomPrice;

	private Main mainScene;
	private CustomerVO customer;
	private HotelInfoVO hotel;
	private ArrayList<HotelRoomInfoVO> hotelRoomInfo;
	private Hotel_blservice service;
	private Room_blService roomService;
	private Label_blService labelService;
	private HotelStrategy_blservice hotelStrategyService;
	private ObservableList<HotelRoomInfoVO> roomData = FXCollections.observableArrayList();

	public HotelInfoController() {
	}

	public void initialize(Main main, CustomerVO customer, HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.service = new Hotel_bl();
		this.roomService = new Room_blServiceImpl();
		this.labelService = new Label_blServiceImpl();
		this.hotelStrategyService = new HotelStrategy_bl();
		this.customer = customer;
		this.hotel = hotel;
		this.hotelRoomInfo = roomService.getAllRoom(this.hotel.getHotelID());
		this.refreshTable();
		this.HotelInfoShow();

	}

	public void HotelInfoShow() {
		this.leftIdLabel.setText(this.customer.getId());
		this.leftNameLabel.setText(this.customer.getUsername());
		this.hotelName.setText(this.hotel.getHotelName());

		this.address.setText(this.hotel.getHotelAddress());
		this.district.setText(this.hotel.getHotelDistrict());
		this.description.setText(this.hotel.getHotelDiscription());
		this.roomInfoTabel.setItems(roomData);

		// 标签方法
		this.strategy.setText(this.getStrategyString());
		this.grade.setText(this.hotel.getRank());
		this.tag.setText(this.getTagString());

		// 图片方法
		// this.hotelPicture2
	}

	public void handleReserveRoom() {
		this.mainScene.showCustomerBookHotelScene(customer, hotel);
	}

	public void handleBack() {
		this.mainScene.showCustomerHotelViewScene(customer);
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

	private void refreshTable() {
		int count = 0;
		while (count < this.hotelRoomInfo.size()) {
			this.roomData.add(this.hotelRoomInfo.get(count));
			count++;
		}
		this.roomType.setCellValueFactory(cellData -> cellData.getValue().getRoomTypeProperty());
		this.roomRemain.setCellValueFactory(cellData -> cellData.getValue().getRoomRemainProperty());
		this.roomPrice.setCellValueFactory(cellData -> cellData.getValue().getRoomPriceProperty());
		this.roomInfoTabel.setItems(roomData);
	}
}
