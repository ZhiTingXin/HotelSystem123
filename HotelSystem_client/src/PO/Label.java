package PO;

import java.io.Serializable;

import VO.LabelVO;
import other.LabelType;

public class Label implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String hotelId;
	private LabelType label;
	public Label(){}
	public Label(LabelVO label){
		this.id = label.getId();
		this.hotelId = label.getHotelId();
		this.label = label.getLabel();
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
