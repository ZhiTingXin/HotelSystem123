package presentation.controller.hotelController;

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
	
	public SystemManagerHotelRegisterController() {

	}

	public void SystemManagerHotelRegisterShow(Main mainScene) {

	}
	
}
