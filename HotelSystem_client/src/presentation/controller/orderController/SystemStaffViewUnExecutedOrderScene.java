package presentation.controller.orderController;

import java.util.ArrayList;

import VO.OrderVO;
import VO.SystemStaffVO;
import blservice.Order_blservice;
import blservice.impl.Order_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class SystemStaffViewUnExecutedOrderScene {

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
	private TableColumn<OrderVO, String> hotelName;
	@FXML
	private TableColumn<OrderVO, String> customerId;
	@FXML
	private TableColumn<OrderVO, String> arriveTime;// 到达时间
	@FXML
	private TableColumn<OrderVO, String> orderDuration;// 订单时长

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private Order_blservice order_blservice;

	private ArrayList<OrderVO> unExecutedOrderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();// 声明

	public SystemStaffViewUnExecutedOrderScene() {
		order_blservice = new Order_bl();
	}

	// 初始化界面
	public void initialize(Main mainScene, SystemStaffVO systemStaffVO) {

		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;

		unExecutedOrderList = order_blservice.getTodayUnfinishedOrders();// 获取未执行订单
		for (OrderVO UnFinishedOrderVO : unExecutedOrderList) {// 把所有的未执行订单加到orderData
			orderData.add(UnFinishedOrderVO);
		}
		// 显示所有的未执行订单
		setTable();
		SystemStaffViewUnExecutedOrderShow(mainScene);// 调用show
	}

	// 显示
	public void SystemStaffViewUnExecutedOrderShow(Main mainScene) {
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		myPicture.setImage(ImageUtil.setImage(this.systemStaffVO.getImage()));
	}

	// 查看订单处理
	@FXML
	private void handleViewOrderInfo() {
		OrderVO orderVO = this.orderTable.getSelectionModel().getSelectedItem();
		if (orderVO == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("提醒");
			alert.setContentText("请先选择订单后再进行操作");
			alert.showAndWait();
		} else {
			mainScene.showSystemStaffOrderViewScene(systemStaffVO, orderVO);
		}
	}

	@FXML
	// 搜索功能
	private void handleSearch() {
		String inputString = searchInput.getText();
		if (!inputString.equals("")) {
			// 该订单确实存在
			OrderVO myOrder1 = order_blservice.getOrder(inputString);//订单id搜索
			ArrayList<OrderVO> myOrder2 = order_blservice.getUnfinishedOrders(inputString);//用户的未执行订单
			ArrayList<OrderVO> myOrder3= order_blservice.getHotelUndoOrderList(inputString);//酒店的未执行订单
			
			if (myOrder1!=null) {
				orderData.add(myOrder1);
				setTable();
			}else if (myOrder2.size()!=0) {
				for (OrderVO orderVO2 : myOrder2) {
					orderData.add(orderVO2);
				}
				setTable();
			}else if (myOrder3.size()!=0) {
				for (OrderVO orderVO3 : myOrder3) {
					orderData.add(orderVO3);
				}
				setTable();
			}
			// 该订单不存在
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("抱歉");
				alert.setHeaderText("查找失败");
				alert.setContentText("非常遗憾，未能查询到该订单信息！");
				alert.showAndWait();
			}
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("抱歉");
			alert.setHeaderText("查找失败");
			alert.setContentText("请输入查找条件！");
			alert.showAndWait();
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}

	@FXML
	private void handleReset() {

		unExecutedOrderList = order_blservice.getTodayUnfinishedOrders();// 获取未执行订单
		for (OrderVO UnFinishedOrderVO : unExecutedOrderList) {// 把所有的未执行订单加到orderData
			orderData.add(UnFinishedOrderVO);
		}
		// 显示所有的未执行订单
		setTable();
	}
	
	
	//显示表格
	private void setTable(){
		customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIdProperty());// 添加所有的tableColumn
		hotelName.setCellValueFactory(cellData -> cellData.getValue().getHotelNameProperty());
		orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
		arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
		orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());
		orderTable.setItems(orderData);
	}
}
