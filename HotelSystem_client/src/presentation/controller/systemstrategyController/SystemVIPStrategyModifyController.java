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
	private Label strategyType;// 表头
	@FXML
	private TextField nameOfStrategy;
	@FXML
	private TextArea descriptionOfStrategy;
	@FXML
	private Label city;
	@FXML
	private Label district;
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

	private VipStrategyVO vipStrategyVO;
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

	public void initilize(Main mainScene,String city,String district,SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.systemStrategyVO = systemStrategyVO;
		// 左栏
		leftIdLabel.setText(this.systemStaffVO.getId());
		leftNameLabel.setText(this.systemStaffVO.getUsername());
		SystemVIPStrategyModifyShow(mainScene);
		this.city.setText(city);
		this.district.setText(district);
		vipVOData.clear();
		ArrayList<VipVO> vipVOs = vipStrategy_blService.getVipstrategy(this.city.getText(),this.district.getText()).getVipStrategyVOList();
		for (VipVO vipVO : vipVOs) {
			vipVOData.add(vipVO);
		}

		systemStrategyTable.setEditable(true);// 可编辑

		memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());

		discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
		discount.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField可编辑化
		discount.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
			((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setDiscount(Double.parseDouble(t.getNewValue()));
		});// setNewValue
		systemStrategyTable.setItems(vipVOData);	
		
	}

	public void SystemVIPStrategyModifyShow(Main mainScene) {
		// 右栏
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());

		// 优惠状态
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
	
	@FXML
	private void handleSaveTable() {

		ObservableList<VipVO> getVipVO = systemStrategyTable.getItems();
			
		ArrayList<VipVO> newVipVO = new ArrayList<VipVO>();
		for (VipVO vipVO : getVipVO) {
			newVipVO.add(vipVO);
		}
			
		vipStrategyVO = new VipStrategyVO();
		vipStrategyVO.setVipStrategyVOList(newVipVO);
			
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("恭喜");
		alert.setContentText("保存成功");
		alert.showAndWait();
		
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
		
		systemStrategyVO.setSystemStrategyName(strategyName);
		systemStrategyVO.setSystemStrategyDescription(strategyDescription);
		systemStrategyVO.setStrategyState(strategyState);
		boolean isOK = systemStrategy_blservice.modifySystemStrategy(systemStrategyVO);
		boolean isModifyTable = vipStrategy_blService.modifuSuperVipStrategy(vipStrategyVO);
		
		if (isOK&&isModifyTable) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("恭喜");
			alert.setHeaderText("保存成功");
			alert.setContentText("您已成功修改一条优惠信息！");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				mainScene.showSystemStrategyViewScene(systemStaffVO);
			} 			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("保存失败");
			alert.setContentText("对不起，优惠策略保存失败！");
			alert.showAndWait();
		}
	}

	@FXML // cancel and back to the former view.
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
