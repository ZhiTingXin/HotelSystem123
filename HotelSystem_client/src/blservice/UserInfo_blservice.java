package blservice;

import VO.CustomerVO;
import VO.HotelStaffVO;
import VO.SystemManagerVO;
import VO.SystemStaffVO;

public interface UserInfo_blservice {

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
