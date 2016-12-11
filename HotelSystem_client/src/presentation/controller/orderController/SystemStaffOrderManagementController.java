package presentation.controller.orderController;

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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;

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
	private UserInfo_blservice systemStaffInfoService;
	private Order_blservice order_blservice;

	private ArrayList<OrderVO> abnormalOrderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();// ����

	public SystemStaffOrderManagementController() {
		systemStaffInfoService = new UserInfo_bl();
		order_blservice = new Order_bl();
	}

	// ��ʼ������
	public void initialize(Main mainScene, SystemStaffVO systemStaffVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;

		String systemStaffID = this.systemStaffVO.getId();// �õ�systemstaff��ID
		abnormalOrderList = order_blservice.getAbnomalOrders(systemStaffID);// ����bl��getAbnoemalOrders������ȡ�쳣����
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
		orderTable.setItems(orderData);
	}

	// ��private��@FXML����˽���ԺͰ�ȫ
	// �鿴��������
	@FXML
	private void handleViewOrderInfo(){
		int focusOn = this.orderTable.getSelectionModel().getFocusedIndex();
		mainScene.showSystemStaffOrderViewScene(systemStaffVO,abnormalOrderList.get(focusOn));
	}
	@FXML
	//��������
	private void handleSearch(){
		String orderId = searchInput.getText();
		if (orderId!=null) {
			//�ö���ȷʵ����
			if (order_blservice.getOrder(orderId)!=null) {
				OrderVO myOrder = order_blservice.getOrder(orderId);
				orderData.add(myOrder);
				this.customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIdProperty());// ������е�tableColumn
				this.hotelId.setCellValueFactory(cellData -> cellData.getValue().getHotelIDProperty());
				this.orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
				this.arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
				this.orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());
				orderTable.setItems(orderData);
			}
			//�ö���������
			else {
				//TODO ��ʾ�� �������ڸö�����
			}
		} else {
			//TODO ��ʾ�� ����������Ϣ��
		}
		
	}
	@FXML
	private void handleBack(){
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}
}
