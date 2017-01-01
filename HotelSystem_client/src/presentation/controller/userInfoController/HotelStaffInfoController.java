package presentation.controller.userInfoController;

import VO.HotelStaffVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class HotelStaffInfoController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView myPicture;
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
	@FXML
	private Label phone;
	@FXML
	private ImageView nowPic;

	private Main mainScene;
	private HotelStaffVO hotelStaff;

	public void initialize(Main mainScene, HotelStaffVO hotelStaff) {
		this.mainScene = mainScene;
		this.hotelStaff = hotelStaff;
		this.HotelStaffInfoShow();
	}

	@FXML
	private void HotelStaffInfoShow() {
		this.nameLabel.setText(this.hotelStaff.getUsername());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
		this.nowPic.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
		this.idLabel.setText(this.hotelStaff.getId());
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.hotelName.setText(this.hotelStaff.getHotelName());
		this.hotelId.setText(this.hotelStaff.getHotelId());
		this.phone.setText(this.hotelStaff.getPhone());
	}

	@FXML
	private void handleInfoModify() {
		this.mainScene.showHotelStaffInfoModifyScene(hotelStaff);
	}

	@FXML
	private void handlePasswordModify() {
		this.mainScene.showHotelStaffPasswordModifyScene(hotelStaff);
	}

	@FXML
	private void handleBack() {
		this.mainScene.showHotelStaffMainScene(hotelStaff);
	}
}
