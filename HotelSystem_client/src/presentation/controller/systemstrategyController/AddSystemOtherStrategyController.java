package presentation.controller.systemstrategyController;

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
		leftNameLabel.setText(systemStaffVO.getUsername());//��ʼ��
	}
	
	@FXML//�����޸�
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
		// SystemStrategyVO���캯��
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
			alert.setTitle("��ϲ");
			alert.setHeaderText("�����ɹ�");
			alert.setContentText("���ѳɹ�����һ���Ż���Ϣ��");
			Optional<ButtonType> aOptional = alert.showAndWait();
			if(aOptional.get()==ButtonType.OK){
				mainScene.showSystemStrategyViewScene(systemStaffVO);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("�ǳ��ź�����δ�ܳɹ������Ż���Ϣ��");
			alert.showAndWait();
		}
	}

	@FXML // ȡ���޸Ĳ�����
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}

}
