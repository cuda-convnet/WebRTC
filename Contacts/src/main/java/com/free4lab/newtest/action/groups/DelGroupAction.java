package com.free4lab.newtest.action.groups;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.GroupManager;
import com.free4lab.newtest.action.base.BaseAction;

public class DelGroupAction extends BaseAction {

	/**
	 * 删除分组信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DelGroupAction.class);
	
	//要删除的分组的id号
	private Integer id;
	private String result = "fail";
	
	public String execute() throws Exception{
		logger.info("id = "+id);
		if(GroupManager.delGroup(id)){
			this.result = "success";
			logger.info("testdelgroup");
		}
		return SUCCESS;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
