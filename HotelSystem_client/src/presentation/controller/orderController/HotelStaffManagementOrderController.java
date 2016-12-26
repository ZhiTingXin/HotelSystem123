package presentation.controller.orderController;

import java.time.LocalDateTime;

import VO.HotelStaffVO;
import VO.LogofUserVO;
import VO.OrderVO;
import blservice.LogOfUser_blServce;
import blservice.Order_blservice;
import blservice.impl.LogOfUser_blServceImpl;
import blservice.impl.Order_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import other.OrderState;

public class HotelStaffManagementOrderController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Label stateLabel;
	@FXML
	private Button setToException;// ����Ϊ�쳣����
	@FXML
	private Button setToDone;// ����Ϊ��ִ�ж���
	@FXML
	private Button back;
	@FXML
	private Label IdLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label hotelName;
	@FXML
	private Label roomType;
	@FXML
	private Label roomNumber;
	@FXML
	private Label orderDuration;// ����ʱ��
	@FXML
	private Label arriveTime;// ����ʱ��
	@FXML
	private Label orderPayment;
	@FXML
	private Label stateOfOrder;

	// �������
	private Main mainScene;
	private OrderVO order;
	private HotelStaffVO hotelStaff;
	private Order_blservice orderServcie;
	private LogOfUser_blServce logOfUser_blServce;


	public void HotelStaffManagementOrderShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.IdLabel.setText(this.order.getUserID());
		this.nameLabel.setText(this.order.getUserName());
		this.hotelName.setText(this.hotelStaff.getHotelName());
		this.roomType.setText(this.order.getRoomType().toString());
		this.roomNumber.setText(String.valueOf(this.order.getRoomNum()));
		this.orderPayment.setText(String.valueOf(this.order.getPrice()));
		this.orderDuration.setText(String.valueOf(this.order.getLastime()));
		this.stateOfOrder.setText(this.order.getOrderState().toString());
		this.arriveTime.setText(this.order.getEntryTime().toString());

		this.controlSetOrderState();

	}

	public void initialize(Main main, HotelStaffVO hotelStaff, OrderVO order) {

		this.mainScene = main;
		this.hotelStaff = hotelStaff;
		this.order = order;
		this.orderServcie = new Order_bl();
		this.HotelStaffManagementOrderShow();
		this.logOfUser_blServce = new LogOfUser_blServceImpl();

	}

	// ����Ϊ�쳣������ť��������
	public void handleSetToException() {
		this.order.setOrderState(OrderState.ABNOMAL);
		this.orderServcie.changeState(order);
		
		/**
		 * ��Ϊ�쳣����ʱ�޸��û�������ֵ�����������ü�¼
		 */
		LogofUserVO logofUserVO = new LogofUserVO();
		logofUserVO.setUserid(order.getUserID());
		logofUserVO.setChange(-(int)(order.getPrice()/2));
		logofUserVO.setDateTime(LocalDateTime.now());
		logofUserVO.setContent("���ڶ�����Ϊ "+order.getOrderID()+" �Ķ����쳣");
		logOfUser_blServce.addLogOfUser(logofUserVO);
		
		
		this.stateOfOrder.setText(this.order.getOrderState().toString());
		this.stateLabel.setText("�Ѹ��ģ�");
	}

	// ����Ϊ����ɶ�����������
	public void handleSetToDone() {
		this.order.setOrderState(OrderState.FINISHED);
		this.orderServcie.changeState(order);
		
		/**
		 * ��ɶ���ʱ����Ҫ�����û�������ֵ�ı���м�¼
		 */
		LogofUserVO logofUserVO = new LogofUserVO();
		logofUserVO.setUserid(order.getUserID());
		logofUserVO.setChange((int)(order.getPrice()/2));
		logofUserVO.setDateTime(LocalDateTime.now());
		logofUserVO.setContent("���ڶ�����Ϊ "+order.getOrderID()+" �Ķ������");
		logOfUser_blServce.addLogOfUser(logofUserVO);
		
		this.stateOfOrder.setText(this.order.getOrderState().toString());
		this.stateLabel.setText("�Ѹ��ģ�");
	}

	// ���ذ�ť��������
	public void handleBack() {
		this.mainScene.showHotelStaffOrderViewScene(hotelStaff);
	}

	// ����״̬���ð�ť���Ʒ���
	private void controlSetOrderState() {
		if (this.order.getOrderState().equals(OrderState.UNFINISHED)) {
			this.setToDone.setDisable(false);
			this.setToException.setDisable(false);
		} else if (this.order.getOrderState().equals(OrderState.FINISHED)) {
			this.setToDone.setDisable(true);
			this.setToException.setDisable(true);
		} else if (this.order.getOrderState().equals(OrderState.ASSESSED)) {
			this.setToDone.setDisable(true);
			this.setToException.setDisable(true);
		} else if (this.order.getOrderState().equals(OrderState.ABNOMAL)) {
			this.setToDone.setDisable(false);
			this.setToException.setDisable(true);
		}
	}
}
