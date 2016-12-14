package main;

import java.time.LocalDate;

import VO.SystemManagerVO;
import blservice.UserManagement_blservice;
import blservice.impl.UserManagement_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class SystemManagerMainController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button userManagment;
	@FXML
	private Button newHotel;
	@FXML
	private Button maintainPersonalInfo;// ά��������Ϣ
	@FXML
	private Button exit;
	@FXML
	private Label dateTime;
	@FXML
	private Label userNumber;
	@FXML
	private Label hotelNumber;
	@FXML
	private Label hotelStaffNumber;
	@FXML
	private Label systemStaffNumber;
	@FXML
	private Label todayOrderNumber;
	@FXML
	private Label orderNumber;

	private Main mainScene;
	private SystemManagerVO systemManagerVO;
	private UserManagement_blservice userManagement_blservice;

	public SystemManagerMainController() {
		userManagement_blservice = new UserManagement_bl();
	}

	public void initilize(Main mainScene, SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
	}

	public void SystemManagerMainShow(Main mainScene) {
		// ����
		leftIdLabel.setText(systemManagerVO.getId());
		leftNameLabel.setText(systemManagerVO.getUserName());
		// ����
		LocalDate nowDate = LocalDate.now();
		dateTime.setText(util.DateUtil.format(nowDate));
		userNumber.setText(String.valueOf(userManagement_blservice.getCustomerNum()));
		hotelNumber.setText(String.valueOf(userManagement_blservice.getHotelStaffNum()));
		hotelStaffNumber.setText(String.valueOf(userManagement_blservice.getHotelStaffNum()));
		systemStaffNumber.setText(String.valueOf(userManagement_blservice.getSystemStaffNum()));
		todayOrderNumber.setText(String.valueOf(userManagement_blservice.getTodayOrderNumberNum()));
		orderNumber.setText(String.valueOf(userManagement_blservice.getOrderNumber()));

	}

	@FXML
	private void handleUserManagement() {
		mainScene.showCustomerManagementScene(systemManagerVO);
	}

	@FXML
	private void handleRegisteNewHotel() {
		mainScene.showSystemManagerHotelRegisterScene(systemManagerVO);
	}

	@FXML
	private void handleMaintainMyInfo() {
		mainScene.showSystemManagerInfoScene(systemManagerVO);
	}

	@FXML
	private void handleExit() {
		mainScene.showLoginScene();
	}
}