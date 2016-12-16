package presentation.controller.adviceFeedBackController;

import VO.AdviceFeedBackVO;
import VO.CustomerVO;
import blservice.AdviceFeedBack_blservice;
import blservice.impl.AdviceFeedBack_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import main.Main;

public class CustomerAdviceInfoController {
	@FXML
	private Label leftIDLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Label sendTime;
	@FXML
	private Label rerlyTime;
	@FXML
	private TextArea sendInfo;
	@FXML
	private TextArea replyInfo;
	@FXML
	private Button reply;
	@FXML
	private Button back;

	private Main mainScene;
	private CustomerVO customer;
	private AdviceFeedBackVO advice;
	private AdviceFeedBack_blservice service;

	public void initialize(Main main, CustomerVO customer2, AdviceFeedBackVO advice2) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.advice = advice2;
		this.customer = customer2;
		this.service = new AdviceFeedBack_bl();
		this.showAdviceInfo();
	}

	private void showAdviceInfo() {
		this.leftIDLabel.setText(this.customer.getId());
		this.leftNameLabel.setText(this.customer.getUsername());
		this.sendTime.setText(this.advice.getSendTime().toString());
		if (this.advice.getReplyTime()!=null) {
			this.rerlyTime.setText(this.advice.getReplyTime().toString());
		}else {
			this.rerlyTime.setText("Î´»Ø¸´");
		}
		
		this.sendInfo.setText(this.advice.getAdviceFeedBack_content());
		this.replyInfo.setText(this.advice.getReplyContent());
	}

	@FXML
	private void handleReply() {
		this.mainScene.showCustomerCreateAdviceScene(customer);
	}

	@FXML
	private void handleBack() {
		this.mainScene.showCustomerAdviceViewScene(customer);
	}

}
