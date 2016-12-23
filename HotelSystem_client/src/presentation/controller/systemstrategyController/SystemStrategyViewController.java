package presentation.controller.systemstrategyController;

import java.util.ArrayList;
import java.util.Optional;

import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import blservice.impl.SystemStrategy_bl;
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
import other.StrategyState;
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
	private TableColumn<SystemStrategyVO, String> discountNum;// 折扣力度
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
		// 左边栏
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		// 右边栏
		discountListLabel.setText("所有优惠");
		systemStrategyVOList = systemStrategy_blservice.getAllSystemStrategys();
		for (SystemStrategyVO systemStrategyVO : systemStrategyVOList) { // 默认初始化所有的促销策略
			systemStrategyData.add(systemStrategyVO);
		} // 初始化column
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // 监听查看节日策略
	private void handleViewHolidayStrategy() {
		discountListLabel.setText("节日优惠");
		systemStrategyData.clear();// 清空列表
		systemStrategyVOList.clear();// 清空List

		// 得到促销策略
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

	@FXML // 查看会员优惠
	private void handleViewMemberStrategy() {
		discountListLabel.setText("会员优惠");
		systemStrategyData.clear();// 清空列表
		systemStrategyVOList.clear();// 清空List

		// 得到促销策略
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

	@FXML // 查看VIP会员优惠
	private void handleViewVIPStrategy() {
		discountListLabel.setText("VIP会员优惠");
		systemStrategyData.clear();// 清空列表
		systemStrategyVOList.clear();// 清空List

		// 得到促销策略
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

	@FXML // 查看其他优惠策略
	private void handleViewOtherStrategy() {
		discountListLabel.setText("其他优惠");
		systemStrategyData.clear();// 清空列表
		systemStrategyVOList.clear();// 清空List

		// 得到促销策略
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

	@FXML // 返回
	private void handleBack() {
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}

	@FXML // 查看详情优惠策略按钮
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
			alert.setTitle("抱歉");
			alert.setHeaderText("操作失败");
			alert.setContentText("不要着急，您应该先选择需要查看的优惠策略！");
			alert.showAndWait();
		}
	}

	@FXML // 新增优惠策略按钮
	private void handleAddStrategyButton() {

		String labelName = discountListLabel.getText();

		if (labelName == "所有优惠") {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("新增失败");
			alert.setContentText("不要着急，您应该先选择某个优惠类型再进行新增！");
			alert.showAndWait();

		} else if (labelName == "节日优惠") {

			mainScene.showAddSystemHolidayStrategyScene(systemStaffVO);

		} else if (labelName == "会员优惠") {

			if (systemStrategy_blservice.getSystemStrategy(SystemStrategyType.MEMBER).size() == 0) {
				mainScene.showAddSystemMemberStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("抱歉");
				alert.setHeaderText("新增失败");
				alert.setContentText("您真是太客气了，我们仅需要一条会员优惠策略！");
				alert.showAndWait();
			}

		} else if (labelName == "VIP会员优惠") {

			if (systemStrategy_blservice.getSystemStrategy(SystemStrategyType.VIPMEMBER).size()==0) {
				mainScene.showAddSystemVIPStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("抱歉");
				alert.setHeaderText("新增失败");
				alert.setContentText("您真是太热心了，我们仅需要一条VIP会员优惠策略！");
				alert.showAndWait();
			}

		} else if (labelName == "其他优惠") {

			mainScene.showAddSystemOtherStrategyScene(systemStaffVO);

		}
	}

	@FXML // 修改优惠策略列表
	private void handleModifyStrategyButton() {
		
		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();
		
		if (selected != null) {// 选中

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
		} else {// 先选中

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警示");
			alert.setHeaderText("修改失败");
			alert.setContentText("不要着急，您应该先选择某个优惠项目再进行修改！");
			alert.showAndWait();
		}
	}

	@FXML // 删除选中的策略
	private void handleDeleteStrategyButton() {

		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();
		if (selected != null) {
			boolean isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
			if (isDelete) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("恭喜");
				alert.setHeaderText("删除成功");
				alert.setContentText("您已成功删除一条策略信息！");
				Optional<ButtonType> btn = alert.showAndWait();
				if (btn.get() == ButtonType.OK) {
					
					String labelName = discountListLabel.getText();
					if (labelName == "所有优惠") {
						systemStrategyVOList = systemStrategy_blservice.getAllSystemStrategys();
					} else if (labelName == "节日优惠") {
						systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.HOLIDAY);
					} else if (labelName == "会员优惠") {
						systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.MEMBER);
					} else if (labelName == "VIP会员优惠") {
						systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.VIPMEMBER);
					} else if (labelName == "其他优惠") {
						systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.OTHER);
					}
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
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("抱歉");
				alert.setHeaderText("删除失败");
				alert.setContentText("删除优惠策略失败，请重试！");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("警示");
			alert.setHeaderText("删除失败");
			alert.setContentText("不要着急，您应该先选择要删除的策略！");
			alert.showAndWait();
		}
	}
}
