package com.free4lab.newtest.api.action.contacts;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.ContactManager;
import com.free4lab.newtest.action.base.BaseAction;

public class DelContactAction extends BaseAction {

	/**
	 * 删除专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DelContactAction.class);
	
	private int id;
	private String result = "fail";
	
	public String execute() throws Exception{
		if(ContactManager.delContact(id)){
			this.result = "success";
			logger.info("test");
		}
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
