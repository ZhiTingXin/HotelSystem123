package presentation.controller.systemstrategyController;

import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import blservice.impl.SystemStrategy_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;

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
	private Label strategyType;//表头
	@FXML
	private TextField nameOfStrategy;
	@FXML
	private TextArea descriptionOfStrategy;
	@FXML
	private TableView<SystemStrategyVO> systemStrategyTable;
	@FXML
	private TableColumn<SystemStrategyVO, String> districtName;
	@FXML
	private TableColumn<SystemStrategyVO, String> memberGrade;
	@FXML
	private TableColumn<SystemStrategyVO, String> vipGrade;
	@FXML
	private TableColumn<SystemStrategyVO, String> discount;
	@FXML
	private Button edit;
	@FXML
	private RadioButton open;
	@FXML
	private RadioButton close;
	
	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategyVO systemStrategyVO;
	private SystemStrategy_blservice systemStrategy_blservice;
	
	public AddSystemVIPStrategyController(){
		systemStrategy_blservice = new SystemStrategy_bl();
	}
	
	public void initilize(Main mainScene, SystemStaffVO systemStaffVO){
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		this.systemStrategyVO = systemStrategyVO;
		//左栏
		leftIdLabel.setText(this.systemStaffVO.getId());
		leftNameLabel.setText(this.systemStaffVO.getUsername());
		SystemVIPStrategyModifyShow(mainScene);
	}
	
	public void SystemVIPStrategyModifyShow(Main mainScene) {
		//右栏
		nameOfStrategy.setText(systemStrategyVO.getSystemStrategyName());
		descriptionOfStrategy.setText(systemStrategyVO.getSystemStrategyDescription());
		// 初始化 table
		
	}
	@FXML
	public void handleSave(){
		
	}
	
	@FXML
	public void handleCancel(){
		
	}
	
	@FXML
	private void handleEdit(){
		
	}
}
