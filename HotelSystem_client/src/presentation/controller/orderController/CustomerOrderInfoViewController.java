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
	private Button recallOrAssessment;// 撤销订单/评价订单
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
	private Label durationOfOrder;// 订单时长
	@FXML
	private Label timeOfArrive;
	@FXML
	private Label actualPayment;
	@FXML
	private Label stateOfOrder;

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
		if (this.order.getRoomType().equals(RoomType.bigBedRoom))
			this.typeOfRoom.setText("大床房");
		else if (this.order.getRoomType().equals(RoomType.doublePersonRoom))
			this.typeOfRoom.setText("双人间");
		else if (this.order.getRoomType().equals(RoomType.singlePersonRoom))
			this.typeOfRoom.setText("单人间");
		else if (this.order.getRoomType().equals(RoomType.multiPersonRoom))
			this.typeOfRoom.setText("多人间");

		this.numberOfRoom.setText(String.valueOf(this.order.getRoomNum()));
		this.durationOfOrder.setText(String.valueOf(this.order.getLastime()));
		// this.timeOfArrive.setText();
		this.actualPayment.setText(String.valueOf(this.order.getPrice()));
		if (this.order.getOrderState().equals(OrderState.FINISHED)) {
			this.stateOfOrder.setText("已执行");
			this.recallOrAssessment.setText("评价订单");
		} else if (this.order.getOrderState().equals(OrderState.UNFINISHED)) {
			this.stateOfOrder.setText("待执行");
			this.recallOrAssessment.setText("撤销订单");
		} else if (this.order.getOrderState().equals(OrderState.ABNOMAL)) {
			this.stateOfOrder.setText("异常");
			this.recallOrAssessment.setText("撤销订单");
			this.recallOrAssessment.setDisable(false);
		} else if (this.order.getOrderState().equals(OrderState.ASSESSED)) {
			this.stateOfOrder.setText("已评价");
			this.recallOrAssessment.setText("修改评价");
		}

	}

	public void handleback() {
		this.mainScene.showCustomerOrderViewScene(customer);
	}

	public void handleRecallOrAssessment() {
		if (this.order.getOrderState().equals(OrderState.FINISHED)) {
			this.stateOfOrder.setText("已执行");
			this.recallOrAssessment.setText("评价订单");
			this.mainScene.showHotelAssessmentScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()),
					this.order);
		} else if (this.order.getOrderState().equals(OrderState.UNFINISHED)) {
			this.order.setOrderState(OrderState.ABNOMAL);
			this.stateOfOrder.setText("异常");
			this.recallOrAssessment.setDisable(false);

			// bl层方法
			this.OrderService.changeState(this.order);

		}
	}

	public void handleViewHotel() {
		this.mainScene.showCustomerHotelInfoScene(customer, this.hotelService.getHotelInfo(this.order.getHotelID()));
	}
}
