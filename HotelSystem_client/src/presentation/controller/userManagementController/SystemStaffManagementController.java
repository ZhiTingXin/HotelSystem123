package presentation.controller.userManagementController;

import java.util.ArrayList;

import VO.SystemManagerVO;
import VO.SystemStaffVO;
import blservice.UserManagement_blservice;
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
import javafx.scene.control.TextField;
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
    private TableColumn<SystemStaffVO, String> districtColumn;
	
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
		ArrayList<SystemStaffVO> systemStaffList = userManagement_blservice.getAllSystemStaff();
		for(SystemStaffVO systemStaff : systemStaffList){
			systemStaffData.add(systemStaff);
		}

		idColumn.setCellValueFactory(cellData->cellData.getValue().getSystemStaffIDProperty());
		nameColumn.setCellValueFactory(cellData->cellData.getValue().getSystemSatffNameProperty());
		identityColumn.setCellValueFactory(cellData->cellData.getValue().getSystemStaffIdentity());
		districtColumn.setCellValueFactory(cellData->cellData.getValue().getSystemStaffPhone());
		
		userTable.setItems(systemStaffData);
	}
	@FXML
	private void handleSearch(){
		if(!inputSearchText.getText().equals("")){
			SystemStaffVO staffVO = userManagement_blservice.getSystemStaff(inputSearchText.getText());
			if(staffVO==null){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("��Ǹ");
				alert.setContentText("δ��ѯ����Ӧ����վӪ����Ա");
				alert.showAndWait();
			}else{
			    systemStaffData.clear();
				systemStaffData.add(staffVO);
				
				idColumn.setCellValueFactory(cellData->cellData.getValue().getSystemStaffIDProperty());
				nameColumn.setCellValueFactory(cellData->cellData.getValue().getSystemSatffNameProperty());
				identityColumn.setCellValueFactory(cellData->cellData.getValue().getSystemStaffIdentity());
				districtColumn.setCellValueFactory(cellData->cellData.getValue().getSystemStaffPhone());
				
				userTable.setItems(systemStaffData);
			}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("����");
			alert.setContentText("��������Ƶ깤����Աid���ٽ�������");
			alert.showAndWait();
		}
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
