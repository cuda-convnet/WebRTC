package com.free4lab.webrtc.manager;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.webrtc.dao.Enterprise;
import com.webrtc.dao.EnterpriseDAO;


public class EnterpriseManager {
	
	private static EnterpriseDAO enterpriseDAO = new EnterpriseDAO();
	private static final Logger LOGGER = Logger.getLogger(EnterpriseManager.class);
	
	//获取所有的企业
	public static List<Enterprise> getAllEnterprises() 
	{
		List<Enterprise> list = enterpriseDAO.findAll();
		if(list == null)
			return Collections.emptyList();
		else
			return list;
	}
}
