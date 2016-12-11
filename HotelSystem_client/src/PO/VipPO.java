package PO;

import VO.VipVO;

public class VipPO {
	 private int mincredit;
	    private int maxcredit;
	    private int Vipgrade;
	    private double discount;
	    public VipPO(){}
	    public VipPO(int min,int max,int gr,double disc){
	    	super();
	    	this.mincredit = min;
	    	this.maxcredit =max;
	    	this.Vipgrade = gr;
	    	this.discount =disc;
	    }
	    public VipPO(VipVO vipVO){
	    	super();
	    	this.maxcredit = vipVO.getMaxcredit();
	    	this.mincredit =vipVO.getMincredit();
	    	this.Vipgrade = vipVO.getVipgrade();
	    	this.discount = vipVO.getDiscount();
	    }
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
