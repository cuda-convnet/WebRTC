package com.free4lab.newtest.action.groups;

//import javax.persistence.Column;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.GroupManager;
import com.free4lab.newtest.action.base.BaseAction;

public class AddGroupAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 增加个人分组信息
	 */
	private static final Logger logger = Logger.getLogger(AddGroupAction.class);
	
	//这个组属于的人的userId
	private Integer userId;
	//群组名称
	private String groupName;
	
	public String execute() throws Exception{
		if(GroupManager.addGroup(userId, groupName)){
			logger.info("testaddgroup");
		}
		return SUCCESS;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
