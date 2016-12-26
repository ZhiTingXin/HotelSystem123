package presentation.controller.userInfoController;

import java.util.Optional;

import VO.SystemStaffVO;
import blservice.Login_blservice;
import blservice.UserInfo_blservice;
import blservice.impl.Login_bl;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
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
	private Login_blservice login_blservice;

	public SystemStaffPasswordModifyController() {
		blservice = new UserInfo_bl();
		login_blservice = new Login_bl();
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaff2) {
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
		if (passwordInField.equals("")) {
			Alert alert = new  Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setContentText("请先输入原密码");
			alert.showAndWait();
		}else {
			boolean isPasswordOK = login_blservice.comfirm(systemStaff.getId(), passwordInField);
			if(!newPasswordInField.equals("")){
				boolean isNewPasswordOK = (newPasswordInField.equals(comfirmPasswordInField));
				if (isPasswordOK && isNewPasswordOK) {
					this.systemStaff.setPassword(newPasswordInField);

					// bl层方法，修改密码
					this.blservice.modifyPassword(systemStaff.getId(), comfirmPasswordInField);
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("恭喜");
					alert.setContentText("修改成功");
					alert.showAndWait();
					this.mainScene.showSystemStaffInfoScene(systemStaff);
				} else if (!isPasswordOK) {
					this.passwordRightLabel.setVisible(true);
					this.passwordRightLabel.setText("原密码错误！");
				} else if (!isNewPasswordOK) {
					this.confirmPasswordRightLabel.setVisible(true);
					this.confirmPasswordRightLabel.setText("两次输入的密码不一致！");
				}
			}else{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("抱歉");
				alert.setContentText("请先输入新密码");
				alert.showAndWait();
			}
		}
		
	
	}

	public void handleBack() {
		if (!newPassword.getText().equals("")||!passWord.getText().equals("")||!confirmPassword.getText().equals("")) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("提示");
			alert.setContentText("退出将不会保存您做出的修改，是否退出？");
			ButtonType yes = new ButtonType("是");
			ButtonType  no = new ButtonType("否");
			alert.getButtonTypes().setAll(yes,no);
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get() == yes) {
				this.mainScene.showSystemStaffInfoScene(systemStaff);
			}
		}else {
			this.mainScene.showSystemStaffInfoScene(systemStaff);
		}
	}
}
