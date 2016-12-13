package main;

import java.io.IOException;

import VO.AdviceFeedBackVO;
import VO.CustomerVO;
import VO.HotelInfoVO;
import VO.HotelStaffVO;
import VO.HotelStrategyVO;
import VO.OrderVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;
import VO.SystemStrategyVO;
import VO.VipVO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.controller.adviceFeedBackController.CustomerAdviceInfoController;
import presentation.controller.adviceFeedBackController.CustomerAdviceViewController;
import presentation.controller.adviceFeedBackController.CustomerCreateAdviceController;
import presentation.controller.hotelController.BookHotelController;
import presentation.controller.hotelController.HotelInfoController;
import presentation.controller.hotelController.HotelStaffHotelInfoModifyController;
import presentation.controller.hotelController.HotelStaffHotelInfoViewController;
import presentation.controller.hotelController.HotelViewController;
import presentation.controller.hotelController.SystemManagerHotelRegisterController;
import presentation.controller.hotelController.SystemManagerHotelRegisterShowIDController;
import presentation.controller.hotelStrategyController.HotelStrategyModifyController;
import presentation.controller.hotelStrategyController.HotelStrategyNewController;
import presentation.controller.hotelStrategyController.HotelStrategyViewController;
import presentation.controller.loginController.LoginController;
import presentation.controller.orderController.CustomerHotelAssessmentController;
import presentation.controller.orderController.CustomerOrderInfoViewController;
import presentation.controller.orderController.CustomerOrderViewController;
import presentation.controller.orderController.HotelStaffManagementOrderController;
import presentation.controller.orderController.HotelStaffOrderViewController;
import presentation.controller.orderController.SystemStaffOrderManagementController;
import presentation.controller.orderController.SystemStaffOrderViewController;
import presentation.controller.registerController.RegisterController;
import presentation.controller.systemstrategyController.AddSystemHolidayStrategyController;
import presentation.controller.systemstrategyController.AddSystemMemberStrategyController;
import presentation.controller.systemstrategyController.AddSystemOtherStrategyController;
import presentation.controller.systemstrategyController.AddSystemVIPStrategyController;
import presentation.controller.systemstrategyController.MemberEditDialogController;
import presentation.controller.systemstrategyController.SystemHolidayStrategyModifyController;
import presentation.controller.systemstrategyController.SystemMemberStrategyModifyController;
import presentation.controller.systemstrategyController.SystemOtherStrategyModifyController;
import presentation.controller.systemstrategyController.SystemStrategyViewController;
import presentation.controller.systemstrategyController.SystemVIPStrategyModifyController;
import presentation.controller.userInfoController.CustomerInfoController;
import presentation.controller.userInfoController.CustomerInfoModifyController;
import presentation.controller.userInfoController.CustomerMemberModifyController;
import presentation.controller.userInfoController.CustomerPasswordModifyController;
import presentation.controller.userInfoController.HotelStaffInfoController;
import presentation.controller.userInfoController.HotelStaffInfoModifyController;
import presentation.controller.userInfoController.HotelStaffPasswordModifyController;
import presentation.controller.userInfoController.SystemManagerInfoController;
import presentation.controller.userInfoController.SystemManagerInfoModifyController;
import presentation.controller.userInfoController.SystemManagerPasswordModifyController;
import presentation.controller.userInfoController.SystemStaffInfoController;
import presentation.controller.userInfoController.SystemStaffInfoModifyController;
import presentation.controller.userInfoController.SystemStaffPasswordModifyController;
import presentation.controller.userManagementController.CustomerManagementController;
import presentation.controller.userManagementController.HotelStaffManagementController;
import presentation.controller.userManagementController.SystemManagerCustomerInfoModifyController;
import presentation.controller.userManagementController.SystemManagerCustomerInfoViewController;
import presentation.controller.userManagementController.SystemManagerHotelStaffInfoModifyController;
import presentation.controller.userManagementController.SystemManagerHotelStaffInfoViewController;
<<<<<<< HEAD
import presentation.controller.userManagementController.SystemManagerSystemStaffInfoModifyController;
=======
>>>>>>> refs/remotes/origin/Âè∂ÊôìÊ≥¢
import presentation.controller.userManagementController.SystemManagerSystemStaffInfoViewController;
import presentation.controller.userManagementController.SystemStaffCreditManagementController;
import presentation.controller.userManagementController.SystemStaffManagementController;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private BorderPane loginLayout;
	private BorderPane registerLayout;

	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("HotelSystem");
<<<<<<< HEAD
		//this.showCustomerInfoScene(new CustomerVO());
=======
		// this.showCustomerInfoScene(new CustomerVO());
<<<<<<< Updated upstream
>>>>>>> refs/remotes/origin/master
=======
>>>>>>> master
>>>>>>> Stashed changes
		// this.showHotelStaffInfoScene(new HotelStaffVO());
		// this.showSystemStaffInfoScene(new SystemStaffVO());
		// this.showSystemManagerInfoScene(new SystemManagerVO());
		// this.showCustomerBookHotelScene(new CustomerVO(), new HotelInfoVO());
		// this.showCustomerHotelViewScene(new CustomerVO());
		// this.showCustomerMainScene(new CustomerVO());
