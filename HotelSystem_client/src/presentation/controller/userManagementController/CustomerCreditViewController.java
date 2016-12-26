package presentation.controller.userManagementController;

import java.util.ArrayList;

import VO.CustomerVO;
import VO.LogofUserVO;
import blservice.LogOfUser_blServce;
import blservice.UserManagement_blservice;
import blservice.impl.LogOfUser_blServceImpl;
import blservice.impl.UserManagement_bl;
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
	private UserManagement_blservice management_blservice;
	private CustomerVO customerVO;
	private ObservableList<LogofUserVO> logsData = FXCollections.observableArrayList();
	private Main mainScene;
	
	public void innitialize(CustomerVO customerVO,Main mainScene){
		logOfUser_blServce = new LogOfUser_blServceImpl();
		management_blservice = new UserManagement_bl();
		this.customerVO = customerVO;
		this.mainScene =mainScene;
		leftbegin();
		rightbegin();
	}
	/**
	 *初始化左邊的基本信息
	 */
	private void leftbegin(){
		leftIdLabel.setText(customerVO.getId());
		leftNameLabel.setText(customerVO.getUsername());
	}
	/**
	 * 初始化右邊的基本信息
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
     * 响应查看详细信息
     */
    @FXML
    private void handleViewSpec(){
    	LogofUserVO selected = logs.getSelectionModel().getSelectedItem();
		if (selected!=null) {
			mainScene.showCustomerCreditViewSpecScene(customerVO, selected);
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提醒");
			alert.setContentText("请先选中后在查看具体信息");
			alert.showAndWait();
		}
    }
    
    /**
     * 响应返回
     */
    @FXML
    private void handleExit(){
    	//需要对VO进行刷新，因为对于信息做出了修改
    	mainScene.showCustomerInfoScene(management_blservice.getCustomer(customerVO.getId()));
    }
    
    
}
