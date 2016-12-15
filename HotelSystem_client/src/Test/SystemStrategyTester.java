package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import VO.SystemStrategyVO;
import blservice.SystemStrategy_blservice;
import blservice.impl.SystemStrategy_bl;
import main.ClientRunner;
import other.StrategyState;
import other.SystemStrategyType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SystemStrategyTester {

	ClientRunner cl = new ClientRunner();
	SystemStrategy_blservice h = new SystemStrategy_bl();
	@Test
	public void test001make(){
		SystemStrategyVO strategyVO = new SystemStrategyVO();
		strategyVO.setStrategyState(StrategyState.open);
		strategyVO.setSystemStrategyDescription("Ŭ���Ĵ���");
		strategyVO.setSystemStrategyName("��Ա�Ż�");
		strategyVO.setSystemStrategyType(SystemStrategyType.VIPMEMBER);
		SystemStrategyVO strategyVO1 = new SystemStrategyVO();
		strategyVO1.setStrategyState(StrategyState.open);
		strategyVO1.setSystemStrategyDescription("Ŭ���Ĵ���");
		strategyVO1.setSystemStrategyName("��Ա���Ż�");
		strategyVO1.setSystemStrategyType(SystemStrategyType.VIPMEMBER);
		SystemStrategyVO strategyVO2 = new SystemStrategyVO();
		strategyVO2.setStrategyState(StrategyState.open);
		strategyVO2.setSystemStrategyDescription("Ŭ���Ĵ���");
		strategyVO2.setSystemStrategyName("��Ա��Ҫ�Ż���");
		strategyVO2.setSystemStrategyType(SystemStrategyType.VIPMEMBER);
		SystemStrategyVO strategyVO3 = new SystemStrategyVO();
		strategyVO3.setStrategyState(StrategyState.open);
		strategyVO3.setSystemStrategyDescription("Ŭ���Ĵ���");
		strategyVO3.setSystemStrategyName("��Ա�����Ż�");
		strategyVO3.setSystemStrategyType(SystemStrategyType.MEMBER);
		h.makeSystemStrategy(strategyVO3);
		h.makeSystemStrategy(strategyVO2);
		h.makeSystemStrategy(strategyVO1);
		assertEquals(true,h.makeSystemStrategy(strategyVO));
	}
	@Test
	public void test002modify(){
		ArrayList<SystemStrategyVO> strategyVOs = h.getSystemStrategy(SystemStrategyType.VIPMEMBER);
		SystemStrategyVO aStrategyVO = strategyVOs.get(0);
		aStrategyVO.setSystemStrategyType(SystemStrategyType.HOLIDAY);
		h.modifySystemStrategy(aStrategyVO);
	}
	@Test
	public void test003getsome(){
		ArrayList<SystemStrategyVO> strategyVOs = h.getSystemStrategy(SystemStrategyType.HOLIDAY);
		assertEquals("291", strategyVOs.get(0).getId());
	}
	@Test 
	public void test004getall(){
		ArrayList<SystemStrategyVO> strategyVOs = h.getAllSystemStrategys();
		assertEquals("��Ա�Ż�", strategyVOs.get(0).getSystemStrategyName());
	}
    @Test
    public void test005dele(){
    	ArrayList<SystemStrategyVO> strategyVOs = h.getAllSystemStrategys();
    	assertEquals(true, h.deleteSystemStrategy(strategyVOs.get(strategyVOs.size()-1)));
    }
}

