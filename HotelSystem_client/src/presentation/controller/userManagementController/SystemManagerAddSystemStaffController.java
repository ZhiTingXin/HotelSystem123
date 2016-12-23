package presentation.controller.userManagementController;

import java.util.ArrayList;

import VO.SystemStrategyVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SystemManagerAddSystemStaffController {

	@FXML
	private ImageView myPicture;
	@FXML
	private Label leftIdLabel;
	@FXML
	private Label leftNameLabel;
	@FXML
	private Button register;
	@FXML
	private Button back;
	@FXML
	private TextField inputID;
	@FXML
	private ChoiceBox<String> district;
	@FXML
	private ChoiceBox<String> city;
	@FXML
	private Button changePicture;
	
	ObservableList<String> cityList = FXCollections.observableArrayList();
	ObservableList<String> districtList = FXCollections.observableArrayList();

	@FXML
	private void initialize() {
		ArrayList<String> cities = new ArrayList<>();	//TODO
		for (String city : cities) {
			cityList.add(city);
		}
		city.setItems(districtList);
		city.getSelectionModel().selectedItemProperty()
				.addListener((Observable, oldvalue, newvalue) -> setDistrictChoiceBox((String) newvalue));
	}
	
	private void setDistrictChoiceBox(String city) {
		ArrayList<String> districts = new ArrayList<>(); //TODO
		for (String district : districts) {
			districtList.add(district);
		}
		district.setItems(districtList);
	}

	public SystemManagerAddSystemStaffController() {

	}

}
