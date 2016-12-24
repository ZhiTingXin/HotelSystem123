package presentation.controller.adviceFeedBackController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import VO.AdviceFeedBackVO;
import VO.SystemStaffVO;
import blservice.AdviceFeedBack_blservice;
import blservice.impl.AdviceFeedBack_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import main.Main;
import other.AdviceFeedBackState;
import util.DateUtil;

public class SystemStaffAdviceViewSpecController {

	@FXML
	private Label idLabel;
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private Button yes;
	
	@FXML
	private Button back;
	
	@FXML
	private Label sendTime;
	
	@FXML
	private Label customerId;
	
	@FXML
	private TextField adviceInfo;
	
	@FXML
	private Label replyTime;
	
	@FXML
	private TextArea reply;
	
	@FXML
	private Label state;
 
	private SystemStaffVO staffVO;
	private Main mainScene;
	private AdviceFeedBackVO advice;
	private AdviceFeedBack_blservice service;
	private boolean clicked;
	
	public void initialize(Main main,AdviceFeedBackVO advice,SystemStaffVO staffVO) {
		clicked = false;
		this.mainScene = main;
		this.advice = advice;
		this.service = new AdviceFeedBack_bl();
		this.staffVO = staffVO;
		this.setInfo();
	}
	
	/**
	 * 用于初始化界面
	 */
	private void setInfo(){
		idLabel.setText(staffVO.getId());
		nameLabel.setText(staffVO.getUsername());
		sendTime.setText(DateUtil.format(advice.getSendTime()));
		customerId.setText(advice.getUserID());
		adviceInfo.setText(advice.getAdviceFeedBack_content());
		LocalDate date = LocalDate.now();
		replyTime.setText(DateUtil.format(date));
	}
	
	/**
	 * 用于处理yes按钮
	 */
	@FXML
	private void handleYes() {
		//不为空时
		if(this.reply.getText()!=""){
			clicked = true;
			advice.setReplyContent(reply.getText());
			advice.setState(AdviceFeedBackState.PROCESSED);
			advice.setReplyTime(DateUtil.parse_1(replyTime.getText()));
			boolean isOk = service.modifyAdviceFeedBack(advice);
			if(isOk){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("恭喜");
				alert.setContentText("回复成功");
				alert.showAndWait();
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("抱歉");
				alert.setHeaderText("对不起");
				alert.setContentText("回复失败");
				alert.showAndWait();
			}
		}else{//为空时
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("对不起，您尚未填写回复信息");
			alert.setContentText("请填写回复信息");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleBack(){
		if(!clicked&&(this.reply.getText()!="")){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提醒");
			alert.setContentText("确定要退出吗，退出将不对您的回复进行保存");
			ButtonType yes = new ButtonType("是");
			ButtonType no = new ButtonType("否");
			alert.getButtonTypes().setAll(yes,no);
			Optional<ButtonType> btn = alert.showAndWait();
			if(btn.get()== yes){
				mainScene.showSystemStaffAdviceViewScene(staffVO);
			}
		}else {
			mainScene.showSystemStaffAdviceViewScene(staffVO);
		}
	}
}
