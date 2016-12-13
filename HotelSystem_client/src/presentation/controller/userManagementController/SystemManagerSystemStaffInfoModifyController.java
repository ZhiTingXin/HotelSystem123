package presentation.controller.userManagementController;

import java.util.Optional;

import VO.SystemManagerVO;
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

public class SystemManagerSystemStaffInfoModifyController {

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
	private TextField nameField;
	@FXML
	private Label businessDistrictLabel;
	@FXML
	private Button changePicture;
	@FXML
	private ImageView myPicture;
	
	private Main mainScene;
	private UserInfo_blservice blservice;
	private SystemStaffVO systemStaffVO;
	private SystemManagerVO systemManagerVO;
	
	public SystemManagerSystemStaffInfoModifyController() {
		blservice = new UserInfo_bl();
	}
	public void initialize(Main mainScene,SystemManagerVO systemManagerVO,SystemStaffVO systemStaffVO) {
		this.mainScene = mainScene;
		this.systemManagerVO =systemManagerVO;
		this.systemStaffVO = systemStaffVO;
		//left
		leftIdLabel.setText(systemManagerVO.getId());
		leftNameLabel.setText(systemManagerVO.getUserName());
		SystemManagerSystemStaffInfoModifyShow(mainScene);
	}
	
	public void SystemManagerSystemStaffInfoModifyShow(Main mainScene) {
		idLabel.setText(systemStaffVO.getId());
		nameField.setText(systemStaffVO.getUsername());
		businessDistrictLabel.setText(systemStaffVO.getBusinessDistrict());
		
	}
	@FXML
	private void handleSave(){
		String idString = idLabel.getText();
		String name = nameField.getText();
		String district = businessDistrictLabel.getText();
		
		systemStaffVO = new SystemStaffVO(idString, name,district);
		boolean isModify = blservice.modifySystemStaff(systemStaffVO);
		

		if (isModify) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ϲ");
			alert.setHeaderText("�޸ĳɹ�");
			alert.setContentText("���ѳɹ��޸�һ����վӪ����Ա��Ϣ");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				mainScene.showSystemManagerSystemStaffInfoViewScene(systemManagerVO, systemStaffVO);
			}
			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("�޸�ʧ��");
			alert.setContentText("������˼����δ�ܳɹ��޸���վӪ����Ա��Ϣ��");
			alert.showAndWait();
		}
	}
	@FXML
	private void handleBack(){
		mainScene.showSystemManagerSystemStaffInfoViewScene(systemManagerVO, systemStaffVO);
	}
}
