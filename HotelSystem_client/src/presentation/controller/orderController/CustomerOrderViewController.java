package presentation.controller.orderController;

import java.util.ArrayList;

import VO.CustomerVO;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;

public class CustomerOrderViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button viewOrderInfo;
	@FXML
	private Button back;
	@FXML
	private TextField searchInput;
	@FXML
	private Button searchButton;
	@FXML
	private TableView<OrderVO> orderTable;
	@FXML
	private TableColumn<OrderVO, String> orderId;
	@FXML
	private TableColumn<OrderVO, String> timeOfArrive;
	@FXML
	private TableColumn<OrderVO, String> nameOfHotel;
	@FXML
	private TableColumn<OrderVO, String> payment;
	@FXML
	private TableColumn<OrderVO, String> stateOfOrder;
	@FXML
	private Label StateField;

	private Main mainScene;
	private CustomerVO customer;
	private Order_blservice service;

	// 表格属性

	private ArrayList<OrderVO> orderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();

	public CustomerOrderViewController() {
	}

	public void initialize(Main main, CustomerVO customer) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.customer = customer;
		this.service = new Order_bl();

		// 表格方法
		this.orderList = this.service.getOrdersOfUsers(this.customer.getId());
		this.refreshTable();

		this.CustomerOrderViewShow();
	}

	public void CustomerOrderViewShow() {
		this.leftIdLabel.setText(customer.getId());
		this.leftNameLabel.setText(customer.getUsername());
	}

	// 订单详细信息按钮监听方法
	public void handleOrderInfo() {
		int focusOn = this.orderTable.getSelectionModel().getFocusedIndex();
		this.mainScene.showCustomerOrderInfoViewScene(customer, this.orderList.get(focusOn));
	}

	// 返回按钮监听方法
	public void handleback() {
		this.mainScene.showCustomerMainScene(customer);
	}

	// 搜索按钮监听方法
	public void handleSearch() {
		ArrayList<OrderVO> searchOrderList = this.service.getOrderFromInput(this.searchInput.getText());
		if (searchOrderList != null && searchOrderList.size() > 0) {
			this.refreshTable();
		} else {
			this.StateField.setText("未找到匹配的酒店！");
		}
	}

	// 表格刷新方法
	private void refreshTable() {
		this.orderData.clear();
		int count = 0;
		while (count < this.orderList.size()) {
			this.orderData.add(this.orderList.get(count));
			count++;
		}
		// VO列表赋值给表格
		this.orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
		this.timeOfArrive.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
		this.payment.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
		this.nameOfHotel.setCellValueFactory(cellData -> cellData.getValue().getHotelNameProperty());
		// this.stateOfOrder.setCellValueFactory(cellData ->
		// cellData.getValue().getOrderStateProperty());
		this.orderTable.setItems(orderData);
	}
}
