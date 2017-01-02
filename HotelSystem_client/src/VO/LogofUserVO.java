package VO;

import java.time.LocalDateTime;

import PO.LogofUserPO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import other.IdGernerateServiceImpl;
import util.DateUtil;

public class LogofUserVO {

	private String id;
	private LocalDateTime dateTime;
	private String content;
	private int change;
	private String userid;

	public LogofUserVO() {
		this.id = IdGernerateServiceImpl.gernerateId();
	}

	public LogofUserVO(LogofUserPO po) {
		super();
		this.id = po.getId();
		this.change = po.getChang();
		this.content = po.getContent();
		this.userid = po.getUserid();
		this.dateTime = po.getDateTime();
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getContent() {
		return content;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	public StringProperty gettimeProperty() {
		return new SimpleStringProperty(DateUtil.format(dateTime));
	}

	public StringProperty getDiscProperty() {
		return new SimpleStringProperty(content);
	}

	public StringProperty getChangeProperty() {
		String chan = new String();
		if (change > 0) {
			chan = "Ôö¼Ó";
		} else {
			chan = "¿Û³ý";
		}
		return new SimpleStringProperty(chan + (int) (Math.abs(change)));
	}

}
