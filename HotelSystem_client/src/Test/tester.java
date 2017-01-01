package Test;

import java.time.LocalDateTime;

import VO.LogofUserVO;
import VO.OrderVO;
import blservice.LogOfUser_blServce;
import blservice.Order_blservice;
import blservice.impl.LogOfUser_blServceImpl;
import blservice.impl.Order_bl;
import main.ClientRunner;
import other.OrderState;

public class tester {
	public static void main(String[] args) {
		ClientRunner runner = new ClientRunner();
		Order_blservice orderService = new Order_bl();
		OrderVO order = orderService.getOrder("455");
		order.setOrderState(OrderState.ABNOMAL);
		orderService.changeState(order);
		LogofUserVO log = new LogofUserVO();
		LogOfUser_blServce logService = new LogOfUser_blServceImpl();
		LogofUserVO logofUserVO = new LogofUserVO();
		logofUserVO.setChange((int) (-order.getPrice() * 0.5));
		logofUserVO.setContent("“Ï≥£∂©µ•" + order.getOrderID());
		logofUserVO.setDateTime(LocalDateTime.now());
		logofUserVO.setUserid(order.getUserID());
		logService.addLogOfUser(logofUserVO);
	}
}
