package presentation.controller.orderController;

import java.time.LocalDateTime;
import java.util.Optional;
import VO.OrderVO;
import VO.SystemStaffVO;
import blservice.Order_blservice;
import blservice.impl.Order_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import other.OrderState;
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
	private Label orderIdLabel;// 订单id
	@FXML
	private Label IdLabel;// 客户id
	@FXML
	private Label nameLabel;// 客户姓名
	@FXML
	private Label nameOfHotel;// 酒店名称
	@FXML
	private Label typeOfRoom;// 房间类型
	@FXML
	private Label numberOfRoom;
	@FXML
	private Label durationOfOrder;// 订单时长
	@FXML
	private Label timeOfArrive;// 到达时间
	@FXML
	private Label actualPayment;// 实际付款
	@FXML
	private Label stateOfOrder;// 订单状态
	@FXML
	private Label revacationTime;// 撤销时间

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
		// 左边栏
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		// 右边栏
		orderIdLabel.setText(orderVO.getOrderID());
		IdLabel.setText(orderVO.getUserID());// 客户id
		nameLabel.setText(orderVO.getUserName());
		nameOfHotel.setText(orderVO.getHotelID());
		typeOfRoom.setText(String.valueOf(orderVO.getRoomType()));
		numberOfRoom.setText(String.valueOf(orderVO.getRoomNum()));
		durationOfOrder.setText(String.valueOf(orderVO.getLastime()));
		timeOfArrive.setText(DateUtil.format(orderVO.getEntryTime()));
		actualPayment.setText(String.valueOf(orderVO.getPrice()));
		stateOfOrder.setText(String.valueOf(orderVO.getOrderState()));
		revacationTime.setText("无");
	}

	@FXML//撤销订单
	private void handleRevocationException(){
	    orderVO.setOrderState(OrderState.REVACATION);
		boolean isOK = 	order_blservice.changeState(orderVO);
		boolean isChange = order_blservice.changeCredit(orderVO.getUserID(), orderVO.getOrderID());//恢复信用值
		if (isOK&& isChange) {
		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("恭喜");
			alert.setHeaderText("撤销成功");
			alert.setContentText("您已经成功撤销一条异常订单！");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.get() == ButtonType.OK){
				stateOfOrder.setText(String.valueOf(orderVO.getOrderState()));//修改订单状态为已撤销状态
				revacationTime.setText(util.DateUtil.format(LocalDateTime.now()));
			}
			
		}else {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("撤销失败");
			alert.setContentText("您未能成功撤销一条异常订单！");
			alert.showAndWait();	
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemStaffOrderManagementScene(systemStaffVO);
	}
}
