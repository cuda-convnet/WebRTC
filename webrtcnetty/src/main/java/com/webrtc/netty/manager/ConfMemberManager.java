package com.webrtc.netty.manager;

import org.apache.log4j.Logger;

import java.util.List;

import com.webrtc.netty.dao.ConfMember;
import com.webrtc.netty.dao.ConfMemberDAO;


public class ConfMemberManager {
	public static ConfMemberDAO confmemberDAO = new ConfMemberDAO();
	private static final Logger LOGGER = Logger.getLogger(ConfMemberManager.class);
	
	public static ConfMember findConfMemberByRoom_IdAndMember(String roomid, String member){
		try{
		    return confmemberDAO.findConfMemberByRoomIdAndMember(roomid,member);
		}
		catch(Exception e){
			LOGGER.debug(e);
			return null;
		}
	}
	/*add by pq 2016-3-2*/
	public static List<ConfMember> findConfMemberByRoom_Id(String roomid){
		try{
//		      if(confmemberDAO.findConfMemberByRoomId(roomid)==null){
//		    	  System.out.println("kong!!!!!");
//		      }
//		      else
			System.out.println("----------------");
		    return confmemberDAO.findConfMemberByRoomId(roomid); 
		}
		catch(Exception e){
			LOGGER.debug(e);
			return null;
		}
	}
	
//	public static void main(String[] args){
//		
//		 ConfMember aaa = ConfMemberManager.findConfMemberByRoom_IdAndMember("2014","guo");
//			 
//			 System.out.println(aaa.getConnId());
//
//	 }
	public static void main(String[] args){
		
		 List<ConfMember> aaa = ConfMemberManager.findConfMemberByRoom_Id("1aBm");
			 
			 System.out.println(aaa.get(0).getConnId());

	 }
}
