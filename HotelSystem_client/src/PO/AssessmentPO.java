package PO;

public class AssessmentPO {
	/*
	 * userId 评价所属用户id
	 * content 评价的信息
	 * type 评价的类型
	 * property 评价的属性
	 * hotelId 对于所在酒店的id
	 */
	private String id;
	private String userId;
	String content;
	String type;
	String hotelId;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
