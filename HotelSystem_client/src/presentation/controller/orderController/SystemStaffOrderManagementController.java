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

public class SystemStaffOrderManagementController {

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
	// @FXML
	// private Label headLabel;
	@FXML
	private TextField searchInput;
	@FXML
	private Button searchButton;
	@FXML
	private TableView<OrderVO> orderTable;
	@FXML
	private TableColumn<OrderVO, String> orderId;
	@FXML
	private TableColumn<OrderVO, String> hotelId;
	@FXML
	private TableColumn<OrderVO, String> customerId;
	@FXML
	private TableColumn<OrderVO, String> arriveTime;// ����ʱ��
	@FXML
	private TableColumn<OrderVO, String> orderDuration;// ����ʱ��

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private Order_blservice order_blservice;

	private ArrayList<OrderVO> abnormalOrderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();// ����

	public SystemStaffOrderManagementController() {
		order_blservice = new Order_bl();
	}

	// ��ʼ������
	public void initialize(Main mainScene, SystemStaffVO systemStaffVO) {

		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;

		abnormalOrderList = order_blservice.getAllAbnormalOrders();// ����bl��getAbnoemalOrders������ȡ�쳣����
		for (OrderVO abnormalOrderVO : abnormalOrderList) {// �����е��쳣�����ӵ�orderData
			orderData.add(abnormalOrderVO);
		}
		// ��ʾ���е��쳣����
		customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIdProperty());// ������е�tableColumn
		hotelId.setCellValueFactory(cellData -> cellData.getValue().getHotelIDProperty());
		orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
		arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
		orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());
		// �ڱ������ʹ��setCellValueFactory(...) ��ȷ��Ϊ�ض���ʹ��orderData�����ĳ������.
		// ��ͷ -> ��ʾ������ʹ��Java 8�� Lambdas ����
		SystemStaffOrderManagementShow(mainScene);// ����show
	}

	// ��ʾ
	public void SystemStaffOrderManagementShow(Main mainScene) {
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		myPicture.setImage(ImageUtil.setImage(this.systemStaffVO.getImage()));
		orderTable.setItems(orderData);
	}

	// ��private��@FXML����˽���ԺͰ�ȫ
	// �鿴��������
	@FXML
	private void handleViewOrderInfo() {
		OrderVO orderVO = this.orderTable.getSelectionModel().getSelectedItem();
		if (orderVO == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("����");
			alert.setContentText("����ѡ�񶩵����ٽ��в���");
			alert.showAndWait();
		} else {
			mainScene.showSystemStaffOrderViewScene(systemStaffVO, orderVO);
		}
	}

	@FXML
	// ��������
	private void handleSearch() {
		String orderId = searchInput.getText();
		if (orderId != null && !orderId.equals("")) {
			// �ö���ȷʵ����
			if (order_blservice.getOrder(orderId) != null) {

				OrderVO myOrder = order_blservice.getOrder(orderId);
				orderData.add(myOrder);
				this.customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIdProperty());// ������е�tableColumn
				this.hotelId.setCellValueFactory(cellData -> cellData.getValue().getHotelIDProperty());
				this.orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
				this.arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
				this.orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());
				orderTable.setItems(orderData);
			}
			// �ö���������
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("����ʧ��");
				alert.setContentText("�ǳ��ź���δ�ܲ�ѯ�ö�����Ϣ��");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("�����붩��ID��");
			alert.showAndWait();
		}

	}

	@FXML
	private void handleBack() {
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}
}
