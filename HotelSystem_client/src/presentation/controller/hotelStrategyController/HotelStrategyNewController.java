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

public class HotelStrategyNewController {
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
	private Label StateLabel;
	@FXML
	private TextArea InputStrategyInfo;
	@FXML
	private TextField InputStrategyName;

	private Main mainscene;
	private HotelStaffVO hotelStaff;
	private HotelInfoVO hotel;
	private HotelStrategyVO hotelStrategy;
	private HotelStrategy_blservice service;

	public HotelStrategyNewController() {

	}

	public void HotelStrategyNewShow() {
		this.leftIdLabel.setText(this.hotelStaff.getId());
		this.leftNameLabel.setText(this.hotelStaff.getUsername());
		this.hotelName.setText(this.hotelStaff.getHotelName());
		this.InputStrategyName.setText(this.hotelStrategy.getStrategyInfo());
		this.InputStrategyInfo.setText(this.hotelStrategy.getStrategyInfo());
	}

	public void initialize(Main main, HotelStaffVO hotelStaff, HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		this.mainscene = main;
		this.hotel = hotel;
		this.hotelStaff = hotelStaff;
		this.hotelStrategy = new HotelStrategyVO();
		this.hotelStrategy.setHotelId(this.hotel.getHotelID());
		this.hotelStrategy.setStrategyInfo("");
		this.hotelStrategy.setStrategyName("");
		this.service = new HotelStrategy_bl();
		this.HotelStrategyNewShow();
	}

	public void handleSave() {
		if (!InputStrategyInfo.getText().equals("") && !InputStrategyName.getText().equals("")) {
			this.hotelStrategy.setStrategyInfo(this.InputStrategyInfo.getText());
			this.hotelStrategy.setStrategyName(this.InputStrategyName.getText());
			// bl层方法
			this.service.makeHotelStrategy(this.hotelStrategy);
			this.mainscene.showHotelStrategyViewScene(this.hotelStaff, hotel);
		} else {
			this.StateLabel.setText("请输入完整信息！");
		}
	}

	public void handleback() {
		this.mainscene.showHotelStrategyViewScene(this.hotelStaff, hotel);
	}
}
