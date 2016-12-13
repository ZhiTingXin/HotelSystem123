package presentation.controller.userManagementController;

import VO.HotelStaffVO;
import VO.SystemManagerVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;

public class SystemManagerHotelStaffInfoViewController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button modifyInfo;
	@FXML
	private Button back;
	@FXML
	private Label idLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label hotelId;
	@FXML
	private Label hotelName;
	@FXML
	private ImageView image;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private SystemManagerVO systemManagerVO;
	private HotelStaffVO hotelStaffVO;
	
	public SystemManagerHotelStaffInfoViewController() {
		blservice = new UserInfo_bl();
	}
	
	public void initialize(Main mainScene ,SystemManagerVO systemManagerVO,HotelStaffVO hotelStaffVO) {
		//left
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		this.hotelStaffVO = hotelStaffVO;
		
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		
		SystemManagerHotelStaffInfoViewShow(this.mainScene);
	}
	
	public void SystemManagerHotelStaffInfoViewShow(Main mainScene) {
		//显示
		idLabel.setText(hotelStaffVO.getId());
		nameLabel.setText(hotelStaffVO.getUsername());
		hotelId.setText(hotelStaffVO.getHotelId());
		hotelName.setText(hotelStaffVO.getHotelName());
	}
	
	@FXML//修改信息
	private void handleModify() {
		mainScene.showSystemManagerHotelStaffInfoModifyScene(systemManagerVO, hotelStaffVO);
	}
	
	@FXML//返回
	private void handleBack(){
		mainScene.showHotelStaffManagementScene(systemManagerVO);
	}
}
