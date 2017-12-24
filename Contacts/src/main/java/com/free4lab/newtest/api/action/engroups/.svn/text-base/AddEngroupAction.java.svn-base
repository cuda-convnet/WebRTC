package com.free4lab.newtest.api.action.engroups;

//import javax.persistence.Column;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EngroupManager;
import com.free4lab.account.model.Engroup;
import com.free4lab.newtest.action.base.BaseAction;

public class AddEngroupAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 增加个人分组信息
	 */
	private static final Logger logger = Logger.getLogger(AddEngroupAction.class);
	
	private Integer eid;
	private String fzmc;
	private Integer lfz;
	private String result="fail";
	
	private Engroup engroup = null;
	
	public String execute() throws Exception{
		engroup = EngroupManager.addEngroup2(eid, fzmc, lfz);
		if(engroup !=null){
			result = "success";
		}
		return SUCCESS;
	}

	
	public Integer getEid() {
		return eid;
	}


	public void setEid(Integer eid) {
		this.eid = eid;
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

	public Engroup getEngroup() {
		return engroup;
	}

	public void setEngroup(Engroup engroup) {
		this.engroup = engroup;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

