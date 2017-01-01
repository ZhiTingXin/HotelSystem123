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

	@FXML
	private void HotelStaffPasswordModifyShow() {
		this.nameLabel.setText(this.hotelStaff.getUsername());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
		this.idLabel.setText(this.hotelStaff.getId());
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.passwordRightLabel.setVisible(false);
		this.newPasswordRightLabel.setVisible(false);
		this.confirmPasswordRightLabel.setVisible(false);
	}

	@FXML
	private void handleSave() {
		String passwordInField = this.passWord.getText();// ����ԭ����
		String newPasswordInField = this.newPassword.getText();// ����������
		String comfirmPasswordInField = this.confirmPassword.getText();// ȷ��������
		String id = this.hotelStaff.getId();
		if (passwordInField.equals("")) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ʾ");
			alert.setContentText("��������ԭ����");
			alert.showAndWait();
		} else {
			boolean isPasswordOK = loginService.comfirm(id, passwordInField);// �ж�����ԭ�����Ƿ���ȷ
			if (!newPasswordInField.equals("")) {
				boolean isNewPasswordOK = newPasswordInField.equals(comfirmPasswordInField);
				if (isPasswordOK && isNewPasswordOK) {
					// bl�㷽�����޸�����
					boolean isModify = this.blservice.modifyPassword(this.hotelStaff.getId(), comfirmPasswordInField);

					if (isModify) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("��ϲ");
						alert.setContentText("���ѳɹ��޸��������룡");

						Optional<ButtonType> btn = alert.showAndWait();
						if (btn.get() == ButtonType.OK) {
							this.mainScene.showHotelStaffInfoScene(hotelStaff);
						}
					} else {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("��Ǹ");
						alert.setContentText("������˼���޸�����ʧ�ܣ�");
						alert.showAndWait();
					}

				} else if (!isPasswordOK) {// �ж�����ԭ�����Ƿ���ȷ
					this.passwordRightLabel.setVisible(true);
					this.passwordRightLabel.setText("ԭ�������");
				} else if (!isNewPasswordOK) {
					this.confirmPasswordRightLabel.setVisible(true);
					this.confirmPasswordRightLabel.setText("������������벻һ�£�");
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("��Ǹ");
				alert.setContentText("��������������");
				alert.showAndWait();
			}
		}
	}

	@FXML
	private void handleBack() {
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
				this.mainScene.showHotelStaffInfoScene(hotelStaff);
			}
		} else {
			this.mainScene.showHotelStaffInfoScene(hotelStaff);
		}
	}
}
