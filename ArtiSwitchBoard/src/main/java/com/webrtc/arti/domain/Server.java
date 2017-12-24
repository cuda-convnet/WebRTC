package com.webrtc.arti.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 客服（人工总机）
 */
public class Server extends Client
{
	private int maxServingNum; //每个客服服务的用户的最大个数
	private Map<String, Client> servingClientMap; //正在服务的用户表
	
	public Server(String username, int eid, int priority, String targetname, String sessionID,int userType, int maxServingNum) 
	{
		super(username, eid, priority,targetname,sessionID,userType);
		this.maxServingNum = maxServingNum;
		this.servingClientMap = new HashMap<String, Client>();
	}

	//接受新的需要服务的用户，(client与server绑定服务关系)
	public void receive(Client client)
	{
		client.setTargetname(this.username);
		this.setTargetname(client.getUsername());
		this.servingClientMap.put(client.getUsername(), client); //正在服务的用户增1
	}
	
	//获得正在服务的用户数量
	public int getServingClientNum()
	{
		return this.servingClientMap.size();
	}
	
	//从正在服务的外部用户中删除clientUsername
	public void removeServingClient(String clientUsername)
	{
		System.out.println("之前正服务的人数为：" + this.servingClientMap.size());
		this.servingClientMap.remove(clientUsername);
		System.out.println("客服：" + username + "删除刚才正在服务的用户" + clientUsername + "。他目前正服务的人数为：" + this.servingClientMap.size());
	}

	public Map<String, Client> getServingClientMap() {
		return servingClientMap;
	}

	public void setServingClientMap(Map<String, Client> servingClientMap) {
		this.servingClientMap = servingClientMap;
	}
	
	public int getMaxServingNum() {
		return maxServingNum;
	}

	public void setMaxServingNum(int maxServingNum) {
		this.maxServingNum = maxServingNum;
	}
}
