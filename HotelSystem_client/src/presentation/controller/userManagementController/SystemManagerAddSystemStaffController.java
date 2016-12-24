package presentation.controller.userManagementController;

import java.awt.Desktop;
import java.io.File;

import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.impl.UserManagement_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.Main;
import other.MyDistricts;

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
	private TextField inputName;
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
	private Stage stage;
	private UserManagement_bl userManagement_bl;
	private FileChooser fileChooser = new FileChooser();
	ObservableList<String> cityList = FXCollections.observableArrayList();// 城市列表
	ObservableList<String> districtList = FXCollections.observableArrayList();// 商圈列表

	public SystemManagerAddSystemStaffController() {
		userManagement_bl = new UserManagement_bl();
	}

	public void showSystemManagerAddSystemStaff(Main mainScene, SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;

		// 左栏
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		
		city.setTooltip(new Tooltip("请选择城市！"));
		district.setTooltip(new Tooltip("请选择商圈！"));
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
		district.setItems(districtList);
	}

	@FXML
	private void handleChangePicture() {

		configureFileChooser(fileChooser);
		File file = fileChooser.showOpenDialog(stage);
		String path = file.getAbsolutePath();
		Image newImage = new Image("file:"+path, 200, 200, false, false);
		image.setImage(newImage);
	}

	private static void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setTitle("View Pictures");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
	}

	@FXML
	private void handleRegister() {
		
		SystemStaffVO systemStaffVO= new SystemStaffVO();
		String systemStaffName = inputName.getText();
		systemStaffVO.setUsername(systemStaffName);
		String myCity = city.getValue();
//		systemStaffVO.s
		
		boolean isAdd = userManagement_bl.addSystemStaff(systemStaffVO);
		if (isAdd) {
			mainScene.
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}
}
