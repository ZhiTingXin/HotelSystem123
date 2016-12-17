package presentation.controller.hotelController;

import java.util.ArrayList;

import VO.CustomerVO;
import VO.HotelInfoVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;

public class HotelViewController {
	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button viewHotelInfo;
	@FXML
	private Button guess;
	@FXML
	private Button back;
	@FXML
	private TextField searchInput;
	@FXML
	private Button searchButton;
	@FXML
	private TableView<HotelInfoVO> hotelTable;
	@FXML
	private TableColumn<HotelInfoVO, String> hotelName;
	@FXML
	private TableColumn<HotelInfoVO, String> address;
	@FXML
	private TableColumn<HotelInfoVO, String> description;
	@FXML
	private Label StateField;

	// ui层属性
	private Hotel_blservice service;
	private Main mainScene;
	private CustomerVO customer;

	// 表格属性
	private ArrayList<HotelInfoVO> hotelList;
	private ObservableList<HotelInfoVO> hotelData = FXCollections.observableArrayList();

	public HotelViewController() {

	}

	public void initialize(Main main, CustomerVO customer) {
		// TODO Auto-generated method stub
		this.service = new Hotel_bl();
		this.customer = customer;
		this.mainScene = main;

		// 获取所有酒店的ID
		this.hotelList = this.service.getAllHotel();
		this.refreshTabel();
		this.HotelViewShow();
	}

	public void HotelViewShow() {
		this.leftIdLabel.setText(this.customer.getId());
		this.leftNameLabel.setText(this.customer.getUsername());
	}

	public void handleViewHotelInfo() {
		int focusOn = this.hotelTable.getSelectionModel().getFocusedIndex();
		this.mainScene.showCustomerHotelInfoScene(customer, this.hotelList.get(focusOn));
	}

	public void handleGuess() {
		this.hotelList = this.service.getListOfHotelPrefer(this.customer.getId());
		this.refreshTabel();
	}

	public void handleBack() {
		this.mainScene.showCustomerMainScene(customer);

	}

	public void handleSearch() {
		this.hotelList = this.service.getHotelFromName(this.searchInput.getText());
		if (hotelList != null && hotelList.size() > 0) {
			this.refreshTabel();
		} else {
			this.StateField.setText("未找到匹配的酒店！");
		}
	}

	// 刷新表格方法
	private void refreshTabel() {
		this.hotelData.clear();
		int count = 0;

		while (count < this.hotelList.size()) {
			this.hotelData.add(this.hotelList.get(count));
			count++;
		}
		// VO列表赋值给表格
		this.hotelName.setCellValueFactory(cellData -> cellData.getValue().getHotelNameProperty());
		this.address.setCellValueFactory(cellData -> cellData.getValue().getHotelAddressProperty());
		this.description.setCellValueFactory(cellData -> cellData.getValue().getHotelDiscriptionProperty());
		this.hotelTable.setItems(this.hotelData);
	}
}
