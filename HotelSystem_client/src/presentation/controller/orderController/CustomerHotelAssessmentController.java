package presentation.controller.orderController;

import VO.AssementVO;
import VO.CustomerVO;
import VO.HotelInfoVO;
import VO.OrderVO;
import blservice.Assessment_blService;
import blservice.Order_blservice;
import blservice.impl.Assessment_bl;
import blservice.impl.Order_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import main.Main;
import other.OrderState;
import util.ImageUtil;

//���޸ĵĽ���
public class CustomerHotelAssessmentController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Label StateLabel;
	@FXML
	private Button save;
	@FXML
	private Button back;
	@FXML
	private Label nameOfHotel;
	@FXML
	private MenuButton starRateReviews;// �Ǽ�����
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
	private MenuButton tagReviews;// ��ǩ����
	@FXML
	private MenuItem confortableTag;
	// @FXML
	// private MenuItem unConfortableTag;
	// @FXML
	// private MenuItem cheapTag;
	// @FXML
	// private MenuItem expensiveTag;

	// @FXML
	// private Label Tag1;// ����ӱ�ǩ
	// @FXML
	// private Label Tag2;
	// @FXML
	// private Label Tag3;
	@FXML
	private TextArea assessmentTextArea;

	private Main mainScene;
	private CustomerVO customer;
	private HotelInfoVO hotel;
	private OrderVO order;
	private int starRank;
	private AssementVO assement;
	private Assessment_blService service;
	private Order_blservice orderService;

	public CustomerHotelAssessmentController() {

	}

	public void initialize(Main main, CustomerVO customer, HotelInfoVO hotel, OrderVO order) {
		// TODO Auto-generated method stub
		this.customer = customer;
		this.mainScene = main;
		this.hotel = hotel;
		this.order = order;

		this.assement = new AssementVO();
		this.assement.setOrderId(this.order.getOrderID());
		this.assement.setContent("");
		this.assement.setHotelId(this.hotel.getHotelID());
		this.assement.setUserId(this.customer.getId());

		this.service = new Assessment_bl();
		this.orderService = new Order_bl();

		this.CustomerHotelAssessmentShow();
	}

	private void CustomerHotelAssessmentShow() {
		this.leftIdLabel.setText(customer.getId());
		this.leftNameLabel.setText(customer.getUsername());
		this.myPicture.setImage(ImageUtil.setImage(customer.getImage()));

		if (this.order.getOrderState().equals(OrderState.ASSESSED)) {
			this.assement = this.service.getAss(this.order.getOrderID());
			this.nameOfHotel.setText(this.hotel.getHotelName());
			this.save.setDisable(true);
			this.assessmentTextArea.setEditable(false);
			this.assessmentTextArea.setText(this.assement.getContent());
			String rank = "";
			int count = 0;
			while (count < this.assement.getRank()) {
				rank += "��";
				count++;
			}
			this.starRateReviews.setText(rank);
		}
	}

	@FXML
	private void handleBack() {
		this.mainScene.showCustomerOrderInfoViewScene(customer, order);

	}

	@FXML
	private void handleSave() {

		boolean isRankReady = this.starRank != 0;
		boolean isContentReady = !this.assessmentTextArea.getText().equals("");
		if (isContentReady && isRankReady) {
			if (this.order.getOrderState().equals(OrderState.FINISHED)) {
				this.assement.setRank(this.starRank);
				this.assement.setContent(this.assessmentTextArea.getText());
				this.order.setOrderState(OrderState.ASSESSED);
				// bl�㷽��
				this.orderService.changeState(this.order);
				this.service.addAssessment(assement);

				this.mainScene.showCustomerOrderInfoViewScene(customer, order);
			}
		} else if (!isContentReady) {
			this.StateLabel.setText("������������Ϣ��");
		} else if (!isRankReady) {
			this.StateLabel.setText("����þƵ��֣�");
		}
	}

	@FXML
	private void handleOneStar() {
		this.starRateReviews.setText("��");
		this.starRank = 1;
	}

	@FXML
	private void handleTwoStar() {
		this.starRateReviews.setText("���");
		this.starRank = 2;
	}

	@FXML
	private void handleThreeStar() {
		this.starRateReviews.setText("����");
		this.starRank = 3;
	}

	@FXML
	private void handleFourStar() {
		this.starRateReviews.setText("�����");
		this.starRank = 4;
	}

	@FXML
	private void handleFiveStar() {
		this.starRateReviews.setText("������");
		this.starRank = 5;
	}

	// public void handleComfortableTag() {
	// }
	//
	// public void handleUncomfortableTag() {
	//
	// }
	//
	// public void handleCheapTag() {
	//
	// }
	//
	// public void handleExpensiveTag() {
	//
	// }
}
