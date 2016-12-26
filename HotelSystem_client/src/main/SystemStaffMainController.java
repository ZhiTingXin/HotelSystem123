package main;

import java.util.ArrayList;
import VO.OrderVO;
import VO.SystemStaffVO;
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
	private Button maintainPersonalInfo;// ά��������Ϣ
	@FXML
	private Button exit;
	@FXML
	private TableView<OrderVO> orderTable;
	@FXML
	private TableColumn<OrderVO, String> customerId;
	@FXML
	private TableColumn<OrderVO, String> hotelId;
	@FXML
	private TableColumn<OrderVO, String> orderId;// ��������������
	@FXML
	private TableColumn<OrderVO, String> arriveTime;// ���
	@FXML
	private TableColumn<OrderVO, String> orderDuration;// ����ʱ��

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private Order_blservice order_blservice;

	private ArrayList<OrderVO> abnormalOrderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();
	//����Щ������, ������Ҫ����ObservableList. ����һ���µ�ObservableList. 
	public SystemStaffMainController() {
		order_blservice = new Order_bl();
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaff) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaff;
		// ��ʼ���쳣�����б�
		//*************δ��ɵ�����ʾ���쳣�����ǣ�*�죩֮�ڵģ��������Ĵ����****************//
		abnormalOrderList = order_blservice.getAllAbnormalOrders();// bl�����getAbnoemalOrders����
		for (OrderVO abnormalOrderVO : abnormalOrderList) {
			orderData.add(abnormalOrderVO);
		}
		// ��ʾ�쳣����
		customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIdProperty());
		hotelId.setCellValueFactory(cellData -> cellData.getValue().getHotelIDProperty());
		orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
		arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
		orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());
		// �ڱ������ʹ��setCellValueFactory(...) ��ȷ��Ϊ�ض���ʹ��orderData�����ĳ������.
		// ��ͷ -> ��ʾ������ʹ��Java 8�� Lambdas ����
		SystemStaffMainShow(this.mainScene);
	}

	public void SystemStaffMainShow(Main m) {
		
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		orderTable.setItems(orderData);//��ʾtable
	}

	//��private��@FXML����˽���Ժ���Ϣ��ȫ
	// �쳣��������
	@FXML
	private void handleSystemStaffOrderManagement() {
		mainScene.showSystemStaffOrderManagementScene(systemStaffVO);
	}

	// ����ֵ����
	@FXML
	private void handleSystemStaffCreditManagement() {
		mainScene.showSystemStaffCreditManagementScene(systemStaffVO);
	}

	// ��������
	@FXML
	private void handleSystemStaffMakeStrategy() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}

	// �������
	@FXML
	private void handleSystemStaffAdviceFeedBack() {
        mainScene.showSystemStaffAdviceViewScene(systemStaffVO);
	}

	// ά��������Ϣ
	@FXML
	private void handleSystemStaffInfo() {
		mainScene.showSystemStaffInfoScene(systemStaffVO);
	}

	// ע��
	@FXML
	private void handleSystemStaffExit() {
		mainScene.showLoginScene();
	}
}
