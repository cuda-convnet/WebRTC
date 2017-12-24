package com.webrtc.netty.websocketchat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.webrtc.netty.common.Constant;
import com.webrtc.netty.common.JSONUtil;
import com.webrtc.netty.manager.ReservationConfManager;
import com.webrtc.netty.dao.ReservationConf;
import com.webrtc.netty.manager.WcsUserManager;
import com.webrtc.wcs.dao.WcsUser;
import com.webrtc.netty.manager.ConfMemberManager;
import com.webrtc.netty.dao.ConfMember;

public class WebSocketFrameHandler extends
		SimpleChannelInboundHandler<WebSocketFrame> {

	public static ChannelGroup channels = new DefaultChannelGroup(
			GlobalEventExecutor.INSTANCE);
	public static HashMap<String, Channel> ChannelMap = new HashMap<String, Channel>();

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg)
			throws Exception {
		JSONObject obj = new JSONObject(((TextWebSocketFrame) msg).text());
		String tempName = obj.getString(Constant.USERNAME);
		System.out.println(tempName);
		if (obj.has(Constant.TYPE)) {
			if (obj.getString(Constant.TYPE).equals(Constant.CONNECT)) {
				ChannelMap.put(tempName, ctx.channel());
			} else if (obj.getString(Constant.TYPE).equals(Constant.DISCONNECT)) {
				ChannelMap.remove(tempName);
			} else if (obj.getString(Constant.TYPE).equals(
					Constant.EVENT_UDP_REQUEST)) {
				//查询数据库获得我的会议列表				
				Channel incoming = ctx.channel();
				SendAnswerToWeb(incoming, tempName,
						obj.getString(Constant.CONTENT));
				
			} else if (obj.getString(Constant.TYPE).equals(
					Constant.EVENT_UDP_MEETINGMEMBER)){
				//接收到浏览器端的查询会议成员请求,这里的tempName为roomid
				Channel incoming = ctx.channel();
				SendMeetingMemberToWeb(incoming, tempName,
						obj.getString(Constant.CONTENT));
			}
			printChannels();
			return;
		}
		ChannelMap.put(tempName, ctx.channel());
		WebsocketChatServer.udpserver.send(((TextWebSocketFrame) msg).text());
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();

		// Broadcast a message to multiple Channels
		channels.writeAndFlush(new TextWebSocketFrame("[SERVER] - "
				+ incoming.remoteAddress() + " 加入"));

		channels.add(incoming);
		System.out.println("Client:" + incoming.remoteAddress() + "加入");
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();

		// Broadcast a message to multiple Channels
		channels.writeAndFlush(new TextWebSocketFrame("[SERVER] - "
				+ incoming.remoteAddress() + " 离开"));

		System.out.println("Client:" + incoming.remoteAddress() + "离开");

		// A closed Channel is automatically removed from ChannelGroup,
		// so there is no need to do "channels.remove(ctx.channel());"
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		System.out.println("Client:" + incoming.remoteAddress() + "在线");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		System.out.println("Client:" + incoming.remoteAddress() + "掉线");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) // (7)
			throws Exception {
		Channel incoming = ctx.channel();
		System.out.println("Client:" + incoming.remoteAddress() + "异常");
		// 当出现异常就关闭连接
		cause.printStackTrace();
		ctx.close();
	}

	public void printChannels() {
		System.out.println("<<<<<<<<<<<<<<");

		Iterator<Map.Entry<String, Channel>> iterator = ChannelMap.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Channel> entry = iterator.next();
			System.out.println("USER:" + entry.getKey());
			System.out.println("CHANNEL:" + entry.getValue());
		}

		System.out.println(">>>>>>>>>>>>>>");
	}

	public void SendAnswerToWeb(Channel dst, String username_dst, String request) {

		System.out.println("pq--收到查询会议列表请求--用户名："+username_dst+"请求内容:"+request);
		if (request.equals(Constant.MeetingList)) {
			//根据username_dst查询144的reservation_conf数据库
			System.out.println("开始查询我的会议！！");
			List<ReservationConf> myMeetingList = ReservationConfManager.findConfnameByUsername(username_dst);
			
			if(myMeetingList == null){
				System.out.println("查询我的会议为空！！！");
				return;
			}
			
			JSONObject result = new JSONObject();
			JSONArray jsons = new JSONArray();
			JSONObject jo;
			
			
			try {
				for(int index=0; index < myMeetingList.size(); index++){
				   jo = JSONUtil.objectToJson(myMeetingList.get(index));
				   jsons.put(jo);
				}
				
				int i = jsons.length();
				System.out.println("pq"+i);
				
				result.put("content", jsons);
				result.put("event",Constant.EVENT_UDP_MESSAGE);
				result.put("username",username_dst);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			List<WcsUser> aaa = WcsUserManager.findWcsUserByUser_Id(username_dst);
//			
//			JSONObject result = new JSONObject();
//			JSONArray jsons = new JSONArray();
//			JSONObject jo;
//			try {
//				for(int index=0; index<aaa.size(); index++){
//				  jo = JSONUtil.objectToJson(aaa.get(index));
//				  jsons.put(jo);
//				}
//
//				int i = jsons.length();
//     			System.out.println("pq"+i);
//     			
//				result.put("content", jsons);
//				result.put("event",Constant.EVENT_UDP_MESSAGE);
//				result.put("username",username_dst);
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			System.out.println("result:"+result.toString());
			
			dst.writeAndFlush(new TextWebSocketFrame(result.toString())); 
		}
	}
	
	public void SendMeetingMemberToWeb(Channel dst, String username_dst, String meetingmember){
		System.out.println("pq--收到查询会议成员请求--用户名："+username_dst+"请求内容:"+meetingmember);
		if (meetingmember.equals(Constant.MeetingMember)) {
			//根据roomid查询会议成员列表,username_dst为roomid
			System.out.println("开始查询会议成员！！");
			List<ConfMember> MeetingMember = ConfMemberManager.findConfMemberByRoom_Id(username_dst);
			
			if(MeetingMember == null){
				System.out.println("会议成员为空！！");
				return;
			}
			
			JSONObject result = new JSONObject();
			JSONArray jsons = new JSONArray();
			JSONObject jo;
			
			
			try {
				for(int index=0; index < MeetingMember.size(); index++){
				   jo = JSONUtil.objectToJson(MeetingMember.get(index));
				   jsons.put(jo);
				}
				
				int i = jsons.length();
				System.out.println("pq--会议成员位数："+i);
				
				result.put("content", jsons);
				result.put("event",Constant.EVENT_UDP_MEETINGMEMBERLIST);
				result.put("username",username_dst); //会议号				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("查询会议列表结果:"+result.toString());
			
            //写入
			dst.writeAndFlush(new TextWebSocketFrame(result.toString())); 
		}
	}

}
