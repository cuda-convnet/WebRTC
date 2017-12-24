package com.free4lab.newtest.api.action.encontacts;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EncontactManager;
import com.free4lab.newtest.action.base.BaseAction;

public class DelEncontactAction extends BaseAction {

	/**
	 * 删除专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DelEncontactAction.class);
	
	private String encontactIds;
	private String result = "fail";
	
	public String execute() throws Exception{
		
		String[] ids = encontactIds.split(",");
		int successes = 0;
		for(String id : ids)
		{
			int ecid = Integer.parseInt(id);
			if(EncontactManager.delEncontact(ecid))
			{
				successes++;
				logger.info("test");
			}
		}
		
		if(successes == ids.length)
			result = "success";
		
		return SUCCESS;
	}


	public String getEncontactIds() {
		return encontactIds;
	}


	public void setEncontactIds(String encontactIds) {
		this.encontactIds = encontactIds;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
