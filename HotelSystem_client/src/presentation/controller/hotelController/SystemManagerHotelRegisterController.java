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
	ObservableList<String> cityList = FXCollections.observableArrayList();// �����б�
	ObservableList<String> districtList = FXCollections.observableArrayList();// ��Ȧ�б�
	
	public SystemManagerHotelRegisterController() {
		hotel_blservice = new Hotel_bl();
	}

	public void initialize(Main mainScene,SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		leftIdLabel.setText(systemManagerVO.getId());
		leftNameLabel.setText(systemManagerVO.getUserName());
		//��ʼ����Ȧ
		city.setTooltip(new Tooltip("��ѡ����У�"));
		district.setTooltip(new Tooltip("��ѡ����Ȧ��"));
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
	private void handleSave(){
		String name = hotelName.getText();
		String districtName = district.getValue();
		String hotelStaffname = hotelStaffName.getText();
		if ((!name.equals(""))&&(!hotelStaffname.equals(""))&&(city.getValue()!=null)&&(district.getValue()!=null)) {
			HotelInfoVO newHotel = new HotelInfoVO();
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
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("����");
			alert.setContentText("���������ƾƵ���Ϣ���ٱ���");
			alert.showAndWait();
		}
		
			
	}
	
	@FXML
	private void handleBack(){
		if(!hotelName.getText().equals("")){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("��ʾ");
			alert.setContentText("�˳������ᱣ�����������޸ģ��Ƿ��˳���");
			ButtonType yes = new ButtonType("��");
			ButtonType  no = new ButtonType("��");
			alert.getButtonTypes().setAll(yes,no);
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get()==yes) {
				mainScene .showSystemManagerMainScene(systemManagerVO);
			}
		}else{
		    mainScene .showSystemManagerMainScene(systemManagerVO);
		}
	}
}
