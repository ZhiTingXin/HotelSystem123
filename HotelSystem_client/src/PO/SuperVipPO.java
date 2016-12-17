package PO;

import VO.VipVO;

public class SuperVipPO {

	private String id;
	private int Vipgrade;//
	private double discount;
	private String district;// …Ã»¶

	public SuperVipPO(VipVO vipVO){
		super();
		this.id = vipVO.getId();
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
