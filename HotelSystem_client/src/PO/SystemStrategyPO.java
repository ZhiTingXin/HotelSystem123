package PO;

import java.time.LocalDate;
import VO.SystemStrategyVO;
import other.StrategyState;
import other.SystemStrategyType;

public class SystemStrategyPO {

	private String systemStrategy_name;
	private String systemStaffId;
    private double discount;
    private LocalDate begin_date;
    private LocalDate end_date;
    private String systemStrategyDescription;
    private SystemStrategyType strategyType;
    private StrategyState state;
    public SystemStrategyPO(){
    }
    public SystemStrategyPO(SystemStrategyVO systemStrategyVO){
    	super();
    	this.systemStrategy_name = systemStrategyVO.getSystemStrategyName();
    	this.systemStaffId = systemStrategyVO.getSystemStaffID();
    	this.discount = systemStrategyVO.getDiscount();
    	this.begin_date = systemStrategyVO.getBegin_Date();
    	this.end_date = systemStrategyVO.getEnd_Date();
    	this.state = systemStrategyVO.getStrategyState();
    	this.strategyType = systemStrategyVO.getSystemStrategyType();
    	this.systemStrategyDescription = systemStrategyVO.getSystemStrategyDescription();
    }
    public SystemStrategyPO(String systemstrategy_name,double count,LocalDate begin,LocalDate end,String systemStaffID){
    	this.systemStrategy_name=systemstrategy_name;
    	this.discount = count;
    	this.begin_date = begin;
    	this.end_date =end;
    	this.systemStaffId = systemStaffID;
    }
    
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
	public String getSystemStaffId() {
		return systemStaffId;
	}
	public void setSystemStaffId(String systemStaffId) {
		this.systemStaffId = systemStaffId;
	}
	public SystemStrategyType getStrategyType() {
		return strategyType;
	}
	public void setStrategyType(SystemStrategyType strategyType) {
		this.strategyType = strategyType;
	}
	public StrategyState getState() {
		return state;
	}
	public void setState(StrategyState state) {
		this.state = state;
	}
	public String getSystemStrategyDescription() {
		return systemStrategyDescription;
	}
	public void setSystemStrategyDescription(String systemStrategyDescription) {
		this.systemStrategyDescription = systemStrategyDescription;
	}

}
