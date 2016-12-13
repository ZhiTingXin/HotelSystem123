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
	 * price 房间的单价
	 * type 房间的类型
	 * hotelId 房间所属的酒店的id
	 * number 房间的数量
	 * id 存储时用作主键
	 */
	private int price;
	private int remain;
	private RoomType type;
	private String hotelId;
	private int number;
	private String id;
	
	//room 的构造方法
	public RoomPO(){}
	public RoomPO(int pric,RoomType type,String hotelid,int number,int remain){
		super();
		this.price = pric;
		this.hotelId = hotelid;
		this.remain = remain;
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
	
	@Id
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
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	
}
