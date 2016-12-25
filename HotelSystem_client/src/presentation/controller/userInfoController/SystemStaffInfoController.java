package presentation.controller.userInfoController;

import VO.SystemStaffVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;

public class SystemStaffInfoController {

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
	private Label phone;

	private Main mainScene;
	private SystemStaffVO systemStaff;

	public SystemStaffInfoController() {
	}

	public void SystemStaffInfoShow() {
		this.idLabel.setText(this.systemStaff.getId());
		this.nameLabel.setText(this.systemStaff.getUsername());
		this.leftIdLabel.setText(this.systemStaff.getId());
		this.leftNameLabel.setText(this.systemStaff.getUsername());
		this.phone.setText(this.systemStaff.getPhone());
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaff) {
		this.mainScene = mainScene;
		this.systemStaff = systemStaff;
		this.SystemStaffInfoShow();
	}

	public void handleInfoModify() {
		this.mainScene.showSystemStaffInfoModifyScene(systemStaff);
	}

	public void handelPasswordModify() {
		this.mainScene.showSystemStaffPasswordModifyScene(systemStaff);
	}

	public void handleBack() {
		this.mainScene.showSystemStaffMainScene(systemStaff);
	}
}
