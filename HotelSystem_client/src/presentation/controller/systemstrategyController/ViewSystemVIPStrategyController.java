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

public class ViewSystemVIPStrategyController {

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
	private Label state;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategyVO systemStrategyVO;
	private SystemStrategy_blservice systemStrategy_blservice;
	private VipStrategy_blService vipStrategy_blService;
	private ObservableList<VipVO> vipVOData = FXCollections.observableArrayList();

	public ViewSystemVIPStrategyController() {
		
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.systemStrategyVO = systemStrategyVO;
		// 左栏
		leftIdLabel.setText(this.systemStaffVO.getId());
		leftNameLabel.setText(this.systemStaffVO.getUsername());
		SystemVIPStrategyModifyShow(mainScene);
	}

	public void SystemVIPStrategyModifyShow(Main mainScene) {
		// 右栏
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());
		vipVOData.clear();
	}

	@FXML // 选择商圈
	private void handleDistrictA() {

		// 初始化表格
		String district = districtA.getText();
		vipVOData.clear();
		ArrayList<VipVO> vipVOs = vipStrategy_blService.getVipstrategy(district).getVipStrategyVOList();
		for (VipVO vipVO : vipVOs) {
			vipVOData.add(vipVO);
		}

		memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());
		discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
		systemStrategyTable.setItems(vipVOData);	
		
	}

	@FXML
	private void handleDistrictB() {
		
		String district = districtB.getText();
		vipVOData.clear();// 清空
		ArrayList<VipVO> vipVOs = vipStrategy_blService.getVipstrategy(district).getVipStrategyVOList();
		for (VipVO vipVO : vipVOs) {
			vipVOData.add(vipVO);
		}

		memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());
		discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
		systemStrategyTable.setItems(vipVOData);

	}

	@FXML
	private void handleModify() {
		mainScene.showSystemVIPStrategyModifyScene(systemStaffVO, systemStrategyVO);
	}

	@FXML // cancel and back to the former view.
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
