package PO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import other.RoomType;


@Entity
@Table(name="room")
public class RoomPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * price ����ĵ���
	 * type ���������
	 * hotelId ���������ľƵ��id
	 * number ���������
	 * id �洢ʱ��������
	 */
	private int price;
	private RoomType type;
	private String hotelId;
	private int number;
	private int remainNum;
	@Id
	private String id;
	
	//room �Ĺ��췽��
	public RoomPO(){}
	public RoomPO(int pric,RoomType type,String hotelid,int number,int remain){
		super();
		this.remainNum = remain;
		this.price = pric;
		this.hotelId = hotelid;
		this.type = type;
		this.number = number;
		this.id = hotelid+type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RoomType getType() {
		return type;
	}
	public void setType(RoomType type) {
		this.type = type;
	}
	public int getRemainNum() {
		return remainNum;
	}
	public void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
	}
	
}
