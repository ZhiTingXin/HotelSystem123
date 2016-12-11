package presentation.controller.orderController;

import VO.HotelInfoVO;
import VO.OrderVO;
import VO.SystemStaffVO;
import blservice.Order_blservice;
import blservice.impl.Order_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import util.DateUtil;

public class SystemStaffOrderViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button cancelOrder;
	@FXML
	private Button back;
	@FXML
	private Label orderIdLabel;// ����id
	@FXML
	private Label IdLabel;// �ͻ�id
	@FXML
	private Label nameLabel;// �ͻ�����
	@FXML
	private Label nameOfHotel;// �Ƶ�����
	@FXML
	private Label typeOfRoom;// ��������
	@FXML
	private Label numberOfRoom;
	@FXML
	private Label durationOfOrder;// ����ʱ��
	@FXML
	private Label timeOfArrive;// ����ʱ��
	@FXML
	private Label actualPayment;// ʵ�ʸ���
	@FXML
	private Label stateOfOrder;// ����״̬

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private OrderVO orderVO;
	private Order_blservice order_blservice;

	public SystemStaffOrderViewController() {
		order_blservice = new Order_bl();
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaffVO, OrderVO orderVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.orderVO = orderVO;
		SystemStaffOrderViewShow(this.mainScene);
	}

	public void SystemStaffOrderViewShow(Main mainScene) {
		// �����
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		// �ұ���
		orderIdLabel.setText(orderVO.getOrderID());
		IdLabel.setText(orderVO.getUserID());// �ͻ�id
		nameLabel.setText(orderVO.getUserName());
		nameOfHotel.setText(orderVO.getHotelID());
		typeOfRoom.setText(String.valueOf(orderVO.getRoomType()));
		numberOfRoom.setText(String.valueOf(orderVO.getRoomNum()));
		durationOfOrder.setText(String.valueOf(orderVO.getLastime()));
		timeOfArrive.setText(DateUtil.format(orderVO.getEntryTime()));
		actualPayment.setText(String.valueOf(orderVO.getPrice()));
		stateOfOrder.setText(String.valueOf(orderVO.getOrderState()));
	}

	@FXML // ��������
	private void handleRevocationException() {
		if (order_blservice.changeState(orderVO)) {
			stateOfOrder.setText(String.valueOf(orderVO.getOrderState()));// �޸Ķ���״̬Ϊ�ѳ���״̬
			order_blservice.changeCredit(orderVO.getUserID(), orderVO.getOrderID());// �ָ�����ֵ
			// ���õ�����ʾ�޸ĳɹ� �ָ�����ֵ�ɹ� �Լ���¼����ʱ��
			// TODO MY DIALOG
		} else {
			// TODO �޸�ʧ��
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemStaffOrderManagementScene(systemStaffVO);
	}
}
