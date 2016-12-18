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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import other.StrategyState;

public class SystemMemberStrategyModifyController {

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
	private SystemStrategyVO systemStrategyVO;
	private ArrayList<VipVO> vipVOList;
	private SystemStrategy_blservice systemStrategy_blservice;
	private VipStrategy_blService vipStrategy_blService;
	private ObservableList<VipVO> vipVOData = FXCollections.observableArrayList();// ����

	public SystemMemberStrategyModifyController() {
		vipStrategy_blService = new VipStrategy_blServiceImpl();
		systemStrategy_blservice = new SystemStrategy_bl();
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.systemStrategyVO = systemStrategyVO;
		// ����
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		SystemHolidayStrategyModifyShow(mainScene);
	}

	public void SystemHolidayStrategyModifyShow(Main mainScene) {
		// ����
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());
		// ��ʼ�� table
		vipVOList = vipStrategy_blService.getVipStrategy().getVipStrategyVOList();
		for (VipVO vipVO : vipVOList) {
			vipVOData.add(vipVO);
		}

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
		memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());
		memberGrade.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField�ɱ༭��
		memberGrade.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
			((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setVipgrade(Integer.parseInt(t.getNewValue()));
		});//setNewValue
		discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
		discount.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField�ɱ༭��
		discount.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
			((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setDiscount(Double.parseDouble(t.getNewValue()));
		});//setNewValue
		
		memberStrategyTable.setItems(vipVOData);
		// �Ż�״̬
		StrategyState strategyState = systemStrategyVO.getStrategyState();
		if (strategyState == StrategyState.open) {
			open.setSelected(true);
			close.setSelected(false);
		} else {
			open.setSelected(true);
			close.setSelected(false);
		}
	}

	@FXML // �����޸���Ϣ
	private void handleSave() {
		systemStrategyVO.setSystemStrategyName(nameOfStrategy.getText());
		systemStrategyVO.setSystemStrategyDescription(descriptionOfStrategy.getText());

		StrategyState strategyState;
		if (open.isSelected()) {
			strategyState = StrategyState.open;
		} else {
			strategyState = StrategyState.close;
		}
		systemStrategyVO.setStrategyState(strategyState);
		
		
		boolean isModify1 = systemStrategy_blservice.modifySystemStrategy(systemStrategyVO);

		ObservableList<VipVO> getVipVO = memberStrategyTable.getItems();

		ArrayList<VipVO> newVipStrategyVoList = new ArrayList<VipVO>();
		for (VipVO vipVO : getVipVO) {
			newVipStrategyVoList.add(vipVO);
		}
		VipStrategyVO vipStrategyVO = new VipStrategyVO();
		vipStrategyVO.setVipStrategyVOList(newVipStrategyVoList);
		boolean isModify2 = vipStrategy_blService.modifyVipStrategy(vipStrategyVO);

		if (isModify1 && isModify2) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ϲ");
			alert.setHeaderText("�޸ĳɹ�");
			alert.setContentText("���ѳɹ��޸Ļ�Ա�Ż���Ϣ��");
			alert.showAndWait();
			// TODO ���ص��鿴����
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("�޸�ʧ��");
			alert.setContentText("�ǳ��ź�����δ�ܳɹ��޸Ļ�Ա�Ż���Ϣ��");
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
			mainScene.showMemberEditDialog(selected);
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
