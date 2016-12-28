package presentation.controller.userManagementController;

import VO.CustomerVO;
import VO.LogofUserVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import main.Main;
import util.DateUtil;
import util.ImageUtil;

public class CustomerViewCreditSpecController {

	@FXML
	private Label leftId;
	@FXML
	private Label leftName;
	@FXML
	private ImageView leftMenuImage;
	@FXML
	private Button back;
	@FXML
	private Label time;
	@FXML
	private TextArea disc;
	@FXML
	private Label change;
	
	private Main mainScene;
	private CustomerVO customerVO;
	private LogofUserVO logofUserVO;
	
	public void initialize(Main main,CustomerVO customerVO,LogofUserVO log){
		this.customerVO = customerVO;
		this.mainScene = main;
		this.logofUserVO = log;
		leftbegin();
		rightbegin();
	}
	
	/**
	 * 对界面左边初始化
	 */
	private void leftbegin(){
		leftId.setText(customerVO.getId());
		leftName.setText(customerVO.getUsername());
		leftMenuImage.setImage(ImageUtil.setImage(customerVO.getImage()));
	}
	
	/**
	 * 对界面左边初始化
	 */
	private void rightbegin(){
		time.setText(DateUtil.format(logofUserVO.getDateTime()));
		disc.setText(logofUserVO.getContent());
		change.setText(String.valueOf(logofUserVO.getChange()));
	}
	
	@FXML
	private void handleBack(){
		mainScene.showCustomerCreditView(customerVO);
	}
}
