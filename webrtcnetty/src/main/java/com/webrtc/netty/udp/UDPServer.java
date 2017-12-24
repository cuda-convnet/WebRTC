package com.webrtc.netty.udp;

import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.json.JSONObject;

public class UDPServer{  
    public static final int PORT = 60000;  
    private DatagramPacket inPacket ;  
    private DatagramPacket outPacket;  
    
    public void init()throws Exception  
    {  
    	byte[] bs = new byte[8192];              
    	inPacket = new DatagramPacket(bs,bs.length); 
            // 创建DatagramSocket对象  
			DatagramSocket socket = new DatagramSocket(PORT);
			outPacket =new DatagramPacket(new byte[0] , 0 , InetAddress.getByName("10.108.115.204") , 40000);	
            while(true){

                // 读取Socket中的数据，读到的数据放入inPacket封装的数组里  
                socket.receive(inPacket); 
                int Len = inPacket.getLength();
                if(Len >0){
	                String result = new String(inPacket.getData(),0,inPacket.getLength());  	
	    			System.out.println(result.length());
	    			System.out.println(result);
	                JSONObject obj = new JSONObject(result);
	    			String tempName = obj.getString("username");
	    			System.out.println(tempName);
	                //String send = "{\"username\":\""+tempName+"\",\"content\":\"lalala\"}";
	                
	                String send = "{\"event\":\"UDP_OK\",\"username\":\""+tempName+"\",\"roomid\":\"lalala\"}";
	                //String send = "{\"event\":\"UDP_FAILED\",\"username\":\""+tempName+"\",\"reason\":\"hehehe\"}";
	                System.out.println(send);
	                byte[] sendData = send.getBytes();
	                // 以指定的字节数组作为发送数据，以刚接收到的DatagramPacket的  
	                // 源SocketAddress作为目标SocketAddress创建DatagramPacket  
	                outPacket.setData(sendData);	
	                // 发送数据  
	                socket.send(outPacket);
                }
            }

    }  
    public static void main(String[] args)  throws Exception  
    {  
        new UDPServer().init();  
    }  
}  