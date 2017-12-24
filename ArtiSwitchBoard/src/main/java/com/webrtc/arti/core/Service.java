package com.webrtc.arti.core;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.webrtc.arti.socket.ArtiSocketClientHandler;
import com.webrtc.arti.socket.SocketHandler;
import com.webrtc.arti.common.Constants;

public class Service {
	
	SocketHandler artiSocketHandler;
	
	public Service() throws UnknownHostException, IOException
	{
		String clientFlag = Constants.ARTI_FLAG;
		String serverAddr = Constants.ADDR;
		int    listenPort = Constants.WCS_TCP_LISTEN_PORT;

		//连接过程准备
		artiSocketHandler = new ArtiSocketClientHandler(clientFlag, new Socket(serverAddr,listenPort));
		ArtiSwitchBoardManager.setSocketHandler(artiSocketHandler);//为人工总机模块提供一个可以向wcs发送消息的socket
		
		//必须要发送一个客户端标志，以便WCS分清是哪个端再请求与它建立服务关系
		artiSocketHandler.send(clientFlag);
		
		//开始双向通信
		artiSocketHandler.run();	//监听WCS有没有向自己发送消息
	}
	
	//启用“自动总机模块”主函数
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		new Service();
	}
}
