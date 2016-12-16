package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import VO.AssementVO;
import VO.HotelInfoVO;
import VO.HotelRoomInfoVO;
import VO.HotelStrategyVO;
import VO.LabelVO;
import VO.OrderVO;
import blservice.Hotel_blservice;
import blservice.impl.Hotel_bl;
import main.ClientRunner;
import other.IdGernerateServiceImpl;
import other.LabelType;
import other.RoomType;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelTester {

	ClientRunner clien = new ClientRunner();
	Hotel_blservice ho = new Hotel_bl();
 	@Test
	public void test001addHotel(){
		HotelInfoVO hotelInfoVO = new HotelInfoVO();
		
		
		
		LabelVO labelVO = new LabelVO();
		labelVO.setHotelId(hotelInfoVO.getHotelID());
		labelVO.setLabel(LabelType.CHEAP);
		LabelVO labelVO2 = new LabelVO();
		labelVO2.setHotelId(hotelInfoVO.getHotelID());
		labelVO2.setLabel(LabelType.NICE);
		ArrayList<LabelVO> arrayList = new ArrayList<LabelVO>();
		arrayList.add(labelVO2);
		arrayList.add(labelVO);
		
		
		HotelStrategyVO strategyVO = new HotelStrategyVO();
		strategyVO.setHotelId(hotelInfoVO.getHotelID());
		strategyVO.setStrategyInfo("��   ����    �� ������������");
		strategyVO.setStrategyName("da  zhe ");
		HotelStrategyVO strategyVO1 = new HotelStrategyVO();
		strategyVO1.setHotelId(hotelInfoVO.getHotelID());
		strategyVO1.setStrategyName("man   jianl e");
		strategyVO1.setStrategyInfo(" mam adajkdha kjdha ");
		
		
		ArrayList<HotelStrategyVO> hotelStrategyVOs = new 
				ArrayList<HotelStrategyVO>();
		hotelStrategyVOs.add(strategyVO1);
		hotelStrategyVOs.add(strategyVO);
		
		ArrayList<AssementVO> arrayList2 = new ArrayList<AssementVO>();
		AssementVO  assementVO = new AssementVO();
		assementVO.setHotelId(hotelInfoVO.getHotelID());
		assementVO.setOrderId(IdGernerateServiceImpl.gernerateId());
		arrayList2.add(assementVO);
		
		
		ArrayList<OrderVO> rOrderVOs = new ArrayList<OrderVO>();
		OrderVO orderVO = new OrderVO();
		orderVO.setHotelID(hotelInfoVO.getHotelID());
		rOrderVOs.add(orderVO);
		
		ArrayList<HotelRoomInfoVO> roomInfoVOs = new ArrayList<HotelRoomInfoVO>();
		
		
		HotelRoomInfoVO roomInfoVO = new  HotelRoomInfoVO();
		roomInfoVO.setHotelid(hotelInfoVO.getHotelID());
		roomInfoVO.setRoomType(RoomType.bigBedRoom);
		roomInfoVO.setRoomNum(20);
		roomInfoVO.setRoomPrice(200);
		roomInfoVO.setRoomRemain(20);
		HotelRoomInfoVO roomInfoVO1 = new HotelRoomInfoVO();
		roomInfoVO1.setHotelid(hotelInfoVO.getHotelID());
		roomInfoVO.setRoomType(RoomType.multiPersonRoom);
		roomInfoVO.setRoomNum(13);
		roomInfoVO.setRoomPrice(600);
		roomInfoVO.setRoomRemain(6);
		roomInfoVOs.add(roomInfoVO1);
		roomInfoVOs.add(roomInfoVO);
		
		
		hotelInfoVO.setAssmentVOs(arrayList2);
		hotelInfoVO.setLabelList(arrayList);
		hotelInfoVO.setRooms(roomInfoVOs);
		hotelInfoVO.setOrderVOs(rOrderVOs);
		hotelInfoVO.setHotelStrategy(hotelStrategyVOs);
		hotelInfoVO.setHotelAddress("�Ͼ�");
		hotelInfoVO.setHotelDiscription("�Ƶ���Ǻ���������һ����һ��ס");
		hotelInfoVO.setRank("3");
		hotelInfoVO.setHotelDistrict("����У��");
		hotelInfoVO.setHotelName("�����Ƶ�");
		assertEquals(true,ho.addHotel(hotelInfoVO));
	}
 	
 	@Test
 	public void test002modify(){
 		HotelInfoVO hotelInfoVO = ho.getHotelInfo("471");
// 		hotelInfoVO.setHotelAddress("���ݹ�԰��");
// 		ho.modifyHotelInfo(hotelInfoVO);
 		assertEquals("�Ͼ�", hotelInfoVO.getHotelAddress());
 	}
	
}
