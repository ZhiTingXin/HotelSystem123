package presentation.controller.orderController;

import java.util.ArrayList;

import VO.HotelInfoVO;
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
	private Button viewOrderInfo;// �鿴��������
	@FXML
	private Button Undo;// δִ��
	@FXML
	private Button Exception;// �쳣����
	@FXML
	private Button Done;// ��ִ�ж���
	@FXML
	private Button back;
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
	private TableColumn<OrderVO, String> orderTpye;// �������ͣ���������/������
	@FXML
	private TableColumn<OrderVO, String> arriveTime;// ����ʱ��

	// order���б�
	private ArrayList<OrderVO> orderList;
	private ObservableList<OrderVO> orderData = FXCollections.observableArrayList();

	// �������
	private Main mainScene;
	private HotelStaffVO hotelStaff;
	// private HotelInfoVO hotel;
	private Order_blservice orderService;

	public HotelStaffOrderViewController() {

	}

	public void HotelStaffOrderViewShow() {
		this.leftIdLabel.setText(this.hotelStaff.getHotelId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.hotelName.setText(this.hotelStaff.getHotelName());

	}

	public void initialize(Main main, HotelStaffVO hotelStaff) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.hotelStaff = hotelStaff;
		this.orderService = new Order_bl();

		this.orderList = this.orderService.getHotelUndoOrderList(this.hotelStaff.getHotelId());
		this.refreshTable();

		this.orderType.setText("δִ�ж����б�");
		this.HotelStaffOrderViewShow();
	}

	// ���ذ�ť��������
	public void handleBack() {
		this.mainScene.showHotelStaffMainScene(hotelStaff);
	}

	// ������ϸ��Ϣ��ť��������
	public void handleViewOrderInfo() {
		try {
			int focus = 0;
			focus = this.orderTable.getSelectionModel().getFocusedIndex();
			this.mainScene.showHotelStaffManagementOrderScene(hotelStaff, this.orderList.get(focus));
		} catch (Exception e) {
			this.stateLabel.setText("δѡ���κζ�����");;
		}
	}

	// δ��ɶ����б�ť��������
	public void handleUndo() {
		this.orderList = this.orderService.getHotelUndoOrderList(this.hotelStaff.getHotelId());
		this.refreshTable();
		this.orderType.setText("δִ�ж����б�");
	}

	// ����ɶ����б�ť��������
	public void handleDone() {
		this.orderList = this.orderService.getHotelFinishedOrderList(this.hotelStaff.getHotelId());
		this.refreshTable();

		this.orderType.setText("��ִ�ж����б�");
	}

	// �쳣�����б�ť��������
	public void handleException() {
		this.orderList = this.orderService.getHotelAbnormalOrderList(this.hotelStaff.getHotelId());
		this.refreshTable();
		this.orderType.setText("�쳣�����б�");
	}

	// ˢ�±�񷽷�
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
