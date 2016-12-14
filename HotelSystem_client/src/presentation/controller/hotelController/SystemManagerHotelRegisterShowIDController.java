package presentation.controller.hotelController;

import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import blservice.IdGernerateService;
import blservice.impl.IdGernerateServiceImpl;
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
	private IdGernerateService idGernerateService;
	private SystemManagerVO systemManagerVO;
	private HotelStaffVO hotelStaffVO;
	
	public SystemManagerHotelRegisterShowIDController(){	
		idGernerateService = new IdGernerateServiceImpl();
	}
	
	public void SystemManagerHotelRegisterShowIDShow(Main mainScene,SystemManagerVO systemManagerVO,HotelInfoVO hotelInfoVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		
		hotelId.setText(idGernerateService.gernerateId());
		hotelName.setText(hotelInfoVO.getHotelName());
		district.setText(hotelInfoVO.getHotelDistrict());
		HotelStaffID.setText(idGernerateService.gernerateId());
	}
	@FXML
	public void handleOK(){
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}
}
