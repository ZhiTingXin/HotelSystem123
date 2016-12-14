package presentation.controller.hotelController;

import VO.HotelInfoVO;
import VO.HotelStaffVO;
import blservice.Hotel_blservice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;

//scene������Ҫ�� û��scene
//***************************
public class HotelStaffHotelInfoViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button modifyHotelInfo;// �޸ľƵ���Ϣ
	@FXML
	private Button back;
	@FXML
	private ImageView hotelPicture1;
	@FXML
	private ImageView hotelPicture2;
	@FXML
	private Label hotelName;
	@FXML
	private Label address;
	@FXML
	private Label district;
	@FXML
	private Label description;
	@FXML
	private Label strategy;
	@FXML
	private Label grade;// �Ƶ��Ǽ�
	@FXML
	private Label tag;// �Ƶ��ǩ
	@FXML
	private Label restRoomNumber;// ʣ��ͷ�����
	@FXML
	private Label price;

	private Main mainScene;
	private HotelInfoVO hotel;
	private HotelStaffVO hotelStaff;
	private Hotel_blservice hotelService;

	public HotelStaffHotelInfoViewController() {
	}

	public void HotelStaffHotelInfoViewShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.hotelName.setText(this.hotel.getHotelName());
		this.address.setText(this.hotel.getHotelAddress());
		this.district.setText(this.hotel.getHotelDistrict());
		this.description.setText(this.hotel.getHotelDiscription());

		// ��ǩ����

		// ����۸񷽷�

	}

	public void initialize(Main main, HotelStaffVO hotelStaff, HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.hotel = hotel;
		this.hotelStaff = hotelStaff;
		this.HotelStaffHotelInfoViewShow();
	}

	public void handleBack() {
		this.mainScene.showHotelStaffMainScene(hotelStaff);
	}

	public void handleModify() {
		this.mainScene.showHotelStaffHotelInfoModifyScene(hotelStaff, hotel);
	}
}
