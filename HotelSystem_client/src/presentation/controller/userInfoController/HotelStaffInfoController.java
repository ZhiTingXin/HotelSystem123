package presentation.controller.userInfoController;

import VO.HotelStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;

public class HotelStaffInfoController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button modifyInfo;
	@FXML
	private Button modifyPassword;
	@FXML
	private Button back;
	@FXML
	private Label idLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label hotelId;
	@FXML
	private Label hotelName;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private HotelStaffVO hotelStaff;

	public HotelStaffInfoController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main mainScene, HotelStaffVO hotelStaff) {
		this.mainScene = mainScene;
		this.hotelStaff = hotelStaff;
		this.HotelStaffInfoShow();
	}

	public void HotelStaffInfoShow() {
		this.nameLabel.setText(this.hotelStaff.getUsername());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.idLabel.setText(this.hotelStaff.getId());
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.hotelName.setText(this.hotelStaff.getHotelName());
		this.hotelId.setText(this.hotelStaff.getHotelId());
	}

	public void handleInfoModify() {
		this.mainScene.showHotelStaffInfoModifyScene(hotelStaff);
	}

	public void handlePasswordModify() {
		this.mainScene.showHotelStaffPasswordModifyScene(hotelStaff);
	}
	public void handleBack(){
		this.mainScene.showHotelStaffMainScene(hotelStaff);
	}
}
