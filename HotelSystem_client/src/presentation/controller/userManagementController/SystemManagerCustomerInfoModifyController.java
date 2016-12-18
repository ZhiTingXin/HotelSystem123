package presentation.controller.userManagementController;

import java.util.Optional;
import VO.CustomerVO;
import VO.SystemManagerVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

public class SystemManagerCustomerInfoModifyController {

	@FXML
	private Button save;
	@FXML
	private Button back;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Label idLabel;
	@FXML
	private Label memberLabel;
	@FXML
	private Label creditLabel;
	@FXML
	private TextField nameTextField;
	@FXML
	private DatePicker datePicker;
	@FXML
	private TextField companyTextField;
	@FXML
	private Button loadPicture;

	private Main mainScene;
	private CustomerVO customerVO;
	private SystemManagerVO systemManagerVO;
	private UserInfo_blservice userInfo_blservice;

	public SystemManagerCustomerInfoModifyController() {
		userInfo_blservice = new UserInfo_bl();
	}

	public void initialize(Main mainScene, SystemManagerVO systemManagerVO, CustomerVO customerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		this.customerVO = customerVO;
		// left
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		SystemManagerCustomerInfoModifyShow(mainScene);
	}


	public void SystemManagerCustomerInfoModifyShow(Main m) {
		idLabel.setText(this.customerVO.getId());
		nameTextField.setText(this.customerVO.getUsername());
		memberLabel.setText(String.valueOf(this.customerVO.getMemberGrade()));
		creditLabel.setText(String.valueOf(this.customerVO.getCredit()));
		datePicker.setConverter(util.DateUtil.converter);
		datePicker.setValue(this.customerVO.getBirthday());
		companyTextField.setText(this.customerVO.getCompanyName());
	}

	@FXML
	private void handleSave() {
		 customerVO.setId(idLabel.getText());
		 customerVO.setUsername(nameTextField.getText());
		 customerVO.setMemberGrade(Integer.parseInt(memberLabel.getText()));
		 customerVO.setBirthday(datePicker.getValue());
		 customerVO.setCompanyName(companyTextField.getText());
		 customerVO.setCredit(Integer.parseInt(creditLabel.getText()));

		boolean isModify = userInfo_blservice.modifyCustomer(customerVO);

		if (isModify) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("恭喜");
			alert.setHeaderText("修改成功");
			alert.setContentText("您已成功修改一条客户信息");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				mainScene.showSystemManagerCustomerInfoViewScene(systemManagerVO, customerVO);
			}
			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("修改失败");
			alert.setContentText("不好意思，您未能成功修改客户信息！");
			alert.showAndWait();
		}
	}
	@FXML
	private void handleBack(){
		mainScene.showSystemManagerCustomerInfoViewScene(systemManagerVO, customerVO);
	}
}
