package PO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vip")
public class VipPO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mincredit;
    private int maxcredit;
    private int Vipgrade;
    private double discount;
    public VipPO(){}
  
	public int getMincredit() {
		return mincredit;
	}
	public void setMincredit(int mincredit) {
		this.mincredit = mincredit;
	}
	public int getMaxcredit() {
		return maxcredit;
	}
	public void setMaxcredit(int maxcredit) {
		this.maxcredit = maxcredit;
	}
	@Id
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
    
    
}
