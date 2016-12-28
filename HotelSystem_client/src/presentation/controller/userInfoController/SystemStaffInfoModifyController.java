package presentation.controller.userInfoController;

import java.util.Optional;

import VO.SystemStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class SystemStaffInfoModifyController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView myPicture;
	@FXML
	private ImageView changedPicture;
	@FXML
	private Button save;
	@FXML
	private Button back;
	@FXML
	private Label idLabel;
	@FXML
	private TextField nameField;
	@FXML
	private Button changePicture;
	@FXML
	private TextField phoneTextField;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private SystemStaffVO systemStaff;

	public SystemStaffInfoModifyController() {
		blservice = new UserInfo_bl();
	}

	public void SystemStaffInfoModifyShow() {
		this.idLabel.setText(this.systemStaff.getId());
		this.nameField.setText(this.systemStaff.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(this.systemStaff.getImage()));
		this.changedPicture.setImage(ImageUtil.setImage(this.systemStaff.getImage()));
		this.leftIdLabel.setText(this.systemStaff.getId());
		this.leftNameLabel.setText(this.systemStaff.getUsername());
	    this.phoneTextField.setText(this.systemStaff.getPhone());

	}

	public void initialize(Main mainScene, SystemStaffVO systemStaff) {
		this.mainScene = mainScene;
		this.systemStaff = systemStaff;
		this.SystemStaffInfoModifyShow();
	}

	public void handleSave() {
		if (!this.nameField.getText().equals("")) {
			this.systemStaff.setUsername(this.nameField.getText());
		}
		if (!this.phoneTextField.getText().equals("")) {
			 this.systemStaff.setPhone(this.phoneTextField.getText());
		}
		this.blservice.modifySystemStaff(systemStaff);
		this.mainScene.showSystemStaffInfoScene(systemStaff);
	}

	public void handleBack() {
		if(!this.phoneTextField.getText().equals(systemStaff.getPhone())||
				!this.nameField.getText().equals(systemStaff.getUsername())){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("提醒");
			alert.setHeaderText("退出我们将不会对你做出的修改进行保存");
			alert.setContentText("是否退出");
			ButtonType yes = new ButtonType("是");
			ButtonType no = new ButtonType("否");
			alert.getButtonTypes().setAll(yes,no);
			Optional<ButtonType> btn = alert.showAndWait();
			if(btn.get()==yes){
				this.mainScene.showSystemStaffInfoScene(systemStaff);
			}
		}else{
			this.mainScene.showSystemStaffInfoScene(systemStaff);
		}
	}
	
	@FXML
	private void handleChange(){
		this.systemStaff.setImage(ImageUtil.setImagePath(changedPicture));
	}
}
