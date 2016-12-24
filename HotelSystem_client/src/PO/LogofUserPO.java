package PO;

import java.io.Serializable;
import java.time.LocalDateTime;

import VO.LogofUserVO;

public class LogofUserPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private LocalDateTime dateTime;
	private String content;
	private String userid;


	public LogofUserPO(LogofUserVO vo){
		super();
		this.id = vo.getId();
		this.content = vo.getContent();
		this.dateTime = vo.getDateTime();
		this.userid = vo.getUserid();
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
