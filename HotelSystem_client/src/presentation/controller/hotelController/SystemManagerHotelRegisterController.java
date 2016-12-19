package presentation.controller.hotelController;



import javafx.scene.control.MenuItem;
import java.util.Optional;

import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	private TextField  hotelName;//客房
	@FXML
	private MenuButton district;
	@FXML
	private MenuItem district1;
	@FXML
	private MenuItem district2;
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
		String name = hotelName.getText();
		String districtName = district.getText();
		
		HotelInfoVO newHotel = new HotelInfoVO();
		newHotel.setHotelName(name);
		newHotel.setHotelDistrict(districtName);
		
		boolean isModify = hotel_blservice.addHotel(newHotel);

		HotelStaffVO hotelStaffVO = new HotelStaffVO();
		hotelStaffVO.setHotelName(name);
		newHotel.setHotelStaffId(hotelStaffVO.getId());
		hotelStaffVO.setPassword(hotelStaffVO.getId());
		hotelStaffVO.setHotelId(newHotel.getHotelID());
		if (isModify) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("恭喜");
			alert.setHeaderText("新增成功");
			alert.setContentText("您已成功新增一条酒店信息");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				mainScene.showSystemManagerHotelRegisterShowIDScene(systemManagerVO,newHotel,hotelStaffVO);
			}
			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("修改失败");
			alert.setContentText("不好意思，您未能成功新增酒店信息！");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleDistrict1(){
		district.setText("新街口");
	}
	@FXML
	private void handleDistrict2(){
		district.setText("仙林中心");
	}
	@FXML
	private void handleBack(){
		mainScene .showSystemManagerMainScene(systemManagerVO);
	}
}
