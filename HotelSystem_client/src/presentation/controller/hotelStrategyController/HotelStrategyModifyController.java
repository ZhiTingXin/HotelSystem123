package presentation.controller.hotelStrategyController;

import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.HotelStrategyVO;
import blservice.HotelStrategy_blservice;
import blservice.impl.HotelStrategy_bl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import util.ImageUtil;

public class HotelStrategyModifyController {

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
	private Label hotelName;
	@FXML
	private TextArea InputStrategyInfo;
	@FXML
	private TextField InputStrategyName;

	private Main mainscene;
	private HotelStaffVO hotelStaff;
	private HotelInfoVO hotel;
	private HotelStrategyVO hotelStrategy;
	private HotelStrategy_blservice service;

	public HotelStrategyModifyController() {

	}

	public void HotelStrategyModifyShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		myPicture.setImage(ImageUtil.setImage(this.hotelStaff.getImage()));
		this.hotelName.setText(this.hotelStaff.getHotelName());
		this.InputStrategyName.setText(this.hotelStrategy.getStrategyName());
		this.InputStrategyInfo.setText(this.hotelStrategy.getStrategyInfo());
	}

	public void initialize(Main main, HotelStaffVO hotelStaff, HotelStrategyVO hotelStrategy, HotelInfoVO hotel) {
		this.mainscene = main;
		this.hotelStaff = hotelStaff;
		this.hotel = hotel;
		this.hotelStrategy = hotelStrategy;
		this.service = new HotelStrategy_bl();
		this.service.getHotelStrategy("a").setHotelId("186");
		this.HotelStrategyModifyShow();
	}

	@FXML
	private void handleSave() {
		this.hotelStrategy.setStrategyInfo(this.InputStrategyInfo.getText());
		this.hotelStrategy.setStrategyName(this.InputStrategyName.getText());
		// bl²ã·½·¨
		this.service.modifyHotelStrategy(this.hotelStrategy);
		this.mainscene.showHotelStrategyViewScene(this.hotelStaff, hotel);
	}

	@FXML
	private void handleback() {
		this.mainscene.showHotelStrategyViewScene(this.hotelStaff, hotel);
	}
}
