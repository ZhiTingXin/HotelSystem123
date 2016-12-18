package presentation.controller.orderController;

import java.time.LocalDateTime;
import java.util.Optional;
import VO.OrderVO;
import VO.SystemStaffVO;
import blservice.Order_blservice;
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

	public SystemStaffOrderViewController() {
		order_blservice = new Order_bl();
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
		boolean isChange = order_blservice.changeCredit(orderVO.getUserID(), orderVO.getOrderID());//�ָ�����ֵ
		if (isOK&& isChange) {
		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ϲ");
			alert.setHeaderText("�����ɹ�");
			alert.setContentText("���Ѿ��ɹ�����һ���쳣������");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.get() == ButtonType.OK){
				stateOfOrder.setText(String.valueOf(orderVO.getOrderState()));//�޸Ķ���״̬Ϊ�ѳ���״̬
				revacationTime.setText(util.DateUtil.format(LocalDateTime.now()));
			}
			
		}else {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("��δ�ܳɹ�����һ���쳣������");
			alert.showAndWait();	
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemStaffOrderManagementScene(systemStaffVO);
	}
}
