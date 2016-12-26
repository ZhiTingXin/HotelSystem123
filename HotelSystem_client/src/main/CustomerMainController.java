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
	private TableView<HotelInfoVO> hotelTable;
	@FXML
	private TableColumn<HotelInfoVO, String> hotelName;
	@FXML
	private TableColumn<HotelInfoVO, String> address;// ��ַ
	@FXML
	private TableColumn<HotelInfoVO, String> introduction;// ���

	// ui������
	private Hotel_blservice hotelService;
	private CustomerVO customer;
	private Main mainScene;
	private UserManagement_blservice userservice;

	// �������
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
		// ������
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
		/**
		 * ���ά��������Ϣʱ��û�� ˢ������
		 */
		this.mainScene.showCustomerInfoScene(userservice.getCustomer(customer.getId()));
	}

	public void handleAdviceFeedback() {
		this.mainScene.showCustomerAdviceViewScene(customer);
	}

	public void handleExit() {
		try {
			this.mainScene.showLoginScene();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handleTableClick() {

	}
}
