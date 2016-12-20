package presentation.controller.hotelController;

import java.rmi.RemoteException;

import PO.LoginPO;
import RMI.RemoteHelper;
import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import blservice.UserManagement_blservice;
import blservice.impl.UserManagement_bl;
import data.service.LoginDataService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;
import other.UserType;

public class SystemManagerHotelRegisterShowIDController {

	@FXML
	private Label hotelId;
	@FXML
	private Label hotelName;
	@FXML
	private Label district;
	@FXML
	private Label HotelStaffID;
	@FXML
	private Button back;
	
	private Main mainScene;
	private SystemManagerVO systemManagerVO;
	private UserManagement_blservice userManagement_blservice;
	
	public SystemManagerHotelRegisterShowIDController(){	
		userManagement_blservice = new UserManagement_bl();
	}
	
	public void SystemManagerHotelRegisterShowIDShow(Main mainScene,SystemManagerVO systemManagerVO,HotelInfoVO hotelInfoVO,HotelStaffVO hotelStaffVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		
		String hotelID = hotelInfoVO.getHotelID();
		hotelId.setText(hotelID);//hotel id
		hotelName.setText(hotelInfoVO.getHotelName());//hotel name
		district.setText(hotelInfoVO.getHotelDistrict());//hotel district
		String hotelStaffID = hotelStaffVO.getId();
		HotelStaffID.setText(hotelStaffID);//hotel staff id
		
		LoginPO loginPO = new LoginPO(hotelStaffVO.getId(),hotelStaffVO.getPassword(),UserType.HOTELSTAFF);
		LoginDataService loginDataService = RemoteHelper.getInstance().getLoginDataService();
		try {
			loginDataService.add(loginPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		userManagement_blservice.addHotelStaff(hotelStaffVO);//´æ´¢hotel Staff
		
	}
	@FXML
	public void handleOK(){
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}
}
