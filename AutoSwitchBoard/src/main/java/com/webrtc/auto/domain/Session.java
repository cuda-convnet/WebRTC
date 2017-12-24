package com.webrtc.auto.domain;

import java.util.Stack;
import java.util.Timer;

import com.webrtc.auto.common.MenuStateType;

/**
 * 自动总机会话类
 *
 */
public class Session {

	private String from; //用户名
	private String sessionID = ""; //会话的唯一标识
	private Timer  timer = null; //会话的定时器
	
	private int eid; //企业号
	private Stack<Step> stepStack = null ; //前几步（以区域搜索时，用区域编号查询数据库获得数据的那种）的索引编号，栈顶是最近那一步的，为空表示上一页并不需要用编号查
		
	public Session(String from, String sessionID, int eid) {
		this.from = from;
		this.sessionID = sessionID;
		this.eid = eid;
		
		stepStack = new Stack<Step>();
		stepStack.push(new Step(MenuStateType.FIRST, 0,"",1, 1));
	}

	public Stack<Step> getStepStack() {
		return stepStack;
	}

	public void setStepStack(Stack<Step> stepStack) {
		this.stepStack = stepStack;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
}
