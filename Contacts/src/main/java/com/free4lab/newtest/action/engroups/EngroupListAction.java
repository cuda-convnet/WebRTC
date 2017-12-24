package com.free4lab.newtest.action.engroups;

import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EngroupManager;
import com.free4lab.account.model.Engroup;
import com.free4lab.newtest.action.base.BaseAction;

public class EngroupListAction extends BaseAction {

	/**
	 * 显示专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EngroupListAction.class);
	
	private List<Engroup> engroups;
	
	public String execute() throws Exception{
		engroups = EngroupManager.getAllEngroups();
		logger.info(getSessionUserEmail());
		logger.info("testchakan");
		System.out.println("rxtghf");
		return SUCCESS;
	}

	public List<Engroup> getEngroups() {
		return engroups;
	}

	public void setEngroups(List<Engroup> engroups) {
		this.engroups = engroups;
	}
	
}
