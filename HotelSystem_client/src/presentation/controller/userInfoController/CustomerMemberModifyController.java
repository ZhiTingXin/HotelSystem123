package presentation.controller.userInfoController;

import VO.CustomerVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import main.Main;
import other.memberState;
import util.ImageUtil;

public class CustomerMemberModifyController {
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView leftMenuImage;
	@FXML
	private Label idLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label memberLabel;
	@FXML
	private Label CreditLabel;
	@FXML
	private Button leftNormalMemberButton;
	@FXML
	private Button leftCompanyMemberButton;
	@FXML
	private Button back;

	private Main mainScene;
	private UserInfo_blservice blservice;
	private CustomerVO customer;

	public CustomerMemberModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main mainScene, CustomerVO customer) {
		this.mainScene = mainScene;
		this.customer = customer;
		this.CustomerinfoShow();
	}

	@FXML
	private void CustomerinfoShow() {
		this.leftIdLabel.setText(this.customer.getId());
		this.leftNameLabel.setText(this.customer.getUsername());
		this.leftMenuImage.setImage(ImageUtil.setImage(customer.getImage()));
		this.nameLabel.setText(this.customer.getUsername());
		this.idLabel.setText(this.customer.getId());
		this.CreditLabel.setText(String.valueOf(this.customer.getCredit()));
		if (customer.getMemberState() == memberState.BUSINESS_MEMBER) {
			this.memberLabel.setText("企业会员");
		} else if (customer.getMemberState() == memberState.NORMAL_MEMBER) {
			this.memberLabel.setText("普通会员");
		} else {
			this.memberLabel.setText("非会员");
		}
	}

	@FXML
	private void handleback() {
		this.mainScene.showCustomerInfoScene(customer);
	}

	@FXML
	private void handleNormalMemberModify() {
		this.customer.setMemberState(memberState.NORMAL_MEMBER);
		// bl层方法
		this.blservice.modifyCustomer(customer);
		// 显示下一个界面
		this.mainScene.showCustomerInfoScene(customer);
	}

	@FXML
	private void handleCompanyMemberModify() {
		this.customer.setMemberState(memberState.BUSINESS_MEMBER);

		// bl层方法
		this.blservice.modifyCustomer(customer);

		// 显示下一个界面
		this.mainScene.showCustomerInfoScene(customer);
	}
}
