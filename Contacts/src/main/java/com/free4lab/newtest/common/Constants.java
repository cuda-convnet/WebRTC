package com.free4lab.newtest.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Constants {
	//session
	public static final String UserID = "uid";
	public static final String UserEmail= "email";
	public static final String AccessToken = "accessToken";
	public static final String AccToken = "accToken";
	
	//app.properties
	public static final String SECRET_KEY;
	public static final String CUSTOM_ID;
	public static final String FRONT_URL;
	
	//add by yck
	public static final int ENCONTACTS_PAGESIZE; //企业通讯录每页成员的数量
	
	static {
		final Logger logger = Logger.getLogger("App configuration");
		logger.info("+++++++++++App configuration information++++++++++++");
		try {
			Properties p = new ConfigurationUtil().getPropertyFileConfiguration("app.properties");

			SECRET_KEY = p.getProperty("SECRET_KEY");
			logger.info("SECRET_KEY:" + SECRET_KEY);
			
            CUSTOM_ID = p.getProperty("CUSTOM_ID");
			logger.info("CUSTOM_ID:" + CUSTOM_ID);
			
			FRONT_URL = p.getProperty("FRONT_URL");
			logger.info("FRONT_URL:" + FRONT_URL);
			
			ENCONTACTS_PAGESIZE = Integer.parseInt(p.getProperty("ENCONTACTS_PAGESIZE"));
			logger.info("ENCONTACTS_PAGESIZE:" + ENCONTACTS_PAGESIZE);

        } catch (IOException e) {
        	logger.warn("Failed to init app configuration" + e.getMessage());
        	throw new RuntimeException("Failed to init app configuration", e);
        }
		logger.info("----------App configuration successfully----------");
    }
}
