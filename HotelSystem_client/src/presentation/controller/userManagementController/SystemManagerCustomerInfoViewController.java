package presentation.controller.userManagementController;

import VO.CustomerVO;
import VO.SystemManagerVO;
import blservice.UserManagement_blservice;
import blservice.impl.UserManagement_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;

public class SystemManagerCustomerInfoViewController {

	@FXML
	private Button modifyInfo;
	@FXML
	private Button modifyState;//更改用户状态（冻结/解冻）
	@FXML
	private Button back;
	@FXML
	private Label idLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label memberLabel;
	@FXML
	private Label birthdayLabel;
	@FXML
	private Label companyLabel;
	@FXML
	private Label creditLabel;
	@FXML
	private Label stateLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Label leftIdLabel;
	@FXML
	private ImageView leftImage;
	@FXML
	private ImageView image;
	
	private Main mainsence;
	private CustomerVO customerVO;
	private SystemManagerVO systemManagerVO;
	private UserManagement_blservice userManagement_blservice;

	public SystemManagerCustomerInfoViewController() {
		userManagement_blservice = new UserManagement_bl();
	}

	public void initialize(Main mainScene,SystemManagerVO systemManagerVO,CustomerVO customerVO) {
		this.mainsence = mainScene;
		this.systemManagerVO = systemManagerVO;
		this.customerVO =customerVO;
		//left
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		SystemManagerCustomerInfoViewShow(this.mainsence);
	}
	
	public void SystemManagerCustomerInfoViewShow(Main mainScene){
		idLabel.setText(customerVO.getId());
		nameLabel.setText(customerVO.getUsername());
		memberLabel.setText(String.valueOf(customerVO.getMemberGrade()));
		birthdayLabel.setText(util.DateUtil.format(customerVO.getBirthday()));//TODO
		companyLabel.setText(customerVO.getCompanyName());
		creditLabel.setText(String.valueOf(customerVO.getCredit()));
		image.setImage(null);
	}
	
	@FXML//
	private void handleModify(){
		mainsence.showSystemManagerCustomerInfoModifyScene(systemManagerVO, customerVO);
	}
	
	@FXML
	private void handleBack(){
		mainsence.showCustomerManagementScene(systemManagerVO);
	}
}
