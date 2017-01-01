package presentation.controller.orderController;

import java.util.ArrayList;

import VO.HotelStaffVO;
import VO.OrderVO;
import blservice.Order_blservice;
import blservice.impl.Order_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class HotelStaffOrderViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Label stateLabel;
	@FXML
	private Button viewOrderInfo;// 查看订单详情
	@FXML
	private Button Undo;// 未执行
	@FXML
	private Button Exception;// 异常订单
	@FXML
	private Button Done;// 已执行订单
	@FXML
	private Button back;
	@FXML
	private Button Revocation;
	@FXML
	private Label orderType;
	@FXML
	private Label hotelName;
	@FXML
	private TableView<OrderVO> orderTable;
	@FXML
	private TableColumn<OrderVO, String> orderId;
	@FXML
	private TableColumn<OrderVO, String> customerId;
	@FXML
	private TableColumn<OrderVO, String> orderTpye;// 订单类型（房间类型/数量）
	@FXML
	private TableColumn<OrderVO, String> arriveTime;// 到达时间

	// order的列表
	private ArrayList<OrderVO> orderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();

	// 界面对象
	private Main mainScene;
	private HotelStaffVO hotelStaff;
	// private HotelInfoVO hotel;
	private Order_blservice orderService;

	public HotelStaffOrderViewController() {

	}

	public void HotelStaffOrderViewShow() {
		this.leftIdLabel.setText(this.hotelStaff.getHotelId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
		this.hotelName.setText(this.hotelStaff.getHotelName());

	}

	public void initialize(Main main, HotelStaffVO hotelStaff) {
		this.mainScene = main;
		this.hotelStaff = hotelStaff;
		this.orderService = new Order_bl();

		this.orderList = this.orderService.getHotelUndoOrderList(this.hotelStaff.getHotelId());
		this.refreshTable();

		this.orderType.setText("未执行订单列表");
		this.HotelStaffOrderViewShow();
	}

	// 返回按钮监听方法
	@FXML
	private void handleBack() {
		this.mainScene.showHotelStaffMainScene(hotelStaff);
	}

	// 订单详细信息按钮监听方法
	@FXML
	private void handleViewOrderInfo() {

		OrderVO focus = this.orderTable.getSelectionModel().getSelectedItem();
		if (focus != null)
			this.mainScene.showHotelStaffManagementOrderScene(hotelStaff, focus);
		else
			this.stateLabel.setText("未选择任何订单！");

	}

	// 未完成订单列表按钮监听方法
	@FXML
	private void handleUndo() {
		this.orderList = this.orderService.getHotelUndoOrderList(this.hotelStaff.getHotelId());
		this.refreshTable();
		this.orderType.setText("未执行订单列表");
	}

	// 已完成订单列表按钮监听方法
	@FXML
	private void handleDone() {
		this.orderList = this.orderService.getHotelFinishedOrderList(this.hotelStaff.getHotelId());
		this.refreshTable();

		this.orderType.setText("已执行订单列表");
	}

	// 异常订单列表按钮监听方法
	@FXML
	private void handleException() {
		this.orderList = this.orderService.getHotelAbnormalOrderList(this.hotelStaff.getHotelId());
		this.refreshTable();
		this.orderType.setText("异常订单列表");
	}

	@FXML
	private void handleRevocation() {
		this.orderList = this.orderService.getRevocationOrder(this.hotelStaff.getHotelId());
		this.refreshTable();
		this.orderType.setText("已撤销订单列表");
	}

	// 刷新表格方法
	private void refreshTable() {
		this.orderData.clear();
		int count = 0;
		while (count < this.orderList.size()) {
			this.orderData.add(this.orderList.get(count));
			count++;
		}
		this.orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
		this.customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIDProperty());
		this.arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
		this.orderTpye.setCellValueFactory(cellData -> cellData.getValue().getRoomInfoProperty());
		this.orderTable.setItems(orderData);
	}
}
