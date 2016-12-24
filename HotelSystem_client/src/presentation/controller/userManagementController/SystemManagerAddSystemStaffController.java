package presentation.controller.userManagementController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.impl.UserManagement_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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
	private String path = "";
	ObservableList<String> cityList = FXCollections.observableArrayList();// �����б�
	ObservableList<String> districtList = FXCollections.observableArrayList();// ��Ȧ�б�

	public SystemManagerAddSystemStaffController() {
		userManagement_bl = new UserManagement_bl();
	}

	public void showSystemManagerAddSystemStaff(Main mainScene, SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;

		// ����
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		
		city.setTooltip(new Tooltip("��ѡ����У�"));
		district.setTooltip(new Tooltip("��ѡ����Ȧ��"));
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
		path = file.getAbsolutePath();
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
		String systemStaffName = inputName.getText();//name
		systemStaffVO.setUsername(systemStaffName);
		String myCity = city.getValue();//city
		systemStaffVO.setCity(myCity);
		String myDistrict = district.getValue();
		systemStaffVO.setBusinessDistrict(myDistrict);
		systemStaffVO.setImage(path);
		systemStaffVO.setPassword(systemStaffVO.getId());//����
		
		boolean isAdd = userManagement_bl.addSystemStaff(systemStaffVO);
		
		if (isAdd) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("�ɹ�");
			alert.setHeaderText("ע��ɹ���");
			alert.setContentText("��ϲ�����ѳɹ�ע��һ����վӪ����Ա��Ϣ��");

			String info = "ID��"+systemStaffVO.getId()+"\n"
							+"�û�����"+systemStaffName+"\n"
							+"�ֹ���Ȧ��"+myCity+" "+myDistrict+"\n"
							+"���룺"+"��ʼ������ID��ͬ.";

			Label label = new Label("��վ������Ա����ϸ��Ϣ���£�");

			TextArea textArea = new TextArea(info);
			textArea.setEditable(false);
			textArea.setWrapText(true);

			textArea.setMaxWidth(360);
			textArea.setMaxHeight(120);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			GridPane expContent = new GridPane();
			expContent.setMaxWidth(120);
			expContent.add(label, 0, 0);
			expContent.add(textArea, 0, 1);
			alert.getDialogPane().setExpandableContent(expContent);
			alert.showAndWait();
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}
}
