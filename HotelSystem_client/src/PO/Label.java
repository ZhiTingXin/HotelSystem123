package PO;

import java.io.Serializable;

import other.LabelType;

public class Label implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userId;
	String hotelId;
	LabelType label;
	public Label(){}
	public Label(String userId,String hotelid,LabelType type){
		super();
		this.userId = userId;
		this.hotelId = hotelid;
		this.label = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public LabelType getLabel() {
		return label;
	}
	public void setLabel(LabelType label) {
		this.label = label;
	}
}
