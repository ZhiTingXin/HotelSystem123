package presentation.controller.orderController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import VO.CustomerVO;
import VO.LogofUserVO;
import VO.OrderVO;
import blservice.Hotel_blservice;
import blservice.LogOfUser_blServce;
import blservice.Order_blservice;
import blservice.impl.Hotel_bl;
import blservice.impl.LogOfUser_blServceImpl;
import blservice.impl.Order_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import other.OrderState;
import other.RoomType;
import util.ImageUtil;

public class CustomerOrderInfoViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button recallOrAssessment;// ��������/���۶���
	@FXML
	private Button viewHotel;
	@FXML
	private Button back;
	@FXML
	private Label IdLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label nameOfHotel;
	@FXML
	private Label typeOfRoom;
	@FXML
	private Label numberOfRoom;
	@FXML
	private Label durationOfOrder;// ����ʱ��
	@FXML
	private Label timeOfArrive;
	@FXML
	private Label actualPayment;
	@FXML
	private Label stateOfOrder;
	@FXML
	private Label StateLabel;

	private Main mainScene;
	private CustomerVO customer;
	private OrderVO order;

	private Order_blservice OrderService;
	private Hotel_blservice hotelService;
	private LogOfUser_blServce logService;

	public CustomerOrderInfoViewController() {

	}

	public void initialize(Main main, CustomerVO customer, OrderVO orderVO) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.customer = customer;
		this.order = orderVO;
		this.OrderService = new Order_bl();
		this.hotelService = new Hotel_bl();
		this.logService = new LogOfUser_blServceImpl();
		this.CustomerOrderInfoViewShow();
	}

	public void CustomerOrderInfoViewShow() {
		this.leftIdLabel.setText(customer.getId());
		this.leftNameLabel.setText(customer.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(customer.getImage()));
		this.IdLabel.setText(this.customer.getId());
		this.nameLabel.setText(customer.getUsername());
		this.nameOfHotel.setText(this.hotelService.getHotelInfo(this.order.getHotelID()).getHotelName());
		// ȷ���Ǻ��ַ�������
		if (this.order.getRoomType().equals(RoomType.bigBedRoom))
			this.typeOfRoom.setText("�󴲷�");
		else if (this.order.getRoomType().equals(RoomType.doublePersonRoom))
			this.typeOfRoom.setText("˫�˼�");
		else if (this.order.getRoomType().equals(RoomType.singlePersonRoom))
			this.typeOfRoom.setText("���˼�");
		else if (this.order.getRoomType().equals(RoomType.multiPersonRoom))
			this.typeOfRoom.setText("���˼�");

		this.numberOfRoom.setText(String.valueOf(this.order.getRoomNum()));
		this.durationOfOrder.setText(String.valueOf(this.order.getLastime()));
		this.timeOfArrive.setText(util.DateUtil.format(this.order.getEntryTime()));
		this.actualPayment.setText(String.valueOf(this.order.getPrice()));
		this.controlRecallOrAssessment();
	}

	// ���ط���
	@FXML
	private void handleback() {
		this.mainScene.showCustomerOrderViewScene(customer);
	}

	// ���ۻ�����ť�Ŀ��Ʒ���
	private void controlRecallOrAssessment() {

		if (this.order.getOrderState().equals(OrderState.FINISHED)) {
			this.stateOfOrder.setText("��ִ��");
			this.recallOrAssessment.setText("���۶���");
		} else if (this.order.getOrderState().equals(OrderState.UNFINISHED)) {
			this.stateOfOrder.setText("��ִ��");
			this.recallOrAssessment.setText("��������");
		} else if (this.order.getOrderState().equals(OrderState.ABNOMAL)) {
			this.stateOfOrder.setText("�쳣");
			this.recallOrAssessment.setText("��������");
			this.recallOrAssessment.setDisable(true);
		} else if (this.order.getOrderState().equals(OrderState.REVACATION)) {
			this.stateOfOrder.setText("�ѳ���");
			this.recallOrAssessment.setText("��������");
			this.recallOrAssessment.setDisable(true);
		} else if (this.order.getOrderState().equals(OrderState.ASSESSED)) {
			this.stateOfOrder.setText("������");
			this.recallOrAssessment.setText("�鿴����");
			this.recallOrAssessment.setDisable(false);
		}
	}

	// ���ۻ�����ť�ļ�������
	@FXML
	private void handleRecallOrAssessment() {

		if (this.order.getOrderState().equals(OrderState.FINISHED)) {
			this.stateOfOrder.setText("��ִ��");
			this.recallOrAssessment.setText("���۶���");
			this.mainScene.showHotelAssessmentScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()),
					this.order);
		} else if (this.order.getOrderState().equals(OrderState.UNFINISHED)) {
			if (!this.order.getEntryTime().minusDays(1).isBefore(LocalDate.now())) {
				this.order.setOrderState(OrderState.REVACATION);
				this.stateOfOrder.setText("�ѳ���");
				this.recallOrAssessment.setDisable(true);
				this.StateLabel.setText("����ɵ�ǰ�����ĳ���������ֵ�ѿ۳���");

				// ������ü�¼
				LogofUserVO logofUserVO = new LogofUserVO();
				logofUserVO.setChange((int) (-order.getPrice() * 0.5));
				logofUserVO.setContent("��������" + this.order.getOrderID());
				logofUserVO.setDateTime(LocalDateTime.now());
				logofUserVO.setUserid(customer.getId());
				this.logService.addLogOfUser(logofUserVO);

				// bl�㷽��
				this.OrderService.changeState(this.order);
			} else {
				this.StateLabel.setText("�޷���������ִ�еĶ�����");
			}
		} else if (this.order.getOrderState().equals(OrderState.ASSESSED)) {
			this.mainScene.showHotelAssessmentScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()),
					order);
		}
	}

	// ��ʾ�Ƶ�ķ���
	@FXML
	private void handleViewHotel() {
		this.mainScene.showCustomerHotelInfoScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()));
	}
}
