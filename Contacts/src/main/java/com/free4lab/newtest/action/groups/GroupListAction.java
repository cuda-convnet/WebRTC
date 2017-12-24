package com.free4lab.newtest.action.groups;

import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.GroupManager;
import com.free4lab.account.model.Group;
import com.free4lab.newtest.action.base.BaseAction;

public class GroupListAction extends BaseAction {

	/**
	 * 显示专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GroupListAction.class);
	
	private List<Group> groups;
	
	public String execute() throws Exception{
		groups = GroupManager.getAllGroups();
		logger.info(getSessionUserEmail());
		logger.info("testchakan");
		System.out.println("rxtghf");
		return SUCCESS;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
}
