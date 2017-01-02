package presentation.controller.userManagementController;

import VO.SystemManagerVO;
import VO.SystemStaffVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

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
	private Label phoneNum;
	@FXML
	private ImageView image;
	@FXML
	private ImageView myPicture;

	private Main mainScene;
	private SystemManagerVO systemManagerVO;
	private SystemStaffVO systemStaffVO;

	public SystemManagerSystemStaffInfoViewController() {
	}

	public void initialize(Main mainScene, SystemManagerVO systemManagerVO, SystemStaffVO systemStaffVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		this.systemStaffVO = systemStaffVO;
		// left
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		myPicture.setImage(ImageUtil.setImage(this.systemManagerVO.getImage()));
		image.setImage(ImageUtil.setImage(this.systemStaffVO.getImage()));
		SystemManagerSystemStaffInfoViewShow(mainScene);
	}

	public void SystemManagerSystemStaffInfoViewShow(Main mainScene) {

		idLabel.setText(systemStaffVO.getId());
		nameLabel.setText(systemStaffVO.getUsername());
		phoneNum.setText(systemStaffVO.getPhone());
	}

	@FXML // modify
	private void handleModify() {
		mainScene.showSystemManagerSystemStaffInfoModfyScene(systemManagerVO, systemStaffVO);
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemStaffManagementScene(systemManagerVO);
	}
}