<<<<<<< HEAD
		 this.showLoginScene();
=======
		this.showLoginScene();
<<<<<<< Updated upstream
>>>>>>> refs/remotes/origin/master
=======
>>>>>>> master
>>>>>>> Stashed changes
		// this.showHotelStaffMainScene(new HotelStaffVO());
		// this.showHotelStaffHotelInfoViewScene(new HotelStaffVO(), new
		// HotelInfoVO());
		// this.showHotelStaffHotelInfoModifyScene(new HotelStaffVO(), new
		// HotelInfoVO());
		// this.showHotelStaffOrderViewScene(new HotelStaffVO());
	}

	public void Exit() {
		this.primaryStage.close();
	}

	/**
	 * œ‘ æµ«¬ºΩÁ√Ê
	 */
	public void showLoginScene() {
		try {
			this.initLoginLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/login_ui/LoginScene.fxml"));
			AnchorPane LoginScene = (AnchorPane) loader.load();
			loginLayout.setCenter(LoginScene);

			// get Controller
			LoginController LoginController = loader.getController();
			LoginController.initialize(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * œ‘ æ◊¢≤·ΩÁ√Ê
	 */
	public void showRegisterScene() {
		try {
			this.initRegisterLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/Register_ui/RegisterScene.fxml"));
			AnchorPane RegisterScene = (AnchorPane) loader.load();
			registerLayout.setCenter(RegisterScene);

			// get Controller
			RegisterController RegisterController = loader.getController();
			RegisterController.initialize(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªßµƒŒ¨ª§∏ˆ»À–≈œ¢ΩÁ√Ê
	 * 
	 * @param customer
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´π˝¿¥µƒCustomerVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showCustomerInfoScene(CustomerVO customer) {
		// TODO Auto-generated method stub
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/userInfo_ui/CustomerInfoScene.fxml"));
			AnchorPane customerInfoScene = (AnchorPane) loader.load();
			rootLayout.setCenter(customerInfoScene);

			// get Controller
			CustomerInfoController customerInfoController = loader.getController();
			customerInfoController.initialize(this, customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªßµƒ–ﬁ∏ƒ∏ˆ»À–≈œ¢ΩÁ√Ê
	 * 
	 * @param customer
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´π˝¿¥µƒCustomerVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showCustomerModifyScene(CustomerVO customer) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/userInfo_ui/CustomerInfoModifyScene.fxml"));
			AnchorPane customerInfoModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(customerInfoModifyScene);

			// get Controller
			CustomerInfoModifyController customerInfoModifyController = loader.getController();
			customerInfoModifyController.initialize(this, customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªßµƒ–ﬁ∏ƒ√‹¬ÎΩÁ√Ê
	 * 
	 * @param customer
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´π˝¿¥µƒCustomerVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showCustomerPasswordModifyScene(CustomerVO customer) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/userInfo_ui/CustomerPasswordModifyScene.fxml"));
			AnchorPane customerPasswordModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(customerPasswordModifyScene);

			// get Controller
			CustomerPasswordModifyController customerPasswordModifyController = loader.getController();
			customerPasswordModifyController.initialize(this, customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªßµƒ◊¢≤·ª·‘±ΩÁ√Ê
	 * 
	 * @param customer
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´π˝¿¥µƒCustomerVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showCustomerMemberModifyScene(CustomerVO customer) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/userInfo_ui/CustomerMemberModifyScene.fxml"));
			AnchorPane customerMemberModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(customerMemberModifyScene);

			// get Controller
			CustomerMemberModifyController customerMemberModifyController = loader.getController();
			customerMemberModifyController.initialize(this, customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±µƒŒ¨ª§∏ˆ»À–≈œ¢ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´π˝¿¥µƒHotelStaffVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showHotelStaffInfoScene(HotelStaffVO hotelStaff) {
		try {
			this.initRootLayout();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/userInfo_ui/HotelStaffInfoScene.fxml"));
			AnchorPane HotelStaffInfoScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStaffInfoScene);

			// get Controller
			HotelStaffInfoController HotelStaffInfoController = loader.getController();
			HotelStaffInfoController.initialize(this, hotelStaff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±–ﬁ∏ƒ∏ˆ»À–≈œ¢ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´¿¥µƒHotalStaffVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showHotelStaffInfoModifyScene(HotelStaffVO hotelStaff) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/userInfo_ui/HotelStaffInfoModifyScene.fxml"));
			AnchorPane HotelStaffInfoModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStaffInfoModifyScene);

			// get Controller
			HotelStaffInfoModifyController HotelStaffInfoModifyController = loader.getController();
			HotelStaffInfoModifyController.initialize(this, hotelStaff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±–ﬁ∏ƒ√‹¬ÎΩÁ√Ê
	 * 
	 * @param hotelStaff
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´¿¥µƒHotalStaffVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showHotelStaffPasswordModifyScene(HotelStaffVO hotelStaff) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/userInfo_ui/HotelStaffPasswordModifyScene.fxml"));
			AnchorPane HotelStaffPasswordModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStaffPasswordModifyScene);

			// get Controller
			HotelStaffPasswordModifyController HotelStaffPasswordModifyController = loader.getController();
			HotelStaffPasswordModifyController.initialize(this, hotelStaff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªß÷˜ΩÁ√Ê£¨Ω” ‹¿¥◊‘∆‰À˚ΩÁ√ÊµƒcustomerVO∂‘œÛ
	 * 
	 * @param customer
	 */
	public void showCustomerMainScene(CustomerVO customer) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/Main/CustomerMainScene.fxml"));
			AnchorPane CustomerMainScene = (AnchorPane) loader.load();
			rootLayout.setCenter(CustomerMainScene);

			// get Controller
			CustomerMainController CustomerMainController = loader.getController();
			CustomerMainController.initialize(this, customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªß‘§∂®æ∆µÍøÕ∑øΩÁ√Ê
	 * 
	 * @param customer
	 *            ¿¥◊‘∆‰À˚ΩÁ√ÊµƒcustomerVO∂‘œÛ
	 * @param hotel
	 *            ¿¥◊‘∆‰À˚ΩÁ√ÊµƒhotelVO∂‘œÛ
	 */
	public void showCustomerBookHotelScene(CustomerVO customer, HotelInfoVO hotel) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/hotel_ui/BookHotelScene.fxml"));
			AnchorPane BookHotelScene = (AnchorPane) loader.load();
			rootLayout.setCenter(BookHotelScene);

			// get Controller
			BookHotelController BookHotelController = loader.getController();
			BookHotelController.initialize(this, customer, hotel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªß≤Èø¥æ∆µÍœÍ«ÈΩÁ√Ê
	 * 
	 * @param customer
	 * @param hotel
	 */
	public void showCustomerHotelInfoScene(CustomerVO customer, HotelInfoVO hotel) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/hotel_ui/HotelInfoScene.fxml"));
			AnchorPane HotelInfoScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelInfoScene);

			// get Controller
			HotelInfoController HotelInfoController = loader.getController();
			HotelInfoController.initialize(this, customer, hotel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªß≤Èø¥æ∆µÍ¡–±ÌΩÁ√Ê
	 * 
	 * @param customer
	 * @param hotel
	 */
	public void showCustomerHotelViewScene(CustomerVO customer) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/hotel_ui/HotelViewScene.fxml"));
			AnchorPane HotelViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelViewScene);

			// get Controller
			HotelViewController HotelViewController = loader.getController();
			HotelViewController.initialize(this, customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªß≤Èø¥∂©µ•¡–±ÌΩÁ√Ê
	 * 
	 * @param customer
	 */
	public void showCustomerOrderViewScene(CustomerVO customer) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/order_ui/CustomerOrderViewScene.fxml"));
			AnchorPane CustomerOrderViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(CustomerOrderViewScene);

			// get Controller
			CustomerOrderViewController CustomerOrderViewController = loader.getController();
			CustomerOrderViewController.initialize(this, customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªß≤Èø¥∂©µ•œÍ«ÈΩÁ√Ê
	 * 
	 * @param customer
	 * @param orderVO
	 */
	public void showCustomerOrderInfoViewScene(CustomerVO customer, OrderVO orderVO) {
		// TODO Auto-generated method stub
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/order_ui/CustomerOrderInfoViewScene.fxml"));
			AnchorPane CustomerOrderInfoViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(CustomerOrderInfoViewScene);

			// get Controller
			CustomerOrderInfoViewController CustomerOrderInfoViewController = loader.getController();
			CustomerOrderInfoViewController.initialize(this, customer, orderVO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªß∆¿º€∂©µ•ΩÁ√Ê
	 * 
	 * @param customer
	 * @param hotel
	 * @param order
	 */
	public void showHotelAssessmentScene(CustomerVO customer, HotelInfoVO hotel, OrderVO order) {
		// TODO Auto-generated method stub
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/order_ui/CustomerHotelAssessmentScene.fxml"));
			AnchorPane CustomerHotelAssessmentScene = (AnchorPane) loader.load();
			rootLayout.setCenter(CustomerHotelAssessmentScene);

			// get Controller
			CustomerHotelAssessmentController CustomerHotelAssessmentController = loader.getController();
			CustomerHotelAssessmentController.initialize(this, customer, hotel, order);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªß“‚º˚∑¥¿°¡–±ÌΩÁ√Ê
	 * 
	 * @param customer
	 */
	public void showCustomerAdviceViewScene(CustomerVO customer) {
		// TODO Auto-generated method stub
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/adviceFeedBack_ui/CustomerAdviceViewScene.fxml"));
			AnchorPane CustomerAdviceViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(CustomerAdviceViewScene);

			// get Controller
			CustomerAdviceViewController CustomerAdviceViewController = loader.getController();
			CustomerAdviceViewController.initialize(this, customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªß“‚º˚∑¥¿°ƒ⁄»›¡–±ÌΩÁ√Ê
	 * 
	 * @param customer
	 */
	public void showCustomerAdviceInfoScene(CustomerVO customer, AdviceFeedBackVO advice) {
		// TODO Auto-generated method stub
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/adviceFeedBack_ui/CustomerAdviceInfoScene.fxml"));
			AnchorPane CustomerAdviceInfoScene = (AnchorPane) loader.load();
			rootLayout.setCenter(CustomerAdviceInfoScene);

			// get Controller
			CustomerAdviceInfoController CustomerAdviceInfoController = loader.getController();
			CustomerAdviceInfoController.initialize(this, customer, advice);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æøÕªß”√ªß–¬Ω®“‚º˚∑¥¿°¡–±ÌΩÁ√Ê
	 * 
	 * @param customer
	 */
	public void showCustomerCreateAdviceScene(CustomerVO customer) {
		// TODO Auto-generated method stub
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/adviceFeedBack_ui/CustomerCreateAdviceScene.fxml"));
			AnchorPane CustomerCreateAdviceScene = (AnchorPane) loader.load();
			rootLayout.setCenter(CustomerCreateAdviceScene);

			// get Controller
			CustomerCreateAdviceController CustomerCreateAdviceController = loader.getController();
			CustomerCreateAdviceController.initialize(this, customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±÷˜ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 */
	public void showHotelStaffMainScene(HotelStaffVO hotelStaff) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/main/HotelStaffMainScene.fxml"));
			AnchorPane HotelStaffMainScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStaffMainScene);

			// get Controller
			HotelStaffMainController HotelStaffMainController = loader.getController();
			HotelStaffMainController.initialize(this, hotelStaff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±æ∆µÍ∂©µ•œ‘ æΩÁ√Ê
	 * 
	 * @param hotelStaff
	 */
	public void showHotelStaffOrderViewScene(HotelStaffVO hotelStaff) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/order_ui/HotelStaffOrderViewScene.fxml"));
			AnchorPane HotelStaffOrderViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStaffOrderViewScene);

			// get Controller
			HotelStaffOrderViewController HotelStaffOrderViewController = loader.getController();
			HotelStaffOrderViewController.initialize(this, hotelStaff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±π‹¿Ìæ∆µÍ∂©µ•ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * @param order
	 */
	public void showHotelStaffManagementOrderScene(HotelStaffVO hotelStaff, OrderVO order) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/order_ui/HotelStaffManagementOrderScene.fxml"));
			AnchorPane HotelStaffManagementOrderScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStaffManagementOrderScene);

			// get Controller
			HotelStaffManagementOrderController HotelStaffManagementOrderController = loader.getController();
			HotelStaffManagementOrderController.initialize(this, hotelStaff, order);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±Œ¨ª§æ∆µÍ–≈œ¢ΩÁ√Ê
	 * 
	 * @param hotel
	 */
	public void showHotelStaffHotelInfoViewScene(HotelStaffVO hotelStaff, HotelInfoVO hotel) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/hotel_ui/HotelStaffHotelInfoViewScene.fxml"));
			AnchorPane HotelStaffHotelInfoViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStaffHotelInfoViewScene);

			// get Controller
			HotelStaffHotelInfoViewController HotelStaffHotelInfoViewController = loader.getController();
			HotelStaffHotelInfoViewController.initialize(this, hotelStaff, hotel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±–ﬁ∏ƒæ∆µÍ–≈œ¢ΩÁ√Ê
	 * 
	 * @param hotel
	 */
	public void showHotelStaffHotelInfoModifyScene(HotelStaffVO hotelStaff, HotelInfoVO hotel) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/hotel_ui/HotelStaffHotelInfoModifyScene.fxml"));
			AnchorPane HotelStaffHotelInfoModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStaffHotelInfoModifyScene);

			// get Controller
			HotelStaffHotelInfoModifyController HotelStaffHotelInfoModifyController = loader.getController();
			HotelStaffHotelInfoModifyController.initialize(this, hotelStaff, hotel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±÷∆∂®æ∆µÍ”™œ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotel
	 */
	public void showHotelStrategyViewScene(HotelStaffVO hotelStaff, HotelInfoVO hotel) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/hotelStrategy_ui/HotelStrategyViewScene.fxml"));
			AnchorPane HotelStrategyViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStrategyViewScene);

			// get Controller
			HotelStrategyViewController HotelStrategyViewController = loader.getController();
			HotelStrategyViewController.initialize(this, hotelStaff, hotel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±–ﬁ∏ƒæ∆µÍ”™œ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotel
	 */
	public void showHotelStrategyModifyScene(HotelStaffVO hotelStaff, HotelStrategyVO hotelStrategy,
			HotelInfoVO hotel) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/hotelStrategy_ui/HotelStrategyModifyScene.fxml"));
			AnchorPane HotelStrategyModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStrategyModifyScene);

			// get Controller
			HotelStrategyModifyController HotelStrategyModifyController = loader.getController();
			HotelStrategyModifyController.initialize(this, hotelStaff, hotelStrategy, hotel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ ææ∆µÍπ§◊˜»À‘±–¬‘ˆæ∆µÍ”™œ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotel
	 */
	public void showHotelStrategyNewScene(HotelStaffVO hotelStaff, HotelInfoVO hotel) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/hotelStrategy_ui/HotelStrategyNewScene.fxml"));
			AnchorPane HotelStrategyNewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(HotelStrategyNewScene);

			// get Controller
			HotelStrategyNewController HotelStrategyNewController = loader.getController();
			HotelStrategyNewController.initialize(this, hotelStaff, hotel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘±mainScene
	 * 
	 * @param hotelStaff,
	 *            orderVO
	 * 
	 */
	public void showSystemStaffMainScene(SystemStaffVO systemStaffVO) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/main/SystemStaffMainScene.fxml"));
			AnchorPane SystemStaffMainScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemStaffMainScene);

			// get Controller
			SystemStaffMainController SystemStaffMainController = loader.getController();
			SystemStaffMainController.initialize(this, systemStaffVO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘±π‹¿Ì“Ï≥£∂©µ•ΩÁ√Ê
	 * 
	 * @param systemStaffVO
	 */
	public void showSystemStaffOrderManagementScene(SystemStaffVO systemStaffVO) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/order_ui/SystemStaffOrderManagementScene.fxml"));
			AnchorPane SystemStaffOrderManagementScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemStaffOrderManagementScene);

			// get Controller
			SystemStaffOrderManagementController systemStaffOrderManagementController = loader.getController();
			systemStaffOrderManagementController.initialize(this, systemStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘±≤Èø¥“Ï≥£∂©µ•œÍ«È
	 * 
	 * @param systemStaffVO
	 */
	public void showSystemStaffOrderViewScene(SystemStaffVO systemStaffVO, OrderVO orderVO) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/order_ui/SystemStaffOrderViewScene.fxml"));
			AnchorPane SystemStaffOrderViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemStaffOrderViewScene);

			// get Controller
			SystemStaffOrderViewController systemStaffOrderViewController = loader.getController();
			systemStaffOrderViewController.initialize(this, systemStaffVO, orderVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘± π‹¿Ì–≈”√÷µΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showSystemStaffCreditManagementScene(SystemStaffVO systemStaffVO) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/userManagement_ui/SystemStaffCreditManagementScene.fxml"));
			AnchorPane SystemStaffCreditManagementScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemStaffCreditManagementScene);

			// get Controller
			SystemStaffCreditManagementController systemStaffCreditManagementController = loader.getController();
			systemStaffCreditManagementController.initialize(this, systemStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘± ≤Èø¥œµÕ≥¥Ÿœ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showSystemStrategyViewScene(SystemStaffVO systemStaffVO) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/systemStrategy_ui/SystemStrategyViewScene.fxml"));
			AnchorPane SystemStrategyViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemStrategyViewScene);

			// get Controller
			SystemStrategyViewController systemStrategyViewController = loader.getController();
			systemStrategyViewController.initialize(this, systemStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
<<<<<<< HEAD
=======
	 * show Õ¯’æ”™œ˙»À‘± ≤Èø¥œµÕ≥¥Ÿœ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showSystemHolidayStrategyModifyScene(SystemStaffVO systemStaffVO) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/systemStrategy_ui/SystemHolidayStrategyModifyScene.fxml"));
			AnchorPane SystemHolidayStrategyModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemHolidayStrategyModifyScene);

			// get Controller
			SystemHolidayStrategyModifyController SystemHolidayStrategyModifyController = loader.getController();
			SystemHolidayStrategyModifyController.initilize(this, systemStaffVO, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
>>>>>>> refs/remotes/origin/Âè∂ÊôìÊ≥¢
	 * show Õ¯’æ”™œ˙»À‘± –ﬁ∏ƒΩ⁄»’œµÕ≥¥Ÿœ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showSystemHolidayStrategyModifyScene(SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/systemStrategy_ui/SystemHolidayStrategyModifyScene.fxml"));
			AnchorPane SystemHolidayStrategyModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemHolidayStrategyModifyScene);

			// get Controller
			SystemHolidayStrategyModifyController SystemHolidayStrategyModifyController = loader.getController();
			SystemHolidayStrategyModifyController.initilize(this, systemStaffVO, systemStrategyVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘± –¬‘ˆΩ⁄»’œµÕ≥¥Ÿœ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showAddSystemHolidayStrategyScene(SystemStaffVO systemStaffVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/systemStrategy_ui/SystemHolidayStrategyModifyScene.fxml"));
			AnchorPane AddSystemHolidayStrategyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(AddSystemHolidayStrategyScene);

			// get Controller
			AddSystemHolidayStrategyController addSystemHolidayStrategyController = loader.getController();
			addSystemHolidayStrategyController.initilize(this, systemStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘± –¬‘ˆª·‘±œµÕ≥¥Ÿœ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showAddSystemMemberStrategyScene(SystemStaffVO systemStaffVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/systemStrategy_ui/SystemMemberStrategyModifyScene.fxml"));
			AnchorPane SystemMemberStrategyModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemMemberStrategyModifyScene);

			// get Controller
			AddSystemMemberStrategyController addSystemMemberStrategyController = loader.getController();
			addSystemMemberStrategyController.initilize(this, systemStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘± –ﬁ∏ƒª·‘±œµÕ≥¥Ÿœ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showSystemMemberStrategyModifyScene(SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/systemStrategy_ui/SystemMemberStrategyModifyScene.fxml"));
			AnchorPane SystemMemberStrategyModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemMemberStrategyModifyScene);

			// get Controller
			SystemMemberStrategyModifyController SystemMemberStrategyModifyController = loader.getController();
			SystemMemberStrategyModifyController.initilize(this, systemStaffVO, systemStrategyVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘± –ﬁ∏ƒª·‘±–≈œ¢
	 * 
	 * @param hotelStaff
	 * 
	 */
	public boolean showPersonEditDialog(VipVO vipVO) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/systemStrategy_ui/MemberEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("±‡º≠ª·‘±–≈œ¢");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			MemberEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setVipVO(vipVO);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘± –¬‘ˆVIPª·‘±œµÕ≥¥Ÿœ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showAddSystemVIPStrategyScene(SystemStaffVO systemStaffVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/systemStrategy_ui/SystemVIPStrategyModifyScene.fxml"));
			AnchorPane SystemVIPStrategyModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemVIPStrategyModifyScene);

			// get Controller
			AddSystemVIPStrategyController addSystemVIPStrategyController = loader.getController();
			addSystemVIPStrategyController.initilize(this, systemStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘± –ﬁ∏ƒVIPª·‘±œµÕ≥¥Ÿœ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showSystemVIPStrategyModifyScene(SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/systemStrategy_ui/SystemVIPStrategyModifyScene.fxml"));
			AnchorPane SystemVIPStrategyModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemVIPStrategyModifyScene);

			// get Controller
			SystemVIPStrategyModifyController SystemVIPStrategyModifyController = loader.getController();
			SystemVIPStrategyModifyController.initilize(this, systemStaffVO, systemStrategyVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘± –ﬁ∏ƒ∆‰À˚œµÕ≥¥Ÿœ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showSystemOtherStrategyModifyScene(SystemStaffVO systemStaffVO, SystemStrategyVO systemStrategyVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/systemStrategy_ui/SystemOtherStrategyModifyScene.fxml"));
			AnchorPane SystemOtherStrategyModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemOtherStrategyModifyScene);

			// get Controller
			SystemOtherStrategyModifyController SystemOtherStrategyModifyController = loader.getController();
			SystemOtherStrategyModifyController.initilize(this, systemStaffVO, systemStrategyVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æ”™œ˙»À‘± –¬‘ˆ∆‰À˚œµÕ≥¥Ÿœ˙≤ﬂ¬‘ΩÁ√Ê
	 * 
	 * @param hotelStaff
	 * 
	 */
	public void showAddSystemOtherStrategyScene(SystemStaffVO systemStaffVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/systemStrategy_ui/SystemOtherStrategyModifyScene.fxml"));
			AnchorPane SystemOtherStrategyModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemOtherStrategyModifyScene);

			// get Controller
			AddSystemOtherStrategyController addSystemOtherStrategyController = loader.getController();
			addSystemOtherStrategyController.initilize(this, systemStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æÕ¯’æ”™œ˙»À‘±Œ¨ª§∏ˆ»À–≈œ¢ΩÁ√Ê
	 * 
	 * @param systemStaff
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´¿¥µƒSystemStaffVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showSystemStaffInfoScene(SystemStaffVO systemStaff) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/userInfo_ui/SystemStaffInfoScene.fxml"));
			AnchorPane SystemStaffInfoModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemStaffInfoModifyScene);

			// get Controller
			SystemStaffInfoController SystemStaffInfoController = loader.getController();
			SystemStaffInfoController.initialize(this, systemStaff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æÕ¯’æ”™œ˙»À‘±–ﬁ∏ƒ∏ˆ»À–≈œ¢ΩÁ√Ê
	 * 
	 * @param systemStaff
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´¿¥µƒSystemStaffVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showSystemStaffInfoModifyScene(SystemStaffVO systemStaff) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/userInfo_ui/SystemStaffInfoModifyScene.fxml"));
			AnchorPane SystemStaffInfoModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemStaffInfoModifyScene);
			// get Controller
			SystemStaffInfoModifyController SystemStaffInfoModifyController = loader.getController();
			SystemStaffInfoModifyController.initialize(this, systemStaff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æÕ¯’æ”™œ˙»À‘±–ﬁ∏ƒ√‹¬ÎΩÁ√Ê
	 * 
	 * @param systemStaff
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´¿¥µƒSystemStaffVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showSystemStaffPasswordModifyScene(SystemStaffVO systemStaff) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/userInfo_ui/SystemStaffPasswordModifyScene.fxml"));
			AnchorPane SystemStaffPasswordModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemStaffPasswordModifyScene);

			// get Controller
			SystemStaffPasswordModifyController SystemStaffPasswordModifyController = loader.getController();
			SystemStaffPasswordModifyController.initialize(this, systemStaff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± mainScene
	 * 
	 * @param
	 */
	public void showSystemManagerMainScene(SystemManagerVO systemManagerVO) {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/main/SystemManagerMainScene.fxml"));
			AnchorPane SystemManagerMainScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerMainScene);

			// get Controller
			SystemManagerMainController SystemManagerMainController = loader.getController();
			SystemManagerMainController.SystemManagerMainShow(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± ”√ªß≤Èø¥–≈œ¢ΩÁ√Ê
	 * 
	 * @param
	 */
	public void showCustomerManagementScene(SystemManagerVO systemManagerVO) {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/userManagement_ui/CustomerManagementScene.fxml"));
			AnchorPane SystemManagerMainScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerMainScene);

			// get Controller
			CustomerManagementController CustomerManagementController = loader.getController();
			CustomerManagementController.initialize(this, systemManagerVO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± æ∆µÍπ§◊˜»À‘±≤Èø¥–≈œ¢ΩÁ√Ê
	 * 
	 * @param
	 */
	public void showHotelStaffManagementScene(SystemManagerVO systemManagerVO) {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/userManagement_ui/HotelStaffManagementScene.fxml"));
			AnchorPane SystemManagerMainScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerMainScene);

			// get Controller
			HotelStaffManagementController HotelStaffManagementController = loader.getController();
			HotelStaffManagementController.initialize(this, systemManagerVO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± Õ¯’æ”™œ˙»À‘±≤Èø¥–≈œ¢ΩÁ√Ê
	 * 
	 * @param
	 */
	public void showSystemStaffManagementScene(SystemManagerVO systemManagerVO) {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/userManagement_ui/SystemStaffManagementScene.fxml"));
			AnchorPane SystemManagerMainScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerMainScene);

			// get Controller
			SystemStaffManagementController SystemStaffManagementController = loader.getController();
			SystemStaffManagementController.initialize(this, systemManagerVO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± ≤Èø¥”√ªß–≈œ¢
	 * 
	 * @param
	 */
	public void showSystemManagerCustomerInfoViewScene(SystemManagerVO systemManagerVO, CustomerVO customerVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/userManagement_ui/SystemManagerCustomerInfoViewScene.fxml"));
			AnchorPane SystemManagerCustomerInfoViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerCustomerInfoViewScene);

			// get Controller
			SystemManagerCustomerInfoViewController systemManagerCustomerInfoViewController = loader.getController();
			systemManagerCustomerInfoViewController.initialize(this, systemManagerVO, customerVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± –ﬁ∏ƒ”√ªß–≈œ¢
	 * 
	 * @param
	 */
	public void showSystemManagerCustomerInfoModifyScene(SystemManagerVO systemManagerVO, CustomerVO customerVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/userManagement_ui/SystemManagerCustomerInfoModifyScene.fxml"));
			AnchorPane SystemManagerCustomerInfoModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerCustomerInfoModifyScene);

			// get Controller
			SystemManagerCustomerInfoModifyController systemManagerCustomerInfoModifyController = loader
					.getController();
			systemManagerCustomerInfoModifyController.initialize(this, systemManagerVO, customerVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± ≤Èø¥hotel staff–≈œ¢
	 * 
	 * @param
	 */
	public void showSystemManagerHotelStaffInfoViewScene(SystemManagerVO systemManagerVO, HotelStaffVO hotelStaffVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/userManagement_ui/SystemManagerHotelStaffInfoViewScene.fxml"));
			AnchorPane SystemManagerCustomerInfoViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerCustomerInfoViewScene);

			// get Controller
			SystemManagerHotelStaffInfoViewController systemManagerHotelStaffInfoViewController = loader
					.getController();
			systemManagerHotelStaffInfoViewController.initialize(this, systemManagerVO, hotelStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± –ﬁ∏ƒhotel staff–≈œ¢
	 * 
	 * @param
	 */
	public void showSystemManagerHotelStaffInfoModifyScene(SystemManagerVO systemManagerVO, HotelStaffVO hotelStaffVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/userManagement_ui/SystemManagerHotelStaffInfoModifyScene.fxml"));
			AnchorPane SystemManagerHotelStaffInfoModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerHotelStaffInfoModifyScene);

			// get Controller
			SystemManagerHotelStaffInfoModifyController systemManagerHotelStaffInfoModifyController = loader
					.getController();
			systemManagerHotelStaffInfoModifyController.initialize(this, systemManagerVO, hotelStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± ≤Èø¥system staff–≈œ¢
	 * 
	 * @param
	 */
	public void showSystemManagerSystemStaffInfoViewScene(SystemManagerVO systemManagerVO,
			SystemStaffVO systemStaffVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/userManagement_ui/SystemManagerSystemStaffInfoViewScene.fxml"));
			AnchorPane SystemManagerCustomerInfoViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerCustomerInfoViewScene);

			// get Controller
			SystemManagerSystemStaffInfoViewController systemManagerSystemStaffInfoViewController = loader
					.getController();
			systemManagerSystemStaffInfoViewController.initialize(this, systemManagerVO, systemStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± ≤Èø¥system staff–≈œ¢
	 * 
	 * @param
	 */
	public void showSystemManagerSystemStaffInfoModfyScene(SystemManagerVO systemManagerVO,
			SystemStaffVO systemStaffVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/userManagement_ui/SystemManagerSystemStaffInfoModifyScene.fxml"));
			AnchorPane SystemManagerCustomerInfoViewScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerCustomerInfoViewScene);

			// get Controller
			SystemManagerSystemStaffInfoModifyController systemManagerSystemStaffInfoViewController = loader
					.getController();
			systemManagerSystemStaffInfoViewController.initialize(this, systemManagerVO, systemStaffVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± ◊¢≤·æ∆µÍ
	 * 
	 * @param
	 */
	public void showSystemManagerHotelRegisterScene(SystemManagerVO systemManagerVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/hotel_ui/SystemManagerHotelRegisterScene.fxml"));
			AnchorPane SystemManagerHotelRegisterScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerHotelRegisterScene);

			// get Controller
			SystemManagerHotelRegisterController SystemManagerHotelRegisterController = loader.getController();
			SystemManagerHotelRegisterController.initialize(this,systemManagerVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show Õ¯’æπ‹¿Ì»À‘± æ∆µÍ◊¢≤·≥…π¶
	 * 
	 * @param
	 */
	public void showSystemManagerHotelRegisterShowIDScene(SystemManagerVO systemManagerVO,HotelInfoVO hotelInfoVO) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("/presentation/view/hotel_ui/SystemManagerHotelRegisterShowIDScene.fxml"));
			AnchorPane SystemManagerHotelRegisterShowIDScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerHotelRegisterShowIDScene);

			// get Controller
			SystemManagerHotelRegisterShowIDController SystemManagerHotelRegisterShowIDController = loader
					.getController();
			SystemManagerHotelRegisterShowIDController.SystemManagerHotelRegisterShowIDShow(this,systemManagerVO,hotelInfoVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æÕ¯’æ”™œ˙»À‘±Œ¨ª§∏ˆ»À–≈œ¢ΩÁ√Ê
	 * 
	 * @param systemManager
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´¿¥µƒSystemManagerVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showSystemManagerInfoScene(SystemManagerVO systemManager) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/presentation/view/userInfo_ui/SystemManagerInfoScene.fxml"));
			AnchorPane SystemManagerInfoScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerInfoScene);

			// get Controller
			SystemManagerInfoController SystemManagerInfoController = loader.getController();
			SystemManagerInfoController.initialize(this, systemManager);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æÕ¯’æ”™œ˙»À‘±–ﬁ∏ƒ∏ˆ»À–≈œ¢ΩÁ√Ê
	 * 
	 * @param systemManager
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´¿¥µƒSystemManagerVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showSystemManagerInfoModifyScene(SystemManagerVO systemManager) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/userInfo_ui/SystemManagerInfoModifyScene.fxml"));
			AnchorPane SystemManagerInfoModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerInfoModifyScene);

			// get Controller
			SystemManagerInfoModifyController SystemManagerInfoModifyController = loader.getController();
			SystemManagerInfoModifyController.initialize(this, systemManager);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * show œ‘ æÕ¯’æ”™œ˙»À‘±–ﬁ∏ƒ√‹¬ÎΩÁ√Ê
	 * 
	 * @param systemManager
	 *            Ω” ‹¥”∆‰À˚ΩÁ√Ê¥´¿¥µƒSystemManagerVO ∂‘œÛ◊˜Œ™≤Œ ˝
	 */
	public void showSystemManagerPasswordModifyScene(SystemManagerVO systemManager) {
		try {
			this.initRootLayout();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					Main.class.getResource("/presentation/view/userInfo_ui/SystemManagerPasswordModifyScene.fxml"));
			AnchorPane SystemManagerPasswordModifyScene = (AnchorPane) loader.load();
			rootLayout.setCenter(SystemManagerPasswordModifyScene);

			// get Controller
			SystemManagerPasswordModifyController SystemManagerPasswordModifyController = loader.getController();
			SystemManagerPasswordModifyController.initialize(this, systemManager);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initRootLayout() {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initLoginLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("LoginLayout.fxml"));
			loginLayout = (BorderPane) loader.load();

			Scene scene = new Scene(loginLayout);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initRegisterLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("RegisterLayout.fxml"));
			registerLayout = (BorderPane) loader.load();

			Scene scene = new Scene(registerLayout);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClientRunner clientRunner = new ClientRunner();
		launch(args);
	}

}
