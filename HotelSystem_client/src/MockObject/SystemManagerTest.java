package MockObject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import VO.SystemManagerVO;
import presentation.controller.userInfoController.SystemManagerInfoController;

public class SystemManagerTest {

	@Test
	public void test(){
	    MockSystemManager mana = new MockSystemManager("151250170","Mr.xin");
	    
	    SystemManagerInfoController con = new SystemManagerInfoController();
//	SystemManagerManagementController con2 = new SystemManagerManagementController();
	    
	    con.add(mana);
	    SystemManagerVO manager = con.get();
	    assertEquals("151250170",manager.getSystemmanager_Id());
	}
	
	
}
