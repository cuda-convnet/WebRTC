package com.webrtc.arti.common;

/**
 * 人工总机模块-----> WCS
 * 消息动作类型
 */
public interface AnswerType 
{
	//client：外部用户
	//server：人工总机客服
	public static final int NONEARTI = 1; //没有一个客服资源可分配（发送给WCS通知对端“稍后再试”）单client	
	public static final int ARTILOGOUT = 2;//人工总机下线（发送给WCS通知那些正在接受该人工总机服务的用户“人工总机出现异常，请重新等待”）多client
	public static final int FORM_REQUESTERNUM = 3; //返回给用户他前面的等待人数（发送给WCS通知对端显示人数）单client
	public static final int UPDATE_REQUESTERNUM = 4; //所有用户他前面的等待人数-1（发送给WCS通知所有对端人数-1）多client
	public static final int SUCCESS = 5; //成功分配（发送给WCS通知对端与“targetname”的客服进行环信连接 && 通知客服有一个名为targetname的外部用户需要服务了）单client && server
	public static final int FINISH = 6; //完成服务（发送给对端（客服或外部用户）“本次服务已结束，您可重新发起请求”） 单client && server
}
