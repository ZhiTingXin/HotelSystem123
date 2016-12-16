package presentation.controller.userInfoController;

import VO.CustomerVO;
import blservice.Login_blservice;
import blservice.UserInfo_blservice;
import blservice.impl.Login_bl;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import main.Main;


public class CustomerPasswordModifyController {
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
	private Label passwordRightLabel;
	@FXML
	private Label newPasswordRightLabel;
	@FXML
	private Label confirmPasswordRightLabel;
	@FXML
	private PasswordField newPassword;
	@FXML
	private PasswordField confirmPassword;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private Login_blservice login_blservice;
	private CustomerVO customer;

	public CustomerPasswordModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main mainScene, CustomerVO customer) {
		this.customer = customer;
		this.mainScene = mainScene;
		this.login_blservice=new Login_bl();
		this.CustomerPasswordModifyShow();
	}

	public void CustomerPasswordModifyShow() {

		leftIdLabel.setText(customer.getId());
		leftNameLabel.setText(customer.getUsername());
		idLabel.setText(customer.getId());
		nameLabel.setText(customer.getUsername());
		
	}

	public void handleBack() {
		this.mainScene.showCustomerInfoScene(customer);
	}

	public void handleSave() {
		String passwordInField = this.passWord.getText();
		String newPasswordInField = this.newPassword.getText();
		String comfirmPasswordInField = this.confirmPassword.getText();
		

		boolean isPasswordOK = this.login_blservice.comfirm(this.customer.getId(), passwordInField);
		boolean isNewPasswordOK = newPasswordInField.equals(comfirmPasswordInField);
		if (isPasswordOK && isNewPasswordOK) {
			this.customer.setPassword(newPasswordInField);
			// bl�㷽�����޸�����
			this.blservice.modifyPassword(this.customer.getId(), comfirmPasswordInField);

			this.mainScene.showCustomerInfoScene(customer);
		} else if (!isPasswordOK) {
			this.passwordRightLabel.setVisible(true);
			this.passwordRightLabel.setText("ԭ�������");
		} else if (!isNewPasswordOK) {
			this.confirmPasswordRightLabel.setVisible(true);
			this.confirmPasswordRightLabel.setText("������������벻һ�£�");
		}
	}
}
