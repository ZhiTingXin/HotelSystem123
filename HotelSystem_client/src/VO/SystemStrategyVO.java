package VO;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.StrategyState;
import other.SystemStrategyType;
import other.memberState;

/**
 * 网站营销策略的名称 网站营销策略的内容 制定网站营销策略的网站营销人员的id 网站营销策略的开始时间 网站营销策略的结束时间
 * 
 * @author zhiting Xin
 *
 */
public class SystemStrategyVO {

	private String systemStaffID;
	private String systemStrategyName;
	private SystemStrategyType systemStrategyType;
	private String systemStrategyDescription;
	private StrategyState strategyState;
	private double discount;//节日优惠的折扣
	// 节日优惠
	private LocalDate begin_date;
	private LocalDate end_date;
	// 会员优惠
	private memberState memberState;

	// public SystemStrategyVO(SystemStrategyPO systemstrategypo){
	// super();
	// this.systemStrategy_name = systemstrategypo.getSystemStrategy_name();
	// this.discount = systemstrategypo.getDiscount();
	// this.begin_date = systemstrategypo.getBegin_date();
	// this.end_date = systemstrategypo.getEnd_date();
	// this.systemStaffID = systemstrategypo.getSystemStaffId();
	// }
	//

	// 节日优惠的VO的构造函数
	public SystemStrategyVO(String strategyName, String strategyDsciption, LocalDate startDate, LocalDate endDate,
			double discount, StrategyState state) {

		this.systemStrategyName = strategyName;
		this.systemStrategyDescription = strategyDsciption;
		this.begin_date = startDate;
		this.end_date = endDate;
		this.discount = discount;
		this.strategyState = state;
	}

	//会员优惠VO构造函数
	public SystemStrategyVO(String strategyName, String strategyDsciption,StrategyState state){
		this.systemStrategyName = strategyName;
		this.systemStrategyDescription = strategyDsciption;
		this.strategyState =  state;
	}
	//其他优惠构造函数
	public SystemStrategyVO(String strategyName, String strategyDsciption,double discount,StrategyState state){
		this.systemStrategyName = strategyName;
		this.systemStrategyDescription = strategyDsciption;
		this.discount = discount;
		this.strategyState =  state;
		
	}
	public double getDiscount() {
		return this.discount;
	}

	public LocalDate getBegin_Date() {
		return begin_date;
	}

	public String getSystemStaffID() {
		return this.systemStaffID;
	}

	public LocalDate getEnd_Date() {
		return end_date;
	}

	public String getSystemStrategyDescription() {
		return systemStrategyDescription;
	}

	public void setSystemStrategyDescription(String systemStrategyDescription) {
		this.systemStrategyDescription = systemStrategyDescription;
	}

	public String getSystemStrategyName() {
		return systemStrategyName;
	}

	public void setSystemStrategyName(String systemStrategyName) {
		this.systemStrategyName = systemStrategyName;
	}

	public SystemStrategyType getSystemStrategyType() {
		return systemStrategyType;
	}

	public void setSystemStrategyType(SystemStrategyType systemStrategyType) {
		this.systemStrategyType = systemStrategyType;
	}

	public StrategyState getStrategyState() {
		return strategyState;
	}

	public void setStrategyState(StrategyState strategyState) {
		this.strategyState = strategyState;
	}
	
	public memberState getMemberState() {
		return memberState;
	}

	public void setMemberState(memberState memberState) {
		this.memberState = memberState;
	}
	
	// ui属性-------------------分割线---------------------
	public StringProperty getStrategyNameProperty() {
		return new SimpleStringProperty(this.systemStrategyName);
	}

	public StringProperty getStrategyDescriptionProperty() {
		return new SimpleStringProperty(this.systemStrategyDescription);
	}

	// 策略状态
	public StringProperty getStrategyStateProperty() {
		if (systemStrategyType == null) {
			return null;
		} else {
			if (systemStrategyType.equals(StrategyState.open)) {
				return new SimpleStringProperty("启用");
			} else {
				return new SimpleStringProperty("禁用");
			}
		}
	}

	public StringProperty getDiscountForHolidayProperty(){
		return new SimpleStringProperty(String.valueOf(this.discount));
	}
}

