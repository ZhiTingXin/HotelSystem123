package presentation.controller.hotelStrategyController;

import java.util.ArrayList;

import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.HotelStrategyVO;
import blservice.HotelStrategy_blservice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import main.Main;

public class HotelStrategyViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button modifyHotelStrategy;
	@FXML
	private Button back;
	@FXML
	private Button newHotelStrategy;
	@FXML
	private Button deleteHotelStrategy;
	@FXML
	private Label hotelName;
	@FXML
	private TableView<HotelStrategyVO> strategyTable;
	@FXML
	private TableColumn<HotelStrategyVO, String> strategyName;
	@FXML
	private TableColumn<HotelStrategyVO, String> strategyInfo;

	private Main mainscene;
	private HotelInfoVO hotel;
	private HotelStaffVO hotelStaff;
	private HotelStrategy_blservice service;
	private ArrayList<HotelStrategyVO> hotelStrategyList;
	private ObservableList<HotelStrategyVO> hotelStrategyData = FXCollections.observableArrayList();

	public HotelStrategyViewController() {

	}

	public void HotelStrategyViewShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.hotelName.setText(this.hotelStaff.getHotelName());
		this.strategyTable.setItems(hotelStrategyData);

	}

	public void initialize(Main main, HotelStaffVO staff, HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		this.mainscene = main;
		this.hotelStaff = staff;
		this.hotel = hotel;
		int count = 0;
		this.hotelStrategyList = this.service.getListOfHotelStrategys(this.hotel.getHotelID());
		while (count < this.hotelStrategyList.size()) {
			this.hotelStrategyData.add(this.hotelStrategyList.get(count));
			count++;
		}
		this.strategyName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		this.strategyInfo.setCellValueFactory(cellData -> cellData.getValue().getInfoProperty());
		this.HotelStrategyViewShow();
	}

	public void handleModify() {
		int foucus = this.strategyTable.getSelectionModel().getFocusedIndex();
		this.mainscene.showHotelStrategyModifyScene(hotelStaff, this.hotelStrategyList.get(foucus), hotel);
	}

	@FXML
	private void handleNew() {
		this.mainscene.showHotelStrategyNewScene(hotelStaff, hotel);
	}

	@FXML
	private void handleBack() {
		this.mainscene.showHotelStaffMainScene(hotelStaff);
	}

	@FXML
	private void handleDelete() {
		int foucus = this.strategyTable.getSelectionModel().getFocusedIndex();
		this.service.deleteHotelStrategy(this.hotelStrategyList.get(foucus).getId());
	}
}
