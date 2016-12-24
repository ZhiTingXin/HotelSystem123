package presentation.controller.adviceFeedBackController;

import java.time.LocalDate;
import java.util.Optional;

import VO.AdviceFeedBackVO;
import VO.CustomerVO;
import blservice.AdviceFeedBack_blservice;
import blservice.impl.AdviceFeedBack_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import main.Main;
import other.AdviceFeedBackState;

public class CustomerCreateAdviceController {
	@FXML
	private Label leftIDLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button send;
	@FXML
	private Button back;
	@FXML
	private TextArea sendInfo;

	private Main mainScene;
	private boolean isSave;
	private CustomerVO customer;
	private AdviceFeedBackVO advice;
	private AdviceFeedBack_blservice service;

	public void initialize(Main main, CustomerVO customer2) {

		this.mainScene = main;
		this.customer = customer2;
		isSave = false;
		this.service = new AdviceFeedBack_bl();
		this.advice = new AdviceFeedBackVO();
		this.showCreateAdvice();
	}

	private void showCreateAdvice() {
		this.leftIDLabel.setText(this.customer.getId());
		this.leftNameLabel.setText(this.customer.getUsername());
	}

	@FXML
	private void handleSend() {
		if (!this.sendInfo.getText().equals("")) {
			isSave = true;
			this.advice.setAdviceFeedBack_content(this.sendInfo.getText());
			LocalDate today = LocalDate.now();
			this.advice.setUserID(this.customer.getId());
			this.advice.setSendTime(today);
			this.advice.setState(AdviceFeedBackState.UNPROCESSED);
			this.service.addAdviceFeedBack(advice);
			this.mainScene.showCustomerAdviceViewScene(customer);
		}else{
			Alert alert = new  Alert(AlertType.ERROR);
			alert.setTitle("提醒");
			alert.setContentText("请先填写反馈信息后在发送");
			alert.showAndWait();
		}
	}

	@FXML
	private void handleBack() {
		if(!isSave &&(!sendInfo.getText().equals(""))){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("提醒");
			alert.setContentText("确定要退出吗，退出将不对您的反馈进行保存");
			ButtonType yes = new ButtonType("是");
			ButtonType no = new ButtonType("否");
			alert.getButtonTypes().setAll(yes,no);
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get()==yes) {
				this.mainScene.showCustomerAdviceViewScene(customer);
			}
		}else {
			this.mainScene.showCustomerAdviceViewScene(customer);
		}
	}

}
