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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import main.Main;
import other.MyDistricts;
import other.StrategyState;
import other.SystemStrategyType;
import util.ImageUtil;

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
	private Label strategyType;// ��ͷ
	@FXML
	private TextField nameOfStrategy;
	@FXML
	private TextArea descriptionOfStrategy;
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
	@FXML
	private ChoiceBox<String> city;
	@FXML
	private ChoiceBox<String> district;
	
	ObservableList<String> cityList = FXCollections.observableArrayList();// �����б�
	ObservableList<String> districtList = FXCollections.observableArrayList();// ��Ȧ�б�
	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategy_blservice systemStrategy_blservice;
	private VipStrategy_blService vipStrategy_blService;
	private ObservableList<VipVO> vipVOData = FXCollections.observableArrayList();
	
	public AddSystemVIPStrategyController(){
		systemStrategy_blservice = new SystemStrategy_bl();
		vipStrategy_blService = new VipStrategy_blServiceImpl();
	}
	
	//��ʼ��������Ϣ
	public void initilize(Main mainScene, SystemStaffVO systemStaffVO){
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		//����
		leftIdLabel.setText(this.systemStaffVO.getId());
		leftNameLabel.setText(this.systemStaffVO.getUsername());
		myPicture.setImage(ImageUtil.setImage(systemStaffVO.getImage()));
		initializeChoiceBox();
        
		freshTable();
		
	}
	
	private void initializeChoiceBox() {
		for (String city : MyDistricts.cities) {
			cityList.add(city);
		}
		city.setItems(cityList);
		city.getSelectionModel().selectedItemProperty()
				.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));
	}
	
	private void setDistrictChoiceBox(String city) {
		districtList.clear();
		String[] districts = MyDistricts.getDistricts(city);
		for (String dist : districts) {
			districtList.add(dist);
		}
		district.setItems(districtList);
	}
	
	@FXML
	private void handleSaveTable() {

		VipStrategyVO vipStrategyVO = vipStrategy_blService.getVipstrategy(city.getValue(), district.getValue());
		if (vipStrategyVO.getVipStrategyVOList().size()!=0) {
			vipVOData.clear();
			ArrayList<VipVO> vipVOs = vipStrategyVO.getVipStrategyVOList();
			for (VipVO vipVO : vipVOs) {
				vipVOData.add(vipVO);
			}

			memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());
			discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
			systemStrategyTable.setItems(vipVOData);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("����");
			alert.setContentText("����Ȧ��VIP��Ա�����Ѿ����ڣ���ѡ���޸�");
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get() == ButtonType.OK) {
				freshTable();
			}
		}else{
			ObservableList<VipVO> getVipVO = systemStrategyTable.getItems();
			ArrayList<VipVO> newVipVO = new ArrayList<VipVO>();
			for (VipVO vipVO : getVipVO) {
				vipVO.setCity(city.getValue());
				vipVO.setDistrict(district.getValue());// ��ȡ��Ȧ����
				newVipVO.add(vipVO);
			}
			vipStrategyVO = new VipStrategyVO();
			vipStrategyVO.setVipStrategyVOList(newVipVO);
			vipStrategy_blService.makeSuperVipStrategy(vipStrategyVO);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ϲ");
			alert.setContentText("����ɹ���");
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
		newSystemStrategy.setSystemStaffID(systemStaffVO.getId());
		newSystemStrategy.setSystemStrategyType(SystemStrategyType.VIPMEMBER);
		
		boolean isOK = systemStrategy_blservice.makeSystemStrategy(newSystemStrategy);
		if (isOK) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("��ϲ");
			alert.setHeaderText("����ɹ�");
			alert.setContentText("���ѳɹ�����һ��VIP��Ա�Ż���Ϣ��");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				mainScene.showSystemStrategyViewScene(systemStaffVO);
			} 			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("�Բ���VIP��Ա�Żݲ�������ʧ�ܣ�");
			alert.showAndWait();
		}
	}

	@FXML // cancel and back to the former view.
	private void handleCancel() {
		mainScene.showSystemStrategyViewScene(systemStaffVO);
	}
	private void freshTable(){
		vipVOData.clear();
		
		VipVO vipVO1 = new VipVO();
		vipVO1.setDiscount(0);
		vipVO1.setVipgrade(4);
		VipVO vipVO = new VipVO();
		vipVO.setDiscount(0);
		vipVO.setVipgrade(5);
		
		vipVOData.add(vipVO1);
		vipVOData.add(vipVO);
		
		systemStrategyTable.setEditable(true);// �ɱ༭

		memberGrade.setCellValueFactory(cellData -> cellData.getValue().getMemberGradeProperty());

		discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
		discount.setCellFactory(TextFieldTableCell.<VipVO> forTableColumn());// textField�ɱ༭��
		discount.setOnEditCommit((CellEditEvent<VipVO, String> t) -> {
			((VipVO) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setDiscount(Double.parseDouble(t.getNewValue()));
		});// setNewValue
		systemStrategyTable.setItems(vipVOData);
		
	}
}
