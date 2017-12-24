package com.webrtc.auto.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Constants {
		
	/**
	 * add by yck
	 */
	public final static String ADDR;
	public final static int WCS_TCP_LISTEN_PORT;
	public final static String AUTO_FLAG; //自动总机客户端标志
	public static final int AUTO_PAGESIZE ; //总机查询结果一页最多显示记录数
	public static final int SESSION_TIMEOUT_DELAY;//自动总机会话失效时限
	
	static {
		  final Logger logger = Logger.getLogger("App configuration");
	        logger.info("+++++++++++App configuration information++++++++++++");
		try {
			   Properties p = new ConfigurationUtil().getPropertyFileConfiguration("app.properties");
	            
//			   PORT = p.getProperty("PORT");
//	            logger.info("PORT:" + PORT);
	            
	            ADDR = p.getProperty("ADDR");
	            logger.info("ADDR:" + ADDR);
	            
	            WCS_TCP_LISTEN_PORT = Integer.parseInt(p.getProperty("WCS_TCP_LISTEN_PORT"));
	            logger.info("WCS_TCP_LISTEN_PORT:" + WCS_TCP_LISTEN_PORT);
	            
	            AUTO_FLAG = p.getProperty("AUTO_FLAG");
	            logger.info("AUTO_FLAG:" + AUTO_FLAG);
	           
	            AUTO_PAGESIZE = Integer.parseInt(p.getProperty("AUTO_PAGESIZE"));
	            logger.info("AUTO_PAGESIZE:" + AUTO_PAGESIZE);	
	            
	            SESSION_TIMEOUT_DELAY = Integer.parseInt(p.getProperty("SESSION_TIMEOUT_DELAY"));
	            logger.info("SESSION_TIMEOUT_DELAY:" + SESSION_TIMEOUT_DELAY);	
		} catch (IOException e) {
           throw new RuntimeException("Failed to init app configuration", e);
        }
	}
}