package presentation.controller.userManagementController;

import java.util.Optional;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import VO.HotelStaffVO;
import VO.SystemManagerVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import main.Main;

public class SystemManagerHotelStaffInfoModifyController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button save;
	@FXML
	private Button cancel;
	@FXML
	private Label idLabel;
	@FXML
	private TextField name;
	@FXML
	private Label hotelId;
	@FXML
	private Label hotelName;
	@FXML
	private Button changePicture;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private SystemManagerVO systemManagerVO;
	private HotelStaffVO hotelStaffVO;

	public SystemManagerHotelStaffInfoModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main mainScene, SystemManagerVO systemManagerVO, HotelStaffVO hotelStaffVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		this.hotelStaffVO = hotelStaffVO;
		// 初始化
		leftIdLabel.setText(systemManagerVO.getId());
		leftNameLabel.setText(systemManagerVO.getUserName());
		SystemManagerHotelStaffInfoModifyShow(mainScene);
	}

	public void SystemManagerHotelStaffInfoModifyShow(Main mainScene) {

		// 显示
		idLabel.setText(hotelStaffVO.getId());
		name.setText(hotelStaffVO.getUsername());
		hotelId.setText(hotelStaffVO.getHotelId());
		hotelName.setText(hotelStaffVO.getHotelName());

	}

	@FXML
	private void handleSave() {

		String idString = idLabel.getText();
		String nameString = name.getText();
		String hotelID = hotelId.getText();
		String hotelNameString = hotelName.getText();
		//构造新的hotel staff VO
		hotelStaffVO = new HotelStaffVO(idString, nameString, hotelID, hotelNameString);

		boolean isModify = blservice.modifyHotelStaff(hotelStaffVO);
		//判断
		if (isModify) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("恭喜");
			alert.setHeaderText("修改成功");
			alert.setContentText("您已成功修改一条酒店工作人员信息");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				mainScene.showSystemManagerHotelStaffInfoViewScene(systemManagerVO, hotelStaffVO);
			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("修改失败");
			alert.setContentText("不好意思，您未能成功修改酒店工作人员信息！");
			alert.showAndWait();
		}
	}
	@FXML//返回
	private void handleBack(){
		mainScene.showSystemManagerHotelStaffInfoViewScene(systemManagerVO, hotelStaffVO);
	}
}
