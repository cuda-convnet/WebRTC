package com.webrtc.arti.actionhandler;



import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.webrtc.arti.common.ActionType;
import com.webrtc.arti.core.ArtiSwitchBoardManager;
import com.webrtc.arti.domain.Client;
import com.webrtc.arti.domain.Server;

/**
 * 当人工总机用户点击“注册”时 进行处理
 */
public class LoginActionHandler extends ActionHandler{

	
	@Override
	public void dispatch(Client client, Queue<Client> requestClientQueue,Map<String, Server> allServerMap, PriorityQueue<Server> idleServerQueue,Map<String, Server> busyServerMap) {

		Server server = ((Server)client);
		String servername = server.getUsername();

		if(!allServerMap.containsKey(servername)) //新的
		{			
			String sessionID = server.getSessionID();
			int eid = server.getEid();
			int priority = server.getPriority();
			int userType = server.getUserType();
			String targetname = server.getTargetname();
			int maxservingnum = server.getMaxServingNum();
			
			//创建新会话
			ArtiSwitchBoardManager.addNewSession(servername, sessionID, eid, userType);
			
			//生成新客服
			Server newServer = new Server(servername, eid, priority, targetname, sessionID, userType, maxservingnum);
			System.out.println("企业用户："+newServer.getUsername()+"注册为人工总机");
			
			//添加客服
			allServerMap.put(servername, newServer); //加入到总客服表
			idleServerQueue.offer(newServer); //根据优先级加入到优先空闲队列
			printAll(requestClientQueue, idleServerQueue, busyServerMap, allServerMap);

			//newServer有多少个名额，就分配多少次
			//1.若等待队列还有很多人等待，那么newServer最多只能给maxservingnum次机会
			//2.若在此期间其它客服也登录进来了，那么giveOffer里面谁分配给谁不用此处操心，给出的机会总和（num1+num2+...+numN肯定是对的）
			//3.若等待队列没人，则giveOffer里面无效，跳过
			for(int i=0;i<newServer.getMaxServingNum();i++)
				super.giveOffer(requestClientQueue,allServerMap, idleServerQueue, busyServerMap);
		}
	}

	@Override
	public int getType() {

		return ActionType.LOGIN;
	}

}
