package presentation.controller.userInfoController;

import VO.SystemManagerVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	@FXML
	private TextField phoneTextField;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private SystemManagerVO systemManager;

	public SystemManagerInfoModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main main, SystemManagerVO systemManager2) {

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

		this.systemManager.setUsername(this.nameLabel.getText());

		if (this.nameLabel.getText() != "") {
			// bl层方法
			this.blservice.modifySystemManager(systemManager);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警告");
			alert.setContentText("用户名为空，请输入您的用户名！");
			alert.showAndWait();
		}
		this.mainScene.showSystemManagerInfoScene(systemManager);
	}

	public void handleBack() {
		this.mainScene.showSystemManagerInfoScene(systemManager);
	}
}
