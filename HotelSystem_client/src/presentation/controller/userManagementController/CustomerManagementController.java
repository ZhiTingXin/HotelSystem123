package presentation.controller.userManagementController;

import java.util.ArrayList;

import VO.CustomerVO;
import VO.SystemManagerVO;
import blservice.UserManagement_blservice;
import blservice.impl.UserManagement_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import main.Main;
import util.ImageUtil;

public class CustomerManagementController {

	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView myPicture;
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
	private TableView<CustomerVO> userTable;
	@FXML
	private TableColumn<CustomerVO, String> idColumn;
	@FXML
	private TableColumn<CustomerVO, String> nameColumn;
	@FXML
	private TableColumn<CustomerVO, String> identityColumn;// �û����
	@FXML
	private TableColumn<CustomerVO, String> stateColumn;// ����״��

	private Main mainScene;
	private SystemManagerVO systemManagerVO;
	private UserManagement_blservice userManagement_blservice;
	// customer table
	private ObservableList<CustomerVO> customerData = FXCollections.observableArrayList();

	public CustomerManagementController() {
		userManagement_blservice = new UserManagement_bl();
	}

	public void initialize(Main mainScene, SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		// left
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		myPicture.setImage(ImageUtil.setImage(this.systemManagerVO.getImage()));

		/**
		 * ��ʼ��Ϊ�ͻ����б�
		 */
		idLabel.setText("�ͻ��б�");
		ArrayList<CustomerVO> customerList = userManagement_blservice.getAllCustomer();
		for (CustomerVO customerVO : customerList) {
			customerData.add(customerVO);
		}
		
		 idColumn.setCellValueFactory(cellData->cellData.getValue().getIDstringProperty());
		 nameColumn.setCellValueFactory(cellData->cellData.getValue().getUserNamePriperty());
		 identityColumn.setCellValueFactory(cellData->cellData.getValue().getUserTypePriperty());
		 stateColumn.setCellValueFactory(cellData->cellData.getValue().getCreditProperty());

		userTable.setItems(customerData);
	}

	@FXML // �鿴�ͻ��б�
	private void handleCustomerList() {
		mainScene.showCustomerManagementScene(systemManagerVO);
	}

	@FXML // hotel staff
	private void handleHotelStaff() {
		mainScene.showHotelStaffManagementScene(systemManagerVO);
	}

	@FXML // system staff
	private void handleSystemStaff() {
		mainScene.showSystemStaffManagementScene(systemManagerVO);
	}

	@FXML // view the information of customer.
	private void handleViewInfo() {
		CustomerVO selected = userTable.getSelectionModel().getSelectedItem();
		if (selected != null) {
			mainScene.showSystemManagerCustomerInfoViewScene(systemManagerVO, selected);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��һ���ͻ��ٽ��в鿴��");
			alert.showAndWait();
		}
	}

	@FXML
	private void handleSearch(){
		if(!inputSearchText.getText().equals("")){
			CustomerVO customerVO = userManagement_blservice.getCustomer(inputSearchText.getText());
			if(customerVO==null){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("��Ǹ");
				alert.setContentText("δ��ѯ����Ӧ�Ŀͻ�");
				alert.showAndWait();
			}else{
				customerData.clear();
				customerData.add(customerVO);
				idColumn.setCellValueFactory(cellData->cellData.getValue().getIDstringProperty());
				nameColumn.setCellValueFactory(cellData->cellData.getValue().getUserNamePriperty());
				identityColumn.setCellValueFactory(cellData->cellData.getValue().getUserTypePriperty());
				stateColumn.setCellValueFactory(cellData->cellData.getValue().getCreditProperty());

				userTable.setItems(customerData);
			}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("����");
			alert.setContentText("��������ͻ�id���ٽ�������");
			alert.showAndWait();
		}
	}
	@FXML
	private void handleBack() {
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}
}
