package com.free4lab.newtest.action.groups;

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
	private int page=1;
	private int size=10;
	private int count;
	private int total;
	
	public String execute() throws Exception{
		//groups = GroupManager.findGroupByUsername(getSessionUserEmail());
		groups = GroupManager.findGroupByUsernameForPage(getSessionUserID().intValue(),page-1,size);
		count=(int) GroupManager.countGroupByUsernameForPage(getSessionUserID().intValue());
		if(count%size==0) total=count/size;
		else total=count/size+1;
		logger.info("total="+total);
		logger.info(getSessionUserID());
		logger.info("testfindgroup");
		System.out.println("zhaoyixia");
		System.out.println(groups.toString());
		return SUCCESS;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}

