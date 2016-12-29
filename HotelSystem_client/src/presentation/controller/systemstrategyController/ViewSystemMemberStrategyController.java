package presentation.controller.systemstrategyController;

import java.util.ArrayList;

import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import VO.VipVO;
import blservice.VipStrategy_blService;
import blservice.impl.VipStrategy_blServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import other.StrategyState;
import util.ImageUtil;

public class ViewSystemMemberStrategyController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button modify;
	@FXML
	private Button back;
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
	private Label state;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategyVO systemStrategyVO;
	private ArrayList<VipVO> vipVOList;
	private VipStrategy_blService vipStrategy_blService;
	private ObservableList<VipVO> vipVOData = FXCollections.observableArrayList();// ����

	public ViewSystemMemberStrategyController() {
		vipStrategy_blService = new VipStrategy_blServiceImpl();
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.systemStrategyVO = systemStrategyVO;
		// ����
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		myPicture.setImage(ImageUtil.setImage(systemStaffVO.getImage()));
		ViewSystemHolidayStrategyShow(mainScene);
	}

	public void ViewSystemHolidayStrategyShow(Main mainScene) {
		// ����
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());
		// ��ʼ�� table
		vipVOList = vipStrategy_blService.getVipStrategy().getVipStrategyVOList();
		for (VipVO vipVO : vipVOList) {
			vipVOData.add(vipVO);
		}

		minCredit.setCellValueFactory(cellData -> cellData.getValue().getMinCreditProperty());

		maxCredit.setCellValueFactory(cellData -> cellData.getValue().getMaxCreditProperty());

		memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());

		discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());

		memberStrategyTable.setItems(vipVOData);
		// ���Ե�״̬
		if (systemStrategyVO.getStrategyState() == StrategyState.open) {
			state.setText("����");
		} else {
			state.setText("�ر�");
		}
	}

	@FXML // �����޸���Ϣ
	private void handleModify() {
		mainScene.showSystemMemberStrategyModifyScene(systemStaffVO, systemStrategyVO);
	}

	@FXML // ȡ���޸Ĳ�����
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
