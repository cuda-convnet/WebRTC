package com.webrtc.arti.core;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.webrtc.arti.actionhandler.ActionHandler;
import com.webrtc.arti.actionhandler.EndActionHandler;
import com.webrtc.arti.actionhandler.FinishActionHandler;
import com.webrtc.arti.actionhandler.LoginActionHandler;
import com.webrtc.arti.actionhandler.LogoutActionHandler;
import com.webrtc.arti.actionhandler.RequestActionHandler;
import com.webrtc.arti.common.ActionType;
import com.webrtc.arti.common.Constants;
import com.webrtc.arti.domain.Client;
import com.webrtc.arti.domain.Server;
import com.webrtc.arti.domain.ServerComparator;

/**
 * eid企业调度客服的模块
 */
public class ArtiSwitchBoard
{	
	private int eid; //所属企业！！！！！！以后可能不需要
	
	private Queue<Client> requestClientQueue; //用户请求队列
	
	private Map<String, Server> allServerMap; //所有客服表（等于idleServerQueue + busyServerMap）方便正在服务的用户突然退出后快速查询
	private PriorityQueue<Server> idleServerQueue; //空闲的客服队列（优先）
	private Map<String, Server> busyServerMap; //已无服务名额的客服表	
	
	public ArtiSwitchBoard(int eid) 
	{
		this.eid = eid;
		
		this.requestClientQueue = new LinkedList<Client>();
		this.allServerMap = new HashMap<String, Server>();
		this.idleServerQueue = new PriorityQueue<Server>(Constants.INIT_ARTINUM,new ServerComparator());
		this.busyServerMap = new HashMap<String, Server>();
	}
	
	//根据动作类型 进行不同的处理
	public void handle(int action,Client client)
	{
		ActionHandler actionHandler = null;
		switch (action) 
		{
			case ActionType.REQUEST: //第一次请求
			{
				actionHandler = new RequestActionHandler();
			}break;
			case ActionType.LOGIN: //注册为人工总机
			{
				actionHandler = new LoginActionHandler();
			}break;
			case ActionType.LOGOUT: //注销人工总机
			{
				actionHandler = new LogoutActionHandler();
			}break;
			case ActionType.FINISH: //完成服务
			{
				actionHandler = new FinishActionHandler();
			}break;
			case ActionType.END: //终止
			default:
			{
				actionHandler = new EndActionHandler();
			}break;
		}
		
		actionHandler.dispatch(client,requestClientQueue,allServerMap,idleServerQueue,busyServerMap);
	}
}