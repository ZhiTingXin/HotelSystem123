package blservice.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.HotelPO;
import PO.OrderPO;
import PO.RoomPO;
import RMI.RemoteHelper;
import VO.AssementVO;
import VO.HotelInfoVO;
import VO.HotelRoomInfoVO;
import blservice.Assessment_blService;
import blservice.Hotel_blservice;
import blservice.Room_blService;
import data.service.HotelDataService;
import data.service.OrderDataService;
import other.OrderState;

public class Hotel_bl implements Hotel_blservice {

	OrderDataService orderDataService = RemoteHelper.getInstance().getOrderDataService();
	HotelDataService dataService = RemoteHelper.getInstance().getHotelDataService();

	/**
	 * 
	 * @param hotelId
	 * @return ͨ��hotel��id�������Ƶ�
	 */

	public HotelInfoVO getHotelInfo(String hotelId) {
		try {
			/*
			 * �õ�PO
			 */
			HotelPO hotelPO = dataService.find(hotelId);
			HotelInfoVO hotelVO = new HotelInfoVO(hotelPO);
			return hotelVO;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param hotelInfo
	 * @return �޸ľƵ����Ϣ�������Ƿ�ɹ��޸ľƵ����Ϣ
	 */
	public boolean modifyHotelInfo(HotelInfoVO hotelInfo) {
		HotelPO hotelPO = new HotelPO(hotelInfo);
		try {
			boolean a = dataService.update(hotelPO);
			return a;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param strict
	 * @return ������Ȧ�ڵ�ȫ���Ƶ�
	 */
	public ArrayList<HotelInfoVO> getListOfHotel(String strict) {

		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
		try {
			ArrayList<HotelPO> poList = dataService.getHotels(strict);
			for (HotelPO po : poList) {
				hotelInfoVOs.add(new HotelInfoVO(po));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hotelInfoVOs;
	}

	/**
	 * 
	 * @return �������еľƵ����Ϣ
	 */
	@Override
	public ArrayList<HotelInfoVO> getAllHotel() {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
		try {
			ArrayList<HotelPO> hotelPOs = dataService.getAllHotels();
			for (HotelPO po : hotelPOs) {
				hotelInfoVOs.add(new HotelInfoVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelInfoVOs;
	}

	/**
	 * 
	 * @param hotel
	 * @return ��ӾƵ���Ϣ�������Ƿ���ӳɹ�
	 */
	public boolean addHotel(HotelInfoVO hotel) {
		HotelPO hotelPO = new HotelPO(hotel);
		try {
			dataService.add(hotelPO);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param userId�û�id
	 * @return ֮ǰ�û������ס�ľƵ�
	 */
	public ArrayList<HotelInfoVO> getListOfHotelPrefer(String userId) {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
		try {
			ArrayList<OrderPO> orderPOList = (ArrayList<OrderPO>) orderDataService.findOrders(userId, "userId");
			// ������ɵĶ���
			for (OrderPO po : orderPOList) {
				if (po.getStatus().equals(OrderState.FINISHED) || po.getStatus().equals(OrderState.ASSESSED)) {

					HotelInfoVO hotelInfoVO = getHotelInfo(po.getHotelId());
					boolean exist = false;
					for (int count = 0; count < hotelInfoVOs.size(); count++) {
						if (hotelInfoVOs.get(count).getHotelID().equals(hotelInfoVO.getHotelID())) {
							exist = true;
							break;
						}

					}
					if (exist == false) {
						hotelInfoVOs.add(hotelInfoVO);
					}
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelInfoVOs;
	}

	/**
	 * 
	 * @param text���ݾƵ����Ƶ��ֶ������Ƶ�
	 * 
	 * @return �������оƵ������к��и��ֶεľƵ�
	 */

	public ArrayList<HotelInfoVO> getHotelFromName(String text) {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
		try {
			ArrayList<HotelPO> hotelPOs = dataService.getAllHotels();
			if (!text.equals("")) {
				for (HotelPO po : hotelPOs) {
					char[] ch = text.toCharArray();
					for (char ch1 : ch) {
						if (po.getHotelName().contains(String.valueOf(ch1))) {
							HotelInfoVO hotelInfoVO = getHotelInfo(po.getHotelId());
							hotelInfoVOs.add(hotelInfoVO);
							break;
						}
					}
				}
			} else {
				for (HotelPO po : hotelPOs) {
					hotelInfoVOs.add(getHotelInfo(po.getHotelId()));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelInfoVOs;
	}

	public static String getHotelName(String hotelID) {
		Hotel_bl hotel_bl = new Hotel_bl();
		HotelInfoVO hotel = hotel_bl.getHotelInfo(hotelID);
		return hotel.getHotelName();
	}

	/**
	 * 
	 * @param �Ƶ���Ǽ�
	 * @return ���з��������ľƵ�
	 */
	public ArrayList<HotelInfoVO> getHotelFromGrade(ArrayList<HotelInfoVO> list, int grade) {
		if (grade == 0) {
			return list;
		}
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
		try {
			for (HotelInfoVO vo : list) {
				String gradeText = this.getHotelGrade(vo.getHotelID());
				if (!gradeText.equals("��������")) {
					if (grade == 5) {
						if (Double.valueOf(gradeText) >= grade - 0.2) {
							hotelInfoVOs.add(vo);
						}
					} else if (Double.valueOf(gradeText) >= grade) {
						hotelInfoVOs.add(vo);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hotelInfoVOs;
	}

	/**
	 * 
	 * @param minPrice
	 * @param maxPrice
	 * @return ���ڼ�λ�������Χ�ڵ����оƵ�
	 */
	public ArrayList<HotelInfoVO> getHotelFromPrice(ArrayList<HotelInfoVO> list, int minPrice, int maxPrice) {
		ArrayList<HotelInfoVO> hotelInfoVOs = new ArrayList<HotelInfoVO>();
		try {
			for (HotelInfoVO vo : list) {
				ArrayList<RoomPO> roomInfo = RemoteHelper.getInstance().getRoomDataService()
						.getAllRoomPO(vo.getHotelID());
				for (RoomPO po : roomInfo) {
					if (po.getPrice() <= maxPrice && po.getPrice() >= minPrice) {
						hotelInfoVOs.add(vo);
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hotelInfoVOs;
	}

	/**
	 * @param �ж���Ϣ�Ƿ�����
	 * @return �����ǻ��߷�
	 */
	public boolean HotelInfoCompletedComfirm(HotelInfoVO hotel) {

		Room_blService roomService = new Room_blServiceImpl();
		ArrayList<HotelRoomInfoVO> roomData = roomService.getAllRoom(hotel.getHotelID());

		boolean isAddaressComplete = hotel.getHotelAddress() != null && !hotel.getHotelAddress().equals("");
		boolean isDescriptionComplete = hotel.getHotelDiscription() != null && !hotel.getHotelDiscription().equals("");
		boolean isRoomInfoOK = true;

		if (roomData.size() == 0) {
			isRoomInfoOK = false;
		} else {
			int count = 0;
			int zeroRoomTypeNum = 0;
			while (count < roomData.size()) {
				if (roomData.get(count).getRoomNum() == 0)
					zeroRoomTypeNum++;
				count++;
			}
			if (zeroRoomTypeNum == roomData.size()) {
				isRoomInfoOK = false;
			}
		}
		return isAddaressComplete && isDescriptionComplete && isRoomInfoOK;
	}

	public String getHotelGrade(String hotelID) {
		// TODO Auto-generated method stub
		Assessment_blService assessmentService = new Assessment_bl();
		ArrayList<AssementVO> assList = assessmentService.getAllHotelAss(hotelID);
		if (assList == null || assList.size() == 0) {
			return "��������";
		} else {
			double rank = 0;
			int sum = 0;
			int count = 0;
			while (count < assList.size()) {
				sum += assList.get(count).getRank();
				count++;
			}
			rank = sum / assList.size();
			return String.valueOf(rank);
		}
	}
}
