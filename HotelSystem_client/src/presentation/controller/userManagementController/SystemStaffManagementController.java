package presentation.controller.userManagementController;

import java.util.ArrayList;

import VO.CustomerVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.UserManagement_blservice;
import blservice.impl.UserManagement_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import main.Main;

public class SystemStaffManagementController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button viewUserInfo;
	@FXML
	private Button viewCustomerList;
	@FXML
	private Button viewHotelStaffList;
	@FXML
	private Button viewSystemStaffList;
	@FXML
	private Button back;
	@FXML
	private Label idLabel;
	@FXML
	private TextField inputSearchText;
	@FXML
	private Button searchButton;
	@FXML
    private TableView<SystemStaffVO> userTable;
    @FXML
    private TableColumn<SystemStaffVO, String> idColumn;
    @FXML
    private TableColumn<SystemStaffVO, String> nameColumn;
    @FXML
    private TableColumn<SystemStaffVO, String> identityColumn;//�û����
    @FXML
    private TableColumn<SystemStaffVO, String> stateColumn;//����״��
	
    private Main mainScene;
	private SystemManagerVO systemManagerVO;
	private UserManagement_blservice userManagement_blservice;
	// table
	private ObservableList<SystemStaffVO> systemStaffData = FXCollections.observableArrayList();

	public SystemStaffManagementController(){
		userManagement_blservice = new UserManagement_bl();
	}
	
	public void initialize(Main mainScene,SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		//left
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		SystemStaffManagementShow(this.mainScene);
	}
	public void SystemStaffManagementShow(Main mainScene) {
		idLabel.setText("��վӪ����Ա�б�");
		ArrayList<SystemStaffVO> systemStaffList = userManagement_blservice.getAllSystemStaff();
		for(SystemStaffVO systemStaff : systemStaffList){
			systemStaffData.add(systemStaff);
		}
		//TODO
//		idColumn.setCellValueFactory(cellData->cellData.getValue().getId());//TODO
//		nameColumn.setCellValueFactory(cellData->cellData.getValue().getUsername());
//		identityColumn.setCellValueFactory();
//		stateColumn.setCellValueFactory(cellData->cellData.getValue().);
		
		userTable.setItems(systemStaffData);
	}
	@FXML//�鿴�ͻ��б�
	private void handleCustomerList(){
		mainScene.showCustomerManagementScene(systemManagerVO);
	}
	
	@FXML//hotel staff
	private void handleHotelStaff(){
		mainScene.showHotelStaffManagementScene(systemManagerVO);
	}
	
	@FXML//system staff
	private void handleSystemStaff(){
		mainScene.showSystemStaffManagementScene(systemManagerVO);
	}
	
	@FXML//view the information of customer.
	private void handleViewInfo(){
		SystemStaffVO selected = userTable.getSelectionModel().getSelectedItem();
		if (selected!=null) {
			mainScene.showSystemManagerSystemStaffInfoViewScene(systemManagerVO,selected);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��һ����վӪ����Ա�ٽ��в鿴��");
			alert.showAndWait();
		}
	}
	@FXML
	private void handleBack(){
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}
}
