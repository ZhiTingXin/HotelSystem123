package presentation.controller.userInfoController;

import VO.HotelStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import main.Main;

public class HotelStaffPasswordModifyController {

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
	private HotelStaffVO hotelStaff;

	public HotelStaffPasswordModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main mainScene, HotelStaffVO hotelStaff) {
		this.mainScene = mainScene;
		this.hotelStaff = hotelStaff;
		this.HotelStaffPasswordModifyShow();
	}

	public void HotelStaffPasswordModifyShow() {
		this.nameLabel.setText(this.hotelStaff.getUsername());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.idLabel.setText(this.hotelStaff.getId());
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.passwordRightLabel.setVisible(false);
		this.newPasswordRightLabel.setVisible(false);
		this.confirmPasswordRightLabel.setVisible(false);
	}

	/**
	 * 未完成的方法
	 */
	public void handleSave() {
		String passwordInField = this.passWord.getText();
		String newPasswordInField = this.newPassword.getText();
		String comfirmPasswordInField = this.confirmPassword.getText();
		String originalPassword = this.hotelStaff.getPassword();

		boolean isPasswordOK = passwordInField == originalPassword;
		boolean isNewPasswordOK = newPasswordInField == comfirmPasswordInField;
		if (isPasswordOK && isNewPasswordOK) {
			this.hotelStaff.setPassword(newPasswordInField);
			// bl层方法，修改密码
			this.blservice.modifyPassword(this.hotelStaff.getId(), comfirmPasswordInField);

			this.mainScene.showHotelStaffInfoScene(hotelStaff);
		} else if (!isPasswordOK) {
			this.passwordRightLabel.setVisible(true);
			this.passwordRightLabel.setText("原密码错误！");
		} else if (!isNewPasswordOK) {
			this.confirmPasswordRightLabel.setVisible(true);
			this.confirmPasswordRightLabel.setText("两次输入的密码不一致！");
		}
	}

	public void handleBack() {
		this.mainScene.showHotelStaffInfoScene(hotelStaff);
	}
}
