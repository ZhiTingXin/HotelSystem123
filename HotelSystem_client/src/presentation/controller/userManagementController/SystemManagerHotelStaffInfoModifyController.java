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
<<<<<<< HEAD
	private SystemManagerVO systemManagerVO;
	private HotelStaffVO hotelStaffVO;
=======
	private HotelStaffVO hotelStaff;
>>>>>>> refs/remotes/origin/叶晓波

	public SystemManagerHotelStaffInfoModifyController() {
		blservice = new UserInfo_bl();
	}

<<<<<<< HEAD
	public void initialize(Main mainScene, SystemManagerVO systemManagerVO, HotelStaffVO hotelStaffVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		this.hotelStaffVO = hotelStaffVO;
		// ��ʼ��
		leftIdLabel.setText(systemManagerVO.getId());
		leftNameLabel.setText(systemManagerVO.getUserName());
		SystemManagerHotelStaffInfoModifyShow(mainScene);
	}

	public void SystemManagerHotelStaffInfoModifyShow(Main mainScene) {

		// ��ʾ
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
		//�����µ�hotel staff VO
		hotelStaffVO = new HotelStaffVO(idString, nameString, hotelID, hotelNameString);

		boolean isModify = blservice.modifyHotelStaff(hotelStaffVO);
		//�ж�
		if (isModify) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ϲ");
			alert.setHeaderText("�޸ĳɹ�");
			alert.setContentText("���ѳɹ��޸�һ���Ƶ깤����Ա��Ϣ");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				mainScene.showSystemManagerHotelStaffInfoViewScene(systemManagerVO, hotelStaffVO);
			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("�޸�ʧ��");
			alert.setContentText("������˼����δ�ܳɹ��޸ľƵ깤����Ա��Ϣ��");
			alert.showAndWait();
		}
	}
	@FXML//����
	private void handleBack(){
		mainScene.showSystemManagerHotelStaffInfoViewScene(systemManagerVO, hotelStaffVO);
=======
	private void getHotelStaffInfo(String id) {
	}

	public void SystemManagerHotelStaffInfoModifyShow(Main mainScene) {
		this.mainScene = mainScene;

	}

	public void initialize(Main main, SystemManagerVO systemManagerVO, HotelStaffVO hotelStaffVO) {
		// TODO Auto-generated method stub

>>>>>>> refs/remotes/origin/叶晓波
	}
}
