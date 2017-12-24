package com.free4lab.newtest.api.action.groups;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.GroupManager;
import com.free4lab.account.model.Group;
import com.free4lab.newtest.action.base.BaseAction;

public class ModGroupAction extends BaseAction {

	/**
	 * 修改群组信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ModGroupAction.class);
	
	private int id;	
	private int userId;
	private String groupName;	
	
	private Group group = null;
	private String result = "fail";
	
	public String execute() throws Exception{
		group = GroupManager.updateGroup2(id, userId, groupName);
		if(group !=null ){
			result = "success";
		}
		return SUCCESS;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


}
