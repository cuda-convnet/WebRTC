package com.free4lab.newtest.action.groups;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.GroupManager;
import com.free4lab.newtest.action.base.BaseAction;

public class ModGroupAction extends BaseAction {

	/**
	 * 修改群组信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ModGroupAction.class);
	
	private Integer id;	
	private Integer userId;
	private String groupName;	
	
	public String execute() throws Exception{
		
		if(GroupManager.updateGroup(id, userId, groupName)){
			logger.info("testmodgroup");
			System.out.println("aaaaaa");
		}
		return SUCCESS;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


}
