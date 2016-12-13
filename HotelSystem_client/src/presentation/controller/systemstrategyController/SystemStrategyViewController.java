package presentation.controller.systemstrategyController;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Iterator;

import javax.print.attribute.standard.MediaSize.Other;
=======

>>>>>>> refs/remotes/origin/å¶æ™“æ³¢
import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import blservice.impl.SystemStrategy_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import main.Main;
import other.SystemStrategyType;

public class SystemStrategyViewController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button viewHolidayDiscount;
	@FXML
	private Button viewMemberDiscount;
	@FXML
	private Button viewVIPDiscount;
	@FXML
	private Button viewOtherDiscount;
	@FXML
	private Button back;
	@FXML
	private Label discountListLabel;
	@FXML
	private TableView<SystemStrategyVO> systemStrategyTable;
	@FXML
	private TableColumn<SystemStrategyVO, String> nameOfStrategy;
	@FXML
	private TableColumn<SystemStrategyVO, String> descriptionOfStrategy;
	@FXML
	private TableColumn<SystemStrategyVO, String> stateOfStrategy;
	@FXML
	private TableColumn<SystemStrategyVO, String> discountNum;// ÕÛ¿ÛÁ¦¶È
	@FXML
	private Button addStrategy;
	@FXML
	private Button modifyStrategy;
	@FXML
	private Button deleteStrategy;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategyVO systemStrategyVO;
	private SystemStrategy_blservice systemStrategy_blservice;
	private ArrayList<SystemStrategyVO> systemStrategyVOList;
	private ObservableList<SystemStrategyVO> systemStrategyData = FXCollections.observableArrayList();

	public SystemStrategyViewController() {
		systemStrategy_blservice = new SystemStrategy_bl();
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaffVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		SystemStrategyViewShow(mainScene);
	}

	public void SystemStrategyViewShow(Main mainScene) {
		// ×ó±ßÀ¸
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		// ÓÒ±ßÀ¸
		discountListLabel.setText("ËùÓĞÓÅ»İÁĞ±í");
		systemStrategyVOList = systemStrategy_blservice.getAllSystemStrategys();
		for (SystemStrategyVO systemStrategyVO : systemStrategyVOList) { // Ä¬ÈÏ³õÊ¼»¯ËùÓĞµÄ´ÙÏú²ßÂÔ
			systemStrategyData.add(systemStrategyVO);
		} // ³õÊ¼»¯column
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // ¼àÌı²é¿´½ÚÈÕ²ßÂÔ
	private void handleViewHolidayStrategy() {
		discountListLabel.setText("½ÚÈÕÓÅ»İÁĞ±í");
		systemStrategyData.clear();// Çå¿ÕÁĞ±í
		systemStrategyVOList.clear();// Çå¿ÕList

		// µÃµ½´ÙÏú²ßÂÔ
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.HOLIDAY);
		for (SystemStrategyVO holidayStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(holidayStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // ²é¿´»áÔ±ÓÅ»İ
	private void handleViewMemberStrategy() {
		discountListLabel.setText("»áÔ±ÓÅ»İÁĞ±í");
		systemStrategyData.clear();// Çå¿ÕÁĞ±í
		systemStrategyVOList.clear();// Çå¿ÕList

		// µÃµ½´ÙÏú²ßÂÔ
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.MEMBER);
		for (SystemStrategyVO memberStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(memberStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // ²é¿´VIP»áÔ±ÓÅ»İ
	private void handleViewVIPStrategy() {
		discountListLabel.setText("VIP»áÔ±ÓÅ»İÁĞ±í");
		systemStrategyData.clear();// Çå¿ÕÁĞ±í
		systemStrategyVOList.clear();// Çå¿ÕList

		// µÃµ½´ÙÏú²ßÂÔ
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.VIPMEMBER);
		for (SystemStrategyVO VIPStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(VIPStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // ²é¿´ÆäËûÓÅ»İ²ßÂÔ
	private void handleViewOtherStrategy() {
		discountListLabel.setText("ÆäËûÓÅ»İÁĞ±í");
		systemStrategyData.clear();// Çå¿ÕÁĞ±í
		systemStrategyVOList.clear();// Çå¿ÕList

		// µÃµ½´ÙÏú²ßÂÔ
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategy(SystemStrategyType.OTHER);
		for (SystemStrategyVO OtherStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(OtherStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // ·µ»Ø
	private void handleBack() {
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}

	@FXML // ĞÂÔöÓÅ»İ²ßÂÔ°´Å¥
	private void handleAddStrategyButton() {
		
		String labelName = discountListLabel.getText();
		
		if (labelName == "ËùÓĞÓÅ»İÁĞ±í") {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("±§Ç¸");
			alert.setHeaderText("ĞÂÔöÊ§°Ü");
			alert.setContentText("²»Òª×Å¼±£¬ÄúÓ¦¸ÃÏÈÑ¡ÔñÄ³¸öÓÅ»İÀàĞÍÔÙ½øĞĞĞÂÔö£¡");
			alert.showAndWait();
			
		} else if (labelName == "½ÚÈÕÓÅ»İÁĞ±í") {
			
			mainScene.showAddSystemHolidayStrategyScene(systemStaffVO);
			
		} else if (labelName == "»áÔ±ÓÅ»İÁĞ±í") {
			
			if (systemStrategy_blservice.getSystemStrategy(SystemStrategyType.MEMBER)==null) {
				mainScene.showAddSystemMemberStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("±§Ç¸");
				alert.setHeaderText("ĞÂÔöÊ§°Ü");
				alert.setContentText("ÄúÕæÊÇÌ«¿ÍÆøÁË£¬ÎÒÃÇ½öĞèÒªÒ»Ìõ»áÔ±ÓÅ»İ²ßÂÔ£¡");
				alert.showAndWait();
			}
			
		} else if (labelName == "VIP»áÔ±ÓÅ»İÁĞ±í") {

			if (systemStrategy_blservice.getSystemStrategy(SystemStrategyType.VIPMEMBER)==null) {
				mainScene.showAddSystemVIPStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("±§Ç¸");
				alert.setHeaderText("ĞÂÔöÊ§°Ü");
				alert.setContentText("ÄúÕæÊÇÌ«ÈÈĞÄÁË£¬ÎÒÃÇ½öĞèÒªÒ»ÌõVIP»áÔ±ÓÅ»İ²ßÂÔ£¡");
				alert.showAndWait();
			}
			
		} else if (labelName == "ÆäËûÓÅ»İÁĞ±í") {

			mainScene.showAddSystemHolidayStrategyScene(systemStaffVO);
			
		}
	}

	@FXML // ĞŞ¸ÄÓÅ»İ²ßÂÔÁĞ±í
	private void handleModifyStrategyButton() {
		String labelName = discountListLabel.getText();
		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();
		if (selected != null) {// Ñ¡ÖĞ
			if (labelName == "ËùÓĞÓÅ»İÁĞ±í") {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("¾¯Ê¾");
				alert.setHeaderText("ĞŞ¸ÄÊ§°Ü");
				alert.setContentText("²»Òª×Å¼±£¬ÄúÓ¦¸ÃÏÈÑ¡ÔñÄ³¸öÓÅ»İÀàĞÍÔÙ½øĞĞĞŞ¸Ä£¡");
				alert.showAndWait();
				
			} else if (labelName == "½ÚÈÕÓÅ»İÁĞ±í") {
				
				mainScene.showSystemHolidayStrategyModifyScene(systemStaffVO, selected);
				
			} else if (labelName == "»áÔ±ÓÅ»İÁĞ±í") {
				
				mainScene.showSystemMemberStrategyModifyScene(systemStaffVO, selected);
				
			} else if (labelName == "VIP»áÔ±ÓÅ»İÁĞ±í") {
				
				mainScene.showSystemVIPStrategyModifyScene(systemStaffVO, selected);
				
			} else if (labelName == "ÆäËûÓÅ»İÁĞ±í") {
				
				mainScene.showSystemOtherStrategyModifyScene(systemStaffVO, selected);
				
			}
		} else {// ÏÈÑ¡ÖĞ
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("¾¯Ê¾");
			alert.setHeaderText("ĞŞ¸ÄÊ§°Ü");
			alert.setContentText("²»Òª×Å¼±£¬ÄúÓ¦¸ÃÏÈÑ¡ÔñÄ³¸öÓÅ»İÏîÄ¿ÔÙ½øĞĞĞŞ¸Ä£¡");
			alert.showAndWait();
		}
	}

	@FXML // É¾³ıÑ¡ÖĞµÄ²ßÂÔ
	private void handleDeleteStrategyButton() {
		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();
		if (selected != null) {
			systemStrategy_blservice.deleteSystemStrategy(selected);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("¾¯Ê¾");
			alert.setHeaderText("É¾³ıÊ§°Ü");
			alert.setContentText("²»Òª×Å¼±£¬ÄúÓ¦¸ÃÏÈÑ¡ÔñÄ³¸öÓÅ»İÏîÄ¿ÔÙ½øĞĞÉ¾³ı£¡");
			alert.showAndWait();
		}
	}
}
