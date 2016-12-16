package presentation.controller.adviceFeedBackController;

import java.time.LocalDate;

import VO.AdviceFeedBackVO;
import VO.CustomerVO;
import blservice.AdviceFeedBack_blservice;
import blservice.impl.AdviceFeedBack_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import main.Main;

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
	private CustomerVO customer;
	private AdviceFeedBackVO advice;
	private AdviceFeedBack_blservice service;

	public void initialize(Main main, CustomerVO customer2) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.customer = customer2;
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
		if (this.sendInfo.getText() != "") {
			this.advice.setAdviceFeedBack_content(this.sendInfo.getText());
			LocalDate today = LocalDate.now();
			this.advice.setUserID(this.customer.getId());
			this.advice.setSendTime(today);
			this.service.addAdviceFeedBack(advice);
			this.mainScene.showCustomerAdviceViewScene(customer);
		}
	}

	@FXML
	private void handleBack() {
		this.mainScene.showCustomerAdviceViewScene(customer);
	}

}
