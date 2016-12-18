package presentation.controller.loginController;

import blservice.Login_blservice;
import blservice.UserManagement_blservice;
import blservice.impl.Login_bl;
import blservice.impl.UserManagement_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

	private Main mainScene;
	private Login_blservice loginService;
	private UserManagement_blservice usermanagementService;

	public LoginController() {

	}

	public void initialize(Main main) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.loginService = new Login_bl();
		this.usermanagementService = new UserManagement_bl();
		this.LoginShow();
	}

	public void LoginShow() {
		this.userId.setPromptText("请输入您的ID");
		this.userPassword.setPromptText("请输入您的密码");
	}

	public void handleLogin() {
		String userIdInField = this.userId.getText();
		String userPasswordInField = this.userPassword.getText();
		boolean isComfirm = this.loginService.comfirm(userIdInField, userPasswordInField);
		if (isComfirm) {

			// 待修改方法
			UserType loginType = this.loginService.assertUserType(userIdInField);
			if (loginType==UserType.CUSTOMER) {
				this.mainScene.showCustomerMainScene(this.usermanagementService.getCustomer(userIdInField));
			}
			if (loginType==UserType.HOTELSTAFF) {
				this.mainScene.showHotelStaffMainScene(this.usermanagementService.getHotelStaff(userIdInField));
			}
			if (loginType==UserType.SYSTEMSTAFF) {
				this.mainScene.showSystemStaffMainScene(this.usermanagementService.getSystemStaff(userIdInField));
			}
			if (loginType==UserType.SYSTEMMANAGER) {
				this.mainScene.showSystemManagerMainScene(this.usermanagementService.getSystemManager(userIdInField));
			}

		}else System.out.println("Error");
	}

	public void handleRegister() {
		this.mainScene.showRegisterScene();
	}

}
