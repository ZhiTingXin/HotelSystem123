package presentation.controller.systemstrategyController;

import java.util.ArrayList;
import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import blservice.impl.SystemStrategy_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import main.Main;
import other.SystemStrategyType;

public class SystemStrategyViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button viewHolidayDiscount;
	@FXML
	private Button viewMemberDiscount;
	@FXML
	private Button viewVIPDiscount;
	@FXML
	private Button viewOtherDiscount;
	@FXML
	private Button back;
	@FXML
	private Label discountListLabel;
	@FXML
	private TableView<SystemStrategyVO> systemStrategyTable;
	@FXML
	private TableColumn<SystemStrategyVO, String> nameOfStrategy;
	@FXML
	private TableColumn<SystemStrategyVO, String> descriptionOfStrategy;
	@FXML
	private TableColumn<SystemStrategyVO, String> stateOfStrategy;
	@FXML
	private TableColumn<SystemStrategyVO, String> discountNum;// �ۿ�����
	@FXML
	private Button addStrategy;
	@FXML
	private Button modifyStrategy;
	@FXML
	private Button deleteStrategy;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategyVO systemStrategyVO;
	private SystemStrategy_blservice systemStrategy_blservice;
	private ArrayList<SystemStrategyVO> systemStrategyVOList;
	private ObservableList<SystemStrategyVO> systemStrategyData = FXCollections.observableArrayList();

	public SystemStrategyViewController() {
		systemStrategy_blservice = new SystemStrategy_bl();
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaffVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		SystemStrategyViewShow(mainScene);
	}

	public void SystemStrategyViewShow(Main mainScene) {
		// �����
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		// �ұ���
		discountListLabel.setText("�����Ż��б�");
		systemStrategyVOList = systemStrategy_blservice.getAllSystemStrategys();
		for (SystemStrategyVO systemStrategyVO : systemStrategyVOList) { // Ĭ�ϳ�ʼ�����еĴ�������
			systemStrategyData.add(systemStrategyVO);
		} // ��ʼ��column
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // �����鿴���ղ���
	private void handleViewHolidayStrategy() {
		discountListLabel.setText("�����Ż��б�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.HOLIDAY);
		for (SystemStrategyVO holidayStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(holidayStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // �鿴��Ա�Ż�
	private void handleViewMemberStrategy() {
		discountListLabel.setText("��Ա�Ż��б�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.MEMBER);
		for (SystemStrategyVO memberStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(memberStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // �鿴VIP��Ա�Ż�
	private void handleViewVIPStrategy() {
		discountListLabel.setText("VIP��Ա�Ż��б�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.VIPMEMBER);
		for (SystemStrategyVO VIPStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(VIPStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // �鿴�����Żݲ���
	private void handleViewOtherStrategy() {
		discountListLabel.setText("�����Ż��б�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.OTHER);
		for (SystemStrategyVO OtherStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(OtherStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // ����
	private void handleBack() {
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}

	@FXML // �����Żݲ��԰�ť
	private void handleAddStrategyButton() {
		
		String labelName = discountListLabel.getText();
		
		if (labelName == "�����Ż��б�") {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��ĳ���Ż������ٽ���������");
			alert.showAndWait();
			
		} else if (labelName == "�����Ż��б�") {
			
			mainScene.showAddSystemHolidayStrategyScene(systemStaffVO);
			
		} else if (labelName == "��Ա�Ż��б�") {
			
			if (systemStrategy_blservice.getSystemStrategy(SystemStrategyType.MEMBER)==null) {
				mainScene.showAddSystemMemberStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("����ʧ��");
				alert.setContentText("������̫�����ˣ����ǽ���Ҫһ����Ա�Żݲ��ԣ�");
				alert.showAndWait();
			}
			
		} else if (labelName == "VIP��Ա�Ż��б�") {

			if (systemStrategy_blservice.getSystemStrategy(SystemStrategyType.VIPMEMBER)==null) {
				mainScene.showAddSystemVIPStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("����ʧ��");
				alert.setContentText("������̫�����ˣ����ǽ���Ҫһ��VIP��Ա�Żݲ��ԣ�");
				alert.showAndWait();
			}
			
		} else if (labelName == "�����Ż��б�") {

			mainScene.showAddSystemHolidayStrategyScene(systemStaffVO);
			
		}
	}

	@FXML // �޸��Żݲ����б�
	private void handleModifyStrategyButton() {
		String labelName = discountListLabel.getText();
		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();
		if (selected != null) {// ѡ��
			if (labelName == "�����Ż��б�") {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("��ʾ");
				alert.setHeaderText("�޸�ʧ��");
				alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��ĳ���Ż������ٽ����޸ģ�");
				alert.showAndWait();
				
			} else if (labelName == "�����Ż��б�") {
				
				mainScene.showSystemHolidayStrategyModifyScene(systemStaffVO, selected);
				
			} else if (labelName == "��Ա�Ż��б�") {
				
				mainScene.showSystemMemberStrategyModifyScene(systemStaffVO, selected);
				
			} else if (labelName == "VIP��Ա�Ż��б�") {
				
				mainScene.showSystemVIPStrategyModifyScene(systemStaffVO, selected);
				
			} else if (labelName == "�����Ż��б�") {
				
				mainScene.showSystemOtherStrategyModifyScene(systemStaffVO, selected);
				
			}
		} else {// ��ѡ��
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ʾ");
			alert.setHeaderText("�޸�ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��ĳ���Ż���Ŀ�ٽ����޸ģ�");
			alert.showAndWait();
		}
	}

	@FXML // ɾ��ѡ�еĲ���
	private void handleDeleteStrategyButton() {
		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();
		if (selected != null) {
			systemStrategy_blservice.deleteSystemStrategy(selected);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ʾ");
			alert.setHeaderText("ɾ��ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��ĳ���Ż���Ŀ�ٽ���ɾ����");
			alert.showAndWait();
		}
	}
}
