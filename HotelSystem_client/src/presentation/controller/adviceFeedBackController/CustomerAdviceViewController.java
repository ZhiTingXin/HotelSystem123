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
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class CustomerAdviceViewController {
	@FXML
	private Label leftIDLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private ImageView leftMenuImage;
	@FXML
	private Label StateLabel;
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
		this.leftMenuImage.setImage(ImageUtil.setImage(customer.getImage()));
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
		AdviceFeedBackVO foucus = this.adviceFeedBackTable.getSelectionModel().getSelectedItem();
		if (foucus != null) {
			this.mainScene.showCustomerAdviceInfoScene(customer, foucus);
		} else
			this.StateLabel.setText("��ѡ��Ҫ�鿴�ķ��������");

	}

	// ˢ�±�񷽷�
	private void refreshtable() {

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
