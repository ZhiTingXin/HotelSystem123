package VO;

import java.time.LocalDate;

import PO.AdviceFeedBackPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.AdviceFeedBackState;
import other.IdGernerateServiceImpl;

public class AdviceFeedBackVO {

	private AdviceFeedBackState state;
	private String AdviceFeedBack_content;
	private String AdviceId;
	private LocalDate sendTime;
	private LocalDate replyTime;
	private String replyContent;
    private String userID;
	public AdviceFeedBackVO() {
		super();
		this.AdviceId = IdGernerateServiceImpl.gernerateId();
	}
	public AdviceFeedBackVO(AdviceFeedBackPO advicefeedbackpo) {
		super();
		this.sendTime = advicefeedbackpo.getSenddate();
		this.replyContent = advicefeedbackpo.getReplycontent();
		this.replyTime = advicefeedbackpo.getReplydate();
		this.userID = advicefeedbackpo.getUserId();
		this.AdviceFeedBack_content = advicefeedbackpo.getAdviceFeedBack_content();
		this.state = advicefeedbackpo.getState();
		this.AdviceId = advicefeedbackpo.getAdviceId();
	}

	public AdviceFeedBackState getState() {
		return state;
	}
	public void setState(AdviceFeedBackState state) {
		this.state = state;
	}

	public String getAdviceFeedBack_content() {
		return AdviceFeedBack_content;
	}

	public void setAdviceFeedBack_content(String adviceFeedBack_content) {
		AdviceFeedBack_content = adviceFeedBack_content;
	}

	public String getAdviceId() {
		return AdviceId;
	}

	public LocalDate getSendTime() {
		return sendTime;
	}

	public void setSendTime(LocalDate sendTime) {
		this.sendTime = sendTime;
	}

	public LocalDate getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(LocalDate replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public StringProperty getSendTimeProperty() {
		return new SimpleStringProperty(this.sendTime.toString());
	}

	public StringProperty getReplyTimeProperty() {
		if (this.replyTime==null) {
			return new SimpleStringProperty("Î´»Ø¸´");
		}
		return new SimpleStringProperty(this.replyTime.toString());
	}

	public StringProperty getSendContentProperty() {
		return new SimpleStringProperty(this.AdviceFeedBack_content);
	}

	public StringProperty getReplyContentProperty() {
		return new SimpleStringProperty(this.replyContent);
	}
	

}
