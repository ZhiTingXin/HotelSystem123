package presentation.controller.hotelController;

import VO.CustomerVO;
import VO.HotelInfoVO;
import VO.HotelRoomInfoVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
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
	private HotelRoomInfoVO[] hotelRoomInfo;
	private Hotel_blservice service;
	private ObservableList<HotelRoomInfoVO> roomData = FXCollections.observableArrayList();

	public HotelInfoController() {
	}

	public void initialize(Main main, CustomerVO customer, HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.service = new Hotel_bl();
		this.customer = customer;
		this.hotel = hotel;
		this.hotelRoomInfo = hotel.getRoomInfo();
		this.roomData.add(this.hotelRoomInfo[0]);
		this.roomData.add(this.hotelRoomInfo[1]);
		this.roomData.add(this.hotelRoomInfo[2]);
		this.roomData.add(this.hotelRoomInfo[3]);
		this.roomType.setCellValueFactory(cellData -> cellData.getValue().getRoomTypeProperty());
		this.roomRemain.setCellValueFactory(cellData -> cellData.getValue().getRoomRemainProperty());
		this.roomPrice.setCellValueFactory(cellData -> cellData.getValue().getRoomPriceProperty());
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

		this.strategy.setText(this.service.getHotelStrategy(this.hotel.getHotelID()));
		this.grade.setText(this.service.getHotelGradeAssessment(this.hotel.getHotelID()));

		// 标签汇总方法
		int count = 0;
		String[] tagList = this.service.getHotelTagAssessment(this.hotel.getHotelID());
		String tagSummary = "";
		while (count < tagList.length) {
			tagSummary += tagList[count];
		}
		this.tag.setText(tagSummary);

		// 图片方法
		// this.hotelPicture2
	}

	public void handleReserveRoom() {
		this.mainScene.showCustomerBookHotelScene(customer, hotel);
	}

	public void handleBack() {
		this.mainScene.showCustomerHotelViewScene(customer);
	}
}
