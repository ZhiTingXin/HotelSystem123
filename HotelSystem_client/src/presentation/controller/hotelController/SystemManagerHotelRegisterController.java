package presentation.controller.hotelController;

import VO.SystemManagerVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;

public class SystemManagerHotelRegisterController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button  save;//保存并分配酒店工作人员
	@FXML
	private Button back;
	@FXML
	private TextField  hotelName;//预定客房
	@FXML
	private MenuButton district;
	
	private Main mainScene;
	private SystemManagerVO systemManagerVO;
	private Hotel_blservice hotel_blservice;
	
	public SystemManagerHotelRegisterController() {
		hotel_blservice = new Hotel_bl();
	}

	public void initialize(Main mainScene,SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		leftIdLabel.setText(systemManagerVO.getId());
		leftNameLabel.setText(systemManagerVO.getUserName());
	}
	@FXML
	private void handleSave(){
		
	}
}
