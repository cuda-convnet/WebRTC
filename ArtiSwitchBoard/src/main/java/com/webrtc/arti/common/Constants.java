package com.webrtc.arti.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Constants {
		
	/**
	 * add by yck
	 */
	public final static String ADDR;
	public final static int WCS_TCP_LISTEN_PORT;
	public final static String ARTI_FLAG; //人工总机客户端标志
	public final static int INIT_ARTINUM; //人工总机初始化数量
	
	static {
		  final Logger logger = Logger.getLogger("App configuration");
	        logger.info("+++++++++++App configuration information++++++++++++");
		try {
			   Properties p = new ConfigurationUtil().getPropertyFileConfiguration("app.properties");
	            
	            ADDR = p.getProperty("ADDR");
	            logger.info("ADDR:" + ADDR);
	            
	            WCS_TCP_LISTEN_PORT = Integer.parseInt(p.getProperty("WCS_TCP_LISTEN_PORT"));
	            logger.info("WCS_TCP_LISTEN_PORT:" + WCS_TCP_LISTEN_PORT);
	            
	            ARTI_FLAG = p.getProperty("ARTI_FLAG");
	            logger.info("ARTI_FLAG:" + ARTI_FLAG);
	            
	            INIT_ARTINUM =  Integer.parseInt(p.getProperty("INIT_ARTINUM"));
	            logger.info("INIT_ARTINUM:" + INIT_ARTINUM);
	            
		} catch (IOException e) {
           throw new RuntimeException("Failed to init app configuration", e);
        }
	}
}