package presentation.controller.adviceFeedBackController;

import java.time.LocalDate;
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
		this.service = new AdviceFeedBack_bl();
		this.staffVO = staffVO;
		this.setInfo();
	}
	
	/**
	 * ���ڳ�ʼ������
	 */
	private void setInfo(){
		idLabel.setText(staffVO.getId());
		nameLabel.setText(staffVO.getUsername());
		sendTime.setText(DateUtil.format(advice.getSendTime()));
		customerId.setText(advice.getUserID());
		adviceInfo.setText(advice.getAdviceFeedBack_content());
		replyTime.setText(DateUtil.format(LocalDate.now()));
	}
	
	/**
	 * ���ڴ���yes��ť
	 */
	@FXML
	private void handleYes() {
		//��Ϊ��ʱ
		if(this.reply.getText()!=""){
			clicked = true;
			advice.setReplyContent(reply.getText());
			advice.setReplyTime(DateUtil.parse_1(replyTime.getText()));
			boolean isOk = service.modifyAdviceFeedBack(advice);
			if(isOk){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("��ϲ");
				alert.setContentText("�ظ��ɹ�");
				alert.showAndWait();
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("�Բ���");
				alert.setContentText("�ظ�ʧ��");
				alert.showAndWait();
			}
		}else{//Ϊ��ʱ
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("�Բ�������δ��д�ظ���Ϣ");
			alert.setContentText("����д�ظ���Ϣ");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleBack(){
		if(!clicked&&(this.reply.getText()!="")){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("����");
			alert.setContentText("ȷ��Ҫ�˳����˳����������Ļظ����б���");
			ButtonType yes = new ButtonType("��");
			ButtonType no = new ButtonType("��");
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
