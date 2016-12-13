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
	private Label orderIdLabel;// ∂©µ•id
	@FXML
	private Label IdLabel;// øÕªßid
	@FXML
	private Label nameLabel;// øÕªß–’√˚
	@FXML
	private Label nameOfHotel;// æ∆µÍ√˚≥∆
	@FXML
	private Label typeOfRoom;// ∑øº‰¿‡–Õ
	@FXML
	private Label numberOfRoom;
	@FXML
	private Label durationOfOrder;// ∂©µ• ±≥§
<<<<<<< HEAD
	@FXML
	private Label timeOfArrive;// µΩ¥Ô ±º‰
	@FXML
	private Label actualPayment;//  µº ∏∂øÓ
	@FXML
	private Label stateOfOrder;// ∂©µ•◊¥Ã¨
	@FXML
	private Label revacationTime;// ≥∑œ˙ ±º‰
=======
	@FXML
	private Label timeOfArrive;// µΩ¥Ô ±º‰
	@FXML
	private Label actualPayment;//  µº ∏∂øÓ
	@FXML
	private Label stateOfOrder;// ∂©µ•◊¥Ã¨
>>>>>>> refs/remotes/origin/Âè∂ÊôìÊ≥¢

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
		// ◊Û±ﬂ¿∏
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		// ”“±ﬂ¿∏
		orderIdLabel.setText(orderVO.getOrderID());
		IdLabel.setText(orderVO.getUserID());// øÕªßid
		nameLabel.setText(orderVO.getUserName());
		nameOfHotel.setText(orderVO.getHotelID());
		typeOfRoom.setText(String.valueOf(orderVO.getRoomType()));
		numberOfRoom.setText(String.valueOf(orderVO.getRoomNum()));
		durationOfOrder.setText(String.valueOf(orderVO.getLastime()));
		timeOfArrive.setText(DateUtil.format(orderVO.getEntryTime()));
		actualPayment.setText(String.valueOf(orderVO.getPrice()));
		stateOfOrder.setText(String.valueOf(orderVO.getOrderState()));
		revacationTime.setText("Œﬁ");
	}

<<<<<<< HEAD
	@FXML//≥∑œ˙∂©µ•
	private void handleRevocationException(){
		boolean isOK = 	order_blservice.changeState(orderVO.getOrderID());
		boolean isChange = order_blservice.changeCredit(orderVO.getUserID(), orderVO.getOrderID());//ª÷∏¥–≈”√÷µ
		if (isOK&& isChange) {
		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("πßœ≤");
			alert.setHeaderText("≥∑œ˙≥…π¶");
			alert.setContentText("ƒ˙“—æ≠≥…π¶≥∑œ˙“ªÃı“Ï≥£∂©µ•£°");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.get() == ButtonType.OK){
				stateOfOrder.setText(String.valueOf(orderVO.getOrderState()));//–ﬁ∏ƒ∂©µ•◊¥Ã¨Œ™“—≥∑œ˙◊¥Ã¨
				revacationTime.setText(util.DateUtil.format(LocalDateTime.now()));
			}
			
		}else {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("±ß«∏");
			alert.setHeaderText("≥∑œ˙ ß∞‹");
			alert.setContentText("ƒ˙Œ¥ƒ‹≥…π¶≥∑œ˙“ªÃı“Ï≥£∂©µ•£°");
			alert.showAndWait();	
=======
	@FXML // ≥∑œ˙∂©µ•
	private void handleRevocationException() {
		if (order_blservice.changeState(orderVO)) {
			stateOfOrder.setText(String.valueOf(orderVO.getOrderState()));// –ﬁ∏ƒ∂©µ•◊¥Ã¨Œ™“—≥∑œ˙◊¥Ã¨
			order_blservice.changeCredit(orderVO.getUserID(), orderVO.getOrderID());// ª÷∏¥–≈”√÷µ
			// …Ë÷√µØ¥∞Ã· æ–ﬁ∏ƒ≥…π¶ ª÷∏¥–≈”√÷µ≥…π¶ “‘º∞º«¬º≥∑œ˙ ±º‰
			// TODO MY DIALOG
		} else {
			// TODO –ﬁ∏ƒ ß∞‹
>>>>>>> refs/remotes/origin/Âè∂ÊôìÊ≥¢
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemStaffOrderManagementScene(systemStaffVO);
	}
}
