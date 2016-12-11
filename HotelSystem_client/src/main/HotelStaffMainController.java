package main;

import java.util.ArrayList;

import VO.HotelStaffVO;
import VO.OrderVO;
import blservice.Hotel_blservice;
import blservice.Order_blservice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class HotelStaffMainController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button viewOrder;
	@FXML
	private Button maintainHotelInfo;
	@FXML
	private Button makeStrategy;
	@FXML
	private Button maintainPersonalInfo;// 维护个人信息
	@FXML
	private Button exit;
	@FXML
	private Label hotelName;
	@FXML
	private TableView<OrderVO> orderTable;
	@FXML
	private TableColumn<OrderVO, String> customerId;
	@FXML
	private TableColumn<OrderVO, String> roomInfo;// 房间数量和类型
	@FXML
	private TableColumn<OrderVO, String> arriveTime;// 简介
	@FXML
	private TableColumn<OrderVO, String> orderDuration;// 订单时长

	private Main mainScene;
	private HotelStaffVO hotelStaff;
	private ArrayList<OrderVO> orderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();

	private Order_blservice orderService;
	private Hotel_blservice hotelService;

	public HotelStaffMainController() {
	}

	public void initialize(Main main, HotelStaffVO hotelStaff) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.hotelStaff = hotelStaff;
		this.orderList = this.orderService.getOrderOfToday(this.hotelStaff.getHotelId());
		int count = 0;

		while (count < this.orderList.size()) {
			this.orderData.add(this.orderList.get(count));
			count++;
		}
		this.customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIDProperty());
		this.roomInfo.setCellValueFactory(cellData -> cellData.getValue().getRoomInfoProperty());
		this.arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
		this.orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());

		this.HotelStaffMainShow();
	}

	public void HotelStaffMainShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.hotelName.setText(this.hotelStaff.getHotelName());
		// this.orderTable.setItems(orderData);
	}

	public void handleViewOrder() {
		this.mainScene.showHotelStaffOrderViewScene(hotelStaff);
	}

	public void handleMaintainHotelInfo() {
		this.mainScene.showHotelStaffHotelInfoViewScene(hotelStaff,
				this.hotelService.getHotelInfo(this.hotelStaff.getHotelId()));
	}

	public void handleMakeStrategy() {
		this.mainScene.showHotelStrategyViewScene(hotelStaff,
				this.hotelService.getHotelInfo(this.hotelStaff.getHotelId()));
	}

	public void handleMaintainPersonalInfo() {
		this.mainScene.showHotelStaffInfoScene(hotelStaff);
	}

	public void handleExit() {
		this.mainScene.showLoginScene();
	}
}
