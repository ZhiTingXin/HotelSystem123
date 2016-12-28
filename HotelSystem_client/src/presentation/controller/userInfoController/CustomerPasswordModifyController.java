package presentation.controller.userInfoController;

import java.util.Optional;

import VO.CustomerVO;
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
	private Label StateLabel;
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
		this.login_blservice = new Login_bl();
		this.CustomerPasswordModifyShow();
	}

	public void CustomerPasswordModifyShow() {

		leftIdLabel.setText(customer.getId());
		leftNameLabel.setText(customer.getUsername());
		idLabel.setText(customer.getId());
		nameLabel.setText(customer.getUsername());

	}

	public void handleBack() {
		if (!newPassword.getText().equals("") || !passWord.getText().equals("")
				|| !confirmPassword.getText().equals("")) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("��ʾ");
			alert.setContentText("�˳������ᱣ�����������޸ģ��Ƿ��˳���");
			ButtonType yes = new ButtonType("��");
			ButtonType no = new ButtonType("��");
			alert.getButtonTypes().setAll(yes, no);
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get() == yes) {
				this.mainScene.showCustomerInfoScene(customer);
			}
		} else {
			this.mainScene.showCustomerInfoScene(customer);
		}
	}

	public void handleSave() {
		String passwordInField = this.passWord.getText();// ����ԭ����
		String newPasswordInField = this.newPassword.getText();// ����������
		String comfirmPasswordInField = this.confirmPassword.getText();// ȷ��������
		String id = this.customer.getId();
		if (passwordInField.equals("")) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ʾ");
			alert.setContentText("��������ԭ����");
			alert.showAndWait();
		} else {
			boolean isPasswordOK = login_blservice.comfirm(id, passwordInField);// �ж�����ԭ�����Ƿ���ȷ
			boolean isPasswordIllegal = this.isPasswordIllegal(newPasswordInField);// �ж�������������Ƿ�Ƿ�
			if (!newPasswordInField.equals("")) {
				boolean isNewPasswordOK = newPasswordInField.equals(comfirmPasswordInField);
				if (isPasswordOK && isNewPasswordOK && !isPasswordIllegal) {
					// bl�㷽�����޸�����
					boolean isModify = this.blservice.modifyPassword(this.customer.getId(), comfirmPasswordInField);

					if (isModify) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("��ϲ");
						alert.setContentText("���ѳɹ��޸��������룡");

						Optional<ButtonType> btn = alert.showAndWait();
						if (btn.get() == ButtonType.OK) {
							this.mainScene.showCustomerInfoScene(customer);
						}
					} else {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("��Ǹ");
						alert.setContentText("������˼���޸�����ʧ�ܣ�");
						alert.showAndWait();
					}

				} else if (!isPasswordOK) {// �ж�����ԭ�����Ƿ���ȷ
					this.StateLabel.setVisible(true);
					this.StateLabel.setText("ԭ�������");
				} else if (isPasswordIllegal) {
					this.StateLabel.setVisible(true);
					this.StateLabel.setText("������������롢���������룡");
				} else if (!isNewPasswordOK) {
					this.StateLabel.setVisible(true);
					this.StateLabel.setText("������������벻һ�£�");
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("��Ǹ");
				alert.setContentText("��������������");
				alert.showAndWait();
			}
		}
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
