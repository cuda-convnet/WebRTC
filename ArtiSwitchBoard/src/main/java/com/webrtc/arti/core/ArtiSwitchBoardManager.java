package com.webrtc.arti.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;

import org.json.JSONObject;

import com.webrtc.arti.common.ActionType;
import com.webrtc.arti.common.Constants;
import com.webrtc.arti.dao.Enterprise;
import com.webrtc.arti.domain.AnswerMessage;
import com.webrtc.arti.domain.Client;
import com.webrtc.arti.domain.Server;
import com.webrtc.arti.manager.EnterpriseManager;
import com.webrtc.arti.socket.SocketHandler;
import com.webrtc.arti.domain.Session;

/**
 * 管理所有企业人工总机的总管
 */
public class ArtiSwitchBoardManager 
{
	private static Map<String, Session> sessions = new HashMap<String, Session>();

	//与wcs相连互发消息的socket
	public static SocketHandler socketHandler = null;
	
	//所有企业对应的人工总机表
	private static Map<Integer, ArtiSwitchBoard> artiSwitchBoardMap = new HashMap<Integer, ArtiSwitchBoard>();//key=eid
	
	static
	{
		//读取所有企业信息、生成它们各自对应的人工总机对象
		//存于表中
		List<Enterprise> enterprises = EnterpriseManager.getAllEnterprises();
		for(Enterprise enterprise : enterprises)
		{
			//构造enterprise企业的人工总机对象
			ArtiSwitchBoard artiSwitchBoard = new ArtiSwitchBoard(enterprise.getEid());
			
			//存入
			artiSwitchBoardMap.put(enterprise.getEid(), artiSwitchBoard);
		}
	};
	
	//进入eid企业的人工总机分配模块进行处理
	public static void handle(JSONObject msgObj)
	{

		//分解JSON字段
		int eid = 0;
		String from = "";
		String sessionID = "";
		int priority = 0;
		String targetname = "";
		int maxservingnum = 3;
		int action = ActionType.END;
		try 
		{
			System.out.println(msgObj);
			eid = msgObj.getInt("eid"); //企业id
			from = msgObj.getString("from"); //来自哪个客户端，from是用户名
			sessionID = msgObj.getString("sessionID");
			priority = msgObj.getInt("priority"); //优先级
			targetname = msgObj.getString("targetname"); //服务（或被服务）对象
			maxservingnum = msgObj.getInt("maxservingnum"); //最大服务数
			action = msgObj.getInt("action"); //userType
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		ArtiSwitchBoard artiSwitchBoard = artiSwitchBoardMap.get(eid);
		artiSwitchBoard.handle(action,new Server(from,eid,priority,targetname,sessionID,action,maxservingnum));
	}
	
	
	/**
	 * 发送给WCS的不同种类的消息
	 */
	//发送最基本的消息给WCS--->Client对象
	public static void sendAnswerToWCS(Client client, int answer)
	{
		if(client == null) return;
	
		AnswerMessage msg = new AnswerMessage(Constants.ARTI_FLAG, client.getUsername(),client.getSessionID(), client.getTargetname(), client.getEid(), answer);
		socketHandler.send(msg.getMsgObj().toString());
	}
	
	//发送最基本的消息给WCS--->Queue<Client>集合里的对象
	public static void sendAnswerToWCS(Queue<Client> requestClientQueue,int answer)
	{
		if(requestClientQueue.isEmpty()) return;
		
		//生成以,相隔的所有在等待队列里的用户字符串
		String requestClientUsernames = "";
		String sessionIDs = "";
		for(Client client : requestClientQueue)
		{			
			requestClientUsernames += client.getUsername() + ",";
			sessionIDs += client.getSessionID() + ",";
		}

		AnswerMessage msg = new AnswerMessage(Constants.ARTI_FLAG, requestClientUsernames,sessionIDs, "", 0, answer);
		socketHandler.send(msg.getMsgObj().toString());
	}
	
	//发送最基本的消息给WCS--->Map<String, Client>集合里的对象
	public static void sendAnswerToWCS(Map<String, Client> servingClientMap, int answer)
	{
		if(servingClientMap.isEmpty()) return;
		
		//生成以,相隔的所有正在服务的用户字符串
		String servingClientUsernames = "";
		String sessionIDs = "";
		for(String clientUsername : servingClientMap.keySet())
		{
			servingClientUsernames += clientUsername  + ",";
			sessionIDs += servingClientMap.get(clientUsername).getSessionID() + ",";
		}

		AnswerMessage msg = new AnswerMessage(Constants.ARTI_FLAG, servingClientUsernames, sessionIDs,"", 0, answer);
		socketHandler.send(msg.getMsgObj().toString());
	}
	
	
	//发送附带前方等待人数的消息给WCS--->Client对象
	public static void sendAnswerToWCS(Client client, int answer,int requesternum)
	{
		if(client == null) return;
		
		AnswerMessage msg = new AnswerMessage(Constants.ARTI_FLAG, client.getUsername(), client.getSessionID(),client.getTargetname(), client.getEid(), answer);
		msg.setRequesterNum(requesternum);
		socketHandler.send(msg.getMsgObj().toString());
	}
	
	public static void setSocketHandler(SocketHandler sc)
	{
		System.out.println("socketHandler已创建好！");
		socketHandler = sc;
	}
	
	//创建会话
	public static void addNewSession(String from,String sessionID, int eid,int userType)
	{
		//先要删除以前的，防止刷新以后又打开总机对话框，而之前的状态却残留在后台
		sessions.remove(from);
		Session session = new Session(from,sessionID,eid,userType); //创建会话
		sessions.put(from, session);
	}
	
	//更新会话，外部用户被servername客服服务，以便以后该用户异常退出，好通知服务于该用户的客服进行相关操作
	public static void updateSession(String from,String servername)
	{
		if(sessions.containsKey(from))
		{
			Session session = sessions.get(from);
			session.setServername(servername);
		}
		printAllSessions();
	}
	
	//删除会话
	public static void removeSession(String from)
	{
		if(sessions.containsKey(from))
		{
			sessions.remove(from);//删除与from的会话
			System.out.println("已删除"+ from +"与人工总机的会话信息");
		}
		printAllSessions();
	}
	
	//打印当前所有会话
	public static void printAllSessions()
	{
		System.out.println("*******************人工总机调度模块目前所有会话*******************");
		for(String key : sessions.keySet())
		{
			System.out.println(key);
		}
	}
	
	
	public static Map<String, Session> getSessions() {
		return sessions;
	}
}
