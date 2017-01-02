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
		// �����ж����
		boolean isPasswordReady = userPasswordInField.equals(userPasswordConfirmInField);
		boolean isPasswordRight = !userPasswordInField.equals("");
		boolean isNameReady = !userNameInField.equals("");
		boolean isPasswordIllegal = this.isPasswordIllegal(userPasswordInField);
		boolean isPhoneReady = !phone.equals("");
		if (!isNameReady) {
			this.errorLabel.setVisible(true);
			this.errorLabel.setText("�������û�����");
		} else {
			if (!isPasswordRight) {
				this.errorLabel.setVisible(true);
				this.errorLabel.setText("���������룡");
			} else if (isPasswordIllegal) {
				this.errorLabel.setVisible(true);
				this.errorLabel.setText("������������룬���������룡");
			} else {
				if (!isPasswordReady) {
					this.errorLabel.setVisible(true);
					this.errorLabel.setText("������������벻һ�£�");
				} else {
					if (!isPhoneReady) {
						this.errorLabel.setVisible(true);
						this.errorLabel.setText("������������ϵ��ʽ");
					}
				}
			}
		}
		if (isPasswordReady && isNameReady && isPasswordRight && isPhoneReady && !isPasswordIllegal) {
			// bl�㴴�����û�
			{
				customer = new CustomerVO();
				customer.setUsername(userNameInField);
				customer.setPassword(userPasswordConfirmInField);
				customer.setPhone(phone);
				customer.setCredit(300);
				customer.setImage("default.png");
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

	@FXML
	private void handleCancel() {
		this.mainScene.showLoginScene();
	}

	/**
	 * ע��ʱ����Ϸ��Ե���֤���� �������֡���ĸ�Ͱ����ո����ڵķ���
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
