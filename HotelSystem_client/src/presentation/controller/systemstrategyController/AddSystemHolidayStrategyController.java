package presentation.controller.systemstrategyController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import blservice.impl.SystemStrategy_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import other.SystemStrategyType;

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
	private Button back;
	@FXML
	private Label strategyType;// �����
	@FXML
	private TextField nameOfStrategy;
	@FXML
	private TextArea descriptionOfStrategy;
	@FXML
	private DatePicker startDate;
	@FXML
	private DatePicker endDate;
	@FXML
	private TextField discountForCustomer;// �Żݶ��
	@FXML
	private RadioButton open;
	@FXML
	private RadioButton close;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategy_blservice systemStrategy_blservice;

	public AddSystemHolidayStrategyController() {
		systemStrategy_blservice = new SystemStrategy_bl();
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO) {

		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		// ����
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		SystemHolidayStrategyModifyShow(mainScene);
	}

	
	public void SystemHolidayStrategyModifyShow(Main mainScene) {

		// ʱ��ѡ������������
		startDate.setConverter(util.DateUtil.converter);
		endDate.setConverter(util.DateUtil.converter);
		// ���ó�ʼֵ
		LocalDate nowDate =LocalDate.now();
		startDate.setValue(nowDate);
		// ���ý���ʱ���ڿ�ʼʱ��֮ǰ
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
						setTooltip(new Tooltip("�Żݲ��Խ����� " + (p+1) + " �죡"));
					}
				};
			}
		};
		final Callback<DatePicker, DateCell> dayCellFactoryForStartDate = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isBefore(nowDate)) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
					}
				};
			}
		};
		startDate.setDayCellFactory(dayCellFactoryForStartDate);
		endDate.setDayCellFactory(dayCellFactory);
		endDate.setValue(startDate.getValue().plusDays(1));
		// ����ʱ��ѡ��������
	}

	@FXML // �޸İ�ť TODO �ж�����Ϸ�+��ʾ��
	private void handleSave() {
		
		String systemStaffId = systemStaffVO.getId();
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
		// ���캯��
		SystemStrategyVO newSystemStrategyVO = new SystemStrategyVO();
		newSystemStrategyVO.setSystemStrategyType(SystemStrategyType.HOLIDAY);
		newSystemStrategyVO.setBegin_date(big_Date);
		newSystemStrategyVO.setDiscount(discount);
		newSystemStrategyVO.setEnd_date(end_Date);
		newSystemStrategyVO.setSystemStaffID(systemStaffId);
		newSystemStrategyVO.setSystemStrategyDescription(strategyDescription);
		newSystemStrategyVO.setSystemStrategyName(strategyName);
		newSystemStrategyVO.setStrategyState(strategyState);
		boolean isSuc = systemStrategy_blservice.makeSystemStrategy(newSystemStrategyVO);
		if(isSuc){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ϲ");
			alert.setContentText("���ѳɹ�������һ�������Żݲ���");
			Optional<ButtonType> ok = alert.showAndWait();
			if(ok.get()==ButtonType.OK){
				mainScene.showSystemStrategyViewScene(systemStaffVO);
			}
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setContentText("�Բ�������ʧ��");
			alert.showAndWait();
		}
	}

	@FXML // ȡ���޸Ĳ�����
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
