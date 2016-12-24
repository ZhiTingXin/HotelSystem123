package presentation.controller.userManagementController;

import java.util.ArrayList;

import PO.SystemManagerPO;
import other.MyDistricts;
import VO.SystemManagerVO;
import VO.SystemStrategyVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;

public class SystemManagerAddSystemStaffController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button register;
	@FXML
	private Button back;
	@FXML
	private TextField inputID;
	@FXML
	private ChoiceBox<String> city;
	@FXML
	private ChoiceBox<String> district;
	@FXML
	private ImageView image;
	@FXML
	private Button changePicture;

	private Main mainScene;
	private SystemManagerVO systemManagerVO;
	ObservableList<String> cityList = FXCollections.observableArrayList();// 城市列表
	ObservableList<String> districtList = FXCollections.observableArrayList();// 商圈列表

	public SystemManagerAddSystemStaffController() {
		
	}

	public void showSystemManagerAddSystemStaff(Main mainScene, SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		
		//左栏
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		initialize();
	}
	
	private void initialize() {

		for (String city : MyDistricts.cities) {
			cityList.add(city);
		}
		city.setItems(cityList);
		city.getSelectionModel().selectedItemProperty()
				.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));
	}

	private void setDistrictChoiceBox(String city) {
		districtList.clear();
		String[] districts = MyDistricts.getDistricts(city);
		for (String dist : districts) {
			districtList.add(dist);
		}
		System.out.println(districtList.size());
		district.setItems(districtList);
	}

	@FXML
	private void handleChangePicture(){
		
	}
	
	@FXML
	private void handleRegister(){
		
	}
	
	@FXML
	private void handleBack(){
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}
}
