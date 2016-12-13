package presentation.controller.loginController;

import VO.CustomerVO;
import VO.HotelStaffVO;
import blservice.Login_blservice;
import blservice.impl.Login_bl;
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

	public LoginController() {

	}

	public void initialize(Main main) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.loginService = new Login_bl();
		this.LoginShow();
	}

	public void LoginShow() {

	}

	public void handleLogin() {
		String userIdInField = this.userId.getText();
		String userPasswordInField = this.userPassword.getText();
		boolean isComfirm = this.loginService.comfirm(userIdInField, userPasswordInField);
		if (isComfirm) {
			
			//´ýÐÞ¸Ä·½·¨
			UserType loginType = this.loginService.assertUserType(userIdInField);
			if (loginType.equals(UserType.CUSTOMER)) {
				this.mainScene.showCustomerMainScene(new CustomerVO());
			}
			if (loginType.equals(UserType.HOTELSTAFF)) {
				this.mainScene.showHotelStaffMainScene(new HotelStaffVO());
			}
			if (loginType.equals(UserType.SYSTEMSTAFF)) {
				// this.mainScene.showCustomerMainScene(new CustomerVO());
			}
			if (loginType.equals(UserType.SYSTEMMANAGER)) {
				// this.mainScene.showCustomerMainScene(new CustomerVO());
			}

		}
	}

	public void handleRegister() {
		this.mainScene.showRegisterScene();
	}

}
