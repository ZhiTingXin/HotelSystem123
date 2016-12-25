package PO;

import java.io.Serializable;

import VO.VipVO;

public class SuperVipPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int Vipgrade;//
	private double discount;
	private String city;
	private String district;// …Ã»¶

	public SuperVipPO(VipVO vipVO){
		super();
		this.id = vipVO.getId();
		this.city = vipVO.getCity();
		this.Vipgrade = vipVO.getVipgrade();
		this.discount = vipVO.getDiscount();
		this.district = vipVO.getDistrict();
	}
	public int getVipgrade() {
		return Vipgrade;
	}

	public void setVipgrade(int vipgrade) {
		Vipgrade = vipgrade;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
