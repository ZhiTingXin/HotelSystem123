package PO;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import other.StrategyState;
import other.SystemStrategyType;

@Entity
@Table(name = "systemstrategy")
public class SystemStrategyPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String systemStrategy_name;
    private double discount;
    private LocalDate begin_date;
    private LocalDate end_date;
    private SystemStrategyType type;
    private StrategyState state;
    
    public SystemStrategyPO(){
    	super();
    }
    public SystemStrategyPO(String systemstrategy_name,double count,LocalDate begin,LocalDate end){
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
	
	public LocalDate getBegin_date() {
		return begin_date;
	}
	
	public void setBegin_date(LocalDate begin_date) {
		this.begin_date = begin_date;
	}
	
	public LocalDate getEnd_date() {
		return end_date;
	}
	
	public void setEnd_date(LocalDate end_date) {
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
