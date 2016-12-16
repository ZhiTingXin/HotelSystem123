package presentation.controller.systemstrategyController;

import java.util.ArrayList;
import java.util.Optional;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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

public class SystemVIPStrategyModifyController {

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
	private MenuButton districtName;
	@FXML
	private MenuItem districtA;
	@FXML
	private MenuItem districtB;
	@FXML
	private TableView<VipVO> systemStrategyTable;
	@FXML
	private TableColumn<VipVO, String> memberGrade;
	@FXML
	private TableColumn<VipVO, String> discount;
	@FXML
	private Button saveTable;
	@FXML
	private RadioButton open;
	@FXML
	private RadioButton close;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategyVO systemStrategyVO;
	private SystemStrategy_blservice systemStrategy_blservice;
	private VipStrategy_blService vipStrategy_blService;
	private ObservableList<VipVO> vipVOData = FXCollections.observableArrayList();

	public SystemVIPStrategyModifyController() {
		systemStrategy_blservice = new SystemStrategy_bl();
		vipStrategy_blService = new VipStrategy_blServiceImpl();
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.systemStrategyVO = systemStrategyVO;
		// ����
		leftIdLabel.setText(this.systemStaffVO.getId());
		leftNameLabel.setText(this.systemStaffVO.getUsername());
		SystemVIPStrategyModifyShow(mainScene);
	}

	public void SystemVIPStrategyModifyShow(Main mainScene) {
		// ����
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());

		// �Ż�״̬
		StrategyState strategyState = systemStrategyVO.getStrategyState();
		if (strategyState == StrategyState.open) {
			open.setSelected(true);
			close.setSelected(false);
		} else {
			open.setSelected(true);
			close.setSelected(false);
		}

		vipVOData.clear();
	}

	@FXML // ѡ����Ȧ
	private void handleDistrictA() {

		// ��ʼ�����
		String district = districtA.getText();
		vipVOData.clear();
		ArrayList<VipVO> vipVOs = vipStrategy_blService.getVipstrategy(district).getVipStrategyVOList();
		for (VipVO vipVO : vipVOs) {
			vipVOData.add(vipVO);
		}

		systemStrategyTable.setEditable(true);// �ɱ༭

		memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());

		discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
		discount.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField�ɱ༭��
		discount.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
			((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setDiscount(Double.parseDouble(t.getNewValue()));
		});// setNewValue
		systemStrategyTable.setItems(vipVOData);	
	}

	@FXML
	private void handleDistrictB() {
		
		String district = districtB.getText();
		vipVOData.clear();// ���
		ArrayList<VipVO> vipVOs = vipStrategy_blService.getVipstrategy(district).getVipStrategyVOList();
		for (VipVO vipVO : vipVOs) {
			vipVOData.add(vipVO);
		}

		systemStrategyTable.setEditable(true);// �ɱ༭

		memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());

		discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
		discount.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField�ɱ༭��
		discount.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
			((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setDiscount(Double.parseDouble(t.getNewValue()));
		});// setNewValue
		systemStrategyTable.setItems(vipVOData);

	}

	@FXML
	private void handleSaveTable() {

		ObservableList<VipVO> getVipVO = systemStrategyTable.getItems();
		if (getVipVO != null) {
			ArrayList<VipVO> newVipVO = new ArrayList<VipVO>();
			for (VipVO vipVO : getVipVO) {
				newVipVO.add(vipVO);
			}
			
			VipStrategyVO vipStrategyVO = new VipStrategyVO();
			vipStrategyVO.setVipStrategyVOList(newVipVO);
			boolean isModifyTable = vipStrategy_blService.modifyVipStrategy(vipStrategyVO);
			if (isModifyTable) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("��ϲ");
				alert.setHeaderText("����ɹ�");
				alert.setContentText("���ѳɹ��޸�һ���Ż���Ϣ��");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("����ʧ��");
				alert.setContentText("�Բ���"+districtName.getText()+"��Ȧ��VIP��Ա�Żݱ���ʧ�ܣ�");
				alert.showAndWait();
			}
		}else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("�Բ�������δ�����޸ģ�");
			alert.showAndWait();
		}
	}

	@FXML // save the strategy.
	private void handleSave() {

		String strategyName = nameOfStrategy.getText();
		String strategyDescription = descriptionOfStrategy.getText();

		StrategyState strategyState = null;
		if (open.isSelected()) {
			strategyState = StrategyState.open;
		} else {
			strategyState = StrategyState.close;
		}
		
		SystemStrategyVO newSystemStrategy = new SystemStrategyVO();
		newSystemStrategy.setSystemStrategyName(strategyName);
		newSystemStrategy.setSystemStrategyDescription(strategyDescription);
		newSystemStrategy.setStrategyState(strategyState);
		boolean isOK = systemStrategy_blservice.modifySystemStrategy(newSystemStrategy);
		
		if (isOK) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ϲ");
			alert.setHeaderText("����ɹ�");
			alert.setContentText("���ѳɹ��޸�һ���Ż���Ϣ��");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				mainScene.showSystemStrategyViewScene(systemStaffVO);
			} 			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("�Բ����Żݲ��Ա���ʧ�ܣ�");
			alert.showAndWait();
		}
	}

	@FXML // cancel and back to the former view.
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
