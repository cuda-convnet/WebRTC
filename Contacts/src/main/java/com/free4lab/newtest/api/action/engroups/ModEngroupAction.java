package com.free4lab.newtest.api.action.engroups;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EngroupManager;
import com.free4lab.account.model.Engroup;
import com.free4lab.newtest.action.base.BaseAction;

public class ModEngroupAction extends BaseAction {

	/**
	 * 修改专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ModEngroupAction.class);
	
	private Integer fz; //分组号
	
//	private Integer eid; //企业名称
	private String fzmc; //分组名称
//	private Integer lfz; //父级分组号
	private Engroup engroup = null;
	private String result = "fail";
	
	public String execute() throws Exception{
		
		engroup = EngroupManager.updateEngroup2(fz,fzmc);
		if(engroup !=null ){
			result = "success";
		}
		return SUCCESS;
	}


	public Integer getFz() {
		return fz;
	}


	public void setFz(Integer fz) {
		this.fz = fz;
	}


	public String getFzmc() {
		return fzmc;
	}


	public void setFzmc(String fzmc) {
		this.fzmc = fzmc;
	}

	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public Engroup getEngroup() {
		return engroup;
	}


	public void setEngroup(Engroup engroup) {
		this.engroup = engroup;
	}
}