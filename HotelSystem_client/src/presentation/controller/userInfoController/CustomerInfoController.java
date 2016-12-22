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
import util.DateUtil;

public class CustomerInfoController {
	@FXML
	private Button modifyPersonalInfo;
	@FXML
	private Button modifyPassword;
	@FXML
	private Button modifyMember;
	@FXML
	private Button backTOSuper;
	@FXML
	private Button back;
	@FXML
	private Label idLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label memberLabel;
	@FXML
	private Label birthdayLabel;
	@FXML
	private Label companyLabel;
	@FXML
	private Label creditLabel;
	@FXML
	private Label stateLabel;
	@FXML
	private Label leftMenuNameLabel;
	@FXML
	private Label leftMenuIdLabel;
	@FXML
	private ImageView leftMenuImage;
	@FXML
	private ImageView image;
	@FXML
	private Label phoneLabel;

	private Main mainsence;
	private CustomerVO Customer;

	public UserInfo_blservice blservice;

	public CustomerInfoController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main mainscene, CustomerVO customer) {
		this.mainsence = mainscene;
		this.Customer = customer;
		this.CustomerinfoShow(this.mainsence);
	}

	public void CustomerinfoShow(Main mainScene) {
		this.idLabel.setText(Customer.getId());
		if (!this.Customer.getUsername().equals("")) {
			this.nameLabel.setText(Customer.getUsername());
		} else {
			this.nameLabel.setText("暂缺");
		}

		if (this.Customer.getBirthday() != null) {
			this.birthdayLabel.setText(DateUtil.format(Customer.getBirthday()));
		} else {
			this.birthdayLabel.setText("暂缺");
		}
		if (this.Customer.getCompanyName() != null && !this.Customer.getCompanyName().equals("")) {
			this.companyLabel.setText(Customer.getCompanyName());
		} else {
			this.companyLabel.setText("暂缺");
		}

		this.creditLabel.setText(String.valueOf(Customer.getCredit()));

		if (Customer.getMemberState() == memberState.BUSINESS_MEMBER) {
			this.memberLabel.setText("企业会员");
		} else if (Customer.getMemberState() == memberState.NORMAL_MEMBER) {
			this.memberLabel.setText("普通会员");
		} else {
			this.memberLabel.setText("非会员");
		}

		this.leftMenuIdLabel.setText(Customer.getId());
		this.leftMenuNameLabel.setText(Customer.getUsername());

		this.phoneLabel.setText(this.Customer.getPhone());
		// this.leftMenuImage.setImage(new Image("D:/我的文档/Pictures/as"));
	}

	public void handleCustomerInfoModify() {
		this.mainsence.showCustomerModifyScene(this.Customer);
	}

	public void handleCustomerPasswordModify() {
		this.mainsence.showCustomerPasswordModifyScene(this.Customer);
	}

	public void handleCustomerMemberModify() {
		this.mainsence.showCustomerMemberModifyScene(this.Customer);
	}

	public void handleBack() {
		this.mainsence.showCustomerMainScene(Customer);
	}
}
