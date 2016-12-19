package VO;

import java.time.LocalDate;

import PO.SystemStrategyPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;

import other.StrategyState;
import other.SystemStrategyType;

/**
 * 缃戠珯钀ラ攢绛栫暐鐨勫悕绉� 缃戠珯钀ラ攢绛栫暐鐨勫唴瀹� 鍒跺畾缃戠珯钀ラ攢绛栫暐鐨勭綉绔欒惀閿�浜哄憳鐨刬d 缃戠珯钀ラ攢绛栫暐鐨勫紑濮嬫椂闂� 缃戠珯钀ラ攢绛栫暐鐨勭粨鏉熸椂闂�
 * 
 * @author zhiting Xin
 *
 */
public class SystemStrategyVO {

	private String id;
	private String systemStaffID;
	private String systemStrategyName;
	private SystemStrategyType systemStrategyType;
	private String systemStrategyDescription;
	private StrategyState strategyState;
	private double discount;//鑺傛棩浼樻儬鐨勬姌鎵�
	// 鑺傛棩浼樻儬
	private LocalDate begin_date;
	private LocalDate end_date;
	
	public SystemStrategyVO(){
		super();
		this.id = IdGernerateServiceImpl.gernerateId();
	}
    //PO鍒癡o鐨勬瀯閫犳柟娉�
	public SystemStrategyVO(SystemStrategyPO strategypo){
		super();
		this.id = strategypo.getId();
		this.systemStaffID = strategypo.getSystemStaffId();
		this.systemStrategyName = strategypo.getSystemStrategy_name();
		this.systemStrategyType = strategypo.getStrategyType();
		this.begin_date = strategypo.getBegin_date();
		this.systemStrategyDescription = strategypo.getSystemStrategyDescription();
		this.strategyState = strategypo.getState();
		this.discount = strategypo.getDiscount();
		this.end_date =strategypo.getEnd_date();
	}

	
	public String getId() {
		return id;
	}
	public String getSystemStaffID() {
		return systemStaffID;
	}
	public String getSystemStrategyName() {
		return systemStrategyName;
	}
	public SystemStrategyType getSystemStrategyType() {
		return systemStrategyType;
	}
	public String getSystemStrategyDescription() {
		return systemStrategyDescription;
	}
	public StrategyState getStrategyState() {
		return strategyState;
	}
	public double getDiscount() {
		return discount;
	}
	public LocalDate getBegin_date() {
		return begin_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setSystemStaffID(String systemStaffID) {
		this.systemStaffID = systemStaffID;
	}
	public void setSystemStrategyName(String systemStrategyName) {
		this.systemStrategyName = systemStrategyName;
	}
	public void setSystemStrategyType(SystemStrategyType systemStrategyType) {
		this.systemStrategyType = systemStrategyType;
	}
	public void setSystemStrategyDescription(String systemStrategyDescription) {
		this.systemStrategyDescription = systemStrategyDescription;
	}
	public void setStrategyState(StrategyState strategyState) {
		this.strategyState = strategyState;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public void setBegin_date(LocalDate begin_date) {
		this.begin_date = begin_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	// ui灞炴��-------------------鍒嗗壊绾�---------------------
	public StringProperty getStrategyNameProperty() {
		return new SimpleStringProperty(this.systemStrategyName);
	}

	public StringProperty getStrategyDescriptionProperty() {
		return new SimpleStringProperty(this.systemStrategyDescription);
	}

	// 绛栫暐鐘舵��
	public StringProperty getStrategyStateProperty() {
		if (strategyState == null) {
			return null;
		} else {
			if (strategyState==(StrategyState.open)) {
				return new SimpleStringProperty("启用");
			} else {
				return new SimpleStringProperty("关闭");
			}
		}
	}

	public StringProperty getDiscountForHolidayProperty(){
		return new SimpleStringProperty(String.valueOf(this.discount));
	}
}

