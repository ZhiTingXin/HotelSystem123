package presentation.controller.orderController;

import java.time.LocalDateTime;
import java.util.Optional;

import VO.LogofUserVO;
import VO.OrderVO;
import VO.SystemStaffVO;
import blservice.LogOfUser_blServce;
import blservice.Order_blservice;
import blservice.impl.LogOfUser_blServceImpl;
import blservice.impl.Order_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import other.OrderState;
import util.DateUtil;
import util.ImageUtil;

public class SystemStaffOrderViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button cancelOrder;
	@FXML
	private Button back;
	@FXML
	private Label orderIdLabel;// ����id
	@FXML
	private Label IdLabel;// �ͻ�id
	@FXML
	private Label nameLabel;// �ͻ�����
	@FXML
	private Label nameOfHotel;// �Ƶ�����
	@FXML
	private Label typeOfRoom;// ��������
	@FXML
	private Label numberOfRoom;
	@FXML
	private Label durationOfOrder;// ����ʱ��
	@FXML
	private Label timeOfArrive;// ����ʱ��
	@FXML
	private Label actualPayment;// ʵ�ʸ���
	@FXML
	private Label stateOfOrder;// ����״̬
	@FXML
	private Label revacationTime;// ����ʱ��

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private OrderVO orderVO;
	private Order_blservice order_blservice;
	private LogOfUser_blServce logOfUser_blServce;
	
	
	public SystemStaffOrderViewController() {
		order_blservice = new Order_bl();
		logOfUser_blServce = new LogOfUser_blServceImpl();
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaffVO, OrderVO orderVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.orderVO = orderVO;
		SystemStaffOrderViewShow(this.mainScene);
	}

	public void SystemStaffOrderViewShow(Main mainScene) {
		// �����
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		myPicture.setImage(ImageUtil.setImage(systemStaffVO.getImage()));
		// �ұ���
		orderIdLabel.setText(orderVO.getOrderID());
		IdLabel.setText(orderVO.getUserID());// �ͻ�id
		nameLabel.setText(orderVO.getUserName());
		nameOfHotel.setText(orderVO.getHotelID());
		typeOfRoom.setText(String.valueOf(orderVO.getRoomType()));
		numberOfRoom.setText(String.valueOf(orderVO.getRoomNum()));
		durationOfOrder.setText(String.valueOf(orderVO.getLastime()));
		timeOfArrive.setText(DateUtil.format(orderVO.getEntryTime()));
		actualPayment.setText(String.valueOf(orderVO.getPrice()));
		stateOfOrder.setText(String.valueOf(orderVO.getOrderState()));
		revacationTime.setText("��");
	}

	@FXML//��������
	private void handleRevocationException(){
		
		orderVO.setOrderState(OrderState.REVACATION);
		boolean isOK = 	order_blservice.changeState(orderVO);
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("ѡ��");
		alert.setHeaderText("��ѡ��Ϊ�û��ָ�����ֵ�����ͣ�");
		ButtonType all = new ButtonType("ȫ��");
		ButtonType half = new ButtonType("һ��");
		alert.getButtonTypes().setAll(all,half);
		Optional<ButtonType> btn = alert.showAndWait();
		boolean isChange = false;
		if (btn.get() == all) {
			LogofUserVO logofUserVO = new LogofUserVO();
			logofUserVO.setChange((int)(orderVO.getPrice()/2));
			logofUserVO.setContent("�ɹ�����������Ϊ "+orderVO.getOrderID()+" �Ķ���");
			logofUserVO.setUserid(orderVO.getUserID());
			logofUserVO.setDateTime(LocalDateTime.now());
			logOfUser_blServce.addLogOfUser(logofUserVO);
			isChange = order_blservice.changeCredit(orderVO.getUserID(), orderVO.getOrderID());//�ָ�����ֵ
		} else {
            isChange = order_blservice.addHalfOfOrginalCredit(orderVO.getUserID(), orderVO.getOrderID());
		}
		
		if (isOK&& isChange) {
		
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("��ϲ");
			alert1.setHeaderText("�����ɹ�");
			alert1.setContentText("���Ѿ��ɹ�����һ���쳣������");
			Optional<ButtonType> result = alert1.showAndWait();
			if(result.get() == ButtonType.OK){
				stateOfOrder.setText(String.valueOf(orderVO.getOrderState()));//�޸Ķ���״̬Ϊ�ѳ���״̬
				revacationTime.setText(util.DateUtil.format(LocalDateTime.now()));
			}
			
		}else {
			
			Alert alert2 = new Alert(AlertType.ERROR);
			alert2.setTitle("��Ǹ");
			alert2.setHeaderText("����ʧ��");
			alert2.setContentText("��δ�ܳɹ�����һ���쳣������");
			alert2.showAndWait();	
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemStaffOrderManagementScene(systemStaffVO);
	}
}
