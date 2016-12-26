package presentation.controller.systemstrategyController;

import java.util.ArrayList;
import java.util.Optional;

import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import VO.VipStrategyVO;
import VO.VipVO;
import blservice.SystemStrategy_blservice;
import blservice.VipStrategy_blService;
import blservice.impl.SystemStrategy_bl;
import blservice.impl.VipStrategy_blServiceImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import main.Main;
import other.MyDistricts;
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
	private TableColumn<SystemStrategyVO, String> discountNum;// �ۿ�����
	@FXML
	private Button addStrategy;
	@FXML
	private Button modifyStrategy;
	@FXML
	private Button deleteStrategy;
	@FXML
	private Button viewStrategy;

	private Main mainScene;
	private SystemStaffVO systemStaffVO;
	private SystemStrategy_blservice systemStrategy_blservice;
	private VipStrategy_blService vipStrategy_blService;
	private ArrayList<SystemStrategyVO> systemStrategyVOList;
	private ObservableList<SystemStrategyVO> systemStrategyData = FXCollections.observableArrayList();
	ObservableList<String> cityList = FXCollections.observableArrayList();// �����б�
	ObservableList<String> districtList = FXCollections.observableArrayList();// ��Ȧ�б�
	private ChoiceBox<String> districtBox = new ChoiceBox<>();
	private	ChoiceBox<String> cityBox = new ChoiceBox<>();
	
	public SystemStrategyViewController() {
		systemStrategy_blservice = new SystemStrategy_bl();
		vipStrategy_blService = new VipStrategy_blServiceImpl();
	}

	public void initialize(Main mainScene, SystemStaffVO systemStaffVO) {
		this.mainScene = mainScene;
		this.systemStaffVO = systemStaffVO;
		SystemStrategyViewShow(mainScene);
		districtBox.setCache(false);
		cityBox.setCache(false);
	}

	public void SystemStrategyViewShow(Main mainScene) {
		// �����
		leftIdLabel.setText(systemStaffVO.getId());
		leftNameLabel.setText(systemStaffVO.getUsername());
		// �ұ���
		discountListLabel.setText("�����Ż�");
		systemStrategyVOList = systemStrategy_blservice.getAllSystemStrategys();
		for (SystemStrategyVO systemStrategyVO : systemStrategyVOList) { // Ĭ�ϳ�ʼ�����еĴ�������
			systemStrategyData.add(systemStrategyVO);
		} // ��ʼ��column
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // �����鿴���ղ���
	private void handleViewHolidayStrategy() {
		discountListLabel.setText("�����Ż�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.HOLIDAY);
		for (SystemStrategyVO holidayStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(holidayStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // �鿴��Ա�Ż�
	private void handleViewMemberStrategy() {
		discountListLabel.setText("��Ա�Ż�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.MEMBER);
		for (SystemStrategyVO memberStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(memberStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // �鿴VIP��Ա�Ż�
	private void handleViewVIPStrategy() {
		discountListLabel.setText("VIP��Ա�Ż�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.VIPMEMBER);
		for (SystemStrategyVO VIPStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(VIPStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // �鿴�����Żݲ���
	private void handleViewOtherStrategy() {
		discountListLabel.setText("�����Ż�");
		systemStrategyData.clear();// ����б�
		systemStrategyVOList.clear();// ���List

		// �õ���������
		systemStrategyVOList = systemStrategy_blservice.getSystemStrategys(SystemStrategyType.OTHER);
		for (SystemStrategyVO OtherStrategyVO : systemStrategyVOList) {
			systemStrategyData.add(OtherStrategyVO);
		}
		nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
		descriptionOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
		stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
		discountNum.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
		systemStrategyTable.setItems(systemStrategyData);
	}

	@FXML // ����
	private void handleBack() {
		mainScene.showSystemStaffMainScene(systemStaffVO);
	}

	@FXML // �鿴�����Żݲ��԰�ť
	private void handleViewStrategyButton() {

		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();

		if (selected != null) {

			SystemStrategyType strategyType = selected.getSystemStrategyType();

			if (strategyType == SystemStrategyType.HOLIDAY) {

				mainScene.showViewSystemHolidayStrategyScene(systemStaffVO, selected);

			} else if (strategyType == SystemStrategyType.MEMBER) {

				mainScene.showViewSystemMemberStrategyScene(systemStaffVO, selected);

			} else if (strategyType == SystemStrategyType.VIPMEMBER) {
				
				//��Ҫ����ѡ����к���Ȧ��ѡ���Ȼ�󷵻ص��ǳ��к���Ȧ����Ϣ
				Dialog<Pair<String, String>> dialog = new Dialog<>();
				dialog.setTitle("��ʾ");
				dialog.setHeaderText("��ѡ����к���Ȧ��");
				//���ͼƬ
				dialog.setGraphic(new ImageView(this.getClass().getResource("district.png").toString()));
				
				ButtonType ok = new ButtonType("ȷ��",ButtonData.OK_DONE);
				ButtonType cancel = new ButtonType("ȡ��",ButtonData.CANCEL_CLOSE);
				dialog.getDialogPane().getButtonTypes().addAll(ok,cancel);
				//����choice box
				GridPane gridPane = new GridPane();
				gridPane.setHgap(10);
				gridPane.setVgap(10);
				gridPane.setPadding(new Insets(20,150,10,10));
				
				cityBox.setMaxWidth(85);
				cityBox.setMinWidth(85);
				districtBox.setMaxWidth(85);
				districtBox.setMinWidth(85);
				for (String city : MyDistricts.cities) {
					cityList.add(city);
				}
				cityBox.setItems(cityList);
				cityBox.getSelectionModel().selectedItemProperty()
						.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));
				
				gridPane.add(new Label("ѡ����У�"), 0, 0);
				gridPane.add(cityBox, 1, 0);
				gridPane.add(new Label("ѡ����Ȧ��"), 0, 1);
				gridPane.add(districtBox, 1, 1);
				// Enable/Disable login button depending on whether a city was choosed.
				Node okButton = dialog.getDialogPane().lookupButton(ok);
				okButton.setDisable(false);

				cityBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				    okButton.setDisable(newValue.trim().isEmpty());
				});
				
				dialog.getDialogPane().setContent(gridPane);
				
				// Request focus on the cityBox by default.
				Platform.runLater(() -> cityBox.requestFocus());

				dialog.setResultConverter(dialogButton -> {
				    if (dialogButton == ok) {
				        return new Pair<>(cityBox.getValue(), districtBox.getValue());
				    }
				    return null;
				});

				Optional<Pair<String, String>> result = dialog.showAndWait();

				result.ifPresent(CityDistict -> {
					mainScene.showViewSystemVIPStrategyScene(systemStaffVO, CityDistict.getKey(), CityDistict.getValue(), selected);
				});

			} else if (strategyType == SystemStrategyType.OTHER) {

				mainScene.showViewSystemOtherStrategyScene(systemStaffVO, selected);

			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ����Ҫ�鿴���Żݲ��ԣ�");
			alert.showAndWait();
		}
	}
	
	//��Ȧchoice box����Ӧ
	private void setDistrictChoiceBox(String city) {
		districtList.clear();
		String[] districts = MyDistricts.getDistricts(city);
		for (String dist : districts) {
			districtList.add(dist);
		}
		districtBox.setItems(districtList);
	}

	@FXML // �����Żݲ��԰�ť
	private void handleAddStrategyButton() {

		String labelName = discountListLabel.getText();

		if (labelName == "�����Ż�") {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("��Ǹ");
			alert.setHeaderText("����ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��ĳ���Ż������ٽ���������");
			alert.showAndWait();

		} else if (labelName == "�����Ż�") {

			mainScene.showAddSystemHolidayStrategyScene(systemStaffVO);

		} else if (labelName == "��Ա�Ż�") {

			if (systemStrategy_blservice.getSystemStrategys(SystemStrategyType.MEMBER).size() == 0) {
				mainScene.showAddSystemMemberStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("����ʧ��");
				alert.setContentText("������̫�����ˣ����ǽ���Ҫһ����Ա�Żݲ��ԣ�");
				alert.showAndWait();
			}

		} else if (labelName == "VIP��Ա�Ż�") {

			if (systemStrategy_blservice.getSystemStrategys(SystemStrategyType.VIPMEMBER).size() == 0) {
				mainScene.showAddSystemVIPStrategyScene(systemStaffVO);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("��Ǹ");
				alert.setHeaderText("����ʧ��");
				alert.setContentText("������̫�����ˣ����ǽ���Ҫһ��VIP��Ա�Żݲ��ԣ�");
				alert.showAndWait();
			}

		} else if (labelName == "�����Ż�") {

			mainScene.showAddSystemOtherStrategyScene(systemStaffVO);

		}
	}

	@FXML // �޸��Żݲ����б�
	private void handleModifyStrategyButton() {

		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();

		if (selected != null) {// ѡ��

			SystemStrategyType strategyType = selected.getSystemStrategyType();

			if (strategyType == SystemStrategyType.HOLIDAY) {

				mainScene.showSystemHolidayStrategyModifyScene(systemStaffVO, selected);

			} else if (strategyType == SystemStrategyType.MEMBER) {

				mainScene.showSystemMemberStrategyModifyScene(systemStaffVO, selected);

			} else if (strategyType == SystemStrategyType.VIPMEMBER) {

				//��Ҫ����ѡ����к���Ȧ��ѡ���Ȼ�󷵻ص��ǳ��к���Ȧ����Ϣ
				Dialog<Pair<String, String>> dialog = new Dialog<>();
				dialog.setTitle("��ʾ");
				dialog.setHeaderText("��ѡ����к���Ȧ��");
				//���ͼƬ
				dialog.setGraphic(new ImageView(this.getClass().getResource("district.png").toString()));
				
				ButtonType ok = new ButtonType("ȷ��",ButtonData.OK_DONE);
				ButtonType cancel = new ButtonType("ȡ��",ButtonData.CANCEL_CLOSE);
				dialog.getDialogPane().getButtonTypes().addAll(ok,cancel);
				//����choice box
				GridPane gridPane = new GridPane();
				gridPane.setHgap(10);
				gridPane.setVgap(10);
				gridPane.setPadding(new Insets(20,150,10,10));
				
				cityBox.setMaxWidth(85);
				cityBox.setMinWidth(85);
				districtBox.setMaxWidth(85);
				districtBox.setMinWidth(85);
				for (String city : MyDistricts.cities) {
					cityList.add(city);
				}
				cityBox.setItems(cityList);
				cityBox.getSelectionModel().selectedItemProperty()
						.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));
				
				gridPane.add(new Label("ѡ����У�"), 0, 0);
				gridPane.add(cityBox, 1, 0);
				gridPane.add(new Label("ѡ����Ȧ��"), 0, 1);
				gridPane.add(districtBox, 1, 1);
				// Enable/Disable login button depending on whether a city was choosed.
				Node okButton = dialog.getDialogPane().lookupButton(ok);
				okButton.setDisable(false);

				cityBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				    okButton.setDisable(newValue.trim().isEmpty());
				});
				
				dialog.getDialogPane().setContent(gridPane);
				
				// Request focus on the cityBox by default.
				Platform.runLater(() -> cityBox.requestFocus());

				dialog.setResultConverter(dialogButton -> {
				    if (dialogButton == ok) {
				        return new Pair<>(cityBox.getValue(), districtBox.getValue());
				    }
				    return null;
				});

				Optional<Pair<String, String>> result = dialog.showAndWait();

				result.ifPresent(CityDistict -> {
				    mainScene.showSystemVIPStrategyModifyScene(systemStaffVO, CityDistict.getKey(), CityDistict.getValue(), selected);
				});
				
			} else if (strategyType == SystemStrategyType.OTHER) {

				mainScene.showSystemOtherStrategyModifyScene(systemStaffVO, selected);

			}
		} else {// ��ѡ��

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ʾ");
			alert.setHeaderText("�޸�ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��ĳ���Ż���Ŀ�ٽ����޸ģ�");
			alert.showAndWait();
		}
	}

	@FXML // ɾ��ѡ�еĲ���
	private void handleDeleteStrategyButton() {

		SystemStrategyVO selected = systemStrategyTable.getSelectionModel().getSelectedItem();
		if (selected != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("ɾ��");
			alert.setHeaderText("ɾ��֮���޷�����");
			alert.setContentText("�Ƿ�ɾ����");
			ButtonType buttonOK = new ButtonType("��");
			ButtonType buttonNO = new ButtonType("��");
			alert.getButtonTypes().setAll(buttonOK, buttonNO);
			Optional<ButtonType> btn = alert.showAndWait();
			if (btn.get() == buttonOK) {// ��
				boolean isDelete = false;
				if (selected.getSystemStrategyType() == SystemStrategyType.HOLIDAY) {
					isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
				} else if (selected.getSystemStrategyType() == SystemStrategyType.OTHER) {
					isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
				} else if (selected.getSystemStrategyType() == SystemStrategyType.VIPMEMBER) {
					if (vipStrategy_blService.getSuperVipNum()==0) {
						isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
					}
					//��Ҫ����ѡ����к���Ȧ��ѡ���Ȼ�󷵻ص��ǳ��к���Ȧ����Ϣ
					Dialog<Pair<String, String>> dialog = new Dialog<>();
					dialog.setTitle("��ʾ");
					dialog.setHeaderText("��ѡ����к���Ȧ��");
					//���ͼƬ
					dialog.setGraphic(new ImageView(this.getClass().getResource("district.png").toString()));
					
					ButtonType ok = new ButtonType("ȷ��",ButtonData.OK_DONE);
					ButtonType cancel = new ButtonType("ȡ��",ButtonData.CANCEL_CLOSE);
					dialog.getDialogPane().getButtonTypes().addAll(ok,cancel);
					//����choice box
					GridPane gridPane = new GridPane();
					gridPane.setHgap(10);
					gridPane.setVgap(10);
					gridPane.setPadding(new Insets(20,150,10,10));
					
					cityBox.setMaxWidth(85);
					cityBox.setMinWidth(85);
					districtBox.setMaxWidth(85);
					districtBox.setMinWidth(85);
					for (String city : MyDistricts.cities) {
						cityList.add(city);
					}
					cityBox.setItems(cityList);
					cityBox.getSelectionModel().selectedItemProperty()
							.addListener((Observable, oldValue, newValue) -> setDistrictChoiceBox((String) newValue));
					
					gridPane.add(new Label("ѡ����У�"), 0, 0);
					gridPane.add(cityBox, 1, 0);
					gridPane.add(new Label("ѡ����Ȧ��"), 0, 1);
					gridPane.add(districtBox, 1, 1);
					// Enable/Disable login button depending on whether a city was choosed.
					Node okButton = dialog.getDialogPane().lookupButton(ok);
					okButton.setDisable(false);

					cityBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
					    okButton.setDisable(newValue.trim().isEmpty());
					});
					
					dialog.getDialogPane().setContent(gridPane);
					
					// Request focus on the cityBox by default.
					Platform.runLater(() -> cityBox.requestFocus());

					dialog.setResultConverter(dialogButton -> {
					    if (dialogButton == ok) {
					        return new Pair<>(cityBox.getValue(), districtBox.getValue());
					    }
					    return null;
					});

					Optional<Pair<String, String>> result = dialog.showAndWait();
					result.ifPresent(CityDistict -> {
						VipStrategyVO vipStrategyVO = vipStrategy_blService.getVipstrategy(CityDistict.getKey(), CityDistict.getValue());
						if (vipStrategyVO.getVipStrategyVOList().size()!=0) {
							vipStrategy_blService.deleteSuperVipStrategy(CityDistict.getKey(),CityDistict.getValue());
						}else {
							Alert alert1 = new Alert(AlertType.INFORMATION);
							alert1.setTitle("����");
							alert1.setContentText("����Ȧ��VIP��Ա���Բ�����");
							alert1.showAndWait();
						}
					});
				} else {
					isDelete = systemStrategy_blservice.deleteSystemStrategy(selected);
					 VipVO vip1 = new VipVO(0, 0, 1, 10);
					 VipVO vip2 = new VipVO(0, 0, 2, 10);
			         VipVO vip3 = new VipVO(0, 0, 3, 10);
				     VipVO vip4 = new VipVO(0, 0, 4, 10);
				     VipVO vip5 = new VipVO(0, 0, 5, 10);
				     ArrayList<VipVO> vipVOData = new ArrayList<VipVO>();
				     vipVOData.add(vip1);
				     vipVOData.add(vip2);
				     vipVOData.add(vip3);
				     vipVOData.add(vip4);
				     vipVOData.add(vip5);
				     VipStrategyVO vipStrategyVO = new VipStrategyVO();
				     vipStrategyVO.setVipStrategyVOList(vipVOData);
				     vipStrategy_blService.modifyVipStrategy(vipStrategyVO);
				}
				if (isDelete) {
					Alert alert1 = new Alert(AlertType.INFORMATION);
					alert1.setTitle("��ϲ");
					alert1.setHeaderText("ɾ���ɹ�");
					alert1.setContentText("���ѳɹ�ɾ��һ��������Ϣ��");
					Optional<ButtonType> btn1 = alert1.showAndWait();
					if (btn1.get() == ButtonType.OK) {

						String labelName = discountListLabel.getText();
						if (labelName == "�����Ż�") {
							systemStrategyVOList = systemStrategy_blservice.getAllSystemStrategys();
						} else if (labelName == "�����Ż�") {
							systemStrategyVOList = systemStrategy_blservice
									.getSystemStrategys(SystemStrategyType.HOLIDAY);
						} else if (labelName == "��Ա�Ż�") {
							systemStrategyVOList = systemStrategy_blservice
									.getSystemStrategys(SystemStrategyType.MEMBER);
						} else if (labelName == "VIP��Ա�Ż�") {
							systemStrategyVOList = systemStrategy_blservice
									.getSystemStrategys(SystemStrategyType.VIPMEMBER);
						} else if (labelName == "�����Ż�") {
							systemStrategyVOList = systemStrategy_blservice
									.getSystemStrategys(SystemStrategyType.OTHER);
						}

						systemStrategyData.clear();
						for (SystemStrategyVO systemStrategy : systemStrategyVOList) {
							systemStrategyData.add(systemStrategy);
						}
						nameOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyNameProperty());
						descriptionOfStrategy
								.setCellValueFactory(cellData -> cellData.getValue().getStrategyDescriptionProperty());
						stateOfStrategy.setCellValueFactory(cellData -> cellData.getValue().getStrategyStateProperty());
						discountNum
								.setCellValueFactory(cellData -> cellData.getValue().getDiscountForHolidayProperty());
						systemStrategyTable.setItems(systemStrategyData);

					}
				} else {
					Alert alert2 = new Alert(AlertType.ERROR);
					alert2.setTitle("��Ǹ");
					alert2.setHeaderText("ɾ��ʧ��");
					alert2.setContentText("ɾ���Żݲ���ʧ��");
					alert2.showAndWait();
				}
			} else {// ѡ���
			}

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ʾ");
			alert.setHeaderText("ɾ��ʧ��");
			alert.setContentText("��Ҫ�ż�����Ӧ����ѡ��Ҫɾ���Ĳ��ԣ�");
			alert.showAndWait();
		}
	}
}
