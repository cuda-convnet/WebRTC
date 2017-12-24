package com.webrtc.netty.udp;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.*;

import org.json.JSONObject;

import com.webrtc.netty.common.Constant;
import com.webrtc.netty.manager.WcsUserManager;
import com.webrtc.netty.websocketchat.WebSocketFrameHandler;

public class SocketUDPService extends Thread {

	private static String localIPAddr;
	private int localPort;

	private DatagramSocket listenSocket;
	private DatagramSocket sendSocket;

	private DatagramPacket indata;
	private DatagramPacket outdata;

	private int D_PORT = 29876;
	private String D_IP = "127.0.0.1";

	public ChannelGroup WSchannels = WebSocketFrameHandler.channels;
	public HashMap<String, Channel> WSMap = WebSocketFrameHandler.ChannelMap;

	public SocketUDPService(int port, String _dip, int _dport) {
		this.localPort = port;
		this.D_IP = _dip;
		this.D_PORT = _dport;
	}

	public void handleRequest() throws Exception {
		byte[] bs = new byte[1024];
		indata = new DatagramPacket(bs, bs.length);
		while (true) {
			listenSocket.receive(indata);
			int Len = indata.getLength();
			if (Len > 0) {
				// String sentence = new String(bs,0,indata.getLength());
				String sentence = new String(indata.getData(), 0,
						indata.getLength());
				System.out.println("receive CS Message length: "
						+ sentence.length());
				System.out.println(sentence);
				JSONObject obj = new JSONObject(sentence);
				String tempName = obj.getString("username");
				String Event = obj.getString("event");

				obj.put("roomid", obj.getString("roomid") + "@conf.com");

				String sentence2 = obj.toString();
				System.out.println("---sentence2:" + sentence2);

				// if(Event.equals(Constant.EVENT_UDP_OK)){
				// //写路由表
				// String roomid = obj.getString("roomid");
				// WcsUserManager.addWcsUser(roomid);
				// System.out.println("写路由表："+roomid);
				// }
				if (tempName != null) {
					if(null != WSMap.get(tempName)){
						WSMap.get(tempName).writeAndFlush(new TextWebSocketFrame(sentence2));
					}
					else{
						System.out.println(tempName + "is not exist in the WSMap");
					}	
				}
			}
		}
	}

	public void run() {
		try {
			this.listenSocket = new DatagramSocket(new InetSocketAddress(
					this.localPort));
			System.out.println("UDP Socket listen on " + this.localPort);
			this.sendSocket = new DatagramSocket();
			outdata = new DatagramPacket(new byte[0], 0,
					InetAddress.getByName(D_IP), D_PORT);
			this.handleRequest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (this.listenSocket != null)
				this.listenSocket.close();
		}
	}

	public void send(String message) {
		System.out.println("receive browser Message: " + message);
		outdata.setData(message.getBytes());
		try {
			sendSocket.send(outdata);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
