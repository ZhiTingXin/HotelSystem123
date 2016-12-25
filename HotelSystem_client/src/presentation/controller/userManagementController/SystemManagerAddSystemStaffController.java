package presentation.controller.userManagementController;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.impl.UserManagement_bl;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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
	private TextField inputName;
	@FXML
	private TextField phoneNum;
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

	public SystemManagerAddSystemStaffController() {
		userManagement_bl = new UserManagement_bl();
	}

	public void showSystemManagerAddSystemStaff(Main mainScene, SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;

		// 左栏
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
	}

	@FXML
	private void handleChangePicture() {

		configureFileChooser(fileChooser);
		File file = fileChooser.showOpenDialog(stage);
		String string = file.getName();
		path = file.getAbsolutePath();

		Image newImage = new Image("file:" + path, 200, 200, false, false);
		try {
			File file1 = new File("src/Img/" + string);
			ImageIO.write(SwingFXUtils.fromFXImage(newImage, null), "gif", file1);
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
    
		if (!inputName.getText().equals("")&&!phoneNum.getText().equals("")) {
			SystemStaffVO systemStaffVO= new SystemStaffVO();
			String systemStaffName = inputName.getText();//name
			systemStaffVO.setUsername(systemStaffName);
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
								+"密码："+"初始密码与ID相同.";

				Label label = new Label("网站管理人员的详细信息如下：");

				TextArea textArea = new TextArea(info);
				textArea.setEditable(false);
				textArea.setWrapText(true);

				textArea.setMaxWidth(300);
				textArea.setMaxHeight(80);
				GridPane.setVgrow(textArea, Priority.ALWAYS);
				GridPane.setHgrow(textArea, Priority.ALWAYS);

				GridPane expContent = new GridPane();
				expContent.setMaxWidth(120);
				expContent.add(label, 0, 0);
				expContent.add(textArea, 0, 1);
				alert.getDialogPane().setExpandableContent(expContent);
				alert.showAndWait();
			}
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("提醒");
			alert.setContentText("请您先完善网站营销人员的信息后，再注册");
			alert.showAndWait();
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}
}
