package presentation.controller.userManagementController;

import VO.SystemStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import other.ResultMessage;

public class SystemManagerSystemStaffInfoViewController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button modifyInfo;
	@FXML
	private Button changeState;
	@FXML
	private Button back;
	@FXML
	private Label idLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label districtName;
	@FXML
	private Label myPicture;
	@FXML
	private ImageView image;
	
	private Main mainScene;
	private SystemStaffVO systemStaff;
	private UserInfo_blservice systemStaffInfoService;
	
	public SystemManagerSystemStaffInfoViewController(){
		systemStaffInfoService = new UserInfo_bl();
	}
	
	public void SystemManagerSystemStaffInfoViewShow(Main mainScene) {
		this.mainScene = mainScene;
		
	}
}
