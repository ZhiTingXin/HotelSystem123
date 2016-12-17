package PO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="superVip")
public class SuperVipPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int Vipgrade;//
	private double discount;
	private String district;// …Ã»¶
	
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
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
