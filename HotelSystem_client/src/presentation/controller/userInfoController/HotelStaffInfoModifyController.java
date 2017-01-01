package presentation.controller.userInfoController;

import VO.HotelStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class HotelStaffInfoModifyController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView myPicture;
	@FXML
	private ImageView changedPicture;
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
	@FXML
	private TextField phoneTextField;

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

	@FXML
	private void HotelStaffInfoModifyShow() {
		this.name.setText(this.hotelStaff.getUsername());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
		this.changedPicture.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
		this.idLabel.setText(this.hotelStaff.getId());
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.hotelName.setText(this.hotelStaff.getHotelName());
		this.hotelId.setText(this.hotelStaff.getHotelId());
		this.phoneTextField.setText(this.hotelStaff.getPhone());

	}

	@FXML
	private void handleSave() {
		if (!this.name.getText().equals("")) {
			this.hotelStaff.setUsername(this.name.getText());

		}
		if (this.phoneTextField.getText() != "") {
			this.hotelStaff.setPhone(this.phoneTextField.getText());
		}
		this.blservice.modifyHotelStaff(hotelStaff);
		this.mainScene.showHotelStaffInfoScene(this.hotelStaff);
	}

	@FXML
	private void handleBacK() {
		this.mainScene.showHotelStaffInfoScene(this.hotelStaff);
	}

	@FXML
	private void handleChange() {
		this.hotelStaff.setImage(ImageUtil.setImagePath(changedPicture));
	}
}
