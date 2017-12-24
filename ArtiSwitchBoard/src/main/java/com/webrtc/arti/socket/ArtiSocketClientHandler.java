package com.webrtc.arti.socket;

import java.net.*;
import java.util.Map;

import org.json.JSONObject;

import com.webrtc.arti.common.ActionType;
import com.webrtc.arti.common.UserType;
import com.webrtc.arti.core.ArtiSwitchBoardManager;
import com.webrtc.arti.domain.Session;


//ArtiSocketHandler 连接的是 人工总机分配资源的模块
public class ArtiSocketClientHandler extends SocketHandler 
{
	public ArtiSocketClientHandler(String id, Socket s) 
	{	
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
		int action = msgObj.getInt("action");
		if(action == ActionType.END) //掉线、关闭网页等非正常终止动作(判断是客服终止、还是外部用户终止，对msgObj进行补充、调整)
		{
			Map<String, Session> sessions = ArtiSwitchBoardManager.getSessions();
			if(!sessions.containsKey(from)) return;
			
			//判断from是外部用户or客服
			Session session = sessions.get(from);
			int userType = session.getUserType();
			if(userType == UserType.SERVER) //客服
			{
				msgObj.put("action", ActionType.LOGOUT);//调整动作
			}
			
			//补充其他必要字段，防止之后json取不到字段的异常
			msgObj.put("eid", session.getEid());
			msgObj.put("sessionID", session.getSessionID());
			msgObj.put("priority", 0);
			msgObj.put("targetname", session.getServername());
			msgObj.put("maxservingnum", 3);
		}
		
		//处理
		ArtiSwitchBoardManager.handle(msgObj);
	}
}
