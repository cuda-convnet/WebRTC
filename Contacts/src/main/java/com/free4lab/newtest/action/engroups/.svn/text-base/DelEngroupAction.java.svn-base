package com.free4lab.newtest.action.engroups;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EngroupManager;
import com.free4lab.newtest.action.base.BaseAction;

public class DelEngroupAction extends BaseAction {

	/**
	 * 删除分组信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EngroupListAction.class);
	
	private Integer fz;
	private String result = "fail";
	
	public String execute() throws Exception{
		logger.info("shanchu");
		if(EngroupManager.delEngroup(fz)){
			this.result = "success";
			logger.info("testdelengroup");
		}
		return SUCCESS;
	}

    public Integer getFz() {
		return fz;
	}

	public void setFz(Integer fz) {
		this.fz = fz;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
