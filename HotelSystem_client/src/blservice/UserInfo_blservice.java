package blservice;

import VO.CustomerVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;

//import VO.CustomerVO;
//import VO.SystemManagerVO;

public interface UserInfo_blservice {

	// public SystemManagerVO getSystemManagerInfo(String SystemManager_name);
	//
	// public boolean modifySystemManagerInfo(SystemManagerVO systemManager);
	//
	// public boolean CustomerinfoModify(CustomerVO Customer);
	//
	// public boolean CustomerinfoShow(CustomerVO Customer);
	// �û����ڸ�����Ϣ���޸�
	public boolean modifyCustomer(CustomerVO customerVO);

	// �Ƶ깤����Ա���ڸ�����Ϣ���޸�
	public boolean modifyHotelStaff(HotelStaffVO hotelStaffVO);

	// ������վӪ����Ա����Ϣ�޸�
	public boolean modifySystemStaff(SystemStaffVO systemStaffVO);

	// ������վ������Ա����Ϣ�޸�
	public boolean modifySystemManager(SystemManagerVO systemManagerVO);

	// �����޸�����ķ���
	public boolean modifyPassword(String userId, String password);
}
