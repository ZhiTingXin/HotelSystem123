package main;

import java.util.ArrayList;

import VO.CustomerVO;
import VO.HotelInfoVO;
import blservice.Hotel_blservice;
import blservice.UserInfo_blservice;
import blservice.impl.Hotel_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

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
	private Button maintainPersonalInfo;// ά��������Ϣ
	@FXML
	private Button adviceFeedBack;
	@FXML
	private Button exit;
	@FXML
	private Label districtName;
	@FXML
	private TableView<HotelInfoVO> hotelTable;
	@FXML
	private TableColumn<HotelInfoVO, String> hotelName;
	@FXML
	private TableColumn<HotelInfoVO, String> address;// ��ַ
	@FXML
	private TableColumn<HotelInfoVO, String> introduction;// ���

	// ui������
	private Hotel_blservice hotelService;
	private UserInfo_blservice userService;
	private CustomerVO customer;
	private Main mainScene;

	// �������
	private ArrayList<HotelInfoVO> hotelList;
	private ObservableList<HotelInfoVO> hotelData = FXCollections.observableArrayList();

	public CustomerMainController() {
	}

	public void initialize(Main main, CustomerVO customer) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.customer = customer;
		this.hotelService = new Hotel_bl();
		this.hotelList = this.hotelService.getAllHotel();
		// ������
		int count = 0;
		while (count < this.hotelList.size()) {
			this.hotelData.add(this.hotelList.get(count));
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

		// ������
		this.hotelTable.setItems(this.hotelData);
	}

	public void handleViewHotel() {
		this.mainScene.showCustomerHotelViewScene(customer);
	}

	public void handleViewOrder() {
		this.mainScene.showCustomerOrderViewScene(customer);
	}

	public void handlePersonal() {
		this.mainScene.showCustomerInfoScene(customer);
	}

	public void handleAdviceFeedback() {
		
	}

	public void handleExit() {
		try {
			this.mainScene.showLoginScene();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void handleTableClick() {

	}
}
