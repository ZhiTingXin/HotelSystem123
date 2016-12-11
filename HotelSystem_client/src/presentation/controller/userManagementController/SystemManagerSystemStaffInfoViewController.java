package presentation.controller.userManagementController;

import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;

public class SystemManagerSystemStaffInfoViewController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button modifyInfo;
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
	private SystemManagerVO systemManagerVO;
	private SystemStaffVO systemStaffVO;
	private UserInfo_blservice systemStaffInfoService;
	
	public SystemManagerSystemStaffInfoViewController(){
		systemStaffInfoService = new UserInfo_bl();
	}
	
	public void initialize(Main mainScene,SystemManagerVO systemManagerVO,SystemStaffVO systemStaffVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		this.systemStaffVO = systemStaffVO;
		//left
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		SystemManagerSystemStaffInfoViewShow(mainScene);
	}
	
	public void SystemManagerSystemStaffInfoViewShow(Main mainScene) {
		
		idLabel.setText(systemStaffVO.getId());
		nameLabel.setText(systemStaffVO.getUsername());
		districtName.setText(systemStaffVO.getBusinessDistrict());
		
	}
	
	@FXML//modify
	private void handleModify(){
		mainScene.showSystemManagerSystemStaffInfoModfyScene(systemManagerVO, systemStaffVO);
	}
	@FXML
	private void handleBack(){
		mainScene.showSystemStaffManagementScene(systemManagerVO);
	}
}
