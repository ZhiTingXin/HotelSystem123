package MockObject;

import static org.junit.Assert.*;

import org.junit.Test;

import VO.SystemStaffVO;
import presentation.controller.userInfoController.SystemStaffInfoController;

public class SystemStaffTest {

	@Test
	public void testSystemStaff(){
		MockSystemStaff staff = new MockSystemStaff("123456","张居正");
		SystemStaffInfoController con = new SystemStaffInfoController();
//		con.add(staff);
//		con.modifyName("申时行");
//		SystemStaffVO system = con.get();
//		assertEquals("申时行",system.getUsername());
	}
}
