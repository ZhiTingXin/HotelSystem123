package PO;

import java.io.Serializable;

import VO.AssementVO;

public class AssessmentPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * userId ���������û�id
	 * content ���۵���Ϣ
	 * type ���۵�����
	 * property ���۵�����
	 * hotelId �������ھƵ��id
	 */
	private String Orderid;
	private String userId;
	private String content;
	private String type;
	private String hotelId;
	public AssessmentPO(AssementVO assementVO){
		Orderid = assementVO.getOrderId();
		userId =assementVO.getUserId();
		content =assementVO.getContent();
		type = assementVO.getType();
		hotelId = assementVO.getHotelId();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getOrderId() {
		return Orderid;
	}
	public void setOrderId(String id) {
		this.Orderid = id;
	}
	
}
