package PO;

import VO.HotelRoomInfoVO;
import other.RoomType;
public class RoomPO {

	/*
	 * price 房间的单价
	 * type 房间的类型
	 * hotelId 房间所属的酒店的id
	 * number 房间的数量
	 * id 存储时用作主键
	 */
	private int price;
	private RoomType type;
	private String hotelId;
	private int number;
	private int remainNum;
	private String id;
	
	//room 的构造方法
	public RoomPO(){}
	public RoomPO(HotelRoomInfoVO hotel,String hotelId){
		this.price = hotel.getRoomPrice();
		this.hotelId = hotelId;
		this.type = hotel.getRoomType();
		this.number = hotel.getRoomNum();
		this.remainNum = hotel.getRoomRemain();
		this.id = hotelId+hotel.getRoomType();
	}
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
