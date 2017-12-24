package com.webrtc.netty.manager;

import org.apache.log4j.Logger;

import java.util.List;

import com.webrtc.netty.dao.ReservationConf;
import com.webrtc.netty.dao.ReservationConfDAO;

public class ReservationConfManager {
	private static ReservationConfDAO reservationconfDAO = new ReservationConfDAO();
	private static final Logger LOGGER = Logger.getLogger(RoomManager.class);
	
	public static List<ReservationConf> findConfnameByUsername(String username){
		try{
			return reservationconfDAO.findConfnameByMembers(username);
		}
		catch(Exception e){
			LOGGER.debug(e);
			return null;
		}
	}
	 public static void main(String[] args){
			
		 List<ReservationConf> aaa = ReservationConfManager.findConfnameByUsername("9999");
			 
			 System.out.println(aaa.get(0).getConfname());

	 }

}
