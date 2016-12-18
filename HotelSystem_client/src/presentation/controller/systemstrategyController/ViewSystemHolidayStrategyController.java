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
	private Label discountForCustomer;// �Żݶ��
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
		// ����
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		ViewSystemHolidayStrategyShow(mainScene);
	}

	public void ViewSystemHolidayStrategyShow(Main mainScene) {
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());
		startDate.setText(util.DateUtil.format(systemStrategyVO.getBegin_Date()));
		endDate.setText(util.DateUtil.format(systemStrategyVO.getEnd_Date()));
		discountForCustomer.setText(String.valueOf(systemStrategyVO.getDiscount()));
		state.setText(String.valueOf(systemStrategyVO.getStrategyState()));
	}

	@FXML 
	private void handleModify() {
		mainScene.showSystemHolidayStrategyModifyScene(systemStaffVO, systemStrategyVO);
	}

	@FXML // ȡ���޸Ĳ�����
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
