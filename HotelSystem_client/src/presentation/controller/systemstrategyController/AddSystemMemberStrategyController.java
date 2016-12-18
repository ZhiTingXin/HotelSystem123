package presentation.controller.systemstrategyController;

import java.util.ArrayList;
import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import VO.VipStrategyVO;
import VO.VipVO;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import main.Main;
import other.StrategyState;

public class AddSystemMemberStrategyController {

		@FXML
		private ImageView myPicture;
		@FXML
		private Label leftIdLabel;
		@FXML
		private Label leftNameLabel;
		@FXML
		private Button save;
		@FXML
		private Button back;
		@FXML
		private Label strategyType;// ��ͷ
		@FXML
		private TextField nameOfStrategy;
		@FXML
		private TextArea descriptionOfStrategy;
		@FXML
		private TableView<VipVO> memberStrategyTable;
		@FXML
		private TableColumn<VipVO, String> minCredit;
		@FXML
		private TableColumn<VipVO, String> maxCredit;
		@FXML
		private TableColumn<VipVO, String> memberGrade;
		@FXML
		private TableColumn<VipVO, String> discount;
		@FXML
		private Button edit;
		@FXML
		private RadioButton open;
		@FXML
		private RadioButton close;

		private Main mainScene;
		private SystemStaffVO systemStaffVO;
		private SystemStrategy_blservice strategy_blservice;
		private VipStrategy_blService vipStrategy_blService;
		private ObservableList<VipVO> vipVOData = FXCollections.observableArrayList();// ����

		public AddSystemMemberStrategyController() {
			strategy_blservice = new SystemStrategy_bl();
			vipStrategy_blService = new VipStrategy_blServiceImpl();
		}

		public void initilize(Main mainScene, SystemStaffVO systemStaffVO) {
			this.mainScene = mainScene;
			this.systemStaffVO = systemStaffVO;
			//����
			leftIdLabel.setText(systemStaffVO.getId());
			leftNameLabel.setText(systemStaffVO.getUsername());
			
			SystemHolidayStrategyModifyShow(mainScene);
		}

		@SuppressWarnings("null")
		public void SystemHolidayStrategyModifyShow(Main mainScene) {
			// ����
			// ��ʼ�� table
			VipVO v1 = null;
			v1.setVipgrade(1);
			VipVO v2 = null;
			v2.setVipgrade(2);
			VipVO v3 = null;
			v3.setVipgrade(3);
			VipVO v4 = null;
			v4.setVipgrade(4);
			VipVO v5 = null;
			v5.setVipgrade(5);
			
			vipVOData.add(v1);
			vipVOData.add(v2);
			vipVOData.add(v3);
			vipVOData.add(v4);
			vipVOData.add(v5);

			memberStrategyTable.setEditable(true);// �ɱ༭

			minCredit.setCellValueFactory(cellData -> cellData.getValue().getMinCreditProperty());
			minCredit.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField�ɱ༭��
			minCredit.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
				((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setMincredit(Integer.parseInt(t.getNewValue()));
			});//setNewValue
			maxCredit.setCellValueFactory(cellData -> cellData.getValue().getMaxCreditProperty());
			maxCredit.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField�ɱ༭��
			maxCredit.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
				((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setMaxcredit(Integer.parseInt(t.getNewValue()));
			});//setNewValue
			
			//�ȼ����ܱ༭--------
			memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());
			
			discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
			discount.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField�ɱ༭��
			discount.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
				((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setDiscount(Double.parseDouble(t.getNewValue()));
			});//setNewValue
			
			memberStrategyTable.setItems(vipVOData);
			// �Ż�״̬
			
		}

		@FXML // �����޸���Ϣ
		private void handleSave() {
			String strategyName = nameOfStrategy.getText();
			String strategyDescription = descriptionOfStrategy.getText();

			StrategyState strategyState;
			if (open.isSelected()) {
				strategyState = StrategyState.open;
			} else {
				strategyState = StrategyState.close;
			}
			// SystemStrategyVO���캯��
			SystemStrategyVO newSystemStrategy = new SystemStrategyVO(strategyName, strategyDescription, strategyState);
			boolean isModify1 = strategy_blservice.makeSystemStrategy(newSystemStrategy);

			ObservableList<VipVO>  newVipVOData= memberStrategyTable.getItems();

			ArrayList<VipVO> newVipStrategyVoList = new ArrayList<VipVO>();
			for (VipVO vipVO : newVipVOData) {
				newVipStrategyVoList.add(vipVO);
			}
			VipStrategyVO vipStrategyVO = new VipStrategyVO();
			vipStrategyVO.setVipStrategyVOList(newVipStrategyVoList);
			boolean isModify2 = vipStrategy_blService.makeVipStrategy(vipStrategyVO);

			if (isModify1 && isModify2) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("��ϲ");
				alert.setHeaderText("�����ɹ�");
				alert.setContentText("���ѳɹ�����һ����Ա�Ż���Ϣ��");
				alert.showAndWait();
				 
				mainScene.showSystemStrategyViewScene(systemStaffVO);//�ص��鿴���Խ���
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("�޸�ʧ��");
				alert.setContentText("�ǳ��ź�����δ�ܳɹ�������Ա�Ż���Ϣ��");
				alert.showAndWait();
			}
		}

		@FXML // ȡ���޸Ĳ�����
		private void handleCancel() {
			mainScene.showSystemStrategyViewScene(systemStaffVO);
		}

		@FXML // �༭��Ա��Ϣ
		private void handleEdit() {
			VipVO selected = memberStrategyTable.getSelectionModel().getSelectedItem();
			if (selected != null) {
				mainScene.showPersonEditDialog(selected);
			} else {
				// Nothing selected.
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("��ʾ");
				alert.setHeaderText("�༭ʧ��");
				alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��ĳ���Ż���Ŀ�ٽ��б༭��");
				alert.showAndWait();
			}
		}
	
}
