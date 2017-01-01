package main;

import java.util.ArrayList;

import VO.HotelStaffVO;
import VO.OrderVO;
import blservice.Hotel_blservice;
import blservice.Order_blservice;
import blservice.impl.Hotel_bl;
import blservice.impl.Order_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import util.ImageUtil;

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
	@FXML
	private TableColumn<OrderVO, String> orderState;// 订单状态

	private Main mainScene;
	private HotelStaffVO hotelStaff;
	private ArrayList<OrderVO> orderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();

	private Order_blservice orderService;
	private Hotel_blservice hotelService;

	public HotelStaffMainController() {
	}

	public void initialize(Main main, HotelStaffVO hotelStaff) {
		this.mainScene = main;
		this.hotelStaff = hotelStaff;
		this.orderService = new Order_bl();
		this.hotelService = new Hotel_bl();
		this.orderList = this.orderService.getOrderOfToday(this.hotelStaff.getHotelId());

		if (this.orderList != null) {
			int count = 0;

			while (count < this.orderList.size()) {
				this.orderData.add(this.orderList.get(count));
				count++;
			}
			this.customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIDProperty());
			this.roomInfo.setCellValueFactory(cellData -> cellData.getValue().getRoomInfoProperty());
			this.arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
			this.orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());
			this.orderState.setCellValueFactory(cellData -> cellData.getValue().getOrderStateProperty());
		}
		this.HotelStaffMainShow();
	}

	public void HotelStaffMainShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.myPicture.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.hotelName.setText(this.hotelStaff.getHotelName());
		this.orderTable.setItems(orderData);
	}

	@FXML
	private void handleViewOrder() {
		this.mainScene.showHotelStaffOrderViewScene(hotelStaff);
	}

	@FXML
	private void handleMaintainHotelInfo() {
		this.mainScene.showHotelStaffHotelInfoViewScene(hotelStaff,
				this.hotelService.getHotelInfo(this.hotelStaff.getHotelId()));
	}

	@FXML
	private void handleMakeStrategy() {
		this.mainScene.showHotelStrategyViewScene(hotelStaff,
				this.hotelService.getHotelInfo(this.hotelStaff.getHotelId()));
	}

	@FXML
	private void handleMaintainPersonalInfo() {
		this.mainScene.showHotelStaffInfoScene(hotelStaff);
	}

	@FXML
	private void handleExit() {
		this.mainScene.showLoginScene();
	}
}
