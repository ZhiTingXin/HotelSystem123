package presentation.controller.userInfoController;

import VO.SystemManagerVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import main.Main;

public class SystemManagerPasswordModifyController {

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
	private Label nameLabel;
	@FXML
	private PasswordField passWord;
	@FXML
	private PasswordField newPassword;
	@FXML
	private PasswordField confirmPassword;
	@FXML
	private Label passwordRightLabel;
	@FXML
	private Label newPasswordRightLabel;
	@FXML
	private Label confirmPasswordRightLabel;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private SystemManagerVO systemManager;

	public SystemManagerPasswordModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main main, SystemManagerVO systemManager2) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.systemManager = systemManager2;
		this.SystemManagerPasswordModifyShow();
	}

	public void SystemManagerPasswordModifyShow() {
		leftIdLabel.setText(systemManager.getId());
		leftNameLabel.setText(systemManager.getUserName());
		idLabel.setText(systemManager.getId());
		nameLabel.setText(systemManager.getUserName());
		this.passwordRightLabel.setVisible(false);
		this.newPasswordRightLabel.setVisible(false);
		this.confirmPasswordRightLabel.setVisible(false);

	}

	public void handleSave() {
		String passwordInField = this.passWord.getText();
		String newPasswordInField = this.newPassword.getText();
		String comfirmPasswordInField = this.confirmPassword.getText();
		String originalPassword = this.systemManager.getPassword();

		boolean isPasswordOK = passwordInField == originalPassword;
		boolean isNewPasswordOK = newPasswordInField == comfirmPasswordInField;
		if (isPasswordOK && isNewPasswordOK) {
			this.systemManager.setPassword(newPasswordInField);

			// bl层方法，修改密码
			this.blservice.modifyPassword(this.systemManager.getId(), comfirmPasswordInField);

			this.mainScene.showSystemManagerInfoScene(systemManager);
		} else if (!isPasswordOK) {
			this.passwordRightLabel.setVisible(true);
			this.passwordRightLabel.setText("原密码错误！");
		} else if (!isNewPasswordOK) {
			this.confirmPasswordRightLabel.setVisible(true);
			this.confirmPasswordRightLabel.setText("两次输入的密码不一致！");
		}
	}

	public void handleBack() {
		this.mainScene.showSystemManagerInfoScene(systemManager);
	}
}
