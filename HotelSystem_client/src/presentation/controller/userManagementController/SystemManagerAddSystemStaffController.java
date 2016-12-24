package presentation.controller.userManagementController;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;
import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.impl.UserManagement_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
		String string = file.getName();
		path = file.getAbsolutePath();
    
		Image newImage = new Image("file:"+path, 200, 200, false, false);
		try {
			File file1 = new File("src/Img/"+string);
			ImageIO.write(SwingFXUtils.fromFXImage(newImage,null), "gif", file1);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
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
		systemStaffVO.setPassword(systemStaffVO.getId());//密码
		
		boolean isAdd = userManagement_bl.addSystemStaff(systemStaffVO);
		
		if (isAdd) {
      
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("成功");
			alert.setHeaderText("注册成功！");
			alert.setContentText("恭喜，您已成功注册一条网站营销人员信息！");

			String info = "ID："+systemStaffVO.getId()+"\n"
							+"用户名："+systemStaffName+"\n"
							+"分管商圈："+myCity+" "+myDistrict+"\n"
							+"密码："+"初始密码与ID相同.";

			Label label = new Label("网站管理人员的详细信息如下：");

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
