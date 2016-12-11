package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.AdviceFeedBackPO;
import PO.CustomerPO;
import PO.HotelPO;
import PO.HotelStaffPO;
import PO.HotelStrategyPO;
import PO.LoginPO;
import PO.OrderPO;
import PO.SystemManagerPO;
import PO.SystemStaffPO;
import PO.SystemStrategyPO;
import PO.VipPO;
import data.service.AdviceFeedBackDataService;
import data.service.CustomerDataService;
import data.service.HotelDataService;
import data.service.HotelStaffDataService;
import data.service.HotelStrategyDataService;
import data.service.LoginDataService;
import data.service.OrderDataService;
import data.service.SystemManagerDataService;
import data.service.SystemStaffDataService;
import data.service.SystemStrategyDataService;
import data.service.VipDataService;
import data.service.impl.AdviceFeedBackDataServiceImpl;
import data.service.impl.CustomerDataServiceImpl;
import data.service.impl.HotelDataServiceImpl;
import data.service.impl.HotelStaffDataServiceImpl;
import data.service.impl.HotelStrategyDataServiceImpl;
import data.service.impl.LoginDataServiceImpl;
import data.service.impl.OrderDataServiceImpl;
import data.service.impl.SystemManagerDataServiceImpl;
import data.service.impl.SystemStaffDataServiceImpl;
import data.service.impl.SystemStrategyDataServiceImpl;
import data.service.impl.VipDataServiceImpl;
import other.SystemStrategyType;

