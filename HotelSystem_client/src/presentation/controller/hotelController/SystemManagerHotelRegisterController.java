package presentation.controller.hotelController;

import java.util.Optional;

import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import main.Main;
import other.MyDistricts;
import util.ImageUtil;

public class SystemManagerHotelRegisterController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button save;// 保存并分配酒店工作人员
	@FXML
	private Button back;
	@FXML
	private TextField hotelName;// 客房
	@FXML
	private ChoiceBox<String> district;
	@FXML
	private ChoiceBox<String> city;
	@FXML
	private Button addPic;
	@FXML
	private TextField hotelStaffName;
	@FXML
	private ImageView img1;
	@FXML
	private ImageView img2;
	@FXML
	private ImageView img3;
	@FXML
	private ImageView img4;

	private Main mainScene;
	private SystemManagerVO systemManagerVO;
	private Hotel_blservice hotel_blservice;
	ObservableList<String> cityList = FXCollections.observableArrayList();// 城市列表
	ObservableList<String> districtList = FXCollections.observableArrayList();// 商圈列表
	private HotelInfoVO newHotel = new HotelInfoVO();
	public SystemManagerHotelRegisterController() {
		hotel_blservice = new Hotel_bl();
	}

	public void initialize(Main mainScene, SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		leftIdLabel.setText(systemManagerVO.getId());
		leftNameLabel.setText(systemManagerVO.getUserName());
		myPicture.setImage(ImageUtil.setImage(this.systemManagerVO.getImage()));
		// 初始化商圈
		city.setTooltip(new Tooltip("请选择城市！"));
		district.setTooltip(new Tooltip("请选择商圈！"));
		for (String city : MyDistricts.cities) {
			cityList.add(city);
		}
		city.setItems(cityList);
		city.getSelectionModel().selectedItemProperty()
				.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));

	}

	public void setDistrictChoiceBox(String city) {
		districtList.clear();
		String[] districts = MyDistricts.getDistricts(city);
		for (String dist : districts) {
			districtList.add(dist);
		}
		district.setItems(districtList);
	}

	@FXML
	private void handleSave() {
		String name = hotelName.getText();
		String districtName = district.getValue();
		String hotelStaffname = hotelStaffName.getText();
		if ((!name.equals("")) && (!hotelStaffname.equals("")) && (city.getValue() != null)
				&& (district.getValue() != null)) {
			HotelStaffVO hotelStaffVO = new HotelStaffVO();

			newHotel.setHotelName(name);
			newHotel.setHotelDistrict(districtName);
			newHotel.setHotelStaffId(hotelStaffVO.getId());
			newHotel.setCity(city.getValue());

			boolean isModify = hotel_blservice.addHotel(newHotel);

			hotelStaffVO.setHotelName(name);
			newHotel.setHotelStaffId(hotelStaffVO.getId());
			hotelStaffVO.setPassword(hotelStaffVO.getId());
			hotelStaffVO.setHotelId(newHotel.getHotelID());
			hotelStaffVO.setUsername(hotelStaffName.getText());
			hotelStaffVO.setImage("src/Img/default.PNG");
			if (isModify) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("恭喜");
				alert.setHeaderText("新增成功");
				alert.setContentText("您已成功新增一条酒店信息");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					mainScene.showSystemManagerHotelRegisterShowIDScene(systemManagerVO, newHotel, hotelStaffVO);
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("抱歉");
				alert.setHeaderText("修改失败");
				alert.setContentText("不好意思，您未能成功新增酒店信息！");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("提醒");
			alert.setContentText("请您先完善酒店信息后再保存");
			alert.showAndWait();
		}

	}

	@FXML
	private void handleBack() {
		if (!hotelName.getText().equals("")) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("提示");
			alert.setContentText("退出将不会保存您做出的修改，是否退出？");
			ButtonType yes = new ButtonType("是");
			ButtonType no = new ButtonType("否");
			alert.getButtonTypes().setAll(yes, no);
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get() == yes) {
				mainScene.showSystemManagerMainScene(systemManagerVO);
			}
		} else {
			mainScene.showSystemManagerMainScene(systemManagerVO);
		}
	}
	
	@FXML
	private void handleAddPic(){
		if (newHotel.getImage()==null||newHotel.getImage()=="") {
			String pic1 = ImageUtil.setImagePath(img1);
			newHotel.setImage(pic1);
		}else if (newHotel.getImage().split(";").length==1) {
			String pic2 = ImageUtil.setImagePath(img2);
			newHotel.setImage(newHotel.getImage()+";"+pic2);
		}else if (newHotel.getImage().split(";").length==2) {
			String pic3 = ImageUtil.setImagePath(img3);
			newHotel.setImage(newHotel.getImage()+";"+pic3);
		}else if(newHotel.getImage().split(";").length==3){
			String pic4 = ImageUtil.setImagePath(img4);
			newHotel.setImage(newHotel.getImage()+";"+pic4+";");
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提醒");
			alert.setContentText("酒店最多有四张图片描述");
			alert.showAndWait();
		}
		
	}
}
