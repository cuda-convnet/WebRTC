package com.webrtc.auto.socket;

import java.net.*;
import org.json.JSONObject;

import com.webrtc.auto.common.SessionStateType;
import com.webrtc.auto.core.AutoSwitchBoardManager;
import com.webrtc.auto.domain.AnswerMessage;


//AutoSocketHandler 连接的是 自动总机问题查询模块

public class AutoSocketClientHandler extends SocketHandler {

	public AutoSocketClientHandler(String id, Socket s) {
		
		super(id,s);
	}
	/**
	 * handle the message received
	 * 
	 * @param message
	 *            : the message need to handle
	 * @throws
	 * @return
	 */
	@Override
	public void handleMessage(String message) {

		System.out.println("From "+this.remoteID+" Socket message : " + message);
		
		//接收WCS传来的数据
		JSONObject msgObj = new JSONObject(message);
		String from = msgObj.getString("from");
		int status = msgObj.getInt("status");
		if(status == SessionStateType.END) //终止操作
		{
			AutoSwitchBoardManager.end(from);
			return;
		}		
		
		String sessionID = msgObj.getString("sessionID");
		String question = msgObj.getString("question");
		int eid = msgObj.getInt("eid");
		
		//包装成JSON数据,发送给WCS服务器
		AnswerMessage answerMsg = AutoSwitchBoardManager.handle(from,sessionID,question,status,eid);
		this.send(answerMsg.getMsgObj().toString());
	}
}
