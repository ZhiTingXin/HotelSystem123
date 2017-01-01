package presentation.controller.userInfoController;

import VO.SystemStaffVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class SystemStaffInfoController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView myPicture;
	@FXML
	private ImageView nowPic;
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
	private Label phone;

	private Main mainScene;
	private SystemStaffVO systemStaff;

	public SystemStaffInfoController() {
	}

	public void SystemStaffInfoShow() {
		this.idLabel.setText(this.systemStaff.getId());
		this.nameLabel.setText(this.systemStaff.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(this.systemStaff.getImage()));
		this.leftIdLabel.setText(this.systemStaff.getId());
		this.leftNameLabel.setText(this.systemStaff.getUsername());
		this.phone.setText(this.systemStaff.getPhone());
		this.nowPic.setImage(ImageUtil.setImage(this.systemStaff.getImage()));
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaff) {
		this.mainScene = mainScene;
		this.systemStaff = systemStaff;
		this.SystemStaffInfoShow();
	}

	@FXML
	private void handleInfoModify() {
		this.mainScene.showSystemStaffInfoModifyScene(systemStaff);
	}

	@FXML
	private void handelPasswordModify() {
		this.mainScene.showSystemStaffPasswordModifyScene(systemStaff);
	}

	@FXML
	private void handleBack() {
		this.mainScene.showSystemStaffMainScene(systemStaff);
	}
}
