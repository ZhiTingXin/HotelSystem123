package presentation.controller.userManagementController;

import VO.SystemStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;

public class SystemManagerSystemStaffInfoModifyController {

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
	@FXML
	private ImageView myPicture;
	
	private Main mainScene;
	private UserInfo_blservice blservice;
	private SystemStaffVO systemStaff;
	
	public SystemManagerSystemStaffInfoModifyController() {
		blservice = new UserInfo_bl();
	}
	
	public void SystemManagerSystemStaffInfoModifyShow(Main mainScene) {
		this.mainScene = mainScene;
		leftIdLabel.setText("123");
	}
}
