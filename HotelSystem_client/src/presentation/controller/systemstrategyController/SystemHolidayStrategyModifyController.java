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
	private SystemStrategyVO systemStrategyVO;
	private SystemStrategy_blservice systemStrategy_blservice;

	public SystemHolidayStrategyModifyController() {
		systemStrategy_blservice = new SystemStrategy_bl();
	}

	public void initilize(Main mainScene, SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.systemStrategyVO = systemStrategyVO;
		// ����
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		SystemHolidayStrategyModifyShow(mainScene);
	}

	public void SystemHolidayStrategyModifyShow(Main mainScene) {
		// ����
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());
		// ʱ��ѡ������������
		startDate.setConverter(util.DateUtil.converter);
		endDate.setConverter(util.DateUtil.converter);
		// ���ó�ʼֵ
		startDate.setValue(systemStrategyVO.getBegin_date());
		endDate.setValue(systemStrategyVO.getEnd_date());
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
						setTooltip(new Tooltip("�Żݲ��Խ����� " + p + " �죡"));
					}
				};
			}
		};
		endDate.setDayCellFactory(dayCellFactory);
		endDate.setValue(startDate.getValue().plusDays(1));
		// ����ʱ��ѡ��������
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

	@FXML // �޸İ�ť TODO �ж�����Ϸ�+��ʾ��
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
		//�����Ѿ���������systemStrategy���޸�
		boolean isModify = systemStrategy_blservice.modifySystemStrategy(systemStrategyVO);

		if (isModify) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ϲ");
			alert.setHeaderText("�޸ĳɹ�");
			alert.setContentText("���ѳɹ��޸Ļ�Ա�Ż���Ϣ��");

			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("�޸�ʧ��");
			alert.setContentText("��δ�ܳɹ��޸Ļ�Ա�Ż���Ϣ��");

			alert.showAndWait();
		}
	}
	
	@FXML//ȡ���޸Ĳ�����
	private void handleCancel(){
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
}
