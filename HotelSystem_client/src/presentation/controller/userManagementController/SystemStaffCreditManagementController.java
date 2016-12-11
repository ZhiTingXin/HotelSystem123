package presentation.controller.userManagementController;

import VO.CustomerVO;
import VO.OrderVO;
import VO.SystemStaffVO;
import blservice.UserInfo_blservice;
import blservice.UserManagement_blservice;
import blservice.impl.UserInfo_bl;
import blservice.impl.UserManagement_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.Main;

public class SystemStaffCreditManagementController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button save;
	@FXML
	private Button back;
	@FXML
	private TextField inputIdText;
	@FXML
	private Button search;
	@FXML
	private TextField reditTextField;
	@FXML
	private TableView<CustomerVO> customerTable;
	@FXML
	private TableColumn<CustomerVO, String> customerId;
	@FXML
	private TableColumn<CustomerVO, String> customerName;
	@FXML
	private TableColumn<CustomerVO, String> customerCredit;
	
	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private CustomerVO customerVO;
	private UserManagement_blservice userManagement_blservice;
	private UserInfo_blservice userInfo_blservice;
	private ObservableList<CustomerVO> customerData = FXCollections.observableArrayList();// 声明
	
	public SystemStaffCreditManagementController(){
		userManagement_blservice = new UserManagement_bl();//充值信用值
		userInfo_blservice = new UserInfo_bl();//获取用户信息
	}
	public void initialize(Main mainScene,SystemStaffVO systemStaffVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		SystemStaffCreditManagementShow(mainScene);
	}
	public void SystemStaffCreditManagementShow(Main mainScene) {
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
	}
	//搜索客户
	@FXML
	private void handleSearch(){
		String customerID = inputIdText.getAccessibleText();
		if (customerID!=null) {
			if (userManagement_blservice.getCustomer(customerID)!=null) {//该用户存在
				this.customerVO = userManagement_blservice.getCustomer(customerID);
				customerData.add(customerVO);//添加该用户
				//customerId.setCellValueFactory(cellData->cellData.getValue().getId());
//				customerName.setCellValueFactory(cellData->cellData.getValue().);
//				customerCredit.setCellValueFactory(cellData->cellData.getValue().);
				customerTable.setItems(customerData);
			} else {
				//用户不存在 TODO
			}
		} else {
			//TODO 请输入ID
		}
	}
	//充值
	@FXML
	private void handleSave(){
		String crditNum = reditTextField.getAccessibleText();
		if (crditNum!=null) {
			String CustomerId  = customerVO.getId();
			//TODO 更新用户信用值列表
		} else {
			//TODO “请输入信用值”
		}
	}
	//返回
	@FXML
	private void handleBack(){
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}
}
