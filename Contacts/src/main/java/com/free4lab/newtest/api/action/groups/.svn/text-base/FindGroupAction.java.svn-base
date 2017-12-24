package com.free4lab.newtest.api.action.groups;

import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.GroupManager;
import com.free4lab.account.model.Group;
import com.free4lab.newtest.action.base.BaseAction;

public class FindGroupAction extends BaseAction {

	/**
	 * 显示专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FindGroupAction.class);
	
	private List<Group> groups;
	private Group group;
	
	private int userId;
	private int groupId;
	
	private String result="fail";
	
	//获取userId的所有分组
	public String execute() throws Exception{
		logger.info(userId);
		groups = GroupManager.findGroupByUsername(userId);
		if(!groups.isEmpty()){
			result = "success";
		}
		return SUCCESS;
	}
	
	//获取指定groupId的单一分组
	public String findSingleGroup() throws Exception{
		logger.info(groupId);
		group = GroupManager.findGroupById(groupId);
		if(group!=null){
			result = "success";
		}
		return SUCCESS;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
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
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public static void main(String[] args){

		Group group = GroupManager.findGroupById(55);
		System.out.println(group.toString());
		
 	}
	
}

