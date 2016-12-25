package presentation.controller.userInfoController;

import java.util.Optional;

import VO.SystemManagerVO;
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

public class SystemManagerPasswordModifyController {

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
	private SystemManagerVO systemManager;
	private Login_blservice login_blservice;

	public SystemManagerPasswordModifyController() {
		blservice = new UserInfo_bl();
		login_blservice = new Login_bl();
	}

	public void initialize(Main main, SystemManagerVO systemManager2) {

		this.mainScene = main;
		this.systemManager = systemManager2;
		this.SystemManagerPasswordModifyShow();
	}

	public void SystemManagerPasswordModifyShow() {
		leftIdLabel.setText(systemManager.getId());
		leftNameLabel.setText(systemManager.getUserName());
		idLabel.setText(systemManager.getId());
		nameLabel.setText(systemManager.getUserName());
		this.passwordRightLabel.setVisible(false);
		this.newPasswordRightLabel.setVisible(false);
		this.confirmPasswordRightLabel.setVisible(false);

	}

	public void handleSave() {
		String passwordInField = this.passWord.getText();//����ԭ����
		String newPasswordInField = this.newPassword.getText();//����������
		String comfirmPasswordInField = this.confirmPassword.getText();//ȷ��������
		String id = this.systemManager.getId();
        if (passwordInField.equals("")) {
			Alert alert = new  Alert(AlertType.INFORMATION);
			alert.setTitle("��ʾ");
			alert.setContentText("��������ԭ����");
			alert.showAndWait();
		}
		boolean isPasswordOK = login_blservice.comfirm(id, passwordInField);//�ж�����ԭ�����Ƿ���ȷ
		if(!newPasswordInField.equals("")){
			boolean isNewPasswordOK = newPasswordInField .equals(comfirmPasswordInField);
			if (isPasswordOK && isNewPasswordOK) {
				// bl�㷽�����޸�����
			boolean isModify = 	this.blservice.modifyPassword(this.systemManager.getId(), comfirmPasswordInField);
			
			if (isModify) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("��ϲ");
				alert.setContentText("���ѳɹ��޸��������룡");
				
				Optional<ButtonType> btn = alert.showAndWait();
				if (btn.get() == ButtonType.OK) {
					this.mainScene.showSystemManagerInfoScene(systemManager);
				}
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("��Ǹ");
				alert.setContentText("������˼���޸�����ʧ�ܣ�");
				alert.showAndWait();
			}

			} else if (!isPasswordOK) {//�ж�����ԭ�����Ƿ���ȷ
				this.passwordRightLabel.setVisible(true);
				this.passwordRightLabel.setText("ԭ�������");
			} else if (!isNewPasswordOK) {
				this.confirmPasswordRightLabel.setVisible(true);
				this.confirmPasswordRightLabel.setText("������������벻һ�£�");
			}
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��Ǹ");
			alert.setContentText("��������������");
			alert.showAndWait();
		}
	}

	public void handleBack() {
		if (!newPassword.getText().equals("")||!passWord.getText().equals("")||!confirmPassword.getText().equals("")) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("��ʾ");
			alert.setContentText("�˳������ᱣ�����������޸ģ��Ƿ��˳���");
			ButtonType yes = new ButtonType("��");
			ButtonType  no = new ButtonType("��");
			alert.getButtonTypes().setAll(yes,no);
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get() == yes) {
				this.mainScene.showSystemManagerInfoScene(systemManager);
			}
		}else {
			this.mainScene.showSystemManagerInfoScene(systemManager);
		}
	}
}
