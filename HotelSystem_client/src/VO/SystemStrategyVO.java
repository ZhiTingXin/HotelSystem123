package VO;

import java.time.LocalDate;

import PO.SystemStrategyPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.MenuButton;
import other.StrategyState;
import other.SystemStrategyType;
import other.memberState;

/**
 * ��վӪ�����Ե����� ��վӪ�����Ե����� �ƶ���վӪ�����Ե���վӪ����Ա��id ��վӪ�����ԵĿ�ʼʱ�� ��վӪ�����ԵĽ���ʱ��
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
	private double discount;//�����Żݵ��ۿ�
	// �����Ż�
	private LocalDate begin_date;
	private LocalDate end_date;
	// ��Ա�Ż�
	private memberState memberState;
    //PO��Vo�Ĺ��췽��
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

	// �����Żݵ�VO�Ĺ��캯��
	public SystemStrategyVO(String strategyName, String strategyDsciption, LocalDate startDate, LocalDate endDate,
			double discount, StrategyState state) {

		this.systemStrategyName = strategyName;
		this.systemStrategyDescription = strategyDsciption;
		this.begin_date = startDate;
		this.end_date = endDate;
		this.discount = discount;
		this.strategyState = state;
	}
	
	//��Ա�Ż�VO���캯��
	public SystemStrategyVO(String strategyName, String strategyDsciption,StrategyState state){
		this.systemStrategyName = strategyName;
		this.systemStrategyDescription = strategyDsciption;
		this.strategyState =  state;
	}
	//�����Żݹ��캯��
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
	
	// ui����-------------------�ָ���---------------------
	public StringProperty getStrategyNameProperty() {
		return new SimpleStringProperty(this.systemStrategyName);
	}

	public StringProperty getStrategyDescriptionProperty() {
		return new SimpleStringProperty(this.systemStrategyDescription);
	}

	// ����״̬
	public StringProperty getStrategyStateProperty() {
		if (systemStrategyType == null) {
			return null;
		} else {
			if (systemStrategyType.equals(StrategyState.open)) {
				return new SimpleStringProperty("����");
			} else {
				return new SimpleStringProperty("����");
			}
		}
	}

	public StringProperty getDiscountForHolidayProperty(){
		return new SimpleStringProperty(String.valueOf(this.discount));
	}
}

