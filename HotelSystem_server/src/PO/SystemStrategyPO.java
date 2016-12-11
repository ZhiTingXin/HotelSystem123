package PO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import other.StrategyState;
import other.SystemStrategyType;

@Entity
@Table(name = "systemstrategy")
public class SystemStrategyPO {

	private String systemStrategy_name;
    private double discount;
    private Date begin_date;
    private Date end_date;
    private SystemStrategyType type;
    private StrategyState state;
    
    public SystemStrategyPO(){
    	super();
    }
    public SystemStrategyPO(String systemstrategy_name,double count,Date begin,Date end){
    	this.systemStrategy_name=systemstrategy_name;
    	this.discount = count;
    	this.begin_date = begin;
    	this.end_date =end;
    }
    
    @Id
	public String getSystemStrategy_name() {
		return systemStrategy_name;
	}
	
	public void setSystemStrategy_name(String systemStrategy_name) {
		this.systemStrategy_name = systemStrategy_name;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double count) {
		this.discount = count;
	}
	
	public Date getBegin_date() {
		return begin_date;
	}
	
	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}
	
	public Date getEnd_date() {
		return end_date;
	}
	
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public SystemStrategyType getType() {
		return type;
	}
	public void setType(SystemStrategyType type) {
		this.type = type;
	}
	public StrategyState getState() {
		return state;
	}
	public void setState(StrategyState state) {
		this.state = state;
	}

}
