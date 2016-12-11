package presentation.controller.hotelController;

import VO.HotelInfoVO;
import VO.HotelStaffVO;
import blservice.Hotel_blservice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;

//scene界面需要改 没连scene
//***************************
public class HotelStaffHotelInfoViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button modifyHotelInfo;// 修改酒店信息
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
	private Label grade;// 酒店星级
	@FXML
	private Label tag;// 酒店标签
	@FXML
	private Label restRoomNumber;// 剩余客房数量
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

		// bl层暂时还没实现的方法
		this.strategy.setText(this.hotelService.getHotelStrategy(this.hotel.getHotelID()));
		String[] tag = this.hotelService.getHotelTagAssessment(this.hotel.getHotelID());
		String tagListLabel = "";
		int count = 0;
		while (count < tag.length) {
			tagListLabel += tag[count];
			count++;
		}
		this.tag.setText(tagListLabel);

		//this.price.setText(this.hotelService.getHotelRoomPrice(this.hotel.getHotelID()));
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
