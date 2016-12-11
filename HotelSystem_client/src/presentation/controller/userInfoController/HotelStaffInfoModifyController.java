package presentation.controller.userInfoController;

import VO.HotelStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

public class HotelStaffInfoModifyController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button save;
	@FXML
	private Button cancel;
	@FXML
	private Label idLabel;
	@FXML
	private TextField name;
	@FXML
	private Label hotelId;
	@FXML
	private Label hotelName;
	@FXML
	private Button changePicture;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private HotelStaffVO hotelStaff;

	public HotelStaffInfoModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main mainScene, HotelStaffVO hotelStaff) {
		this.mainScene = mainScene;
		this.hotelStaff = hotelStaff;
		this.HotelStaffInfoModifyShow();
	}

	public void HotelStaffInfoModifyShow() {
		this.name.setText(this.hotelStaff.getUsername());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.idLabel.setText(this.hotelStaff.getId());
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.hotelName.setText(this.hotelStaff.getHotelName());
		this.hotelId.setText(this.hotelStaff.getHotelId());

	}

	public void handleSave() {
		if (this.name.getText() != "") {
			this.hotelStaff.setUsername(this.name.getText());
			// bl²ã·½·¨
			this.blservice.modifyHotelStaff(hotelStaff);
		}
		this.mainScene.showHotelStaffInfoScene(this.hotelStaff);
	}

	public void handleBacK() {
		this.mainScene.showHotelStaffInfoScene(this.hotelStaff);
	}
}
