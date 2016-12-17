package VO;

import PO.SuperVipPO;
import PO.VipPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;

public class VipVO {

    private String id;
	private int minCredit;
	private int maxCredit;
	private int Vipgrade;//
	private double discount;
	private String district;//商圈
	
	//会员
	public VipVO(int min, int max, int gr, double disc) {
		super();
		this.minCredit = min;
		this.maxCredit = max;
		this.Vipgrade = gr;
		this.discount = disc;
	}
	public VipVO(){
		this.id = IdGernerateServiceImpl.gernerateId();
	}
	
	//VIP 会员
	public VipVO(SuperVipPO superVipPO) {
		super();
		this.district = superVipPO.getDistrict();
		this.Vipgrade = superVipPO.getVipgrade();
		this.discount =superVipPO.getDiscount();
	}
	
	public VipVO(VipPO vipPO) {
		this.maxCredit = vipPO.getMaxcredit();
		this.minCredit = vipPO.getMincredit();
		this.discount = vipPO.getDiscount();
		this.Vipgrade = vipPO.getVipgrade();
	}

	public int getMincredit() {
		return minCredit;
	}

	public void setMincredit(int mincredit) {
		this.minCredit = mincredit;
	}

	public int getMaxcredit() {
		return maxCredit;
	}

	public void setMaxcredit(int maxcredit) {
		this.maxCredit = maxcredit;
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
	
	// ui属性-------------------分割线---------------------
	// 折扣力度(一位小数表示)
	public StringProperty getDiscountProperty() {
		return new SimpleStringProperty(String.valueOf(discount));
	}
	//会员等级
	public StringProperty getMemberGradeProperty() {
		return new SimpleStringProperty(String.valueOf(Vipgrade));
	}

	public StringProperty getMaxCreditProperty() {
		return new SimpleStringProperty(String.valueOf(maxCredit));
	}
	
	public StringProperty getMinCreditProperty(){
		return new SimpleStringProperty(String.valueOf(minCredit));
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	public StringProperty getDistrictProperty() {
		return new SimpleStringProperty(district);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
