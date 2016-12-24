package presentation.controller.systemstrategyController;

import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import other.StrategyState;

public class ViewSystemHolidayStrategyController {

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
	private Label startDate;
	@FXML
	private Label endDate;
	@FXML
	private Label discountForCustomer;// 优惠额度
	@FXML
	private Label state;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategyVO systemStrategyVO;

	public ViewSystemHolidayStrategyController() {
		
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO,SystemStrategyVO systemStrategyVO) {

		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.systemStrategyVO = systemStrategyVO;
		// 左栏
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		ViewSystemHolidayStrategyShow(mainScene);
	}

	public void ViewSystemHolidayStrategyShow(Main mainScene) {
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());
		startDate.setText(util.DateUtil.format(systemStrategyVO.getBegin_date()));
		endDate.setText(util.DateUtil.format(systemStrategyVO.getEnd_date()));
		discountForCustomer.setText(String.valueOf(systemStrategyVO.getDiscount()));
		if (systemStrategyVO.getStrategyState()==StrategyState.open) {
			state.setText("启用");
		} else {
			state.setText("关闭");
		}
	}

	@FXML 
	private void handleModify() {
		mainScene.showSystemHolidayStrategyModifyScene(systemStaffVO, systemStrategyVO);
	}

	@FXML // 取消修改并返回
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
