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
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import main.Main;
import other.MyDistricts;
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
	@FXML
	private Button viewStrategy;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategy_blservice systemStrategy_blservice;
	private VipStrategy_blService vipStrategy_blService;
	private ArrayList<SystemStrategyVO> systemStrategyVOList;
	private ObservableList<SystemStrategyVO> systemStrategyData = FXCollections.observableArrayList();
	ObservableList<String> cityList = FXCollections.observableArrayList();// 城市列表
	ObservableList<String> districtList = FXCollections.observableArrayList();// 商圈列表
	private ChoiceBox<String> districtBox = new ChoiceBox<>();
	private	ChoiceBox<String> cityBox = new ChoiceBox<>();
	
	public SystemStrategyViewController() {
		systemStrategy_blservice = new SystemStrategy_bl();
		vipStrategy_blService = new VipStrategy_blServiceImpl();
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaffVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		SystemStrategyViewShow(mainScene);
		districtBox.setCache(false);
		cityBox.setCache(false);
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

	@FXML // 查看会员优惠
	private void handleViewMemberStrategy() {
		discountListLabel.setText("会员优惠");
		systemStrategyData.clear();// 清空列表
		systemStrategyVOList.clear();// 清空List

		// 得到促销策略
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

	@FXML // 查看VIP会员优惠
	private void handleViewVIPStrategy() {
		discountListLabel.setText("VIP会员优惠");
		systemStrategyData.clear();// 清空列表
		systemStrategyVOList.clear();// 清空List

		// 得到促销策略
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

	@FXML // 查看其他优惠策略
	private void handleViewOtherStrategy() {
		discountListLabel.setText("其他优惠");
		systemStrategyData.clear();// 清空列表
		systemStrategyVOList.clear();// 清空List

		// 得到促销策略
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
				
				//需要弹出选择城市和商圈的选择框，然后返回的是城市和商圈的信息
				Dialog<Pair<String, String>> dialog = new Dialog<>();
				dialog.setTitle("提示");
				dialog.setHeaderText("请选择城市和商圈！");
				//添加图片
				dialog.setGraphic(new ImageView(this.getClass().getResource("district.png").toString()));
				
				ButtonType ok = new ButtonType("确认",ButtonData.OK_DONE);
				ButtonType cancel = new ButtonType("取消",ButtonData.CANCEL_CLOSE);
				dialog.getDialogPane().getButtonTypes().addAll(ok,cancel);
				//建立choice box
				GridPane gridPane = new GridPane();
				gridPane.setHgap(10);
				gridPane.setVgap(10);
				gridPane.setPadding(new Insets(20,150,10,10));
				
				cityBox.setMaxWidth(85);
				cityBox.setMinWidth(85);
				districtBox.setMaxWidth(85);
				districtBox.setMinWidth(85);
				for (String city : MyDistricts.cities) {
					cityList.add(city);
				}
				cityBox.setItems(cityList);
				cityBox.getSelectionModel().selectedItemProperty()
						.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));
				
				gridPane.add(new Label("选择城市："), 0, 0);
				gridPane.add(cityBox, 1, 0);
				gridPane.add(new Label("选择商圈："), 0, 1);
				gridPane.add(districtBox, 1, 1);
				// Enable/Disable login button depending on whether a city was choosed.
				Node okButton = dialog.getDialogPane().lookupButton(ok);
				okButton.setDisable(false);

				cityBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				    okButton.setDisable(newValue.trim().isEmpty());
				});
				
				dialog.getDialogPane().setContent(gridPane);
				
				// Request focus on the cityBox by default.
				Platform.runLater(() -> cityBox.requestFocus());

				dialog.setResultConverter(dialogButton -> {
				    if (dialogButton == ok) {
				        return new Pair<>(cityBox.getValue(), districtBox.getValue());
				    }
				    return null;
				});

				Optional<Pair<String, String>> result = dialog.showAndWait();

				result.ifPresent(CityDistict -> {
					mainScene.showViewSystemVIPStrategyScene(systemStaffVO, CityDistict.getKey(), CityDistict.getValue(), selected);
				});

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
	
	//商圈choice box的响应
	private void setDistrictChoiceBox(String city) {
		districtList.clear();
		String[] districts = MyDistricts.getDistricts(city);
		for (String dist : districts) {
			districtList.add(dist);
		}
		districtBox.setItems(districtList);
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

			if (systemStrategy_blservice.getSystemStrategys(SystemStrategyType.MEMBER).size() == 0) {
				mainScene.showAddSystemMemberStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("抱歉");
				alert.setHeaderText("新增失败");
				alert.setContentText("您真是太客气了，我们仅需要一条会员优惠策略！");
				alert.showAndWait();
			}

		} else if (labelName == "VIP会员优惠") {

			if (systemStrategy_blservice.getSystemStrategys(SystemStrategyType.VIPMEMBER).size() == 0) {
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

				//需要弹出选择城市和商圈的选择框，然后返回的是城市和商圈的信息
				Dialog<Pair<String, String>> dialog = new Dialog<>();
				dialog.setTitle("提示");
				dialog.setHeaderText("请选择城市和商圈！");
				//添加图片
				dialog.setGraphic(new ImageView(this.getClass().getResource("district.png").toString()));
				
				ButtonType ok = new ButtonType("确认",ButtonData.OK_DONE);
				ButtonType cancel = new ButtonType("取消",ButtonData.CANCEL_CLOSE);
				dialog.getDialogPane().getButtonTypes().addAll(ok,cancel);
				//建立choice box
				GridPane gridPane = new GridPane();
				gridPane.setHgap(10);
				gridPane.setVgap(10);
				gridPane.setPadding(new Insets(20,150,10,10));
				
				cityBox.setMaxWidth(85);
				cityBox.setMinWidth(85);
				districtBox.setMaxWidth(85);
				districtBox.setMinWidth(85);
				for (String city : MyDistricts.cities) {
					cityList.add(city);
				}
				cityBox.setItems(cityList);
				cityBox.getSelectionModel().selectedItemProperty()
						.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));
				
				gridPane.add(new Label("选择城市："), 0, 0);
				gridPane.add(cityBox, 1, 0);
				gridPane.add(new Label("选择商圈："), 0, 1);
				gridPane.add(districtBox, 1, 1);
				// Enable/Disable login button depending on whether a city was choosed.
				Node okButton = dialog.getDialogPane().lookupButton(ok);
				okButton.setDisable(false);

				cityBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				    okButton.setDisable(newValue.trim().isEmpty());
				});
				
				dialog.getDialogPane().setContent(gridPane);
				
				// Request focus on the cityBox by default.
				Platform.runLater(() -> cityBox.requestFocus());

				dialog.setResultConverter(dialogButton -> {
				    if (dialogButton == ok) {
				        return new Pair<>(cityBox.getValue(), districtBox.getValue());
				    }
				    return null;
				});

				Optional<Pair<String, String>> result = dialog.showAndWait();

				result.ifPresent(CityDistict -> {
				    mainScene.showSystemVIPStrategyModifyScene(systemStaffVO, CityDistict.getKey(), CityDistict.getValue(), selected);
				});
				
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
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("删除");
			alert.setHeaderText("删除之后将无法撤销");
			alert.setContentText("是否删除？");
			ButtonType buttonOK = new ButtonType("是");
			ButtonType buttonNO = new ButtonType("否");
			alert.getButtonTypes().setAll(buttonOK, buttonNO);
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get() == buttonOK) {// 是
				boolean isDelete = false;
				if (selected.getSystemStrategyType() == SystemStrategyType.HOLIDAY) {
					isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
				} else if (selected.getSystemStrategyType() == SystemStrategyType.OTHER) {
					isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
				} else if (selected.getSystemStrategyType() == SystemStrategyType.VIPMEMBER) {
					if (vipStrategy_blService.getSuperVipNum()==0) {
						isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
					}
					//需要弹出选择城市和商圈的选择框，然后返回的是城市和商圈的信息
					Dialog<Pair<String, String>> dialog = new Dialog<>();
					dialog.setTitle("提示");
					dialog.setHeaderText("请选择城市和商圈！");
					//添加图片
					dialog.setGraphic(new ImageView(this.getClass().getResource("district.png").toString()));
					
					ButtonType ok = new ButtonType("确认",ButtonData.OK_DONE);
					ButtonType cancel = new ButtonType("取消",ButtonData.CANCEL_CLOSE);
					dialog.getDialogPane().getButtonTypes().addAll(ok,cancel);
					//建立choice box
					GridPane gridPane = new GridPane();
					gridPane.setHgap(10);
					gridPane.setVgap(10);
					gridPane.setPadding(new Insets(20,150,10,10));
					
					cityBox.setMaxWidth(85);
					cityBox.setMinWidth(85);
					districtBox.setMaxWidth(85);
					districtBox.setMinWidth(85);
					for (String city : MyDistricts.cities) {
						cityList.add(city);
					}
					cityBox.setItems(cityList);
					cityBox.getSelectionModel().selectedItemProperty()
							.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));
					
					gridPane.add(new Label("选择城市："), 0, 0);
					gridPane.add(cityBox, 1, 0);
					gridPane.add(new Label("选择商圈："), 0, 1);
					gridPane.add(districtBox, 1, 1);
					// Enable/Disable login button depending on whether a city was choosed.
					Node okButton = dialog.getDialogPane().lookupButton(ok);
					okButton.setDisable(false);

					cityBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
					    okButton.setDisable(newValue.trim().isEmpty());
					});
					
					dialog.getDialogPane().setContent(gridPane);
					
					// Request focus on the cityBox by default.
					Platform.runLater(() -> cityBox.requestFocus());

					dialog.setResultConverter(dialogButton -> {
					    if (dialogButton == ok) {
					        return new Pair<>(cityBox.getValue(), districtBox.getValue());
					    }
					    return null;
					});

					Optional<Pair<String, String>> result = dialog.showAndWait();
					result.ifPresent(CityDistict -> {
						VipStrategyVO vipStrategyVO = vipStrategy_blService.getVipstrategy(CityDistict.getKey(), CityDistict.getValue());
						if (vipStrategyVO.getVipStrategyVOList().size()!=0) {
							vipStrategy_blService.deleteSuperVipStrategy(CityDistict.getKey(),CityDistict.getValue());
						}else {
							Alert alert1 = new Alert(AlertType.INFORMATION);
							alert1.setTitle("提醒");
							alert1.setContentText("该商圈的VIP会员策略不存在");
							alert1.showAndWait();
						}
					});
				} else {
					isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
					 VipVO vip1 = new VipVO(0, 0, 1, 10);
					 VipVO vip2 = new VipVO(0, 0, 2, 10);
			         VipVO vip3 = new VipVO(0, 0, 3, 10);
				     VipVO vip4 = new VipVO(0, 0, 4, 10);
				     VipVO vip5 = new VipVO(0, 0, 5, 10);
				     ArrayList<VipVO> vipVOData = new ArrayList<VipVO>();
				     vipVOData.add(vip1);
				     vipVOData.add(vip2);
				     vipVOData.add(vip3);
				     vipVOData.add(vip4);
				     vipVOData.add(vip5);
				     VipStrategyVO vipStrategyVO = new VipStrategyVO();
				     vipStrategyVO.setVipStrategyVOList(vipVOData);
				     vipStrategy_blService.modifyVipStrategy(vipStrategyVO);
				}
				if (isDelete) {
					Alert alert1 = new Alert(AlertType.INFORMATION);
					alert1.setTitle("恭喜");
					alert1.setHeaderText("删除成功");
					alert1.setContentText("您已成功删除一条策略信息！");
					Optional<ButtonType> btn1 = alert1.showAndWait();
					if (btn1.get() == ButtonType.OK) {

						String labelName = discountListLabel.getText();
						if (labelName == "所有优惠") {
							systemStrategyVOList = systemStrategy_blservice.getAllSystemStrategys();
						} else if (labelName == "节日优惠") {
							systemStrategyVOList = systemStrategy_blservice
									.getSystemStrategys(SystemStrategyType.HOLIDAY);
						} else if (labelName == "会员优惠") {
							systemStrategyVOList = systemStrategy_blservice
									.getSystemStrategys(SystemStrategyType.MEMBER);
						} else if (labelName == "VIP会员优惠") {
							systemStrategyVOList = systemStrategy_blservice
									.getSystemStrategys(SystemStrategyType.VIPMEMBER);
						} else if (labelName == "其他优惠") {
							systemStrategyVOList = systemStrategy_blservice
									.getSystemStrategys(SystemStrategyType.OTHER);
						}

						systemStrategyData.clear();
						for (SystemStrategyVO systemStrategy : systemStrategyVOList) {
							systemStrategyData.add(systemStrategy);
						}
						nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
						descriptionOfStrategy
								.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
						stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
						discountNum
								.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
						systemStrategyTable.setItems(systemStrategyData);

					}
				} else {
					Alert alert2 = new Alert(AlertType.ERROR);
					alert2.setTitle("抱歉");
					alert2.setHeaderText("删除失败");
					alert2.setContentText("删除优惠策略失败");
					alert2.showAndWait();
				}
			} else {// 选择否
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
