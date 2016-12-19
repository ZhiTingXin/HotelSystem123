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
import other.SystemStrategyType;

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
		private Label strategyType;// 表头
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
		private ObservableList<VipVO> vipVOData = FXCollections.observableArrayList();// 声明

		public AddSystemMemberStrategyController() {
			strategy_blservice = new SystemStrategy_bl();
			vipStrategy_blService = new VipStrategy_blServiceImpl();
		}

		public void initilize(Main mainScene, SystemStaffVO systemStaffVO) {
			this.mainScene = mainScene;
			this.systemStaffVO = systemStaffVO;
			//左栏
			leftIdLabel.setText(systemStaffVO.getId());
			leftNameLabel.setText(systemStaffVO.getUsername());
			
			AddSystemMemberStrategyShow(mainScene);
		}

		public void AddSystemMemberStrategyShow(Main mainScene) {
			// 右栏
			// 初始化 table
			VipStrategy_blService vipStrategy_blService = new VipStrategy_blServiceImpl();
			ArrayList<VipVO> vips = vipStrategy_blService.getVipStrategy().getVipStrategyVOList();
			
			for (VipVO vipVO:vips) {
				vipVOData.add(vipVO);
			}
			
			memberStrategyTable.setEditable(true);// 可编辑

			minCredit.setCellValueFactory(cellData -> cellData.getValue().getMinCreditProperty());
			minCredit.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField可编辑化
			minCredit.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
				((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setMincredit(Integer.parseInt(t.getNewValue()));
			});//setNewValue
			maxCredit.setCellValueFactory(cellData -> cellData.getValue().getMaxCreditProperty());
			maxCredit.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField可编辑化
			maxCredit.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
				((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setMaxcredit(Integer.parseInt(t.getNewValue()));
			});//setNewValue
			
			//等级不能编辑--------
			memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());
			
			discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
			discount.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField可编辑化
			discount.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
				((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setDiscount(Double.parseDouble(t.getNewValue()));
			});//setNewValue
			
			memberStrategyTable.setItems(vipVOData);
			// 优惠状态
			
		}

		@FXML // 保存修改信息
		private void handleSave() {
			String strategyName = nameOfStrategy.getText();
			String strategyDescription = descriptionOfStrategy.getText();
            String systemStaffId = systemStaffVO.getId();
			StrategyState strategyState;
			if (open.isSelected()) {
				strategyState = StrategyState.open;
			} else {
				strategyState = StrategyState.close;
			}
			// SystemStrategyVO构造函数
			SystemStrategyVO newSystemStrategy = new SystemStrategyVO();
			newSystemStrategy.setSystemStaffID(systemStaffId);
			newSystemStrategy.setSystemStrategyType(SystemStrategyType.MEMBER);
			newSystemStrategy.setStrategyState(strategyState);
			newSystemStrategy.setSystemStrategyName(strategyName);
			newSystemStrategy.setSystemStrategyDescription(strategyDescription);
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
				alert.setTitle("恭喜");
				alert.setHeaderText("新增成功");
				alert.setContentText("您已成功新增一条会员优惠信息！");
				alert.showAndWait();
				 
				mainScene.showSystemStrategyViewScene(systemStaffVO);//回到查看策略界面
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("抱歉");
				alert.setHeaderText("修改失败");
				alert.setContentText("非常遗憾，您未能成功新增会员优惠信息！");
				alert.showAndWait();
			}
		}

		@FXML // 取消修改并返回
		private void handleCancel() {
			mainScene.showSystemStrategyViewScene(systemStaffVO);
		}

		@FXML // 编辑会员信息
		private void handleEdit() {
			VipVO selected = memberStrategyTable.getSelectionModel().getSelectedItem();
			if (selected != null) {
				mainScene.showMemberEditDialog(selected);
			} else {
				// Nothing selected.
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警示");
				alert.setHeaderText("编辑失败");
				alert.setContentText("不要着急，您应该先选中某个优惠项目再进行编辑！");
				alert.showAndWait();
			}
		}
	
}
