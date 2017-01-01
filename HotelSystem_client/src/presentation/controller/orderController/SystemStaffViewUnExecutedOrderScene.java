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
	private TableColumn<OrderVO, String> arriveTime;// ����ʱ��
	@FXML
	private TableColumn<OrderVO, String> orderDuration;// ����ʱ��

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private Order_blservice order_blservice;

	private ArrayList<OrderVO> unExecutedOrderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();// ����

	public SystemStaffViewUnExecutedOrderScene() {
		order_blservice = new Order_bl();
	}

	// ��ʼ������
	public void initialize(Main mainScene, SystemStaffVO systemStaffVO) {

		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;

		unExecutedOrderList = order_blservice.getTodayUnfinishedOrders();// ��ȡδִ�ж���
		for (OrderVO UnFinishedOrderVO : unExecutedOrderList) {// �����е�δִ�ж����ӵ�orderData
			orderData.add(UnFinishedOrderVO);
		}
		// ��ʾ���е�δִ�ж���
		setTable();
		SystemStaffViewUnExecutedOrderShow(mainScene);// ����show
	}

	// ��ʾ
	public void SystemStaffViewUnExecutedOrderShow(Main mainScene) {
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		myPicture.setImage(ImageUtil.setImage(this.systemStaffVO.getImage()));
	}

	// �鿴��������
	@FXML
	private void handleViewOrderInfo() {
		OrderVO orderVO = this.orderTable.getSelectionModel().getSelectedItem();
		if (orderVO == null) {
			Alert alert = new Alert(AlertType.WARNING);
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
		String inputString = searchInput.getText();
		if (!inputString.equals("")) {
			// �ö���ȷʵ����
			OrderVO myOrder1 = order_blservice.getOrder(inputString);//����id����
			ArrayList<OrderVO> myOrder2 = order_blservice.getUnfinishedOrders(inputString);//�û���δִ�ж���
			ArrayList<OrderVO> myOrder3= order_blservice.getHotelUndoOrderList(inputString);//�Ƶ��δִ�ж���
			
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
			// �ö���������
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("����ʧ��");
				alert.setContentText("�ǳ��ź���δ�ܲ�ѯ���ö�����Ϣ��");
				alert.showAndWait();
			}
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("���������������");
			alert.showAndWait();
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}

	@FXML
	private void handleReset() {

		unExecutedOrderList = order_blservice.getTodayUnfinishedOrders();// ��ȡδִ�ж���
		for (OrderVO UnFinishedOrderVO : unExecutedOrderList) {// �����е�δִ�ж����ӵ�orderData
			orderData.add(UnFinishedOrderVO);
		}
		// ��ʾ���е�δִ�ж���
		setTable();
	}
	
	
	//��ʾ���
	private void setTable(){
		customerId.setCellValueFactory(cellData -> cellData.getValue().getCustomerIdProperty());// ������е�tableColumn
		hotelName.setCellValueFactory(cellData -> cellData.getValue().getHotelNameProperty());
		orderId.setCellValueFactory(cellData -> cellData.getValue().getOrderIDProperty());
		arriveTime.setCellValueFactory(cellData -> cellData.getValue().getEntryTimeProperty());
		orderDuration.setCellValueFactory(cellData -> cellData.getValue().getLastTimeProperty());
		orderTable.setItems(orderData);
	}
}
