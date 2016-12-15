package VO;

import PO.VipPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VipVO {

	private int minCredit;
	private int maxCredit;
	private int Vipgrade;//
	private double discount;

	public VipVO(int min, int max, int gr, double disc) {
		super();
		this.minCredit = min;
		this.maxCredit = max;
		this.Vipgrade = gr;
		this.discount = disc;
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
	
	// ui����-------------------�ָ���---------------------
	// �ۿ�����(һλС����ʾ)
	public StringProperty getDiscountProperty() {
		return new SimpleStringProperty(String.valueOf(discount));
	}
	//��Ա�ȼ�
	public StringProperty getMemberGradeProperty() {
		return new SimpleStringProperty(String.valueOf(Vipgrade));
	}

	public StringProperty getMaxCreditProperty() {
		return new SimpleStringProperty(String.valueOf(maxCredit));
	}
	
	public StringProperty getMinCreditProperty(){
		return new SimpleStringProperty(String.valueOf(minCredit));
	}
}
