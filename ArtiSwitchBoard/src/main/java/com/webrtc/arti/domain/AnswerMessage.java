package com.webrtc.arti.domain;

import org.json.JSONObject;
import org.json.JSONException;

public class AnswerMessage 
{
	private JSONObject msgObj= null;
	
	public AnswerMessage(String from, String to,String sessionID, String targetname,int eid, int answer)
	{
		try {
			this.msgObj = new JSONObject();
			this.msgObj.put("from", from);
			this.msgObj.put("to", to);
			this.msgObj.put("sessionID", sessionID);
			this.msgObj.put("targetname", targetname);
			this.msgObj.put("eid", eid);
			this.msgObj.put("answer", answer); //口令(发送CONFIRM确认口令确认外部用户还在线)
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 	个别情况下需要传的参数
	 */
	public void setServerName(String servername)
	{
		this.msgObj.put("servername", servername); //客服用户名
	}
	
	public void setRequesterNum(int requesternum)
	{
		this.msgObj.put("requesternum", requesternum); //to前面还在等待的用户数量
	}
	
	public JSONObject getMsgObj() {
		return msgObj;
	}

	public void setMsgObj(JSONObject msgObj) {
		this.msgObj = msgObj;
	}
}
