package presentation.controller.hotelController;



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
	private Button  save;//���沢����Ƶ깤����Ա
	@FXML
	private Button back;
	@FXML
	private TextField  hotelName;//�ͷ�
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
		String name = hotelName.getText();
		String districtName = district.getText();
		
		HotelInfoVO newHotel = new HotelInfoVO();
		newHotel.setHotelName(name);
		newHotel.setHotelDistrict(districtName);
		
		boolean isModify = hotel_blservice.addHotel(newHotel);
		
		HotelStaffVO hotelStaffVO = new HotelStaffVO();
		if (isModify) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ϲ");
			alert.setHeaderText("�����ɹ�");
			alert.setContentText("���ѳɹ�����һ���Ƶ���Ϣ");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				mainScene.showSystemManagerHotelRegisterShowIDScene(systemManagerVO,newHotel,hotelStaffVO);
			}
			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("�޸�ʧ��");
			alert.setContentText("������˼����δ�ܳɹ������Ƶ���Ϣ��");
			alert.showAndWait();
		}
	}
	@FXML
	private void handleBack(){
		mainScene .showSystemManagerMainScene(systemManagerVO);
	}
}
