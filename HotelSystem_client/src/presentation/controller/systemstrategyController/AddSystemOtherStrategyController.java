package presentation.controller.systemstrategyController;

import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import blservice.impl.SystemStrategy_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import other.StrategyState;
import other.SystemStrategyType;

public class AddSystemOtherStrategyController {
	
	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button save;
	@FXML
	private Button delete;
	@FXML
	private Button back;
	@FXML
	private Label strategyType;
	@FXML
	private TextField nameOfStrategy;
	@FXML
	private TextArea descriptionOfStrategy;
	@FXML
	private TextField discountForCustomer;
	@FXML
	private RadioButton open;
	@FXML
	private RadioButton close;
	
	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategy_blservice systemStrategy_blservice;
	
	public AddSystemOtherStrategyController() {
		systemStrategy_blservice = new SystemStrategy_bl();
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		SystemHolidayStrategyModifyShow(mainScene);
	}

	public void SystemHolidayStrategyModifyShow(Main mainScene) {
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());//初始化
	}
	
	@FXML//保存修改
	private void handleSave(){
		String strategyName = nameOfStrategy.getText();
		String strategyDescription = descriptionOfStrategy.getText();
		double discount = Double.parseDouble(discountForCustomer.getText());
		String systemStaffID = systemStaffVO.getId();
		StrategyState strategyState;
		if (open.isSelected()) {
			strategyState = StrategyState.open;
		} else {
			strategyState = StrategyState.close;
		}
		// SystemStrategyVO构造函数
		SystemStrategyVO newSystemStrategy = new SystemStrategyVO();
		newSystemStrategy.setSystemStrategyName(strategyName);
		newSystemStrategy.setSystemStrategyDescription(strategyDescription);
		newSystemStrategy.setDiscount(discount);
		newSystemStrategy.setStrategyState(strategyState);
		newSystemStrategy.setSystemStaffID(systemStaffID);
		newSystemStrategy.setSystemStrategyType(SystemStrategyType.OTHER);
		boolean isModify1 = systemStrategy_blservice.makeSystemStrategy(newSystemStrategy);

		if (isModify1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("恭喜");
			alert.setHeaderText("新增成功");
			alert.setContentText("您已成功新增一条优惠信息！");
			alert.showAndWait();
			// TODO 返回到查看界面
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("新增失败");
			alert.setContentText("非常遗憾，您未能成功新增优惠信息！");
			alert.showAndWait();
		}
	}

	@FXML // 取消修改并返回
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}

}
