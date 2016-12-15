package VO;


import PO.Label;
import other.IdGernerateServiceImpl;
import other.LabelType;

public class LabelVO {
	private String hotelId;
	private LabelType label;
	private String id;
	public LabelVO(){
		id = IdGernerateServiceImpl.gernerateId();
	}
	public LabelVO(Label label){
		super();
		this.id = label.getId();
		this.label = label.getLabel();
		this.hotelId = label.getHotelId();
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
