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
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class CustomerPasswordModifyController {
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView leftMenuImage;
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
		leftMenuImage.setImage(ImageUtil.setImage(customer.getImage()));
		idLabel.setText(customer.getId());
		nameLabel.setText(customer.getUsername());

	}

	public void handleBack() {
		if (!newPassword.getText().equals("") || !passWord.getText().equals("")
				|| !confirmPassword.getText().equals("")) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("提示");
			alert.setContentText("退出将不会保存您做出的修改，是否退出？");
			ButtonType yes = new ButtonType("是");
			ButtonType no = new ButtonType("否");
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
		String passwordInField = this.passWord.getText();// 输入原密码
		String newPasswordInField = this.newPassword.getText();// 输入新密码
		String comfirmPasswordInField = this.confirmPassword.getText();// 确认新密码
		String id = this.customer.getId();
		if (passwordInField.equals("")) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setContentText("请先输入原密码");
			alert.showAndWait();
		} else {
			boolean isPasswordOK = login_blservice.comfirm(id, passwordInField);// 判断输入原密码是否正确
			boolean isPasswordIllegal = this.isPasswordIllegal(newPasswordInField);// 判断输入的新密码是否非法
			if (!newPasswordInField.equals("")) {
				boolean isNewPasswordOK = newPasswordInField.equals(comfirmPasswordInField);
				if (isPasswordOK && isNewPasswordOK && !isPasswordIllegal) {
					// bl层方法，修改密码
					boolean isModify = this.blservice.modifyPassword(this.customer.getId(), comfirmPasswordInField);

					if (isModify) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("恭喜");
						alert.setContentText("您已成功修改您的密码！");

						Optional<ButtonType> btn = alert.showAndWait();
						if (btn.get() == ButtonType.OK) {
							this.mainScene.showCustomerInfoScene(customer);
						}
					} else {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("抱歉");
						alert.setContentText("不好意思，修改密码失败！");
						alert.showAndWait();
					}

				} else if (!isPasswordOK) {// 判断输入原密码是否正确
					this.StateLabel.setVisible(true);
					this.StateLabel.setText("原密码错误！");
				} else if (isPasswordIllegal) {
					this.StateLabel.setVisible(true);
					this.StateLabel.setText("不符规则的密码、请重新输入！");
				} else if (!isNewPasswordOK) {
					this.StateLabel.setVisible(true);
					this.StateLabel.setText("两次输入的密码不一致！");
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("抱歉");
				alert.setContentText("请先输入新密码");
				alert.showAndWait();
			}
		}
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
