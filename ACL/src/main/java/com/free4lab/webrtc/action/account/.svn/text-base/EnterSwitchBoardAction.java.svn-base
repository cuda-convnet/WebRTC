package com.free4lab.webrtc.action.account;

import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.utils.action.BaseAction;
import com.free4lab.webrtc.manager.EnterpriseManager;
import com.webrtc.dao.Enterprise;

/**
 * 初次进入总机业务首页时，获取所有企业信息
 */

public class EnterSwitchBoardAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	private final Logger logger = Logger.getLogger(EnterSwitchBoardAction.class);
	
	//所有企业的信息
	private List<Enterprise> enterprises;
	
	public String execute() throws Exception{
		
		enterprises = EnterpriseManager.getAllEnterprises();
		
		return SUCCESS;
	}
	
	public List<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}
}
