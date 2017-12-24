package com.webrtc.arti.actionhandler;



import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.webrtc.arti.common.ActionType;
import com.webrtc.arti.common.AnswerType;
import com.webrtc.arti.core.ArtiSwitchBoardManager;
import com.webrtc.arti.domain.Client;
import com.webrtc.arti.domain.Server;

/**
 * 当外部用户进入“人工总机平台”时 进行处理
 */
public class RequestActionHandler extends ActionHandler{

	@Override
	public void dispatch(Client client, Queue<Client> requestClientQueue,Map<String, Server> allServerMap, PriorityQueue<Server> idleServerQueue,Map<String, Server> busyServerMap) {
		
		//先检查是否有客服
		if(allServerMap.isEmpty()) //一个客服也没有
		{
			ArtiSwitchBoardManager.sendAnswerToWCS(client, AnswerType.NONEARTI); //通知这个client
		}
		else //有客服
		{
			if(!requestClientQueue.contains(client))
			{
				ArtiSwitchBoardManager.addNewSession(client.getUsername(), client.getSessionID(), client.getEid(), client.getUserType());
				
				int requesternum = requestClientQueue.size(); //获取前面等待的人数
				requestClientQueue.offer(client); //进等待队列,等待资源分配
				ArtiSwitchBoardManager.sendAnswerToWCS(client, AnswerType.FORM_REQUESTERNUM,requesternum);//返回给前台client前面还在等待的人数
				System.out.println("用户："+client.getUsername()+"申请人工服务");
				printClientsInRequestQueue(requestClientQueue);
				
				super.giveOffer(requestClientQueue,allServerMap, idleServerQueue, busyServerMap);
			}
		}
	}

	@Override
	public int getType() {

		return ActionType.REQUEST;
	}

}
