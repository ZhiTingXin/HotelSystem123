package MockObject;

import VO.SystemManagerVO;

public class MockSystemManager extends SystemManagerVO{
	
	String systemManagerName;
	String systemManagerId;
	
	public MockSystemManager(String systemid,String systemname){
		systemManagerId = systemid;
		systemManagerName = systemname;
	}
	
	public String getSystemmanager_Id(){
		return this.systemManagerId;
	}
}
