package main;

import java.util.ArrayList;

import VO.CustomerVO;
import VO.HotelInfoVO;
import blservice.Hotel_blservice;
import blservice.UserManagement_blservice;
import blservice.impl.Hotel_bl;
import blservice.impl.UserManagement_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import util.ImageUtil;

public class CustomerMainController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button viewHotel;
	@FXML
	private Button viewOrder;
	@FXML
	private Button maintainPersonalInfo;// 维护个人信息
	@FXML
	private Button adviceFeedBack;
	@FXML
	private Button exit;
	@FXML
	private TableView<HotelInfoVO> hotelTable;
	@FXML
	private TableColumn<HotelInfoVO, String> hotelName;
	@FXML
	private TableColumn<HotelInfoVO, String> address;// 地址
	@FXML
	private TableColumn<HotelInfoVO, String> introduction;// 简介

	// ui层属性
	private Hotel_blservice hotelService;
	private CustomerVO customer;
	private Main mainScene;
	private UserManagement_blservice userservice;

	// 表格属性
	private ArrayList<HotelInfoVO> hotelList;
	private ObservableList<HotelInfoVO> hotelData = FXCollections.observableArrayList();

	public CustomerMainController() {
	}

	public void initialize(Main main, CustomerVO customer) {
		this.mainScene = main;
		this.customer = customer;
		this.hotelService = new Hotel_bl();
		userservice = new UserManagement_bl();
		this.hotelList = this.hotelService.getAllHotel();
		// 表格操作
		int count = 0;
		while (count < this.hotelList.size()) {
			if (this.hotelService.HotelInfoCompletedComfirm(this.hotelList.get(count))) {
				this.hotelData.add(this.hotelList.get(count));
			}
			count++;
		}
		this.hotelName.setCellValueFactory(cellData -> cellData.getValue().getHotelNameProperty());
		this.address.setCellValueFactory(cellData -> cellData.getValue().getHotelAddressProperty());
		this.introduction.setCellValueFactory(cellData -> cellData.getValue().getHotelDiscriptionProperty());

		this.CustomerMainShow();
	}

	public void CustomerMainShow() {
		this.leftIdLabel.setText(customer.getId());
		this.leftNameLabel.setText(customer.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(customer.getImage()));
		// 表格操作
		this.hotelTable.setItems(this.hotelData);
	}

	@FXML
	private void handleViewHotel() {
		this.mainScene.showCustomerHotelViewScene(customer);
	}

	@FXML
	private void handleViewOrder() {
		this.mainScene.showCustomerOrderViewScene(customer);
	}

	@FXML
	private void handlePersonal() {
		this.mainScene.showCustomerInfoScene(userservice.getCustomer(customer.getId()));
	}

	@FXML
	private void handleAdviceFeedback() {
		this.mainScene.showCustomerAdviceViewScene(customer);
	}

	@FXML
	private void handleExit() {
		try {
			// this.customer.changeLoginState(false);
			// this.userservice.modifyCustomer(customer);
			this.mainScene.showLoginScene();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handleTableClick() {

	}
}
