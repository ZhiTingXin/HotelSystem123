package presentation.controller.userInfoController;

import VO.SystemManagerVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class SystemManagerInfoController {

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
	private SystemManagerVO systemManager;

	public void initialize(Main main, SystemManagerVO systemManager) {
		this.mainScene = main;
		this.systemManager = systemManager;
		this.SystemManagerInfoShow();
	}

	public void SystemManagerInfoShow() {
		leftIdLabel.setText(systemManager.getId());
		leftNameLabel.setText(systemManager.getUserName());
		myPicture.setImage(ImageUtil.setImage(this.systemManager.getImage()));
		nowPic.setImage(ImageUtil.setImage(this.systemManager.getImage()));
		idLabel.setText(systemManager.getId());
		nameLabel.setText(systemManager.getUserName());
		this.phone.setText(systemManager.getPhone());

	}

	public void handleModifyInfo() {
		this.mainScene.showSystemManagerInfoModifyScene(systemManager);
	}

	public void handleModifyPassword() {
		this.mainScene.showSystemManagerPasswordModifyScene(systemManager);
	}
	
	@FXML
	private void handleBack(){
		mainScene.showSystemManagerMainScene(systemManager);
	}
}
