package presentation.controller.adviceFeedBackController;

import VO.AdviceFeedBackVO;
import VO.CustomerVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import main.Main;
import util.DateUtil;
import util.ImageUtil;

public class CustomerAdviceInfoController {
	@FXML
	private Label leftIDLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView leftMenuImage;
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

	public void initialize(Main main, CustomerVO customer2, AdviceFeedBackVO advice2) {
		this.mainScene = main;
		this.advice = advice2;
		this.customer = customer2;
		this.showAdviceInfo();
	}

	private void showAdviceInfo() {
		this.leftIDLabel.setText(this.customer.getId());
		this.leftNameLabel.setText(this.customer.getUsername());
		this.leftMenuImage.setImage(ImageUtil.setImage(customer.getImage()));
		this.sendTime.setText(DateUtil.format(this.advice.getSendTime()));
		if (this.advice.getReplyTime()!=null) {
			this.rerlyTime.setText(DateUtil.format(this.advice.getReplyTime()));
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
