package VO;

import PO.AssessmentPO;

public class AssementVO {
	private String Orderid;
	private String userId;
	String content;
	String type;
	String hotelId;
	int rank;

	public AssementVO() {
	}

	public AssementVO(AssessmentPO assessmentPO) {
		this.Orderid = assessmentPO.getOrderId();
		this.userId = assessmentPO.getUserId();
		this.hotelId = assessmentPO.getHotelId();
		this.content = assessmentPO.getContent();
		this.type = assessmentPO.getType();
		this.rank = assessmentPO.getRank();
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

	public int getRank() {
		// TODO Auto-generated method stub
		return this.rank;
	}

	public void setRank(int rank) {
		// TODO Auto-generated method stub
		this.rank = rank;
	}
}
