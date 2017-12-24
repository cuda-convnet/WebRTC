package com.free4lab.newtest.api.action.groups;

//import javax.persistence.Column;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.GroupManager;
import com.free4lab.account.model.Group;
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
	private int userId;
	//群组名称
	private String groupName;
	
	private String result="fail";
	
	private Group group = null;
	
	public String execute() throws Exception{
		group = GroupManager.addGroup2(userId, groupName);
		if(group !=null){
			result = "success";
		}
		return SUCCESS;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
