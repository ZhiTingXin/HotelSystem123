package presentation.controller.userManagementController;

import java.util.Optional;

import VO.CustomerVO;
import VO.SystemStaffVO;
import blservice.UserInfo_blservice;
import blservice.UserManagement_blservice;
import blservice.impl.UserInfo_bl;
import blservice.impl.UserManagement_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
		String myCustomerID = inputIdText.getText();
		if (!myCustomerID.equals("")) {
			if (userManagement_blservice.getCustomer(myCustomerID)!=null) {//该用户存在
				this.customerVO = userManagement_blservice.getCustomer(myCustomerID);
				customerData.clear();
				customerData.add(customerVO);//添加该用户
				customerId.setCellValueFactory(cellData->cellData.getValue().getIDstringProperty());
				customerName.setCellValueFactory(cellData->cellData.getValue().getUserNamePriperty());
				customerCredit.setCellValueFactory(cellData->cellData.getValue().getCreditProperty());
				customerTable.setItems(customerData);
			} else {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("查找失败");
				alert.setContentText("抱歉，您所查找的用户不存在！");
				alert.setTitle("错误");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("查找失败");
			alert.setContentText("抱歉，请您先输入用户ID！");
			alert.setTitle("错误");
			alert.showAndWait();
		}
	}
	//充值
	@FXML
	private void handleSave(){
		String crditNum = reditTextField.getText();
		if (crditNum!=null) {
			CustomerVO customer = customerTable.getSelectionModel().getSelectedItem();
			if(customer==null){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("未选中任何用户");
				alert.setContentText("请您先选中用户确认充值！");
				alert.setTitle("警示");
				alert.showAndWait();
			}else{
				int nowCridet = customer.getCredit()+Integer.valueOf(crditNum);
				customer.setCredit(nowCridet);
				boolean isOK = userManagement_blservice.modifyCustomer(customer);
				if (isOK) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText("充值成功");
					alert.setContentText("您成功为用户"+"\""+customer.getUsername()+"\""+"充值信用值："+crditNum+"点");
					alert.setTitle("恭喜");
					Optional<ButtonType> button = alert.showAndWait();
					if (button.get()==ButtonType.OK) {
						customerData.clear();
						customerData.add(customer);
						customerId.setCellValueFactory(cellData->cellData.getValue().getIDstringProperty());
						customerName.setCellValueFactory(cellData->cellData.getValue().getUserNamePriperty());
						customerCredit.setCellValueFactory(cellData->cellData.getValue().getCreditProperty());
						customerTable.setItems(customerData);
					}
				}
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("充值失败");
			alert.setContentText("抱歉，请您先输入要充值的信用值！");
			alert.setTitle("错误");
			alert.showAndWait();
		}
	}
	//返回
	@FXML
	private void handleBack(){
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}
}
