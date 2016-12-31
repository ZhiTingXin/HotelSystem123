package presentation.controller.userInfoController;

import java.util.Optional;

import VO.HotelStaffVO;
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

public class HotelStaffPasswordModifyController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView myPicture;
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
	private PasswordField newPassword;
	@FXML
	private PasswordField confirmPassword;
	@FXML
	private Label passwordRightLabel;
	@FXML
	private Label newPasswordRightLabel;
	@FXML
	private Label confirmPasswordRightLabel;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private HotelStaffVO hotelStaff;
	private Login_blservice loginService;

	public HotelStaffPasswordModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main mainScene, HotelStaffVO hotelStaff) {
		this.mainScene = mainScene;
		this.hotelStaff = hotelStaff;
		this.loginService = new Login_bl();
		this.HotelStaffPasswordModifyShow();
	}

	public void HotelStaffPasswordModifyShow() {
		this.nameLabel.setText(this.hotelStaff.getUsername());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
		this.idLabel.setText(this.hotelStaff.getId());
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.passwordRightLabel.setVisible(false);
		this.newPasswordRightLabel.setVisible(false);
		this.confirmPasswordRightLabel.setVisible(false);
	}

	/**
	 * 未完成的方法
	 */
	public void handleSave() {
		String passwordInField = this.passWord.getText();//输入原密码
		String newPasswordInField = this.newPassword.getText();//输入新密码
		String comfirmPasswordInField = this.confirmPassword.getText();//确认新密码
		String id = this.hotelStaff.getId();
        if (passwordInField.equals("")) {
			Alert alert = new  Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setContentText("请先输入原密码");
			alert.showAndWait();
		}else{
			boolean isPasswordOK = loginService.comfirm(id, passwordInField);//判断输入原密码是否正确
			if(!newPasswordInField.equals("")){
				boolean isNewPasswordOK = newPasswordInField .equals(comfirmPasswordInField);
				if (isPasswordOK && isNewPasswordOK) {
					// bl层方法，修改密码
				boolean isModify = 	this.blservice.modifyPassword(this.hotelStaff.getId(), comfirmPasswordInField);
				
				if (isModify) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("恭喜");
					alert.setContentText("您已成功修改您的密码！");
					
					Optional<ButtonType> btn = alert.showAndWait();
					if (btn.get() == ButtonType.OK) {
						this.mainScene.showHotelStaffInfoScene(hotelStaff);
					}
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("抱歉");
					alert.setContentText("不好意思，修改密码失败！");
					alert.showAndWait();
				}

				} else if (!isPasswordOK) {//判断输入原密码是否正确
					this.passwordRightLabel.setVisible(true);
					this.passwordRightLabel.setText("原密码错误！");
				} else if (!isNewPasswordOK) {
					this.confirmPasswordRightLabel.setVisible(true);
					this.confirmPasswordRightLabel.setText("两次输入的密码不一致！");
				}
			}else{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("抱歉");
				alert.setContentText("请先输入新密码");
				alert.showAndWait();
			}
		}
	}

	public void handleBack() {
		if (!newPassword.getText().equals("")||!passWord.getText().equals("")||!confirmPassword.getText().equals("")) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("提示");
			alert.setContentText("退出将不会保存您做出的修改，是否退出？");
			ButtonType yes = new ButtonType("是");
			ButtonType  no = new ButtonType("否");
			alert.getButtonTypes().setAll(yes,no);
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get() == yes) {
				this.mainScene.showHotelStaffInfoScene(hotelStaff);
			}
		}else {
			this.mainScene.showHotelStaffInfoScene(hotelStaff);
		}
	}
}
