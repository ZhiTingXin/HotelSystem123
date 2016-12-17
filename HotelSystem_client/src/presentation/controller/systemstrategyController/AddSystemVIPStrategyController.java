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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import main.Main;
import other.StrategyState;

public class AddSystemVIPStrategyController {
	
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
	private SystemStrategy_blservice systemStrategy_blservice;
	private VipStrategy_blService vipStrategy_blService;
	private ObservableList<VipVO> vipVOData = FXCollections.observableArrayList();
	
	public AddSystemVIPStrategyController(){
		systemStrategy_blservice = new SystemStrategy_bl();
		vipStrategy_blService = new VipStrategy_blServiceImpl();
	}
	
	//初始化个人信息
	public void initilize(Main mainScene, SystemStaffVO systemStaffVO){
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		//左栏
		leftIdLabel.setText(this.systemStaffVO.getId());
		leftNameLabel.setText(this.systemStaffVO.getUsername());
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
<<<<<<< HEAD
	@FXML
	public void handleSave(){
		
	}
	
	@FXML
	public void handleCancel(){
		
	}
	
	@FXML
	private void handleEdit(){
		
=======

	@FXML
	private void handleDistrictB() {
		String district = districtB.getText();
		vipVOData.clear();// 清空
		ArrayList<VipVO> vipVOs = vipStrategy_blService.getVipstrategy(district).getVipStrategyVOList();
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

	@FXML
	private void handleSaveTable() {

		ObservableList<VipVO> getVipVO = systemStrategyTable.getItems();
		if (getVipVO != null) {
			ArrayList<VipVO> newVipVO = new ArrayList<VipVO>();
			for (VipVO vipVO : getVipVO) {
				vipVO.setDistrict(districtName.getText());// 获取商圈名称
				newVipVO.add(vipVO);
			}
			VipStrategyVO vipStrategyVO = new VipStrategyVO();
			vipStrategyVO.setVipStrategyVOList(newVipVO);
			boolean isModifyTable = vipStrategy_blService.makeVipStrategy(vipStrategyVO);
			if (isModifyTable) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("恭喜");
				alert.setHeaderText("保存成功");
				alert.setContentText("您已成功保存一条优惠信息！");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("抱歉");
				alert.setHeaderText("保存失败");
				alert.setContentText("对不起，"+districtName.getText()+"商圈的VIP会员优惠保存失败！");
				alert.showAndWait();
			}
		}else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("保存失败");
			alert.setContentText("对不起，您尚未输入策略信息！");
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
		
		boolean isOK = systemStrategy_blservice.makeSystemStrategy(newSystemStrategy);
		
		if (isOK) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("恭喜");
			alert.setHeaderText("保存成功");
			alert.setContentText("您已成功新增一条VIP会员优惠信息！");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				mainScene.showSystemStrategyViewScene(systemStaffVO);
			} 			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("保存失败");
			alert.setContentText("对不起，VIP会员优惠策略新增失败！");
			alert.showAndWait();
		}
	}

	@FXML // cancel and back to the former view.
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
>>>>>>> refs/remotes/origin/master
	}
}
