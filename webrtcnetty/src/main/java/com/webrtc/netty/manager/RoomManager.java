package com.webrtc.netty.manager;


import org.apache.log4j.Logger;


import com.webrtc.netty.dao.Room;
import com.webrtc.netty.dao.RoomDAO;

public class RoomManager {
	private static RoomDAO roomDAO = new RoomDAO();
	private static final Logger LOGGER = Logger.getLogger(RoomManager.class);
	
	public static Room findRoomByRoom_Id(String roomid){
		try{
			return roomDAO.findRoomByRoomId(roomid);
		}
		catch(Exception e){
			LOGGER.debug(e);
			return null;
		}
	}
	 public static void main(String[] args){
			
		 Room aaa = RoomManager.findRoomByRoom_Id("2014");
			 
			 System.out.println(aaa.getConfid());

	 }
}
