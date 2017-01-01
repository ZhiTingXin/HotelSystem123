package presentation.controller.hotelController;

import java.util.ArrayList;
import java.util.Observable;

import VO.CustomerVO;
import VO.HotelInfoVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
import blservice.impl.Room_blServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import other.MyDistricts;
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
	private ChoiceBox<String> chooseCity;
	@FXML
	private ChoiceBox<String> chooseDistrict;
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
	@FXML
	private Button clearButton;

	// ui层属性
	private Hotel_blservice service;
	private Main mainScene;
	private CustomerVO customer;
	// 表格属性
	private ArrayList<HotelInfoVO> hotelList;
	private ObservableList<HotelInfoVO> hotelData = FXCollections.observableArrayList();
	private ObservableList<String> cities = FXCollections.observableArrayList();
	private ObservableList<String> districts = FXCollections.observableArrayList();

	private int lowPrice = 0;
	private int highPrice = Integer.MAX_VALUE;
	private int hotelRank = 0;
	private String city;
	private String district;

	public void initialize(Main main, CustomerVO customer) {
		this.service = new Hotel_bl();
		this.customer = customer;
		this.mainScene = main;
		this.hotelList = this.service.getAllHotel();
		this.refreshTabel();
		this.HotelViewShow();

		// 初始化城市和商圈
		for (String city : MyDistricts.cities) {
			cities.add(city);
		}
		chooseCity.setItems(cities);
		// 根据城市选择商圈
		chooseCity.getSelectionModel().selectedItemProperty()
				.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));
	}

	private void setDistrictChoiceBox(String city) {
		districts.clear();
		if (city != null) {
			String[] allDistrict = MyDistricts.getDistricts(city);
			for (String dist : allDistrict) {
				districts.add(dist);
			}
		}
		chooseDistrict.setItems(districts);
	}

	/**
	 * 显示信息
	 */
	private void HotelViewShow() {
		this.leftIdLabel.setText(this.customer.getId());
		this.leftNameLabel.setText(this.customer.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(customer.getImage()));
	}

	/**
	 * 查看详情按钮响应
	 */
	@FXML
	private void handleViewHotelInfo() {
		HotelInfoVO hotelin = this.hotelTable.getSelectionModel().getSelectedItem();
		if (hotelin != null)
			this.mainScene.showCustomerHotelInfoScene(customer, hotelin);
		else
			this.StateField.setText("未选择酒店！");
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
		// 搜索方法初始化
		this.city = null;
		this.district = null;
		this.lowPrice = 0;
		this.highPrice = Integer.MAX_VALUE;

		// 确定最大最小价格
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
		// 确定城市和商圈
		this.city = this.chooseCity.getSelectionModel().getSelectedItem();
		this.district = this.chooseDistrict.getSelectionModel().getSelectedItem();

		// 四次筛选
		if (this.lowPrice != 0 || !this.searchInput.getText().equals("") || this.highPrice != Integer.MAX_VALUE
				|| this.hotelRank != 0 || this.city != null) {
			this.hotelList = this.service.getHotelFromName(this.searchInput.getText());
			this.hotelList = this.service.getHotelFromCity(hotelList, this.city, this.district);
			this.hotelList = this.service.getHotelFromPrice(hotelList, lowPrice, highPrice);
			this.hotelList = this.service.getHotelFromGrade(hotelList, hotelRank);

			if (hotelList != null && hotelList.size() > 0) {
				this.refreshTabel();
				this.StateField.setText("已完成搜索");
			} else {
				this.refreshTabel();
				this.StateField.setText("未找到匹配的酒店！");
			}
		} else {
			this.hotelList = this.service.getAllHotel();
			this.refreshTabel();
		}
	}

	// 刷新表格方法
	private void refreshTabel() {
		this.hotelData.clear();
		int count = 0;

		while (count < this.hotelList.size()) {
			if (this.service.HotelInfoCompletedComfirm(this.hotelList.get(count))) {
				this.hotelData.add(this.hotelList.get(count));
			}
			count++;
		}
		// VO列表赋值给表格
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
		this.rankButton.setText("★");
	}

	@FXML
	private void handleTwo() {
		this.hotelRank = 2;
		this.rankButton.setText("★★");
	}

	@FXML
	private void handleThree() {
		this.hotelRank = 3;
		this.rankButton.setText("★★★");
	}

	@FXML
	private void handleFour() {
		this.hotelRank = 4;
		this.rankButton.setText("★★★★");
	}

	@FXML
	private void handleFive() {
		this.hotelRank = 5;
		this.rankButton.setText("★★★★★");
	}

	@FXML
	private void handleClear() {
		this.lowPrice = 0;
		this.hotelRank = 0;
		this.highPrice = 0;
		this.rankButton.setText("选择评分");
		this.searchInput.clear();
		this.minPrice.clear();
		this.maxPrice.clear();
		this.city = null;
		this.district = null;
		cities.clear();
		// 初始化城市和商圈
		for (String city : MyDistricts.cities) {
			cities.add(city);
		}
		chooseCity.setItems(cities);
		// 根据城市选择商圈
		chooseCity.getSelectionModel().selectedItemProperty()
				.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));

	}
}
