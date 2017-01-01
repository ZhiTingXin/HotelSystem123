package presentation.controller.adviceFeedBackController;

import java.util.ArrayList;

import VO.AdviceFeedBackVO;
import VO.SystemStaffVO;
import blservice.AdviceFeedBack_blservice;
import blservice.impl.AdviceFeedBack_bl;
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
import util.ImageUtil;

public class SystemStaffAdviceViewController {

	@FXML
	private Label idLabel;

	@FXML
	private Label adviceType;

	@FXML
	private ImageView myPicture;
	@FXML
	private Label nameLabel;

	@FXML
	private Button back;

	@FXML
	private Button Unprocessed;

	@FXML
	private Button processed;

	@FXML
	private TableView<AdviceFeedBackVO> adviceTable;

	@FXML
	private TableColumn<AdviceFeedBackVO, String> sendtime;

	@FXML
	private TableColumn<AdviceFeedBackVO, String> customerID;

	@FXML
	private TableColumn<AdviceFeedBackVO, String> content;// 反馈内容

	@FXML
	private TableColumn<AdviceFeedBackVO, String> Astate;// 反馈状态

	private Main mainScene;
	private SystemStaffVO staffVO;
	private ObservableList<AdviceFeedBackVO> adviceData = FXCollections.observableArrayList();
	private AdviceFeedBack_blservice adviceFeedBack_blservice;

	/**
	 * 
	 * @param main
	 * @param staffVO
	 *            界面初始化
	 */
	public void initialize(Main main, SystemStaffVO staffVO) {

		adviceFeedBack_blservice = new AdviceFeedBack_bl();

		this.staffVO = staffVO;
		this.mainScene = main;
		idLabel.setText(staffVO.getId());
		nameLabel.setText(staffVO.getUsername());
		myPicture.setImage(ImageUtil.setImage(this.staffVO.getImage()));
		adviceType.setText("意见反馈信息表");

		ArrayList<AdviceFeedBackVO> aBackVOs = adviceFeedBack_blservice.getUnprocessedAdvice();
		for (AdviceFeedBackVO vo : aBackVOs) {
			adviceData.add(vo);
		}

		sendtime.setCellValueFactory(cellData -> cellData.getValue().getSendTimeProperty());
		customerID.setCellValueFactory(cellData -> cellData.getValue().getUserIdProperty());
		content.setCellValueFactory(cellData -> cellData.getValue().getSendContentProperty());
		Astate.setCellValueFactory(cellData -> cellData.getValue().getAstateProperty());

		adviceTable.setItems(adviceData);
	}

	@FXML
	private void handleBack() {
		mainScene.showSystemStaffMainScene(staffVO);
	}

	@FXML
	private void viewUnprocessed() {
		adviceData.clear();

		ArrayList<AdviceFeedBackVO> aBackVOs = adviceFeedBack_blservice.getUnprocessedAdvice();
		for (AdviceFeedBackVO vo : aBackVOs) {
			adviceData.add(vo);
		}

		sendtime.setCellValueFactory(cellData -> cellData.getValue().getSendTimeProperty());
		customerID.setCellValueFactory(cellData -> cellData.getValue().getUserIdProperty());
		content.setCellValueFactory(cellData -> cellData.getValue().getSendContentProperty());
		Astate.setCellValueFactory(cellData -> cellData.getValue().getAstateProperty());

		adviceTable.setItems(adviceData);
	}

	@FXML
	private void viewProcessed() {
		adviceData.clear();

		ArrayList<AdviceFeedBackVO> aBackVOs = adviceFeedBack_blservice.getProcessedAdvice();
		for (AdviceFeedBackVO vo : aBackVOs) {
			adviceData.add(vo);
		}

		sendtime.setCellValueFactory(cellData -> cellData.getValue().getSendTimeProperty());
		customerID.setCellValueFactory(cellData -> cellData.getValue().getUserIdProperty());
		content.setCellValueFactory(cellData -> cellData.getValue().getSendContentProperty());
		Astate.setCellValueFactory(cellData -> cellData.getValue().getAstateProperty());

		adviceTable.setItems(adviceData);
	}

	@FXML
	private void viewSpecific() {
		AdviceFeedBackVO selected = adviceTable.getSelectionModel().getSelectedItem();
		if (selected == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("抱歉");
			alert.setContentText("请先选中后再查看");
			alert.showAndWait();
		} else {
			mainScene.showSystemStaffAdviceViewSpecScene(staffVO, selected);
		}
	}
}
