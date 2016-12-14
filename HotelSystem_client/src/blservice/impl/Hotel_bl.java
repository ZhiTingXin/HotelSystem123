package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelPO;
import PO.HotelStaffPO;
import PO.HotelStrategyPO;
import PO.Label;
import PO.OrderPO;
import PO.RoomPO;
import RMI.RemoteHelper;
import VO.HotelInfoVO;
import VO.HotelRoomInfoVO;
import VO.HotelStaffVO;
import VO.HotelStrategyVO;
import VO.OrderVO;
import blservice.Hotel_blservice;
import data.service.HotelDataService;
import data.service.HotelStrategyDataService;
import data.service.OrderDataService;
import data.service.RoomDataService;
import other.OrderState;

public class Hotel_bl implements Hotel_blservice {

	HotelDataService dataService = RemoteHelper.getInstance().getHotelDataService();
	RoomDataService roomDataService = RemoteHelper.getInstance().getRoomDataService();
	OrderDataService orderDataService = RemoteHelper.getInstance().getOrderDataService();
	HotelStrategyDataService hotelStrategyDataService = RemoteHelper.getInstance().getHotelStrategyDataService();
	public HotelInfoVO getHotelInfo(String hotelId) {
		try {
			HotelPO hotelPO = dataService.find(hotelId);
			ArrayList<HotelStrategyPO> hotelStrategyPOs = hotelStrategyDataService.getAll(hotelId);
			ArrayList<OrderPO> orderPOs = orderDataService.getAllHotelOrders(hotelId);
			/*
			 * 目前底层还没有label的实现
			 */
			ArrayList<Label> labels = new ArrayList<Label>();
			ArrayList<RoomPO> roomPOs = roomDataService.getAllRoomPO(hotelId);
			ArrayList<HotelStrategyVO> hotelStrategyVOs = new ArrayList<HotelStrategyVO>();
			ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
			ArrayList<HotelRoomInfoVO> roomInfoVOs = new ArrayList<HotelRoomInfoVO>();
			for(HotelStrategyPO hotelStrategyPO:hotelStrategyPOs){
				hotelStrategyVOs.add(new HotelStrategyVO(hotelStrategyPO));
			}
			for(RoomPO room:roomPOs){
				roomInfoVOs.add(new HotelRoomInfoVO(room));
			}
			for(OrderPO po:orderPOs){
				orderVOs.add(new OrderVO(po));
			}
			HotelInfoVO hotelVO = new HotelInfoVO(hotelPO, orderVOs, hotelStrategyVOs, roomInfoVOs, labels);
			
			return hotelVO;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean modifyHotelInfo(HotelInfoVO hotelInfo){
		HotelPO hotelPO = new HotelPO(hotelInfo);
		ArrayList<OrderVO> orderVOs = hotelInfo.getOrderVOs();
		ArrayList<HotelRoomInfoVO> roomInfoVOs = hotelInfo.getRooms();
		ArrayList<HotelStrategyVO> hotelStrategyVOs = hotelInfo.getHotelStrategy();
		ArrayList<Label> labels = hotelInfo.getLabelList();
		try {
			boolean a = dataService.update(hotelPO);
			boolean order = true;
			for(OrderVO ordervo:orderVOs){
				OrderPO orderPO = new OrderPO(ordervo);
				boolean b = orderDataService.update(orderPO);
				order = order&&b;
			}
			boolean roo = true;
			for(HotelRoomInfoVO room:roomInfoVOs){
				RoomPO roomPO = new RoomPO(room,hotelInfo.getHotelID());
				boolean d = roomDataService.modify(roomPO);
				roo = roo&&d;
			}
			boolean strategy = true;
			for(HotelStrategyVO hotelStrategyVO: hotelStrategyVOs){
				HotelStrategyPO hotelStrategyPO = new 
						 HotelStrategyPO(hotelStrategyVO);
				boolean h = hotelStrategyDataService.modify(hotelStrategyPO);
				strategy = strategy&&h;
			}
			/*
			 * 没有label的dataservice
			 */
			
			// TODO Auto-generated method stub
			boolean lab = true;
			for(Label label:labels){
//				lab = lab&&;
			}
			return (order&&a&&lab&&strategy&&roo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<HotelInfoVO> getListOfHotel(String strict,String type) {
		/*
		 * 先查找所有的商圈的hotelPO对象，根据PO对象中的hotelid查找其他的表来构造vo对象
		 */
		ArrayList<HotelPO> poList = null; 
		try {
			ArrayList<HotelStrategyVO> hotelStrategyVOs = new ArrayList<HotelStrategyVO>();
			ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
			ArrayList<HotelRoomInfoVO> roomInfoVOs = new ArrayList<HotelRoomInfoVO>();
			poList = dataService.getHotels(strict, type);
		    ArrayList<HotelInfoVO> voList = new ArrayList<HotelInfoVO>();
		    for(int i=0;i<poList.size();i++){
			    HotelPO hotelPO = poList.get(i);
			    String hotelid = hotelPO.getHotelId();
			    ArrayList<OrderPO> orderPOs = orderDataService.getAllHotelOrders(hotelid);
			    ArrayList<HotelStrategyPO> hotelStrategyPOs = hotelStrategyDataService.getAll(hotelid);
			    ArrayList<RoomPO> roomPOs = roomDataService.getAllRoomPO(hotelid);
			    //TODO Auto-generated method stub
			    ArrayList<Label> labels = new ArrayList<Label>();
			    for(OrderPO orderPO : orderPOs){
			    	orderVOs.add(new OrderVO(orderPO));
			    }
			    for(HotelStrategyPO strategyPO:hotelStrategyPOs){
			    	hotelStrategyVOs.add(new HotelStrategyVO(strategyPO));
			    }
			    for(RoomPO roomPO :roomPOs){
			    	roomInfoVOs.add(new HotelRoomInfoVO(roomPO));
			    }
			    HotelInfoVO hotelInfoVO = new HotelInfoVO(hotelPO, orderVOs, hotelStrategyVOs, roomInfoVOs, labels);
		        voList.add(hotelInfoVO);
		     }
		    return voList;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addHotel(HotelInfoVO hotel) {
		HotelPO hotelPO = new HotelPO(hotel);
		ArrayList<OrderVO> orderVOs = hotel.getOrderVOs();
		ArrayList<HotelRoomInfoVO> roomInfoVOs = hotel.getRooms();
		ArrayList<HotelStrategyVO> hotelStrategyVOs = hotel.getHotelStrategy();
		ArrayList<Label> labels = hotel.getLabelList();
		try {
			boolean a = dataService.add(hotelPO);
			boolean order = true;
			for(OrderVO ordervo:orderVOs){
				OrderPO orderPO = new OrderPO(ordervo);
				boolean b = orderDataService.add(orderPO);
				order = order&&b;
			}
			boolean roo = true;
			for(HotelRoomInfoVO room:roomInfoVOs){
				RoomPO roomPO = new RoomPO(room,hotel.getHotelID());
				boolean d = roomDataService.addRoom(roomPO);
				roo = roo&&d;
			}
			boolean strategy = true;
			for(HotelStrategyVO hotelStrategyVO: hotelStrategyVOs){
				HotelStrategyPO hotelStrategyPO = new 
						 HotelStrategyPO(hotelStrategyVO);
				boolean h = hotelStrategyDataService.add(hotelStrategyPO);
				strategy = strategy&&h;
			}
			/*
			 * 没有label的dataservice
			 */
			
			// TODO Auto-generated method stub
			boolean lab = true;
			for(Label label:labels){
//				lab = lab&&;
			}
			return (order&&a&&lab&&strategy&&roo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addHotelStaff(HotelStaffVO hotelStaff) {
		HotelStaffPO hotelStaffPO = new HotelStaffPO(hotelStaff);
		try {
			return RemoteHelper.getInstance().getHotelStaffDataService().addStaff(hotelStaffPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<HotelInfoVO> getListOfHotelPrefer(String userId) {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
		try {
			ArrayList<OrderPO> orderPOList = (ArrayList<OrderPO>)orderDataService.findOrders(userId, "userId");
			//遍历完成的订单
			for(OrderPO po : orderPOList){
				if(po.getStatus().equals(OrderState.FINISHED)){
					HotelInfoVO hotelInfoVO = getHotelInfo(po.getHotelId());
					hotelInfoVOs.add(hotelInfoVO);
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		return hotelInfoVOs;
	}

	
	@Override
	public ArrayList<HotelInfoVO> getAllHotel() {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<>();
		try {
			ArrayList<HotelPO> hotelPOs = dataService.getAllHotels();
			for(HotelPO po : hotelPOs){
				HotelInfoVO hotelInfoVO = getHotelInfo(po.getHotelId());
				hotelInfoVOs.add(hotelInfoVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelInfoVOs;
	}

	@Override
	public ArrayList<HotelInfoVO> getHotelFromName(String text) {
		
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<>();
		try {
			ArrayList<HotelPO> hotelPOs = dataService.getAllHotels();
			for(HotelPO po : hotelPOs){
				if(po.getHotelName().contains(text)){
					HotelInfoVO hotelInfoVO = getHotelInfo(po.getHotelId());
					hotelInfoVOs.add(hotelInfoVO);
				}	
			}
			return hotelInfoVOs;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
