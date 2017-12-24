package com.webrtc.auto.domain;

import org.json.JSONObject;
import org.json.JSONException;

public class AnswerMessage 
{
	private JSONObject msgObj= null;
	
	public AnswerMessage(String from, String to,String sessionID, int curMenu, String answer_head,String answer_body,String answer_footer)
	{
		try {
			this.msgObj = new JSONObject();
			this.msgObj.put("from", from);
			this.msgObj.put("to", to);
			this.msgObj.put("sessionID", sessionID);
			this.msgObj.put("curmenu",curMenu);
			this.msgObj.put("answer_head", answer_head); //普通文本
			this.msgObj.put("answer_body", answer_body); //分组列表 or 邮箱列表
			this.msgObj.put("answer_footer", answer_footer); //其他链接

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public JSONObject getMsgObj() {
		return msgObj;
	}

	public void setMsgObj(JSONObject msgObj) {
		this.msgObj = msgObj;
	}
}
