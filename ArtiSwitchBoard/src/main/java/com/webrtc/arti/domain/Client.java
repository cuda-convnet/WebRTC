package com.webrtc.arti.domain;


/**
 * 请求客服的用户
 */
public class Client {

	protected String username; //用户名
	protected int eid; //企业号
	protected int priority; //优先数
	protected String targetname; //目标对象名称（外部用户目标对象：客服用户名，客服目标对象：本次完成服务的外部用户名）
	protected String sessionID;
	protected int userType;

	public Client(String username, int eid, int priority, String targetname, String sessionID,int userType) 
	{
		this.username = username;
		this.eid = eid;
		this.priority = priority;
		this.targetname = targetname;
		this.sessionID = sessionID;
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTargetname() {
		return targetname;
	}

	public void setTargetname(String targetname) {
		this.targetname = targetname;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
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

	//重新定义client的比较
	//若username相同认为相等
	@Override
	public boolean equals(Object otherObject)
	{
		if(this == otherObject)  return true;
		if(otherObject == null)  return false;
		if(this.getClass() != otherObject.getClass()) return false;
		
		Client other = (Client)otherObject;

		return username.equals(other.username);
	}
}
