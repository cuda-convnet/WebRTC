package com.webrtc.arti.domain;


import com.webrtc.arti.common.UserType;

/**
 * 自动总机会话类
 *
 */
public class Session {

	private String from; //用户名
	private String sessionID = ""; //会话的唯一标识
	
	private int eid; //企业号
	private int userType = UserType.CLIENT; //是否是客服
	private String servername = ""; //客服名称
	
	public Session(String from, String sessionID, int eid,int userType) {
		this.from = from;
		this.sessionID = sessionID;
		this.eid = eid;
		this.userType = userType;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}
}
