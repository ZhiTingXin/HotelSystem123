package Test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import VO.CustomerVO;
import blservice.Register_blservice;
import blservice.impl.Register_bl;
import main.ClientRunner;
import other.memberState;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegisterTester {
	ClientRunner clientRunner = new ClientRunner();
    Register_blservice register_blservice = new Register_bl();
    @Test
	public void test001register() {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setId("151250");
		customerVO.setPassword("xzt123");
		customerVO.setMemberState(memberState.NORMAL_MEMBER);
		register_blservice.addRegister(customerVO);
	}
}
