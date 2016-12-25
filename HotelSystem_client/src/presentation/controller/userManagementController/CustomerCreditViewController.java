package presentation.controller.userManagementController;

import java.util.ArrayList;

import VO.CustomerVO;
import VO.LogofUserVO;
import blservice.LogOfUser_blServce;
import blservice.impl.LogOfUser_blServceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Main;

public class CustomerCreditViewController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button viewSpec;
	@FXML
	private Button exit;
	@FXML
	private TableView<LogofUserVO> logs;
	@FXML
	private TableColumn<LogofUserVO, String> time;
	@FXML
	private TableColumn<LogofUserVO, String> disc;
	@FXML
	private TableColumn<LogofUserVO, String> change;
	
	private LogOfUser_blServce logOfUser_blServce;
	private CustomerVO customerVO;
	private ObservableList<LogofUserVO> logsData = FXCollections.observableArrayList();
	private Main mainScene;
	
	public void innitialize(CustomerVO customerVO,Main mainScene){
		logOfUser_blServce = new LogOfUser_blServceImpl();
		this.customerVO = customerVO;
		this.mainScene =mainScene;
		leftbegin();
		rightbegin();
	}
	/**
	 *��ʼ����߅�Ļ�����Ϣ
	 */
	private void leftbegin(){
		leftIdLabel.setText(customerVO.getId());
		leftNameLabel.setText(customerVO.getUsername());
	}
	/**
	 * ��ʼ����߅�Ļ�����Ϣ
	 */
    private void rightbegin(){
		ArrayList<LogofUserVO> logofUserVOs = logOfUser_blServce.getAllLogsOfUser(customerVO.getId());
		for(LogofUserVO vo:logofUserVOs){
			logsData.add(vo);
		}
		
		time.setCellValueFactory(cellData->cellData.getValue().gettimeProperty());
	    disc.setCellValueFactory(cellData->cellData.getValue().getDiscProperty());
		change.setCellValueFactory(cellData->cellData.getValue().getChangeProperty());
		
		logs.setItems(logsData);
	}
    
    /**
     * ��Ӧ�鿴��ϸ��Ϣ
     */
    @FXML
    private void handleViewSpec(){
    	LogofUserVO selected = logs.getSelectionModel().getSelectedItem();
		if (selected!=null) {
			mainScene.showCustomerCreditViewSpecScene(customerVO, selected);
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("����");
			alert.setContentText("����ѡ�к��ڲ鿴������Ϣ");
			alert.showAndWait();
		}
    }
    
    /**
     * ��Ӧ����
     */
    @FXML
    private void handleExit(){
    	mainScene.showCustomerInfoScene(customerVO);
    }
    
    
}
