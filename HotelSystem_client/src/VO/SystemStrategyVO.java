package VO;

import java.time.LocalDate;

import PO.SystemStrategyPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
<<<<<<< HEAD
import other.IdGernerateServiceImpl;
=======
import javafx.scene.control.MenuButton;
>>>>>>> refs/remotes/origin/é™ˆæ­¥å…µ
import other.StrategyState;
import other.SystemStrategyType;

/**
 * ÍøÕ¾ÓªÏú²ßÂÔµÄÃû³Æ ÍøÕ¾ÓªÏú²ßÂÔµÄÄÚÈİ ÖÆ¶¨ÍøÕ¾ÓªÏú²ßÂÔµÄÍøÕ¾ÓªÏúÈËÔ±µÄid ÍøÕ¾ÓªÏú²ßÂÔµÄ¿ªÊ¼Ê±¼ä ÍøÕ¾ÓªÏú²ßÂÔµÄ½áÊøÊ±¼ä
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
	private double discount;//½ÚÈÕÓÅ»İµÄÕÛ¿Û
	// ½ÚÈÕÓÅ»İ
	private LocalDate begin_date;
	private LocalDate end_date;
	
	public SystemStrategyVO(){
		super();
		this.id = IdGernerateServiceImpl.gernerateId();
	}
    //POµ½VoµÄ¹¹Ôì·½·¨
	public SystemStrategyVO(SystemStrategyPO strategypo){
		super();
		this.systemStaffID = strategypo.getSystemStaffId();
		this.systemStrategyName = strategypo.getSystemStrategy_name();
		this.systemStrategyType = strategypo.getStrategyType();
		this.begin_date = strategypo.getBegin_date();
		this.systemStrategyDescription = strategypo.getSystemStrategyDescription();
		this.strategyState = strategypo.getState();
		this.discount = strategypo.getDiscount();
		this.end_date =strategypo.getEnd_date();
	}
<<<<<<< HEAD
=======

	// ½ÚÈÕÓÅ»İµÄVOµÄ¹¹Ôìº¯Êı
	public SystemStrategyVO(String strategyName, String strategyDsciption, LocalDate startDate, LocalDate endDate,
			double discount, StrategyState state) {

		this.systemStrategyName = strategyName;
		this.systemStrategyDescription = strategyDsciption;
		this.begin_date = startDate;
		this.end_date = endDate;
		this.discount = discount;
		this.strategyState = state;
	}
	
	//»áÔ±ÓÅ»İVO¹¹Ôìº¯Êı
	public SystemStrategyVO(String strategyName, String strategyDsciption,StrategyState state){
		this.systemStrategyName = strategyName;
		this.systemStrategyDescription = strategyDsciption;
		this.strategyState =  state;
	}
	//ÆäËûÓÅ»İ¹¹Ôìº¯Êı
	public SystemStrategyVO(String strategyName, String strategyDsciption,double discount,StrategyState state){
		this.systemStrategyName = strategyName;
		this.systemStrategyDescription = strategyDsciption;
		this.discount = discount;
		this.strategyState =  state;
		
	}
>>>>>>> refs/remotes/origin/é™ˆæ­¥å…µ
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	// uiÊôĞÔ-------------------·Ö¸îÏß---------------------
	public StringProperty getStrategyNameProperty() {
		return new SimpleStringProperty(this.systemStrategyName);
	}

	public StringProperty getStrategyDescriptionProperty() {
		return new SimpleStringProperty(this.systemStrategyDescription);
	}

	// ²ßÂÔ×´Ì¬
	public StringProperty getStrategyStateProperty() {
		if (systemStrategyType == null) {
			return null;
		} else {
			if (systemStrategyType.equals(StrategyState.open)) {
				return new SimpleStringProperty("ÆôÓÃ");
			} else {
				return new SimpleStringProperty("½ûÓÃ");
			}
		}
	}

	public StringProperty getDiscountForHolidayProperty(){
		return new SimpleStringProperty(String.valueOf(this.discount));
	}
}

