package presentation.controller.hotelController;

import java.util.ArrayList;

import VO.CustomerVO;
import VO.HotelInfoVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
import blservice.impl.Room_blServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

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
	private TextField minPrice;
	@FXML
	private TextField maxPrice;
	@FXML
	private MenuButton rankButton;
	@FXML
	private MenuItem oneStar;
	@FXML
	private MenuItem twoStar;
	@FXML
	private MenuItem threeStar;
	@FXML
	private MenuItem fourStar;
	@FXML
	private MenuItem fiveStar;
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
	private TableColumn<HotelInfoVO, String> price;
	@FXML
	private TableColumn<HotelInfoVO, String> rank;
	@FXML
	private Label StateField;

	// ui������
	private Hotel_blservice service;
	private Main mainScene;
	private CustomerVO customer;
	// �������
	private ArrayList<HotelInfoVO> hotelList;
	private ObservableList<HotelInfoVO> hotelData = FXCollections.observableArrayList();

	private int lowPrice = 0;
	private int highPrice = Integer.MAX_VALUE;
	private int hotelRank = 0;

	public void initialize(Main main, CustomerVO customer) {
		this.service = new Hotel_bl();
		this.customer = customer;
		this.mainScene = main;
		this.hotelList = this.service.getAllHotel();
		this.refreshTabel();
		this.HotelViewShow();
	}

	/**
	 * ��ʾ��Ϣ
	 */
	private void HotelViewShow() {
		this.leftIdLabel.setText(this.customer.getId());
		this.leftNameLabel.setText(this.customer.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(customer.getImage()));
	}

	/**
	 * �鿴���鰴ť��Ӧ
	 */
	@FXML
	private void handleViewHotelInfo() {
		HotelInfoVO hotelin = this.hotelTable.getSelectionModel().getSelectedItem();
		if (hotelin != null)
			this.mainScene.showCustomerHotelInfoScene(customer, hotelin);
		else
			this.StateField.setText("δѡ��Ƶ꣡");
	}

	@FXML
	private void handleGuess() {
		this.hotelList = this.service.getListOfHotelPrefer(this.customer.getId());
		this.refreshTabel();
	}

	@FXML
	private void handleBack() {
		this.mainScene.showCustomerMainScene(customer);

	}

	@FXML
	private void handleSearch() {
		this.lowPrice = 0;
		this.highPrice = Integer.MAX_VALUE;
		if (!this.minPrice.getText().equals("")) {
			this.lowPrice = Integer.parseInt(this.minPrice.getText());
		} else {
			this.lowPrice = 0;
		}

		if (!this.maxPrice.getText().equals("")) {
			this.highPrice = Integer.parseInt(this.maxPrice.getText());
		} else {
			this.highPrice = Integer.MAX_VALUE;
		}
		// ����ɸѡ
		this.hotelList = this.service.getHotelFromName(this.searchInput.getText());
		this.hotelList = this.service.getHotelFromPrice(hotelList, lowPrice, highPrice);
		this.hotelList = this.service.getHotelFromGrade(hotelList, hotelRank);

		if (hotelList != null && hotelList.size() > 0) {
			this.refreshTabel();
			this.StateField.setText("���������");
		} else {
			this.refreshTabel();
			this.StateField.setText("δ�ҵ�ƥ��ľƵ꣡");
		}
	}

	// ˢ�±�񷽷�
	private void refreshTabel() {
		this.hotelData.clear();
		int count = 0;

		while (count < this.hotelList.size()) {
			if (this.service.HotelInfoCompletedComfirm(this.hotelList.get(count))) {
				this.hotelData.add(this.hotelList.get(count));
			}
			count++;
		}
		// VO�б�ֵ�����
		this.hotelName.setCellValueFactory(cellData -> cellData.getValue().getHotelNameProperty());
		this.address.setCellValueFactory(cellData -> cellData.getValue().getHotelAddressProperty());
		this.description.setCellValueFactory(cellData -> cellData.getValue().getHotelDiscriptionProperty());
		this.rank.setCellValueFactory(cellData -> cellData.getValue().getHotelRankProperty(this.service));
		this.price.setCellValueFactory(cellData -> cellData.getValue().getHotelPriceProperty(new Room_blServiceImpl()));

		this.hotelTable.setItems(this.hotelData);
	}

	@FXML
	private void handleOne() {
		this.hotelRank = 1;
		this.rankButton.setText("��");
	}

	@FXML
	private void handleTwo() {
		this.hotelRank = 2;
		this.rankButton.setText("���");
	}

	@FXML
	private void handleThree() {
		this.hotelRank = 3;
		this.rankButton.setText("����");
	}

	@FXML
	private void handleFour() {
		this.hotelRank = 4;
		this.rankButton.setText("�����");
	}

	@FXML
	private void handleFive() {
		this.hotelRank = 5;
		this.rankButton.setText("������");
	}

}
