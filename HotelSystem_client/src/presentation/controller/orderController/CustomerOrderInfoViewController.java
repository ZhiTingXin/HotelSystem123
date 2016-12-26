package presentation.controller.orderController;

import VO.CustomerVO;
import VO.OrderVO;
import blservice.Hotel_blservice;
import blservice.Order_blservice;
import blservice.impl.Hotel_bl;
import blservice.impl.Order_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import other.OrderState;
import other.RoomType;

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

	public CustomerOrderInfoViewController() {

	}

	public void initialize(Main main, CustomerVO customer, OrderVO orderVO) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.customer = customer;
		this.order = orderVO;
		this.OrderService = new Order_bl();
		this.hotelService = new Hotel_bl();
		this.CustomerOrderInfoViewShow();
	}

	public void CustomerOrderInfoViewShow() {
		this.leftIdLabel.setText(customer.getId());
		this.leftNameLabel.setText(customer.getUsername());
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
	public void handleback() {
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
	public void handleRecallOrAssessment() {

		if (this.order.getOrderState().equals(OrderState.FINISHED)) {
			this.stateOfOrder.setText("��ִ��");
			this.recallOrAssessment.setText("���۶���");
			this.mainScene.showHotelAssessmentScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()),
					this.order);
		} else if (this.order.getOrderState().equals(OrderState.UNFINISHED)) {
			this.order.setOrderState(OrderState.REVACATION);
			this.stateOfOrder.setText("�ѳ���");
			this.recallOrAssessment.setDisable(true);
			this.StateLabel.setText("����ɵ�ǰ�����ĳ���������ֵ�ѿ۳���");
			// bl�㷽��
			this.OrderService.changeState(this.order);

		} else if (this.order.getOrderState().equals(OrderState.ASSESSED)) {
			this.mainScene.showHotelAssessmentScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()),
					order);
		}
	}

	// ��ʾ�Ƶ�ķ���
	public void handleViewHotel() {
		this.mainScene.showCustomerHotelInfoScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()));
	}
}
