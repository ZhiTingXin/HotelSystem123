package VO;

import java.time.LocalDateTime;

import PO.LogofUserPO;
import other.IdGernerateServiceImpl;

public class LogofUserVO {

	private String id;
	private LocalDateTime dateTime;
	private String content;
	private String userid;


	public LogofUserVO(){
		this.id = IdGernerateServiceImpl.gernerateId();
	}
	
	public LogofUserVO(LogofUserPO po){
		super();
		this.id = po.getId();
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
	
	
}
