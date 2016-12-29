package presentation.controller.userInfoController;

import java.time.LocalDate;
import VO.CustomerVO;
import blservice.UserInfo_blservice;
import blservice.impl.UserInfo_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import other.memberState;
import util.ImageUtil;

public class CustomerInfoModifyController {
	@FXML
	private Button save;
	@FXML
	private Button back;
	@FXML
	private Button changeImage;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView leftMenuImage;
	@FXML
	private ImageView image;
	@FXML
	private Label idLabel;
	@FXML
	private Label memberLabel;
	@FXML
	private Label creditLabel;
	@FXML
	private TextField nameTextField;
	@FXML
	private DatePicker datePicker;
	@FXML
	private TextField companyTextField;
	@FXML
	private TextField phoneTextField;
	@FXML
	private Label stateLabel;

	private Main mainScene;
	private CustomerVO customer;
	private UserInfo_blservice blservice;

	public CustomerInfoModifyController() {
		blservice = new UserInfo_bl();
	}

	public void initialize(Main mainScene, CustomerVO customer) {
		this.mainScene = mainScene;
		this.customer = customer;
		this.CustomerinfoShow(this.mainScene);

	}

	public void CustomerinfoShow(Main mainScene) {
		
		/**
		 * 左栏初始化
		 */
		this.leftIdLabel.setText(this.customer.getId());
		this.leftNameLabel.setText(this.customer.getUsername());
		this.leftMenuImage.setImage(ImageUtil.setImage(customer.getImage()));
		
		
		this.idLabel.setText(this.customer.getId());
		this.creditLabel.setText(String.valueOf(this.customer.getCredit()));
		this.image.setImage(ImageUtil.setImage(customer.getImage()));
		this.nameTextField.setText(this.customer.getUsername());
		this.companyTextField.setText(this.customer.getCompanyName());
		if (this.customer.getBirthday() != null) {
			this.datePicker.setValue(LocalDate.of(this.customer.getBirthday().getYear(),
					this.customer.getBirthday().getMonth(), this.customer.getBirthday().getDayOfMonth()));
		}
		if (customer.getMemberState() == memberState.NON_MEMBER) {
			this.memberLabel.setText("非会员");
		} else if (customer.getMemberState() == memberState.NORMAL_MEMBER) {
			this.memberLabel.setText("企业会员");
		} else if (customer.getMemberState() == memberState.NORMAL_MEMBER) {
			this.memberLabel.setText("普通会员");
		}
		this.phoneTextField.setText(this.customer.getPhone());
	}

	public void handleBack() {
		this.mainScene.showCustomerInfoScene(customer);
	}

	public void handleSave() {
		if (this.nameTextField.getText() != "") {
			this.customer.setUsername(this.nameTextField.getText());
		}
		if (this.companyTextField.getText() != "") {
			this.customer.setCompanyName(this.companyTextField.getText());
		}
		if (this.phoneTextField.getText() != "") {
			this.customer.setPhone(this.phoneTextField.getText());
		}
		// 调用Bl层的方法对数据库进行修改
		this.customer.setBirthday(this.datePicker.getValue());
		this.blservice.modifyCustomer(this.customer);
		this.mainScene.showCustomerInfoScene(customer);
	}
	
	@FXML
	private void handleChangeImg(){
		customer.setImage(ImageUtil.setImagePath(image));
	}
}
