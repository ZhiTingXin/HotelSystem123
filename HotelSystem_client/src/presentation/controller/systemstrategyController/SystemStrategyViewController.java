package presentation.controller.systemstrategyController;

import java.util.ArrayList;
import java.util.Optional;

import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import blservice.VipStrategy_blService;
import blservice.impl.SystemStrategy_bl;
import blservice.impl.VipStrategy_blServiceImpl;
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
	@FXML
	private Button viewStrategy;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategyVO systemStrategyVO;
	private SystemStrategy_blservice systemStrategy_blservice;
	private VipStrategy_blService vipStrategy_blService;
	private ArrayList<SystemStrategyVO> systemStrategyVOList;
	private ObservableList<SystemStrategyVO> systemStrategyData = FXCollections.observableArrayList();

	public SystemStrategyViewController() {
		systemStrategy_blservice = new SystemStrategy_bl();
		vipStrategy_blService = new VipStrategy_blServiceImpl();
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
		discountListLabel.setText("�����Ż�");
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
		discountListLabel.setText("�����Ż�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.HOLIDAY);
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
		discountListLabel.setText("��Ա�Ż�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.MEMBER);
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
		discountListLabel.setText("VIP��Ա�Ż�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.VIPMEMBER);
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
		discountListLabel.setText("�����Ż�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.OTHER);
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

	@FXML // �鿴�����Żݲ��԰�ť
	private void handleViewStrategyButton() {

		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();

		if (selected != null) {

			SystemStrategyType strategyType = selected.getSystemStrategyType();

			if (strategyType == SystemStrategyType.HOLIDAY) {

				mainScene.showViewSystemHolidayStrategyScene(systemStaffVO, selected);

			} else if (strategyType == SystemStrategyType.MEMBER) {

				mainScene.showViewSystemMemberStrategyScene(systemStaffVO, selected);

			} else if (strategyType == SystemStrategyType.VIPMEMBER) {
			
				mainScene.showViewSystemVIPStrategyScene(systemStaffVO, selected);
				
			} else if (strategyType == SystemStrategyType.OTHER) {

				mainScene.showViewSystemOtherStrategyScene(systemStaffVO, selected);
				
			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ����Ҫ�鿴���Żݲ��ԣ�");
			alert.showAndWait();
		}
	}

	@FXML // �����Żݲ��԰�ť
	private void handleAddStrategyButton() {

		String labelName = discountListLabel.getText();

		if (labelName == "�����Ż�") {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��ĳ���Ż������ٽ���������");
			alert.showAndWait();

		} else if (labelName == "�����Ż�") {

			mainScene.showAddSystemHolidayStrategyScene(systemStaffVO);

		} else if (labelName == "��Ա�Ż�") {

			if (systemStrategy_blservice.getSystemStrategys(SystemStrategyType.MEMBER).size() == 0) {
				mainScene.showAddSystemMemberStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("����ʧ��");
				alert.setContentText("������̫�����ˣ����ǽ���Ҫһ����Ա�Żݲ��ԣ�");
				alert.showAndWait();
			}

		} else if (labelName == "VIP��Ա�Ż�") {

			if (systemStrategy_blservice.getSystemStrategys(SystemStrategyType.VIPMEMBER).size()==0) {
				mainScene.showAddSystemVIPStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("����ʧ��");
				alert.setContentText("������̫�����ˣ����ǽ���Ҫһ��VIP��Ա�Żݲ��ԣ�");
				alert.showAndWait();
			}

		} else if (labelName == "�����Ż�") {

			mainScene.showAddSystemOtherStrategyScene(systemStaffVO);

		}
	}

	@FXML // �޸��Żݲ����б�
	private void handleModifyStrategyButton() {
		
		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();
		
		if (selected != null) {// ѡ��

			SystemStrategyType strategyType = selected.getSystemStrategyType();

			if (strategyType == SystemStrategyType.HOLIDAY) {

				mainScene.showSystemHolidayStrategyModifyScene(systemStaffVO, selected);

			} else if (strategyType == SystemStrategyType.MEMBER) {

				mainScene.showSystemMemberStrategyModifyScene(systemStaffVO, selected);

			} else if (strategyType == SystemStrategyType.VIPMEMBER) {

				mainScene.showSystemVIPStrategyModifyScene(systemStaffVO, selected);

			} else if (strategyType == SystemStrategyType.OTHER) {

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
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("ɾ��");
			alert.setHeaderText("ɾ��֮���޷�����");
			alert.setContentText("�Ƿ�ɾ����");
			ButtonType buttonOK  = new ButtonType("��");
			ButtonType buttonNO  = new ButtonType("��");
			alert.getButtonTypes().setAll(buttonOK,buttonNO);
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get() == buttonOK) {//��
				boolean isDelete = false;
				if(selected.getSystemStrategyType()==SystemStrategyType.HOLIDAY){
				      isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
				}else if(selected.getSystemStrategyType()==SystemStrategyType.OTHER){
					  isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
				}else if(selected.getSystemStrategyType()==SystemStrategyType.VIPMEMBER){
					isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
					isDelete = isDelete&&vipStrategy_blService.deleteSuperVipStrategy(systemStaffVO.getBusinessDistrict());
				}else{
					//TODO ������վ��Ա���ԵĴ���
				}
				if (isDelete) {
					Alert alert1 = new Alert(AlertType.INFORMATION);
					alert1.setTitle("��ϲ");
					alert1.setHeaderText("ɾ���ɹ�");
					alert1.setContentText("���ѳɹ�ɾ��һ��������Ϣ��");
					Optional<ButtonType> btn1 = alert1.showAndWait();
					if (btn1.get() == ButtonType.OK) {
						
						String labelName = discountListLabel.getText();
						if (labelName == "�����Ż�") {
							systemStrategyVOList = systemStrategy_blservice.getAllSystemStrategys();
						} else if (labelName == "�����Ż�") {
							systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.HOLIDAY);
						} else if (labelName == "��Ա�Ż�") {
							systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.MEMBER);
						} else if (labelName == "VIP��Ա�Ż�") {
							systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.VIPMEMBER);
						} else if (labelName == "�����Ż�") {
							systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.OTHER);
						}
						
						systemStrategyData.clear();
						for(SystemStrategyVO systemStrategy:systemStrategyVOList){
							systemStrategyData.add(systemStrategy);
						}
						nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
						descriptionOfStrategy
								.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
						stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
						discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
						systemStrategyTable.setItems(systemStrategyData);
						
					}
				} else {
					Alert alert2 = new Alert(AlertType.ERROR);
					alert2.setTitle("��Ǹ");
					alert2.setHeaderText("ɾ��ʧ��");
					alert2.setContentText("ɾ���Żݲ���ʧ�ܣ������ԣ�");
					alert2.showAndWait();
				}
			} else {//ѡ���
			}
			
			
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ʾ");
			alert.setHeaderText("ɾ��ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��Ҫɾ���Ĳ��ԣ�");
			alert.showAndWait();
		}
	}
}
