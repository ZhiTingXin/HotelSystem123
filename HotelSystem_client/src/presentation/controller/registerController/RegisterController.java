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
		// �����ж����
		boolean isPasswordReady = userPasswordInField.equals(userPasswordConfirmInField);
		boolean isPasswordRight = !userPasswordInField.equals("");
		boolean isNameReady = !userNameInField.equals("");

		if (!isNameReady) {
			this.errorLabel.setVisible(true);
			this.errorLabel.setText("�������û�����");
		} else if (!isPasswordRight) {
			this.errorLabel.setVisible(true);
			this.errorLabel.setText("���������룡");
		}
		if (!isPasswordReady) {
			this.errorLabel.setVisible(true);
			this.errorLabel.setText("������������벻һ�£�");
		}
		if (isPasswordReady && isNameReady && isPasswordRight == true) {
			// bl�㴴�����û�
			{
				customer = new CustomerVO();
				customer.setUsername(userNameInField);
				customer.setPassword(userPasswordConfirmInField);
				customer.setPhone(phone);
				customer.setCredit(300);
				LogofUserVO logofUserVO = new LogofUserVO();
				logofUserVO.setChange(300);
				logofUserVO.setContent("ע��ʱ");
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
