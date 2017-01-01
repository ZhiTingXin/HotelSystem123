package presentation.controller.orderController;

import java.time.LocalDate;
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
import util.ImageUtil;

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
	private Button setToException;// 设置为异常订单
	@FXML
	private Button setToDone;// 设置为已执行订单
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
	private Label orderDuration;// 订单时长
	@FXML
	private Label arriveTime;// 订单时长
	@FXML
	private Label orderPayment;
	@FXML
	private Label stateOfOrder;

	// 界面对象
	private Main mainScene;
	private OrderVO order;
	private HotelStaffVO hotelStaff;
	private Order_blservice orderServcie;
	private LogOfUser_blServce logOfUser_blServce;

	public void HotelStaffManagementOrderShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
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

	// 设置为异常订单按钮监听方法
	@FXML
	private void handleSetToException() {
		this.order.setOrderState(OrderState.ABNOMAL);
		this.orderServcie.changeState(order);

		/**
		 * 置为异常订单时修改用户的信用值，并生成信用记录
		 */
		LogofUserVO logofUserVO = new LogofUserVO();
		logofUserVO.setUserid(order.getUserID());
		logofUserVO.setChange(-(int) (order.getPrice() / 2));
		logofUserVO.setDateTime(LocalDateTime.now());
		logofUserVO.setContent("由于订单号为 " + order.getOrderID() + " 的订单异常");
		logOfUser_blServce.addLogOfUser(logofUserVO);

		this.stateOfOrder.setText(this.order.getOrderState().toString());
		this.stateLabel.setText("已更改！");
	}

	// 设置为已完成订单监听方法
	@FXML
	private void handleSetToDone() {
		if (this.order.getEntryTime().equals(LocalDate.now())) {
			this.order.setOrderState(OrderState.FINISHED);
			this.orderServcie.changeState(order);

			/**
			 * 完成订单时，需要对于用户的信用值改变进行记录
			 */
			LogofUserVO logofUserVO = new LogofUserVO();
			logofUserVO.setUserid(order.getUserID());
			logofUserVO.setChange((int) (order.getPrice() / 2));
			logofUserVO.setDateTime(LocalDateTime.now());
			logofUserVO.setContent("由于订单号为 " + order.getOrderID() + " 的订单完成");
			logOfUser_blServce.addLogOfUser(logofUserVO);

			this.stateOfOrder.setText(this.order.getOrderState().toString());
			this.stateLabel.setText("已更改！");
		} else {
			this.stateLabel.setText("只能执行当天的订单！");
		}
	}

	// 返回按钮监听方法
	public void handleBack() {
		this.mainScene.showHotelStaffOrderViewScene(hotelStaff);
	}

	// 订单状态设置按钮控制方法
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
