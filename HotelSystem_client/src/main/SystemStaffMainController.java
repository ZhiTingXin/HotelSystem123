package main;

import java.util.ArrayList;

import VO.OrderVO;
import VO.SystemStaffVO;
import blservice.Order_blservice;
import blservice.UserInfo_blservice;
import blservice.impl.Order_bl;
import blservice.impl.UserInfo_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class SystemStaffMainController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button ExceptionOrderManagement;
	@FXML
	private Button creditManagement;
	@FXML
	private Button makeSystemStrategy;
	@FXML
	private Button adcviceManagement;
	@FXML
	private Button maintainPersonalInfo;// 维护个人信息
	@FXML
	private Button exit;
	@FXML
	private Label districtName;
	@FXML
	private TableView<OrderVO> orderTable;
	@FXML
	private TableColumn<OrderVO, String> customerId;
	@FXML
	private TableColumn<OrderVO, String> hotelId;
	@FXML
	private TableColumn<OrderVO, String> orderId;// 房间数量和类型
	@FXML
	private TableColumn<OrderVO, String> arriveTime;// 简介
	@FXML
	private TableColumn<OrderVO, String> orderDuration;// 订单时长

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private UserInfo_blservice systemStaffInfoService;
	private Order_blservice order_blservice;

	private ArrayList<OrderVO> abnormalOrderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();
	//在这些集合中, 我们需要的是ObservableList. 创建一个新的ObservableList. 
	public SystemStaffMainController() {
		systemStaffInfoService = new UserInfo_bl();
		order_blservice = new Order_bl();
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaff) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaff;
		// 初始化异常订单列表
		//*************未完成的是显示的异常订单是（*天）之内的（新增）的处理的****************//
		String systemStaffID = this.systemStaffVO.getId();
		abnormalOrderList = order_blservice.getAbnomalOrders(systemStaffID);// bl层调用getAbnoemalOrders方法
		for (OrderVO abnormalOrderVO : abnormalOrderList) {
			orderData.add(abnormalOrderVO);
		}
		// 显示异常订单
		customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIdProperty());
		hotelId.setCellValueFactory(cellData -> cellData.getValue().getHotelIDProperty());
		orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
		arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
		orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());
		// 在表格列上使用setCellValueFactory(...) 来确定为特定列使用orderData对象的某个属性.
		// 箭头 -> 表示我们在使用Java 8的 Lambdas 特性
		SystemStaffMainShow(this.mainScene);
	}

	public void SystemStaffMainShow(Main m) {
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		districtName.setText(systemStaffVO.getBusinessDistrict());
		orderTable.setItems(orderData);//显示table
	}

	//用private和@FXML保持私有性和信息安全
	// 异常订单处理
	@FXML
	private void handleSystemStaffOrderManagement() {
		mainScene.showSystemStaffOrderManagementScene(systemStaffVO);
	}

	// 信用值管理
	@FXML
	private void handleSystemStaffCreditManagement() {
		mainScene.showSystemStaffCreditManagementScene(systemStaffVO);
	}

	// 促销策略
	@FXML
	private void handleSystemStaffMakeStrategy() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}

	// 意见反馈
	@FXML
	private void handleSystemStaffAdviceFeedBack() {

	}

	// 维护个人信息
	@FXML
	private void handleSystemStaffInfo() {
		mainScene.showSystemStaffInfoScene(systemStaffVO);
	}

	// 注销
	@FXML
	private void handleSystemStaffExit() {
		mainScene.showLoginScene();
	}
}
