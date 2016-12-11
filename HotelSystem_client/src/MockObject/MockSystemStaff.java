package MockObject;

import blservice.impl.UserInfo_bl;

public class MockSystemStaff extends UserInfo_bl{
     String SystemStaffID;
     String SystemStaffName;
     
     public MockSystemStaff(String systemstaffid,String systemstaffName){
    	 SystemStaffID = systemstaffid;
    	 SystemStaffName = systemstaffName;
     }
     
     public String modifyName(String changedName){
    	 SystemStaffName = changedName;
    	 return this.SystemStaffName;
     }
}
