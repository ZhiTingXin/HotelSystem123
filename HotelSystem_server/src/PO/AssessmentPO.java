package PO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AssessmentPO")
public class AssessmentPO {
	/*
	 * userId ���������û�id
	 * content ���۵���Ϣ
	 * type ���۵�����
	 * property ���۵�����
	 * hotelId �������ھƵ��id
	 */
	private String Orderid;
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
	@Id
	public String getOrderId() {
		return Orderid;
	}
	public void setOrderId(String id) {
		this.Orderid = id;
	}
	
}
