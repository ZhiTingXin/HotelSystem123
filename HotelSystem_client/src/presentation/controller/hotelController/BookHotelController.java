package presentation.controller.hotelController;

import java.util.Date;

import VO.CustomerVO;
import VO.HotelInfoVO;
import VO.OrderVO;
import blservice.Order_blservice;
import blservice.UserInfo_blservice;
import blservice.impl.Order_bl;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import main.Main;
import other.RoomType;

public class BookHotelController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button save;
	@FXML
	private Button back;
	@FXML
	private Label customerId;
	@FXML
	private Label customerName;
	@FXML
	private Label hotelName;

	@FXML
	private MenuButton typeOfRoom;
	@FXML
	private MenuItem doublePersonRoom;
	@FXML
	private MenuItem singlePersonRoom;
	@FXML
	private MenuItem multiPersonRoom;
	@FXML
	private MenuItem bigBedRoom;

	@FXML
	private MenuButton numberOfRoom;
	@FXML
	private MenuItem oneRoom;
	@FXML
	private MenuItem twoRoom;
	@FXML
	private MenuItem threeRoom;
	@FXML
	private MenuItem fourRoom;
	@FXML
	private MenuItem fiveRoom;

	@FXML
	private DatePicker dateOfCheckIn;
	@FXML
	private Label duration;// ��סʱ��
	@FXML
	private Button increase;
	@FXML
	private Button decrease;
	@FXML
	private Label memberDeals;// ��Ա�Ż�
	@FXML
	private Label holidayDeals;// �����Ż�
	@FXML
	private Label otherDeals;// �����Ż�
	@FXML
	private Label orderTotal;// �����ܶ�
	@FXML
	private Label actualPayment;// ʵ�ʸ���
	@FXML
	private TextField stateField;

	private Main mainScene;
	private UserInfo_blservice userService;
	private Order_blservice orderService;
	private CustomerVO customer;
	private HotelInfoVO hotel;
	private OrderVO order;

	private int days;
	private RoomType roomtype;
	private int roomNum;
	private Date checkInDate;

	public BookHotelController() {

	}

	public void initialize(Main mainScene, CustomerVO customer, HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		this.customer = customer;
		this.hotel = hotel;
		this.mainScene = mainScene;
		userService = new UserInfo_bl();
		this.orderService = new Order_bl();
		this.SystemManagerSystemStaffInfoModifyShow();
	}

	public void SystemManagerSystemStaffInfoModifyShow() {
		this.leftIdLabel.setText(customer.getId());
		this.leftNameLabel.setText(customer.getUsername());
		this.customerName.setText(customer.getUsername());
		this.customerId.setText(customer.getId());

		this.hotelName.setText(this.hotel.getHotelName());
		this.typeOfRoom.setText("��ѡ�񷿼�����");
		this.numberOfRoom.setText("��ѡ�񷿼�����");
		this.days = 1;
		this.duration.setText(String.valueOf(days) + "��");

	}

	public void handleIncrease() {
		if (this.days < 30) {
			this.days++;
			this.order.setLastime(days);
			// bl�㷽��
			this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
			this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
		}
		this.duration.setText(String.valueOf(days) + "��");
	}

	public void handleDecrease() {
		if (this.days > 1) {
			this.days--;
			this.order.setLastime(days);
			// bl�㷽��
			this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
			this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
		}
		this.duration.setText(String.valueOf(days) + "��");
	}

	public void handleSinglePersonRoom() {
		this.roomtype = RoomType.singlePersonRoom;
		this.order.setRoomType(roomtype);
		this.typeOfRoom.setText("���˼�");
		// bl�㷽��
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
	}

	public void handleMultiPersonRoom() {
		this.roomtype = RoomType.multiPersonRoom;
		this.order.setRoomType(roomtype);
		this.typeOfRoom.setText("���˼�");
		// bl�㷽��
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
	}

	public void handleDoublePersonRoom() {
		this.roomtype = RoomType.doublePersonRoom;
		this.order.setRoomType(roomtype);
		this.typeOfRoom.setText("˫�˼�");
		// bl�㷽��
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
	}

	public void handleBigBedRoom() {
		this.roomtype = RoomType.bigBedRoom;
		this.order.setRoomType(roomtype);
		this.typeOfRoom.setText("�󴲷�");
		// bl�㷽��
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
	}

	public void handleOneRoom() {
		this.roomNum = 1;
		this.order.setRoomNum(1);
		this.numberOfRoom.setText("1��");
		// bl�㷽��
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
	}

	public void handleTwoRoom() {
		this.roomNum = 2;
		this.order.setRoomNum(2);
		this.numberOfRoom.setText("2��");
		// bl�㷽��
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
	}

	public void handleThreeRoom() {
		this.roomNum = 3;
		this.order.setRoomNum(3);
		this.numberOfRoom.setText("3��");
		// bl�㷽��
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
	}

	public void handleFourRoom() {
		this.roomNum = 4;
		this.order.setRoomNum(4);
		this.numberOfRoom.setText("4��");
		// bl�㷽��
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
	}

	public void handleFiveRoom() {
		this.roomNum = 5;
		this.order.setRoomNum(5);
		this.numberOfRoom.setText("5��");
		// bl�㷽��
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
	}

	public void handleSave() {
		boolean isRoomTypeOK = this.typeOfRoom.getText() != "��ѡ�񷿼�����";
		boolean isRoomNumOK = this.numberOfRoom.getText() != "��ѡ�񷿼�����";

		// ����ɵ�����ȷ��
		boolean isDateOK = true;

		if (isRoomTypeOK && isRoomNumOK && isDateOK) {

			this.orderService.generateOrder(this.order);
			this.mainScene.showCustomerHotelInfoScene(customer, hotel);
		} else if (!isRoomTypeOK) {
			this.stateField.setText("��ѡ�񷿼�����");
		} else if (!isRoomNumOK) {
			this.stateField.setText("��ѡ�񷿼�����");
		} else if (!isDateOK) {
			this.stateField.setText("���޸ĳ�������");
		}
	}

	public void handleBack() {
		this.mainScene.showCustomerHotelInfoScene(customer, hotel);
	}

	public void handleDatePicker() {
		// ��ȡʱ��
		this.order.setEntryTime(dateOfCheckIn.getValue());
		// bl�㷽��
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order, this.customer.getId())));
	}
}
