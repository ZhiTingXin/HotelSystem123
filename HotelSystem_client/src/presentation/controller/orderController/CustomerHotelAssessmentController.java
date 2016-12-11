package presentation.controller.orderController;

import VO.CustomerVO;
import VO.HotelInfoVO;
import VO.OrderVO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import main.Main;
import other.OrderState;

public class CustomerHotelAssessmentController {

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
	private Label nameOfHotel;
	@FXML
	private MenuButton starRateReviews;// 星级评价
	@FXML
	private MenuItem oneStar;
	@FXML
	private MenuItem twoStar;
	@FXML
	private MenuItem threeStar;
	@FXML
	private MenuItem fourStar;
	@FXML
	private MenuItem fiveStar;

	@FXML
	private MenuButton tagReviews;// 标签评价
	@FXML
	private MenuItem confortableTag;
	@FXML
	private MenuItem unConfortableTag;
	@FXML
	private MenuItem cheapTag;
	@FXML
	private MenuItem expensiveTag;

	@FXML
	private Label Tag1;// 已添加标签
	@FXML
	private Label Tag2;
	@FXML
	private Label Tag3;
	@FXML
	private TextArea assessmentTextArea;

	private Main mainScene;
	private CustomerVO customer;
	private HotelInfoVO hotel;
	private OrderVO order;
	private int starRank;

	public CustomerHotelAssessmentController() {

	}

	public void initialize(Main main, CustomerVO customer, HotelInfoVO hotel, OrderVO order) {
		// TODO Auto-generated method stub
		this.customer = customer;
		this.mainScene = main;
		this.hotel = hotel;
		this.order = order;

		this.CustomerHotelAssessmentShow();
	}

	public void CustomerHotelAssessmentShow() {
		this.leftIdLabel.setText(customer.getId());
		this.leftNameLabel.setText(customer.getUsername());
	}

	public void handleBack() {
		this.mainScene.showCustomerOrderInfoViewScene(customer, order);

	}

	public void handleSave() {
		// bl层方法
		{
			this.order.setOrderState(OrderState.ASSESSED);
		}
		this.mainScene.showCustomerOrderInfoViewScene(customer, order);
	}

	public void handleOneStar() {
		this.starRateReviews.setText("★");
		this.starRank = 1;
	}

	public void handleTwoStar() {
		this.starRateReviews.setText("★★");
		this.starRank = 2;
	}

	public void handleThreeStar() {
		this.starRateReviews.setText("★★★");
		this.starRank = 3;
	}

	public void handleFourStar() {
		this.starRateReviews.setText("★★★★");
		this.starRank = 4;
	}

	public void handleFiveStar() {
		this.starRateReviews.setText("★★★★★");
		this.starRank = 5;
	}

	public void handleComfortableTag() {
	}

	public void handleUncomfortableTag() {

	}

	public void handleCheapTag() {

	}

	public void handleExpensiveTag() {

	}
}
