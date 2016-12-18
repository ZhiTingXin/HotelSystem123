package presentation.controller.adviceFeedBackController;

import java.util.ArrayList;

import VO.AdviceFeedBackVO;
import VO.CustomerVO;
import blservice.AdviceFeedBack_blservice;
import blservice.impl.AdviceFeedBack_bl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.Main;

public class CustomerAdviceViewController {
	@FXML
	private Label leftIDLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private TableColumn<AdviceFeedBackVO, String> sendTime;
	@FXML
	private TableColumn<AdviceFeedBackVO, String> replyTime;
	@FXML
	private TableColumn<AdviceFeedBackVO, String> sendInfo;
	@FXML
	private TableColumn<AdviceFeedBackVO, String> replyInfo;
	@FXML
	private TableView<AdviceFeedBackVO> adviceFeedBackTable;
	@FXML
	private Button create;
	@FXML
	private Button adviceInfo;
	@FXML
	private Button back;

	private Main mainScene;
	private CustomerVO customer;
	private ArrayList<AdviceFeedBackVO> adviceList;
	private ObservableList<AdviceFeedBackVO> adviceData = FXCollections.observableArrayList();
	private AdviceFeedBack_blservice service;

	public void initialize(Main main, CustomerVO customer2) {
		// TODO Auto-generated method stub
		this.mainScene = main;
		this.customer = customer2;
		this.service = new AdviceFeedBack_bl();
		this.adviceList = this.service.getAllAdvice(this.customer.getId());

		this.refreshtable();
		this.showCustomerAdviceView();
	}

	public void showCustomerAdviceView() {
		this.leftIDLabel.setText(this.customer.getId());
		this.leftNameLabel.setText(this.customer.getUsername());
		this.adviceFeedBackTable.setItems(adviceData);
	}

	@FXML
	private void handleCreate() {
		this.mainScene.showCustomerCreateAdviceScene(customer);
	}

	@FXML
	private void handleBack() {
		this.mainScene.showCustomerMainScene(customer);
	}

	@FXML
	private void handleInfoShow() {
		int foucus = this.adviceFeedBackTable.getSelectionModel().getFocusedIndex();
		if (foucus >= 0) {
			this.mainScene.showCustomerAdviceInfoScene(customer, this.adviceList.get(foucus));
		}

	}

	// 刷新表格方法
	private void refreshtable() {
		// TODO Auto-generated method stub
		int count = 0;
		while (count < this.adviceList.size()) {
			this.adviceData.add(this.adviceList.get(count));
			count++;
		}
		this.sendTime.setCellValueFactory(cellData -> cellData.getValue().getSendTimeProperty());
		this.replyTime.setCellValueFactory(cellData -> cellData.getValue().getReplyTimeProperty());
		this.sendInfo.setCellValueFactory(cellData -> cellData.getValue().getSendContentProperty());
		this.replyInfo.setCellValueFactory(cellData -> cellData.getValue().getReplyContentProperty());
		this.adviceFeedBackTable.setItems(adviceData);
	}
}
