package presentation.controller.userInfoController;

import VO.SystemManagerVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

public class SystemManagerInfoModifyController {

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
	private TextField nameLabel;
	@FXML
	private Button changePicture;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private SystemManagerVO systemManager;

	public SystemManagerInfoModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main main, SystemManagerVO systemManager2) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.systemManager = systemManager2;
		this.SystemManagerInfoModifyShow();
	}

	public void SystemManagerInfoModifyShow() {
		leftIdLabel.setText(systemManager.getId());
		leftNameLabel.setText(systemManager.getUserName());
		idLabel.setText(systemManager.getId());
		nameLabel.setText(systemManager.getUserName());
	}

	public void handleSave() {
		if (this.nameLabel.getText() != "") {
			// bl²ã·½·¨
			this.blservice.modifySystemManager(systemManager);

			this.systemManager.setUsername(this.nameLabel.getText());
		}
		this.mainScene.showSystemManagerInfoScene(systemManager);

	}

	public void handleBack() {
		this.mainScene.showSystemManagerInfoScene(systemManager);
	}
}
