package presentation.controller.hotelController;

import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;

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
	private Hotel_blservice hotel_blservice;
	private SystemManagerVO systemManagerVO;
	private HotelStaffVO hotelStaffVO;
	
	public SystemManagerHotelRegisterShowIDController(){	
		hotel_blservice = new Hotel_bl();
	}
	
	public void SystemManagerHotelRegisterShowIDShow(Main mainScene,SystemManagerVO systemManagerVO,HotelInfoVO hotelInfoVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		
		hotelId.setText(hotel_blservice.genarateHotelID());
		hotelName.setText(hotelInfoVO.getHotelName());
		district.setText(hotelInfoVO.getHotelDistrict());
		HotelStaffID.setText(hotel_blservice.genarateHotelStaffID());
	}
	@FXML
	public void handleOK(){
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}
}
