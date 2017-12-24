package com.webrtc.auto.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import com.webrtc.auto.common.AnswerCompo;
import com.webrtc.auto.common.Constants;
import com.webrtc.auto.common.MenuStateType;
import com.webrtc.auto.common.SessionStateType;
import com.webrtc.auto.domain.AnswerMessage;
import com.webrtc.auto.domain.Session;
import com.webrtc.auto.domain.Step;
import com.webrtc.auto.menuhandler.MenuHandler;
import com.webrtc.auto.menuhandler.FirstMenuHandler;
import com.webrtc.auto.menuhandler.QueryByFzMenuHandler;
import com.webrtc.auto.menuhandler.QueryByRealNameMenuHandler;
import com.webrtc.auto.menuhandler.QueryByRealNameResultMenuHandler;
import com.webrtc.auto.menuhandler.QueryByUserNameMenuHandler;
import com.webrtc.auto.menuhandler.QueryByUserNameResultMenuHandler;
import com.webrtc.auto.socket.SocketHandler;

public class AutoSwitchBoardManager
{
	
	private static Map<String, Session> sessions = new HashMap<String, Session>();
	private static final int SESSION_TIMEOUT_DELAY = Constants.SESSION_TIMEOUT_DELAY; //会话回复的最长等待时间
	
	private static final int HEAD = AnswerCompo.HEAD;
	private static final int BODY = AnswerCompo.BODY;
	private static final int FOOTER = AnswerCompo.FOOTER;
	
	//处理外部用户的查询请求
	public static AnswerMessage handle(String from, String sessionID, String question, int status, int eid)
	{
		
		//计算应答答案
		AnswerMessage answerMsg = null;
		switch (status) 
		{
			case SessionStateType.REQUEST: //第一次请求
			{
				answerMsg = begin(from,sessionID,eid);
			}break;
			case SessionStateType.CHAT: //聊天中
			{
				answerMsg = answer(from,sessionID,question);
			}break;
		}
		
		return answerMsg;
	}
	
	
	//创建会话
	public static void addNewSession(String from,String sessionID, int eid)
	{
		//先要删除以前的，防止刷新以后又打开总机对话框，而之前的状态却残留在后台
		sessions.remove(from);
		
		Session session = new Session(from,sessionID,eid); //创建会话
		Timer timer = new Timer();
		timer.schedule(new SessionTimeoutTimerTask(from), SESSION_TIMEOUT_DELAY);
		session.setTimer(timer);//开启定时器
		
		sessions.put(from, session);
	}
	
	//清空from的session的定时时间，重新开始
	public static void updateSessionTimer(String from)
	{
		if(sessions.containsKey(from))
		{
			System.out.println("与自动总机的定时器归零重新计时");
			Session session = sessions.get(from);
			
			//先中断上个定时器
			Timer timer = session.getTimer();
			timer.cancel();
			timer = null;
	
			//生成一个新的定时器
			timer = new Timer();
			timer.schedule(new SessionTimeoutTimerTask(from), SESSION_TIMEOUT_DELAY);
			session.setTimer(timer);
		}
	}
		
	//初次连接，会话开始
	public static AnswerMessage begin(String from,String sessionID, int eid)
	{
		//检查是否需要添加新的在总机会话
		addNewSession(from,sessionID,eid);

		String[] answer = {"","",""};	
		answer[HEAD] = "欢迎进入WebRTC自动总机系统";
		answer[FOOTER] = "1按姓名 / 邮箱 / 电话 / 地址等查号,2按分组查号,3直接输入账号查询";
		
		//Session session = sessions.get(from);
		return new AnswerMessage(Constants.AUTO_FLAG,from,sessionID,MenuStateType.FIRST,answer[HEAD],answer[BODY],answer[FOOTER]);
	}
	
	//会话中，回应
	public static AnswerMessage answer(String from,String sessionID, String question)
	{
		updateSessionTimer(from);

		String[] answer = {"","",""};
		MenuHandler menuHandler = null;
		
		Session session = sessions.get(from);
		Stack<Step> stepStack = session.getStepStack();
		Step curStep = stepStack.peek();
		int curMenu = curStep.getCurMenu();
		
		switch (curMenu) 
		{
			case MenuStateType.FIRST:
			{
				menuHandler = new FirstMenuHandler();
			}break;
			case MenuStateType.QUERYBYKEYWORD:
			{
				menuHandler = new QueryByRealNameMenuHandler();
			}break;
			case MenuStateType.QUERYBYKEYWORDRESULT:
			{
				menuHandler = new QueryByRealNameResultMenuHandler();
			}break;
			case MenuStateType.QUERYBYUSERNAME:
			{
				menuHandler = new QueryByUserNameMenuHandler();
			}break;
			case MenuStateType.QUERYBYUSERNAMERESULT:
			{
				menuHandler = new QueryByUserNameResultMenuHandler();
			}break;
			case MenuStateType.QUERYBYFZ1:
			case MenuStateType.QUERYBYFZ2:
			case MenuStateType.QUERYBYFZ3:
			case MenuStateType.QUERYBYFZ4:
			case MenuStateType.QUERYBYFZRESULT:
			{
				menuHandler = new QueryByFzMenuHandler();
			}break;
			default:answer[HEAD] ="查询失败，请重新输入";break;
		}

		//计算应答答案
		if(menuHandler != null)
			answer = menuHandler.answerQuestion(session, question);
		
		return new AnswerMessage(Constants.AUTO_FLAG,from,sessionID,session.getStepStack().peek().getCurMenu(),answer[HEAD],answer[BODY],answer[FOOTER]);
	}
	
	//会话超时
	public static AnswerMessage timeout(String from,String sessionID)
	{
		end(from); //终止
		
		String[] answer = {"","",""};
		answer[HEAD] = "感谢您的使用，欢迎下次再来";
		answer[BODY] = "重新发起会话,";
		
		return new AnswerMessage(Constants.AUTO_FLAG,from,sessionID,MenuStateType.UNKNOWN,answer[HEAD],answer[BODY],answer[FOOTER]);
	}
	
	//会话结束或中断
	public static void end(String from)
	{
		if(sessions.containsKey(from))
		{
			//终止定时器
			Timer timer = sessions.get(from).getTimer();
			if(timer != null)
			{
				timer.cancel();
				timer = null;
			}
			
			//删除与from的会话
			sessions.remove(from);
		}
	}
	
	/**
	 * 超时
	 * 超过最长响应时间，用户未回应自动总机的终结操作
	 */
	public static class SessionTimeoutTimerTask extends TimerTask {

		private String userID; //用户名
		
		public SessionTimeoutTimerTask(String userID) {
			this.userID = userID;
		}

		@Override
		public void run() {

			if (sessions.containsKey(this.userID)) {
				
				String sessionID = sessions.get(this.userID).getSessionID();
				
				SocketHandler autoSocketHandler = Service.getAutoSocketHandler();
				autoSocketHandler.send(timeout(this.userID,sessionID).getMsgObj().toString());
			}
		}
	}
	
}