public class DataRemoteObject extends UnicastRemoteObject implements LoginDataService
,OrderDataService,HotelStrategyDataService,SystemStrategyDataService,HotelDataService,AdviceFeedBackDataService
,HotelStaffDataService,SystemStaffDataService,SystemManagerDataService,CustomerDataService,VipDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginDataService login;
	private OrderDataService orderdata;
	private HotelStrategyDataService hotelstrategy;
	private SystemStrategyDataService systemstrategy;
	private HotelDataService hotel;
	private AdviceFeedBackDataService advice;
	private SystemManagerDataService systemManagerDataService;
	private SystemStaffDataService systemStaffDataService;
	private CustomerDataService customerDataService;
	private HotelStaffDataService hotelStaffDataService;
	private VipDataService vipDataService;
	protected DataRemoteObject() throws RemoteException {
		vipDataService = new VipDataServiceImpl();
		customerDataService = new CustomerDataServiceImpl();
		hotelStaffDataService = new HotelStaffDataServiceImpl();
		systemManagerDataService = new SystemManagerDataServiceImpl();
		systemStaffDataService = new SystemStaffDataServiceImpl();
		login = new LoginDataServiceImpl();
		orderdata = new OrderDataServiceImpl();
		hotelstrategy = new HotelStrategyDataServiceImpl();
		systemstrategy = new SystemStrategyDataServiceImpl();
		hotel = new HotelDataServiceImpl();
		advice = new AdviceFeedBackDataServiceImpl();
	}
	public boolean addAdvice(AdviceFeedBackPO advicefeedback) throws RemoteException {
		return advice.addAdvice(advicefeedback);
	}
	public boolean updateAdvice(AdviceFeedBackPO advicefeedback) throws RemoteException {
		return advice.updateAdvice(advicefeedback);
	}
	public ArrayList<AdviceFeedBackPO> getAdvices(String userId, String type) throws RemoteException {
		return advice.getAdvices(userId, type);
	}
	public boolean add(HotelPO hotel)throws RemoteException {
		return this.hotel.add(hotel);
	}
	public boolean del(HotelPO hotel) throws RemoteException{
		return this.hotel.del(hotel);
	}
	
	public boolean update(HotelPO hotel)throws RemoteException {
		return this.hotel.update(hotel);
	}
	public ArrayList<HotelPO> getHotels(String strict, String type) throws RemoteException{
		return this.hotel.getHotels(strict, type);
	}
	public boolean add(SystemStrategyPO systemstrategy) throws RemoteException {
		return this.systemstrategy.add(systemstrategy);
	}
	public boolean delete(SystemStrategyPO systemstrategy) throws RemoteException {
		return this.systemstrategy.delete(systemstrategy);
	}
	public boolean modify(SystemStrategyPO systemstrategy) throws RemoteException {
		return this.systemstrategy.modify(systemstrategy);
	}
	public boolean add(HotelStrategyPO hotelstrategy) throws RemoteException {
		return this.hotelstrategy.add(hotelstrategy);
	}
	public boolean delete(HotelStrategyPO hotelstrategy) throws RemoteException {
		return this.hotelstrategy.delete(hotelstrategy);
	}
	public boolean modify(HotelStrategyPO hotelstartegy) throws RemoteException {
		return this.hotelstrategy.modify(hotelstartegy);
	}
	public ArrayList<HotelStrategyPO> getAll(String hotelId) throws RemoteException {
		return hotelstrategy.getAll(hotelId);
	}
	public boolean add(OrderPO order) throws RemoteException {
		return orderdata.add(order);
	}
	public boolean update(OrderPO order) throws RemoteException {
		return orderdata.update(order);
	}
	public boolean dalete(OrderPO order) throws RemoteException {
		return orderdata.dalete(order);
	}
	public OrderPO findorder(String orderId) throws RemoteException {
		return orderdata.findorder(orderId);
	}
	public List<OrderPO> findOrders(String userId, String type) throws RemoteException {
		return orderdata.findOrders(userId, type);
	}
	public boolean confirm(String userId, String userPassword) throws RemoteException {
		return this.login.confirm(userId, userPassword);
	}
	public boolean add(LoginPO login) throws RemoteException {
		return this.login.add(login);
	}
	public boolean delete(LoginPO login) throws RemoteException {
		return this.login.delete(login);
	}
	public boolean update(LoginPO login) throws RemoteException {
		return this.login.update(login);
	}
	public HotelPO find(String hotelId) throws RemoteException{
		return hotel.find(hotelId);
	}
	public HotelStrategyPO get(String hotelstrategyId) throws RemoteException {
		return hotelstrategy.get(hotelstrategyId);
	}
	public SystemStrategyPO getSstrategy(String strategyName) throws RemoteException {
		return systemstrategy.getSstrategy(strategyName);
	}
	public boolean addCustomer(CustomerPO customer) throws RemoteException {
		return customerDataService.addCustomer(customer);
	}
	public boolean deleteCustomer(CustomerPO customer) throws RemoteException {
		return customerDataService.deleteCustomer(customer);
	}
	public boolean updateCustomer(CustomerPO customer) throws RemoteException {
		return customerDataService.updateCustomer(customer);
	}
	public CustomerPO findCustomer(String customerID) throws RemoteException {
		return customerDataService.findCustomer(customerID);
	}
	public SystemManagerPO findManager(String managerID) throws RemoteException {
		return systemManagerDataService.findManager(managerID);
	}
	public boolean addManager(SystemManagerPO managerPO) throws RemoteException {
		return systemManagerDataService.addManager(managerPO);
	}
	public boolean deleteManager(SystemManagerPO systemManagerPO) throws RemoteException {
		return systemManagerDataService.deleteManager(systemManagerPO);
	}
	public boolean updateManager(SystemManagerPO managerPO) throws RemoteException {
		return systemManagerDataService.updateManager(managerPO);
	}
	public boolean addStaff(SystemStaffPO staffPO) throws RemoteException {
		return systemStaffDataService.addStaff(staffPO);
	}
	public boolean updateStaff(SystemStaffPO staffPO) throws RemoteException {
		return systemStaffDataService.updateStaff(staffPO);
	}
	public boolean deleteStaff(SystemStaffPO staffPO) throws RemoteException {
		return systemStaffDataService.deleteStaff(staffPO);
	}
	public SystemStaffPO findStaff(String staffID) throws RemoteException {
		return systemStaffDataService.findStaff(staffID);
	}
	public boolean addStaff(HotelStaffPO staffPO) throws RemoteException {
		return hotelStaffDataService.addStaff(staffPO);
	}
	public boolean updateStaff(HotelStaffPO staffPO) throws RemoteException {
		return hotelStaffDataService.updateStaff(staffPO);
	}
	public boolean deleteStaff(HotelStaffPO staffPO) throws RemoteException {
		
		return hotelStaffDataService.deleteStaff(staffPO);
	}
	public HotelStaffPO findHotelStaff(String staffID) throws RemoteException {
		return hotelStaffDataService.findHotelStaff(staffID);
	}
	public ArrayList<CustomerPO> getAllCustomers() throws RemoteException {
		return customerDataService.getAllCustomers();
	}
	public ArrayList<SystemStaffPO> getAllSystemStaffs() throws RemoteException {
		return systemStaffDataService.getAllSystemStaffs();
	}
	public ArrayList<HotelStaffPO> getAllHotelStaffs() throws RemoteException {
		return hotelStaffDataService.getAllHotelStaffs();
	}
	public ArrayList<AdviceFeedBackPO> getAllAdvices() throws RemoteException {
		return advice.getAllAdvices();
	}
	public ArrayList<HotelPO> getAllHotels() throws RemoteException {
		return hotel.getAllHotels();
	}
	public ArrayList<SystemStrategyPO> getAllStrategys() throws RemoteException {
		return systemstrategy.getAllStrategys();
	}
	public boolean makeVip(VipPO vipPO) throws RemoteException {
		return vipDataService.makeVip(vipPO);
	}
	public VipPO getVip(int grade) throws RemoteException {
		return vipDataService.getVip(grade);
	}
	public boolean updateVip(VipPO vipPO) throws RemoteException {
		return vipDataService.updateVip(vipPO);
	}
	public ArrayList<VipPO> getAllVips()throws RemoteException{
		return vipDataService.getAllVips();
	}
	public ArrayList<SystemStrategyPO> getSystemStrategys(SystemStrategyType strategyType) throws RemoteException {
		return systemstrategy.getSystemStrategys(strategyType);
	}

}
