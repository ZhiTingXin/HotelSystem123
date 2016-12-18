package presentation.controller.systemstrategyController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import blservice.impl.SystemStrategy_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import main.Main;
import other.StrategyState;

public class SystemHolidayStrategyModifyController {

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
	private Label strategyType;// 大标题
	@FXML
	private TextField nameOfStrategy;
	@FXML
	private TextArea descriptionOfStrategy;
	@FXML
	private DatePicker startDate;
	@FXML
	private DatePicker endDate;
	@FXML
	private TextField discountForCustomer;// 优惠额度
	@FXML
	private RadioButton open;
	@FXML
	private RadioButton close;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategyVO systemStrategyVO;
	private SystemStrategy_blservice systemStrategy_blservice;

	public SystemHolidayStrategyModifyController() {
		systemStrategy_blservice = new SystemStrategy_bl();
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.systemStrategyVO = systemStrategyVO;
		// 左栏
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		SystemHolidayStrategyModifyShow(mainScene);
	}

	public void SystemHolidayStrategyModifyShow(Main mainScene) {
		// 右栏
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());
		// 时间选择器属性设置
		startDate.setConverter(util.DateUtil.converter);
		endDate.setConverter(util.DateUtil.converter);
		// 设置初始值
		startDate.setValue(systemStrategyVO.getBegin_date());
		endDate.setValue(systemStrategyVO.getEnd_date());
		// 设置结束时间在开始时间之前
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isBefore(startDate.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
						long p = ChronoUnit.DAYS.between(endDate.getValue(), item);
						setTooltip(new Tooltip("优惠策略将持续 " + p + " 天！"));
					}
				};
			}
		};
		endDate.setDayCellFactory(dayCellFactory);
		endDate.setValue(startDate.getValue().plusDays(1));
		// 设置时间选择器结束
		discountForCustomer.setText(String.valueOf(systemStrategyVO.getDiscount() * 10));
		StrategyState strategyState = systemStrategyVO.getStrategyState();
		if (strategyState == StrategyState.open) {
			open.setSelected(true);
			close.setSelected(false);
		} else {
			open.setSelected(true);
			close.setSelected(false);
		}
	}

	@FXML // 修改按钮 TODO 判断输入合法+提示框
	private void handleSave() {
		systemStrategyVO.setSystemStrategyName(nameOfStrategy.getText());
		systemStrategyVO.setSystemStrategyDescription(descriptionOfStrategy.getText());
		systemStrategyVO.setBegin_date(startDate.getValue());
		systemStrategyVO.setEnd_date(endDate.getValue());
		systemStrategyVO.setDiscount(Double.valueOf(discountForCustomer.getText()));
		StrategyState strategyState;
		if (open.isSelected()) {
			strategyState = StrategyState.open;
		} else {
			strategyState = StrategyState.close;
		}
		systemStrategyVO.setStrategyState(strategyState);
		//对于已经传上来的systemStrategy的修改
		boolean isModify = systemStrategy_blservice.modifySystemStrategy(systemStrategyVO);

		if (isModify) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("恭喜");
			alert.setHeaderText("修改成功");
			alert.setContentText("您已成功修改会员优惠信息！");

			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setHeaderText("修改失败");
			alert.setContentText("您未能成功修改会员优惠信息！");

			alert.showAndWait();
		}
	}
	
	@FXML//取消修改并返回
	private void handleCancel(){
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
