package RMI;

import java.rmi.Remote;

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

public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	//连接server的接口
	public HotelDataService getHotelDataService(){
		return (HotelDataService)remote;
	}
	public AdviceFeedBackDataService getAdviceFeedBackDataService(){
		return (AdviceFeedBackDataService)remote;
	}
	public CustomerDataService getCustomerDataService(){
		return (CustomerDataService)remote;
	}
	public HotelStaffDataService getHotelStaffDataService(){
		return (HotelStaffDataService)remote;
	}
	public SystemManagerDataService getSystemManagerDataService(){
		return (SystemManagerDataService)remote;
	}
	public SystemStaffDataService getSystemStaffDataService(){
		return (SystemStaffDataService)remote;
	}
	public HotelStrategyDataService getHotelStrategyDataService(){
		return (HotelStrategyDataService)remote;
	}
	
	public OrderDataService getOrderDataService(){
		return (OrderDataService)remote;
	}
	public SystemStrategyDataService getSystemStrategyDataService(){
		return (SystemStrategyDataService)remote;
	}
	public LoginDataService getLoginDataService(){
		return (LoginDataService)remote;
	}
    public VipDataService getVipDataService(){
    	return (VipDataService)remote;
    }
}
