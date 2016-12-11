package testAll;

import java.util.ArrayList;

import PO.CustomerPO;
import other.hibernateUtil;

//import PO.AdviceFeedBackPO;
//import data.service.AdviceFeedBackDataService;
//import data.service.impl.AdviceFeedBackDataServiceImpl;
//import other.AdviceFeedBackState;

public class tes {

	public static void main(String [] args)throws Exception{
//		AdviceFeedBackDataService adviceFeedBackDataService = new AdviceFeedBackDataServiceImpl();
//		AdviceFeedBackPO adviceFeedBackPO = new  AdviceFeedBackPO();
//		adviceFeedBackPO.setAdviceFeedBack_content("adua64565");
//		adviceFeedBackPO.setState(AdviceFeedBackState.PROCESSED);
////		adviceFeedBackPO.setSystemStaffId("151250170");
//		adviceFeedBackPO.setUserId("151250169");
//		adviceFeedBackDataService.updateAdvice(adviceFeedBackPO);
//		CustomerPO customerPO = new CustomerPO();
//		customerPO.setBirthday(new Date());
//		customerPO.setCredit(0);
//		customerPO.setId("151250179");
//		customerPO.setMemberGrade(5);
//		customerPO.setPhone("15851266554");
//		customerPO.setUserName("xinzhiting");
//		hibernateUtil.add(customerPO);
		ArrayList<CustomerPO> list2 = (ArrayList<CustomerPO>)hibernateUtil.getAll("customer",CustomerPO.class);
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i).getId());
		}
//		for(CustomerPO customerPO:list){
//			
//		}
//		ArrayList<CustomerPO> list  = (ArrayList<CustomerPO>)hibernateUtil.findbySome("CustomerPO", "userName", "xinzhiting");
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getId());
//		}
	}
}
