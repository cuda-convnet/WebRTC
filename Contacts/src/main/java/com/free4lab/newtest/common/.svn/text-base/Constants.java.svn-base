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

        } catch (IOException e) {
        	logger.warn("Failed to init app configuration" + e.getMessage());
        	throw new RuntimeException("Failed to init app configuration", e);
        }
		logger.info("----------App configuration successfully----------");
    }
}
