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
import main.Main;
import other.OrderState;
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
	private Label duration;// 入住时长
	@FXML
	private Button increase;
	@FXML
	private Button decrease;
	@FXML
	private Label memberDeals;// 会员优惠
	@FXML
	private Label holidayDeals;// 节日优惠
	@FXML
	private Label otherDeals;// 其他优惠
	@FXML
	private Label orderTotal;// 订单总额
	@FXML
	private Label actualPayment;// 实际付款
	@FXML
	private Label stateField;

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
		// order的初始设定
		this.order = new OrderVO();
		this.order.setHotelID(this.hotel.getHotelID());
		this.order.setUserID(this.customer.getId());
		this.order.setUserName(this.customer.getUsername());
		this.order.setRoomNum(1);
		this.order.setOrderState(OrderState.UNFINISHED);

		this.actualPayment.setText("0");
		this.orderTotal.setText("0");
		this.SystemManagerSystemStaffInfoModifyShow();
	}

	public void SystemManagerSystemStaffInfoModifyShow() {
		this.leftIdLabel.setText(customer.getId());
		this.leftNameLabel.setText(customer.getUsername());
		this.customerName.setText(customer.getUsername());
		this.customerId.setText(customer.getId());

		this.hotelName.setText(this.hotel.getHotelName());
		this.typeOfRoom.setText("请选择房间类型");
		this.numberOfRoom.setText("请选择房间数量");
		this.days = 1;
		this.duration.setText(String.valueOf(days) + "天");

		// this.holidayDeals.setText();
		// his.memberDeals.setText(value);
		// this.otherDeals.setText(value);

	}

	public void handleIncrease() {
		if (this.days < 30) {
			this.days++;
			this.order.setLastime(days);
			this.refreshActualPayment();
			this.refreshOrderTotal();
		}
		this.duration.setText(String.valueOf(days) + "天");
	}

	public void handleDecrease() {
		if (this.days > 1) {
			this.days--;
			this.order.setLastime(days);
			this.refreshActualPayment();
			this.refreshOrderTotal();
		}
		this.duration.setText(String.valueOf(days) + "天");
	}

	public void handleSinglePersonRoom() {
		this.roomtype = RoomType.singlePersonRoom;
		this.order.setRoomType(roomtype);
		this.typeOfRoom.setText("单人间");
		this.refreshActualPayment();
		this.refreshOrderTotal();
	}

	public void handleMultiPersonRoom() {
		this.roomtype = RoomType.multiPersonRoom;
		this.order.setRoomType(roomtype);
		this.typeOfRoom.setText("多人间");
		this.refreshActualPayment();
		this.refreshOrderTotal();
	}

	public void handleDoublePersonRoom() {
		this.roomtype = RoomType.doublePersonRoom;
		this.order.setRoomType(roomtype);
		this.typeOfRoom.setText("双人间");
		this.refreshActualPayment();
		this.refreshOrderTotal();
	}

	public void handleBigBedRoom() {
		this.roomtype = RoomType.bigBedRoom;
		this.order.setRoomType(roomtype);
		this.typeOfRoom.setText("大床房");
		this.refreshActualPayment();
		this.refreshOrderTotal();
	}

	public void handleOneRoom() {
		this.roomNum = 1;
		this.order.setRoomNum(1);
		this.numberOfRoom.setText("1间");
		this.refreshActualPayment();
		this.refreshOrderTotal();
	}

	public void handleTwoRoom() {
		this.roomNum = 2;
		this.order.setRoomNum(2);
		this.numberOfRoom.setText("2间");
		this.refreshActualPayment();
		this.refreshOrderTotal();
	}

	public void handleThreeRoom() {
		this.roomNum = 3;
		this.order.setRoomNum(3);
		this.numberOfRoom.setText("3间");
		this.refreshActualPayment();
		this.refreshOrderTotal();
	}

	public void handleFourRoom() {
		this.roomNum = 4;
		this.order.setRoomNum(4);
		this.numberOfRoom.setText("4间");
		this.refreshActualPayment();
		this.refreshOrderTotal();
	}

	public void handleFiveRoom() {
		this.roomNum = 5;
		this.order.setRoomNum(5);
		this.numberOfRoom.setText("5间");
		this.refreshActualPayment();
		this.refreshOrderTotal();
	}

	public void handleSave() {
		boolean isRoomTypeOK = this.typeOfRoom.getText() != "请选择房间类型";
		boolean isRoomNumOK = this.numberOfRoom.getText() != "请选择房间数量";

		// 待完成的日期确认
		boolean isDateOK = true;

		if (isRoomTypeOK && isRoomNumOK && isDateOK) {

			this.orderService.generateOrder(this.order);
			this.mainScene.showCustomerHotelInfoScene(customer, hotel);
		} else if (!isRoomTypeOK) {
			this.stateField.setText("请选择房间类型");
		} else if (!isRoomNumOK) {
			this.stateField.setText("请选择房间数量");
		} else if (!isDateOK) {
			this.stateField.setText("请修改出行日期");
		}
	}

	public void handleBack() {
		this.mainScene.showCustomerHotelInfoScene(customer, hotel);
	}

	public void handleDatePicker() {
		// 获取时间
		this.order.setEntryTime(dateOfCheckIn.getValue());

		this.refreshActualPayment();
		this.refreshOrderTotal();
	}

	// 刷新总价
	private void refreshOrderTotal() {
		this.orderTotal.setText(String.valueOf(this.orderService.getOrderOriginalPrice(order)));
	}

	// 刷新实际价格
	private void refreshActualPayment() {
		this.actualPayment.setText(String.valueOf(this.orderService.getOrderPrice(order)));
	}
}
