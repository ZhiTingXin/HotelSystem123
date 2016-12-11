package presentation.controller.userInfoController;

import VO.SystemManagerVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;

public class SystemManagerInfoController {

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

	private Main mainScene;
	private SystemManagerVO systemManager;
	private UserInfo_blservice systemManagerInfoService;

	public SystemManagerInfoController() {
		systemManagerInfoService = new UserInfo_bl();
	}

	public void initialize(Main main, SystemManagerVO systemManager) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.systemManager = systemManager;
		this.SystemManagerInfoShow();
	}

	public void SystemManagerInfoShow() {
		leftIdLabel.setText(systemManager.getId());
		leftNameLabel.setText(systemManager.getUserName());
		idLabel.setText(systemManager.getId());
		nameLabel.setText(systemManager.getUserName());

	}

	public void handleModifyInfo() {
		this.mainScene.showSystemManagerInfoModifyScene(systemManager);
	}

	public void handleModifyPassword() {
		this.mainScene.showSystemManagerPasswordModifyScene(systemManager);
	}
}
