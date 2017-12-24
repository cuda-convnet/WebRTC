package com.webrtc.netty.service;

import com.webrtc.netty.udp.SocketUDPService;
import com.webrtc.netty.websocketchat.WebsocketChatServer;
import com.webrtc.netty.common.Constants;
public class Service {
	
	WebsocketChatServer WSServer;	
	SocketUDPService UDPServer;
	
	public Service() throws Exception{
		int WEBSOCKET_PORT = Integer.parseInt(Constants.NETTY_WEBSOCKET_LISTEN_PORT);
		int UDP_LISTEN_PORT = Integer.parseInt(Constants.NETTY_UDP_LISTEN_PORT);
		int UDP_CONNECT_PORT =Integer.parseInt(Constants.NETTY_UDP_CONNECT_PORT);
		String UDP_CONNECT_IP =Constants.NETTY_UDP_CONNECT_IP;
		UDPServer = new SocketUDPService(UDP_LISTEN_PORT,UDP_CONNECT_IP,UDP_CONNECT_PORT);
		UDPServer.start();	
		WSServer =  new WebsocketChatServer(WEBSOCKET_PORT);
		WebsocketChatServer.udpserver = UDPServer;
		WSServer.run();	
	}
	
	public static void main(String[] args) throws Exception {
		new Service();
	}
}
