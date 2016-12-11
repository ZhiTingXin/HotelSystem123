package presentation.controller.userManagementController;

import VO.HotelStaffVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;
import other.ResultMessage;

public class SystemManagerHotelStaffInfoModifyController {

	@FXML
	private  Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button save;
	@FXML
	private Button cancel;
	@FXML
	private Label idLabel;
	@FXML
	private TextField name;
	@FXML
	private Label hotelId;
	@FXML
	private Label hotelName;
	@FXML
	private Button changePicture;
	
	private Main mainScene;
	private UserInfo_blservice blservice;
	private HotelStaffVO hotelStaff;
	
	public SystemManagerHotelStaffInfoModifyController() {
		blservice = new UserInfo_bl();
	}
	
	private void getHotelStaffInfo(String id) {
	}
	
	public void SystemManagerHotelStaffInfoModifyShow(Main mainScene) {
		this.mainScene = mainScene;
		
	}
}
