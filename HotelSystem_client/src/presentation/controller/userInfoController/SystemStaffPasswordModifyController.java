package presentation.controller.userInfoController;

import VO.SystemStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import main.Main;

public class SystemStaffPasswordModifyController {

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
	private SystemStaffVO systemStaff;

	public SystemStaffPasswordModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaff2) {
		// TODO Auto-generated method stub
		this.mainScene = mainScene;
		this.systemStaff = systemStaff2;
		this.SystemStaffPasswordModifyShow();
	}

	public void SystemStaffPasswordModifyShow() {
		this.idLabel.setText(this.systemStaff.getId());
		this.nameLabel.setText(this.systemStaff.getUsername());
		this.leftIdLabel.setText(this.systemStaff.getId());
		this.leftNameLabel.setText(this.systemStaff.getUsername());
		this.passwordRightLabel.setVisible(false);
		this.newPasswordRightLabel.setVisible(false);
		this.confirmPasswordRightLabel.setVisible(false);

	}

	public void handleSave() {
		String passwordInField = this.passWord.getText();
		String newPasswordInField = this.newPassword.getText();
		String comfirmPasswordInField = this.confirmPassword.getText();
		String originalPassword = this.systemStaff.getPassword();

		boolean isPasswordOK = passwordInField == originalPassword;
		boolean isNewPasswordOK = newPasswordInField == comfirmPasswordInField;
		if (isPasswordOK && isNewPasswordOK) {
			this.systemStaff.setPassword(newPasswordInField);

			// bl层方法，修改密码
			this.blservice.modifyPassword(systemStaff.getId(), comfirmPasswordInField);

			this.mainScene.showSystemStaffInfoScene(systemStaff);
		} else if (!isPasswordOK) {
			this.passwordRightLabel.setVisible(true);
			this.passwordRightLabel.setText("原密码错误！");
		} else if (!isNewPasswordOK) {
			this.confirmPasswordRightLabel.setVisible(true);
			this.confirmPasswordRightLabel.setText("两次输入的密码不一致！");
		}
	}

	public void handleBack() {
		this.mainScene.showSystemStaffInfoScene(systemStaff);
	}
}
