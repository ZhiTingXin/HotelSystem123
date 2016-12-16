package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.AssessmentPO;
import PO.HotelPO;
import PO.HotelStaffPO;
import PO.HotelStrategyPO;
import PO.Label;
import PO.OrderPO;
import PO.RoomPO;
import RMI.RemoteHelper;
import VO.AssementVO;
import VO.HotelInfoVO;
import VO.HotelRoomInfoVO;
import VO.HotelStaffVO;
import VO.HotelStrategyVO;
import VO.LabelVO;
import VO.OrderVO;
import blservice.Hotel_blservice;
import data.service.AssessmentDataService;
import data.service.HotelDataService;
import data.service.HotelStrategyDataService;
import data.service.LabelDataService;
import data.service.OrderDataService;
import data.service.RoomDataService;
import other.OrderState;

public class Hotel_bl implements Hotel_blservice {

	AssessmentDataService assessmentDataService = RemoteHelper.getInstance().getAssessmentDataService();
	HotelDataService dataService = RemoteHelper.getInstance().getHotelDataService();
	RoomDataService roomDataService = RemoteHelper.getInstance().getRoomDataService();
	OrderDataService orderDataService = RemoteHelper.getInstance().getOrderDataService();
	HotelStrategyDataService hotelStrategyDataService = RemoteHelper.getInstance().getHotelStrategyDataService();
	LabelDataService labelDataService = RemoteHelper.getInstance().getLabelDataService();
	public HotelInfoVO getHotelInfo(String hotelId) {
		try {
			/*
			 * 得到PO
			 */
			HotelPO hotelPO = dataService.find(hotelId);
			System.out.println("1");
			ArrayList<HotelStrategyPO> hotelStrategyPOs = hotelStrategyDataService.getAll(hotelId);
			System.out.println("2");
//			ArrayList<OrderPO> orderPOs = orderDataService.getAllHotelOrders(hotelId);
			System.out.println("3");
			ArrayList<Label> labels = labelDataService.getLabels(hotelId);
			System.out.println("4");
			ArrayList<RoomPO> roomPOs = roomDataService.getAllRoomPO(hotelId);
			System.out.println("5");
			ArrayList<AssessmentPO> assementPOs = assessmentDataService.getAllAssement(hotelId);
			System.out.println("100");
			ArrayList<HotelStrategyVO> hotelStrategyVOs = new ArrayList<HotelStrategyVO>();
			ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
			ArrayList<HotelRoomInfoVO> roomInfoVOs = new ArrayList<HotelRoomInfoVO>();
			ArrayList<AssementVO> arrayList = new ArrayList<AssementVO>();
			ArrayList<LabelVO> labelVOs = new ArrayList<LabelVO>();
			
		
			for(HotelStrategyPO hotelStrategyPO:hotelStrategyPOs){
				hotelStrategyVOs.add(new HotelStrategyVO(hotelStrategyPO));
			}
			
			for(RoomPO room:roomPOs){
				roomInfoVOs.add(new HotelRoomInfoVO(room));
			}
			
//			for(OrderPO po:orderPOs){
//				orderVOs.add(new OrderVO(po));
//			}
			
			for(AssessmentPO assessmentPO:assementPOs){
				arrayList.add(new AssementVO(assessmentPO));
			}
			for(Label po:labels){
				labelVOs.add(new LabelVO(po));
			}
			HotelInfoVO hotelVO = new HotelInfoVO(hotelPO, orderVOs, hotelStrategyVOs, roomInfoVOs, labelVOs,arrayList);
			return hotelVO;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean modifyHotelInfo(HotelInfoVO hotelInfo){
		HotelPO hotelPO = new HotelPO(hotelInfo);
		/*
		 * 得到VO
		 */
		ArrayList<OrderVO> orderVOs = hotelInfo.getOrderVOs();
		ArrayList<HotelRoomInfoVO> roomInfoVOs = hotelInfo.getRooms();
		ArrayList<HotelStrategyVO> hotelStrategyVOs = hotelInfo.getHotelStrategy();
		ArrayList<LabelVO> labels = hotelInfo.getLabelList();
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
				RoomPO roomPO = new RoomPO(room);
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
			boolean lab = true;
			ArrayList<Label> lArrayList = labelDataService.getLabels(hotelInfo.getHotelID());
			for(LabelVO label:labels){
				boolean in = false;
				for(Label po:lArrayList){
					if(label.getId()==po.getId()){
						in = true;
						break;
					}
				}
				if(in){
				}else{
					lab = lab &&labelDataService.addLabel(new Label(label));
				}
			}
			for(Label po:lArrayList){
				boolean in =false;
				for(LabelVO labelVO:labels){
					if(labelVO.getId()==po.getId()){
						in = true;
						break;
					}
				}
				if(!in){
					lab = lab&&labelDataService.delLabel(po);
				}
			}
			return (order&&a&&lab&&strategy&&roo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<HotelInfoVO> getListOfHotel(String strict) {
		/*
		 * 先查找所有的商圈的hotelPO对象，根据PO对象中的hotelid查找其他的表来构造vo对象
		 */
		ArrayList<HotelPO> poList = null; 
		try {
			ArrayList<HotelStrategyVO> hotelStrategyVOs = new ArrayList<HotelStrategyVO>();
			ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();
			ArrayList<HotelRoomInfoVO> roomInfoVOs = new ArrayList<HotelRoomInfoVO>();
			ArrayList<AssementVO> assementVOs = new ArrayList<AssementVO>();
			ArrayList<LabelVO> labelVOs = new ArrayList<LabelVO>();
			poList = dataService.getHotels(strict);
			
		    ArrayList<HotelInfoVO> voList = new ArrayList<HotelInfoVO>();
		    for(int i=0;i<poList.size();i++){
			    HotelPO hotelPO = poList.get(i);
			    String hotelid = hotelPO.getHotelId();
			    ArrayList<OrderPO> orderPOs = orderDataService.getAllHotelOrders(hotelid);
			    ArrayList<HotelStrategyPO> hotelStrategyPOs = hotelStrategyDataService.getAll(hotelid);
			    ArrayList<RoomPO> roomPOs = roomDataService.getAllRoomPO(hotelid);
			    ArrayList<AssessmentPO> assessmentPOs = assessmentDataService.getAllAssement(hotelid);
			    ArrayList<Label> labels = labelDataService.getLabels(hotelid);
			    
			    
			    for(OrderPO orderPO : orderPOs){
			    	orderVOs.add(new OrderVO(orderPO));
			    }
			    for(HotelStrategyPO strategyPO:hotelStrategyPOs){
			    	hotelStrategyVOs.add(new HotelStrategyVO(strategyPO));
			    }
			    for(RoomPO roomPO :roomPOs){
			    	roomInfoVOs.add(new HotelRoomInfoVO(roomPO));
			    }
			    for(AssessmentPO assessmentPO:assessmentPOs){
			    	assementVOs.add(new AssementVO(assessmentPO));
			    }
			    for(Label label:labels){
			    	labelVOs.add(new LabelVO(label));
			    }
			    HotelInfoVO hotelInfoVO = new HotelInfoVO(hotelPO, orderVOs, hotelStrategyVOs, roomInfoVOs, labelVOs,assementVOs);
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
		ArrayList<LabelVO> labels = hotel.getLabelList();
		ArrayList<AssementVO> assementVOs = hotel.getAssmentVOs();
		try {
			boolean a = dataService.add(hotelPO);
			
			boolean as = true;
			for(AssementVO assementVO:assementVOs){
				as = as&&assessmentDataService.addAssessment(new AssessmentPO(assementVO));
			}
			boolean order = true;
			for(OrderVO ordervo:orderVOs){
				OrderPO orderPO = new OrderPO(ordervo);
				boolean b = orderDataService.add(orderPO);
				order = order&&b;
			}
			boolean roo = true;
			for(HotelRoomInfoVO room:roomInfoVOs){
				RoomPO roomPO = new RoomPO(room);
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
			
			boolean lab = true;
			for(LabelVO label:labels){
				lab = lab&&labelDataService.addLabel(new Label(label));
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
