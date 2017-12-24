package com.free4lab.newtest.action.engroups;

//import javax.persistence.Column;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EngroupManager;
import com.free4lab.newtest.action.base.BaseAction;

public class AddEngroupAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 增加个人分组信息
	 */
	private static final Logger logger = Logger.getLogger(EngroupListAction.class);
	
	private Integer eid;
	private String fzmc;
	private Integer lfz;

	
	public String execute() throws Exception{
		if(EngroupManager.addEngroup(eid, fzmc, lfz)){
			logger.info("testaddengroup");
			System.out.println("abcdefg");
		}
		return SUCCESS;
	}


	public String getFzmc() {
		return fzmc;
	}


	public void setFzmc(String fzmc) {
		this.fzmc = fzmc;
	}


	public Integer getLfz() {
		return lfz;
	}


	public void setLfz(Integer lfz) {
		this.lfz = lfz;
	}




	public Integer getEid() {
		return eid;
	}




	public void setEid(Integer eid) {
		this.eid = eid;
	}

	
}
