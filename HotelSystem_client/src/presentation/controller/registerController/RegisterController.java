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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
	private MenuButton setDistrict;
	@FXML
	private MenuItem setDistrictItem1;
	@FXML
	private MenuItem setDistrictItem2;
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

	public void handleComfirm() {
		String userNameInField = this.name.getText();
		String userPasswordInField = this.password.getText();
		String userPasswordConfirmInField = this.confirmPassword.getText();
		LocalDate userBirthday = this.birthday.getValue();
		String phone = this.phoneTextField.getText();
		// 条件判断语句
		boolean isPasswordReady = userPasswordInField.equals(userPasswordConfirmInField);
		boolean isPasswordRight = !userPasswordInField.equals("");
		boolean isNameReady = !userNameInField.equals("");

		if (!isNameReady) {
			this.errorLabel.setVisible(true);
			this.errorLabel.setText("请输入用户名！");
		} else if (!isPasswordRight) {
			this.errorLabel.setVisible(true);
			this.errorLabel.setText("请输入密码！");
		}
		if (!isPasswordReady) {
			this.errorLabel.setVisible(true);
			this.errorLabel.setText("两次输入的密码不一致！");
		}
		if (isPasswordReady && isNameReady && isPasswordRight == true) {
			// bl层创建新用户
			{
				customer = new CustomerVO();
				customer.setUsername(userNameInField);
				customer.setPassword(userPasswordConfirmInField);
				customer.setPhone(phone);
				customer.setCredit(300);
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

	public void handleCancel() {
		this.mainScene.showLoginScene();
	}

	public void handleDistrictMenuItem1() {
		this.setDistrict.setText(this.setDistrictItem1.getText());
	}

	public void handleDistrictMenuItem2() {
		this.setDistrict.setText(this.setDistrictItem2.getText());
	}

}
