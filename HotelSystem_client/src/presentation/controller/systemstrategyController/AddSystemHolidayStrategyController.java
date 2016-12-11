package presentation.controller.systemstrategyController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import blservice.impl.SystemStrategy_bl;
import javafx.fxml.FXML;
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

public class AddSystemHolidayStrategyController {

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
	private SystemStrategyVO newSystemStrategyVO;
	private SystemStrategy_blservice systemStrategy_blservice;

	public AddSystemHolidayStrategyController() {
		systemStrategy_blservice = new SystemStrategy_bl();
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO) {

		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		// 左栏
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		strategyType.setText("新增节日优惠");
		SystemHolidayStrategyModifyShow(mainScene);
	}

	@SuppressWarnings("unchecked")
	public void SystemHolidayStrategyModifyShow(Main mainScene) {

		// 时间选择器属性设置
		startDate.setConverter(util.DateUtil.converter);
		endDate.setConverter(util.DateUtil.converter);
		// 设置初始值
		startDate.setValue(startDate.getValue());
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
	}

	@FXML // 修改按钮 TODO 判断输入合法+提示框
	private void handleSave() {
		String strategyName = nameOfStrategy.getText();
		String strategyDescription = descriptionOfStrategy.getText();
		LocalDate big_Date = startDate.getValue();
		LocalDate end_Date = endDate.getValue();
		double discount = Double.valueOf(discountForCustomer.getText());
		StrategyState strategyState;
		if (open.isSelected()) {
			strategyState = StrategyState.open;
		} else {
			strategyState = StrategyState.close;
		}
		// 构造函数
		newSystemStrategyVO = new SystemStrategyVO(strategyName, strategyDescription, big_Date, end_Date, discount,
				strategyState);
		systemStrategy_blservice.makeSystemStrategy(newSystemStrategyVO);
	}

	@FXML // 取消修改并返回
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
