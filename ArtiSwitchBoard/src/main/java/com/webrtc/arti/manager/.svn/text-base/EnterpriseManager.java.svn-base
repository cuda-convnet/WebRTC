package com.webrtc.arti.manager;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.webrtc.arti.dao.Enterprise;
import com.webrtc.arti.dao.EnterpriseDAO;



public class EnterpriseManager {
	
	private static EnterpriseDAO enterpriseDAO = new EnterpriseDAO();
	private static final Logger LOGGER = Logger.getLogger(EnterpriseManager.class);
	
	//获取数据库中所有企业实体
	public static List<Enterprise> getAllEnterprises() {
		try{
			return enterpriseDAO.findAll();
		}catch (Exception e) {
			LOGGER.debug(e);
			return Collections.emptyList();
		}
	}
}
