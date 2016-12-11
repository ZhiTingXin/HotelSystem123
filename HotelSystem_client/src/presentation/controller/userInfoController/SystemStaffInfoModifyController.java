package presentation.controller.userInfoController;

import VO.SystemStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;


public class SystemStaffInfoModifyController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button save;
	@FXML
	private Button back;
	@FXML
	private Label idLabel;
	@FXML
	private TextField nameField;
	@FXML
	private Label businessDistrictLabel;
	@FXML
	private Button changePicture;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private SystemStaffVO systemStaff;

	public SystemStaffInfoModifyController() {
		blservice = new UserInfo_bl();
	}

	public void SystemStaffInfoModifyShow() {
		this.idLabel.setText(this.systemStaff.getId());
		this.nameField.setText(this.systemStaff.getUsername());
		this.leftIdLabel.setText(this.systemStaff.getId());
		this.leftNameLabel.setText(this.systemStaff.getUsername());
		this.businessDistrictLabel.setText(this.systemStaff.getBusinessDistrict());

	}

	public void initialize(Main mainScene, SystemStaffVO systemStaff) {
		// TODO Auto-generated method stub
		this.mainScene = mainScene;
		this.systemStaff = systemStaff;
		this.SystemStaffInfoModifyShow();
	}

	public void handleSave() {
		if (this.nameField.getText() != "") {
			this.systemStaff.setUsername(this.nameField.getText());
			this.blservice.modifySystemStaff(systemStaff);
		}
		this.mainScene.showSystemStaffInfoScene(systemStaff);
	}

	public void handleBack() {
		this.mainScene.showSystemStaffInfoScene(systemStaff);
	}
}
