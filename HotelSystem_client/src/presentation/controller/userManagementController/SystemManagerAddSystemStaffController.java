package presentation.controller.userManagementController;

import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.impl.UserManagement_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import main.Main;
import util.ImageUtil;

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
	private UserManagement_bl userManagement_bl;
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
		myPicture.setImage(ImageUtil.setImage(this.systemManagerVO.getImage()));
	}

	@FXML
	private void handleChangePicture() {
		path = util.ImageUtil.setImagePath(image);
	}

	@FXML
	private void handleRegister() {

		if (!inputName.getText().equals("") && !phoneNum.getText().equals("")) {
			SystemStaffVO systemStaffVO = new SystemStaffVO();
			String systemStaffName = inputName.getText();// name
			systemStaffVO.setUsername(systemStaffName);
			systemStaffVO.setImage(path);
			systemStaffVO.setPassword(systemStaffVO.getId());// 密码
			systemStaffVO.setPhone(phoneNum.getText());
			systemStaffVO.setImage("src/Img/default.png");
			boolean isAdd = userManagement_bl.addSystemStaff(systemStaffVO);

			if (isAdd) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("成功");
				alert.setHeaderText("注册成功！");
				alert.setContentText("恭喜，您已成功注册一条网站营销人员信息！");

				String info = "ID：" + systemStaffVO.getId() + "\n" + "用户名：" + systemStaffName + "\n" + "密码："
						+ "初始密码与ID相同.";

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
		} else {
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
