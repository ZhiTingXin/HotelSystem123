package presentation.controller.userManagementController;

import java.util.ArrayList;
import java.util.Optional;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class SystemStaffManagementController {

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
	private TableView<SystemStaffVO> userTable;
	@FXML
	private TableColumn<SystemStaffVO, String> idColumn;
	@FXML
	private TableColumn<SystemStaffVO, String> nameColumn;
	@FXML
	private TableColumn<SystemStaffVO, String> identityColumn;// 用户身份
	@FXML
	private TableColumn<SystemStaffVO, String> phoneColumn;
	@FXML
	private Button deleBu;

	private Main mainScene;
	private SystemManagerVO systemManagerVO;
	private UserManagement_blservice userManagement_blservice;
	// table
	private ObservableList<SystemStaffVO> systemStaffData = FXCollections.observableArrayList();

	public SystemStaffManagementController() {
		userManagement_blservice = new UserManagement_bl();
	}

	public void initialize(Main mainScene, SystemManagerVO systemManagerVO) {
		this.mainScene = mainScene;
		this.systemManagerVO = systemManagerVO;
		// left
		leftIdLabel.setText(this.systemManagerVO.getId());
		leftNameLabel.setText(this.systemManagerVO.getUserName());
		myPicture.setImage(ImageUtil.setImage(this.systemManagerVO.getImage()));
		SystemStaffManagementShow(this.mainScene);
	}

	public void SystemStaffManagementShow(Main mainScene) {
		ArrayList<SystemStaffVO> systemStaffList = userManagement_blservice.getAllSystemStaff();
		for (SystemStaffVO systemStaff : systemStaffList) {
			systemStaffData.add(systemStaff);
		}

		idColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemStaffIDProperty());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemSatffNameProperty());
		identityColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemStaffIdentity());
		phoneColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemStaffPhone());

		userTable.setItems(systemStaffData);
	}

	@FXML
	private void handleSearch() {
		if (!inputSearchText.getText().equals("")) {
			SystemStaffVO staffVO = userManagement_blservice.getSystemStaff(inputSearchText.getText());
			if (staffVO == null) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("抱歉");
				alert.setContentText("未查询到对应的网站营销人员");
				alert.showAndWait();
			} else {
				systemStaffData.clear();
				systemStaffData.add(staffVO);

				idColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemStaffIDProperty());
				nameColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemSatffNameProperty());
				identityColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemStaffIdentity());
				phoneColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemStaffPhone());

				userTable.setItems(systemStaffData);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("提醒");
			alert.setContentText("请先输入酒店工作人员id后再进行搜索");
			alert.showAndWait();
		}
	}

	@FXML // 查看客户列表
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
		SystemStaffVO selected = userTable.getSelectionModel().getSelectedItem();
		if (selected != null) {
			mainScene.showSystemManagerSystemStaffInfoViewScene(systemManagerVO, selected);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("操作失败");
			alert.setContentText("不要着急，您应该先选择一个网站营销人员再进行查看！");
			alert.showAndWait();
		}
	}

	@FXML
	private void handleDelete() {
		SystemStaffVO selected = userTable.getSelectionModel().getSelectedItem();
		if (selected != null) {
			Alert alert1 = new Alert(AlertType.CONFIRMATION);
			alert1.setTitle("提醒");
			alert1.setContentText("确定要删除该用户吗？删除后将无法撤销 ，请选择是或否");
			ButtonType yes = new ButtonType("是");
			ButtonType no = new ButtonType("否");
			alert1.getButtonTypes().setAll(yes, no);
			Optional<ButtonType> btn = alert1.showAndWait();
			if (btn.get() == yes) {
				if (userManagement_blservice.deleSystemStaff(selected)) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("恭喜");
					alert.setContentText("您已经成功删除了一个网站营销人员");
					alert.showAndWait();
					freshTable();
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("抱歉");
					alert.setContentText("删除失败，请稍后再试");
					alert.showAndWait();
				}
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("操作失败");
			alert.setContentText("不要着急，请先选择一个网站营销人员");
			alert.showAndWait();
		}
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemManagerMainScene(systemManagerVO);
	}

	private void freshTable() {
		systemStaffData.clear();
		ArrayList<SystemStaffVO> systemStaffList = userManagement_blservice.getAllSystemStaff();
		for (SystemStaffVO systemStaff : systemStaffList) {
			systemStaffData.add(systemStaff);
		}

		idColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemStaffIDProperty());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemSatffNameProperty());
		identityColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemStaffIdentity());
		phoneColumn.setCellValueFactory(cellData -> cellData.getValue().getSystemStaffPhone());

		userTable.setItems(systemStaffData);
	}
}
