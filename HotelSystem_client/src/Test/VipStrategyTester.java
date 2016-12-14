package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import VO.VipStrategyVO;
import VO.VipVO;
import blservice.VipStrategy_blService;
import blservice.impl.VipStrategy_blServiceImpl;
import main.ClientRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VipStrategyTester {
	ClientRunner Client = new ClientRunner();
	VipStrategy_blService vipStrategy_blService = new  VipStrategy_blServiceImpl();
   @Test
   public void test001make(){
	   VipStrategyVO vipStrategyVO = new VipStrategyVO();
	   VipVO vip1 = new VipVO(123, 124, 1, 0.85);
	   VipVO vip2 = new VipVO(124, 126, 2, 0.85);
	   VipVO vip3 = new VipVO(127, 130, 3, 0.85);
	   VipVO vip4 = new VipVO(131, 134, 4, 0.85);
	   VipVO vip5 = new VipVO(143, 154, 5, 0.85);
	   ArrayList<VipVO> arrayList = new ArrayList<VipVO>();
	   arrayList.add(vip5);arrayList.add(vip1);arrayList.add(vip4);arrayList.add(vip3);arrayList.add(vip2);
	   vipStrategyVO.setVipStrategyVOList(arrayList);
	   assertEquals(true,vipStrategy_blService.makeVipStrategy(vipStrategyVO));
   }
   @Test
   public void test002modify(){
	   VipStrategyVO vipStrategyVO = new VipStrategyVO();
	   VipVO vip1 = new VipVO(163, 150, 1, 0.85);
	   VipVO vip2 = new VipVO(124, 126, 2, 0.95);
	   VipVO vip3 = new VipVO(127, 130, 3, 0.75);
	   VipVO vip4 = new VipVO(131, 134, 4, 0.65);
	   VipVO vip5 = new VipVO(143, 154, 5, 0.55);
	   ArrayList<VipVO> arrayList = new ArrayList<VipVO>();
	   arrayList.add(vip5);arrayList.add(vip1);arrayList.add(vip4);arrayList.add(vip3);arrayList.add(vip2);
	   vipStrategyVO.setVipStrategyVOList(arrayList);
	   assertEquals(true, vipStrategy_blService.modifyVipStrategy(vipStrategyVO));
   }
   @Test
   public void test003get(){
	   VipStrategyVO vipStrategyVO = vipStrategy_blService.getVipStrategy();
	   assertEquals(163, vipStrategyVO.getVipStrategyVOList().get(0).getMincredit());
   }
}
