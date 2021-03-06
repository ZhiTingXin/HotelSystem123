package presentation.controller.loginController;

import blservice.Login_blservice;
import blservice.UserManagement_blservice;
import blservice.impl.Login_bl;
import blservice.impl.UserManagement_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Main;
import other.UserType;

public class LoginController {

	@FXML
	private TextField userId;
	@FXML
	private PasswordField userPassword;
	@FXML
	private Button login;
	@FXML
	private Button register;
	@FXML
	private Label errorLabel;
	@FXML
	private Label errorLabel1;

	private Main mainScene;
	private Login_blservice loginService;
	private UserManagement_blservice usermanagementService;

	public LoginController() {

	}

	public void initialize(Main main) {
		this.mainScene = main;
		this.loginService = new Login_bl();
		this.usermanagementService = new UserManagement_bl();
		this.LoginShow();
	}

	@FXML
	private void LoginShow() {
		this.userId.setPromptText("����������ID");
		this.userPassword.setPromptText("��������������");

	}

	@FXML
	private void handleLogin() {
		this.errorLabel.setVisible(false);
		this.errorLabel1.setVisible(false);
		String userIdInField = this.userId.getText();
		String userPasswordInField = this.userPassword.getText();
		boolean isComfirm = this.loginService.comfirm(userIdInField, userPasswordInField);
		if (isComfirm) {
			// ���޸ķ���
			UserType loginType = this.loginService.assertUserType(userIdInField);
			if (loginType == UserType.CUSTOMER) {
				// if (true//this.loginService.isOnlineConfirm(userIdInField)) {
				// this.mainScene.showCustomerMainScene(this.usermanagementService.getCustomer(userIdInField));
				// //this.loginService.login(userIdInField);
				// } else {
				// this.errorLabel.setVisible(true);
				// this.errorLabel.setText("�޷��ظ���¼��");
				// }
				this.mainScene.showCustomerMainScene(this.usermanagementService.getCustomer(userIdInField));
			}
			if (loginType == UserType.HOTELSTAFF) {
				this.mainScene.showHotelStaffMainScene(this.usermanagementService.getHotelStaff(userIdInField));
			}
			if (loginType == UserType.SYSTEMSTAFF) {
				this.mainScene.showSystemStaffMainScene(this.usermanagementService.getSystemStaff(userIdInField));
			}
			if (loginType == UserType.SYSTEMMANAGER) {
				this.mainScene.showSystemManagerMainScene(this.usermanagementService.getSystemManager(userIdInField));
			}

		} else if (userIdInField.equals("")) {
			this.errorLabel1.setVisible(true);
			this.errorLabel1.setText("�������û���");
		} else if (!isComfirm) {
			this.errorLabel.setVisible(true);
			this.errorLabel.setText("�������");
		}

	}

	@FXML
	private void handleRegister() {
		this.mainScene.showRegisterScene();
	}

}
