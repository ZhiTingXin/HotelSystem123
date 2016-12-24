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
import other.SystemStrategyType;

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
	private ObservableList<VipVO> vipVOData = FXCollections.observableArrayList();// 声明

	public ViewSystemMemberStrategyController() {
		vipStrategy_blService = new VipStrategy_blServiceImpl();
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.systemStrategyVO = systemStrategyVO;
		// 左栏
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		ViewSystemHolidayStrategyShow(mainScene);
	}

	public void ViewSystemHolidayStrategyShow(Main mainScene) {
		// 右栏
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());
		// 初始化 table
		vipVOList = vipStrategy_blService.getVipStrategy().getVipStrategyVOList();
		for (VipVO vipVO : vipVOList) {
			vipVOData.add(vipVO);
		}

		minCredit.setCellValueFactory(cellData -> cellData.getValue().getMinCreditProperty());

		maxCredit.setCellValueFactory(cellData -> cellData.getValue().getMaxCreditProperty());

		memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());

		discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());

		memberStrategyTable.setItems(vipVOData);
		// 策略的状态
		if (systemStrategyVO.getStrategyState() == StrategyState.open) {
			state.setText("启用");
		} else {
			state.setText("关闭");
		}
	}

	@FXML // 保存修改信息
	private void handleModify() {
		mainScene.showSystemMemberStrategyModifyScene(systemStaffVO, systemStrategyVO);
	}

	@FXML // 取消修改并返回
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
