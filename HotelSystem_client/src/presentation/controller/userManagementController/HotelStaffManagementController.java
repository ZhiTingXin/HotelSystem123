package presentation.controller.userManagementController;

import java.util.ArrayList;

import VO.HotelStaffVO;
import VO.SystemManagerVO;
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

public class HotelStaffManagementController {

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
    private TableView<HotelStaffVO> userTable;
    @FXML
    private TableColumn<HotelStaffVO, String> idColumn;
    @FXML
    private TableColumn<HotelStaffVO, String> nameColumn;
    @FXML
    private TableColumn<HotelStaffVO, String> identityColumn;//用户身份
    @FXML
    private TableColumn<HotelStaffVO, String> stateColumn;//在线状况
	
    private Main mainScene;
	private SystemManagerVO systemManagerVO;
	private UserManagement_blservice userManagement_blservice;
	//hotel staff table
	private ObservableList<HotelStaffVO> hotelStaffData = FXCollections.observableArrayList();
	
	public HotelStaffManagementController(){
		userManagement_blservice = new UserManagement_bl();
	}
	
	public void initialize(Main mainScene,SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		//left
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		HotelStaffManagementShow(this.mainScene);
	}
	public void HotelStaffManagementShow(Main mainScene) {
		
		idLabel.setText("酒店工作人员列表");
		
		ArrayList<HotelStaffVO> hotelStaffList = userManagement_blservice.getAllHotelStaff();
		for(HotelStaffVO hotelStaff : hotelStaffList){
			hotelStaffData.add(hotelStaff);
		}
	
		idColumn.setCellValueFactory(cellData->cellData.getValue().getHotelStaffIdProperty());
		nameColumn.setCellValueFactory(cellData->cellData.getValue().getHotelStaffNameProperty());
		identityColumn.setCellValueFactory(cellData->cellData.getValue().getHotelStaffTypeProperty());//
		stateColumn.setCellValueFactory(cellData->cellData.getValue().getHotelNameProperty());
		
		userTable.setItems(hotelStaffData);
	}
	@FXML//查看客户列表
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
		HotelStaffVO selected = userTable.getSelectionModel().getSelectedItem();
		if (selected!=null) {
			mainScene.showSystemManagerHotelStaffInfoViewScene(systemManagerVO,selected);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("操作失败");
			alert.setContentText("不要着急，您应该先选择一个就当做人员再进行查看！");
			alert.showAndWait();
		}
	}
	@FXML
	private void handleBack(){
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}
}
