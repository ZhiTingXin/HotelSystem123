package presentation.controller.registerController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import VO.CustomerVO;
import VO.LogofUserVO;
import blservice.LogOfUser_blServce;
import blservice.Register_blservice;
import blservice.impl.LogOfUser_blServceImpl;
import blservice.impl.Register_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

public class RegisterController {

	@FXML
	private TextField name;
	@FXML
	private TextField password;
	@FXML
	private TextField confirmPassword;
	@FXML
	private DatePicker birthday;
	@FXML
	private Button confirm;
	@FXML
	private Button cancel;
	@FXML
	private Label errorLabel;
	@FXML
	private TextField phoneTextField;

	private Main mainScene;
	private Register_blservice registerService;
	private CustomerVO customer;
	private LogOfUser_blServce logOfUser_blServce;

	public void initialize(Main main) {
		registerService = new Register_bl();
		logOfUser_blServce = new LogOfUser_blServceImpl();
		this.mainScene = main;
	}

	public void RegisterShow() {
		this.errorLabel.setVisible(false);
	}

	@FXML
	private void handleComfirm() {
		String userNameInField = this.name.getText();
		String userPasswordInField = this.password.getText();
		String userPasswordConfirmInField = this.confirmPassword.getText();
		LocalDate userBirthday = this.birthday.getValue();
		String phone = this.phoneTextField.getText();
		// 条件判断语句
		boolean isPasswordReady = userPasswordInField.equals(userPasswordConfirmInField);
		boolean isPasswordRight = !userPasswordInField.equals("");
		boolean isNameReady = !userNameInField.equals("");
		boolean isPasswordIllegal = this.isPasswordIllegal(userPasswordInField);
		boolean isPhoneReady = !phone.equals("");
		if (!isNameReady) {
			this.errorLabel.setVisible(true);
			this.errorLabel.setText("请输入用户名！");
		} else {
			if (!isPasswordRight) {
				this.errorLabel.setVisible(true);
				this.errorLabel.setText("请输入密码！");
			} else if (isPasswordIllegal) {
				this.errorLabel.setVisible(true);
				this.errorLabel.setText("不符规则的密码，请重新输入！");
			} else {
				if (!isPasswordReady) {
					this.errorLabel.setVisible(true);
					this.errorLabel.setText("两次输入的密码不一致！");
				} else {
					if (!isPhoneReady) {
						this.errorLabel.setVisible(true);
						this.errorLabel.setText("请输入您的联系方式");
					}
				}
			}
		}
		if (isPasswordReady && isNameReady && isPasswordRight && isPhoneReady && !isPasswordIllegal) {
			// bl层创建新用户
			{
				customer = new CustomerVO();
				customer.setUsername(userNameInField);
				customer.setPassword(userPasswordConfirmInField);
				customer.setPhone(phone);
				customer.setCredit(300);
				customer.setImage("src/Img/default.PNG");
				LogofUserVO logofUserVO = new LogofUserVO();
				logofUserVO.setChange(300);
				logofUserVO.setContent("注册时");
				logofUserVO.setDateTime(LocalDateTime.now());

				logofUserVO.setUserid(customer.getId());
				if (userBirthday != null) {
					customer.setBirthday(userBirthday);
				}
				this.registerService.addRegister(customer);
				this.logOfUser_blServce.addLogOfUser(logofUserVO);
			}
			this.mainScene.showCustomerMainScene(customer);
		}
	}

	@FXML
	private void handleCancel() {
		this.mainScene.showLoginScene();
	}

	/**
	 * 注册时密码合法性的验证方法 允许数字、字母和包括空格在内的符号
	 * 
	 * @param password
	 * @return
	 */
	private boolean isPasswordIllegal(String password) {
		char[] passwordArray = password.toCharArray();
		if (passwordArray.length < 8 || passwordArray.length > 14)
			return true;
		int count = 0;
		while (count < passwordArray.length) {
			char ch = passwordArray[count];
			if (ch < 32 || ch > 126) {
				return true;
			}
			count++;
		}
		return false;
	}

}
