package com.webrtc.netty.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.apache.log4j.Logger;

//常量其值待抽离出.properties文件
public class Constants {
	
	public final static String NETTY_UDP_CONNECT_PORT;
	public final static String NETTY_UDP_CONNECT_IP;
	public final static String NETTY_UDP_LISTEN_PORT;
	public final static String NETTY_WEBSOCKET_LISTEN_PORT;
	public final static String SG_ID;
	
	final static Logger logger = Logger.getLogger(Constants.class);
	static {
		  final Logger logger = Logger.getLogger("App configuration");
	        logger.info("+++++++++++App configuration information++++++++++++");
		try {
			   Properties p = new ConfigurationUtil().getPropertyFileConfiguration("app.properties");
	            
			   NETTY_UDP_CONNECT_PORT = p.getProperty("NETTY_UDP_CONNECT_PORT");
	            logger.info("NETTY_UDP_CONNECT_PORT:" + NETTY_UDP_CONNECT_PORT);
	            
	            NETTY_UDP_CONNECT_IP = p.getProperty("NETTY_UDP_CONNECT_IP");
	            logger.info("NETTY_UDP_CONNECT_IP:" + NETTY_UDP_CONNECT_IP);
	            
	            NETTY_UDP_LISTEN_PORT = p.getProperty("NETTY_UDP_LISTEN_PORT");
	            logger.info("NETTY_UDP_LISTEN_PORT:" + NETTY_UDP_LISTEN_PORT);
	            
	            NETTY_WEBSOCKET_LISTEN_PORT = p.getProperty("NETTY_WEBSOCKET_LISTEN_PORT");
	            logger.info("NETTY_WEBSOCKET_LISTEN_PORT:" + NETTY_WEBSOCKET_LISTEN_PORT);
	            
	            SG_ID = p.getProperty("SG_ID");
	            logger.info("SG_ID:" + SG_ID);
						
		} catch (IOException e) {
           throw new RuntimeException("Failed to init app configuration", e);
        }
	}
}