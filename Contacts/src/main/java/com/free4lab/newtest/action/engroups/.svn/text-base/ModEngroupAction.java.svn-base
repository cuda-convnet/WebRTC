package com.free4lab.newtest.action.engroups;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EngroupManager;
import com.free4lab.newtest.action.base.BaseAction;

public class ModEngroupAction extends BaseAction {

	/**
	 * 修改专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EngroupListAction.class);
	
	private Integer fz;
	
	private Integer eid;
	private String fzmc;	
	private Integer lfz;
	
	
	public String execute() throws Exception{
		
		if(EngroupManager.updateEngroup(fz, eid, fzmc, lfz)){
			logger.info("testmodengroup");
			System.out.println("aaaaaa");
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
	

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getZydm() {
//		return zydm;
//	}
//
//	public void setZydm(String zydm) {
//		this.zydm = zydm;
//	}
//
//	public String getZymc() {
//		return zymc;
//	}
//
//	public void setZymc(String zymc) {
//		this.zymc = zymc;
//	}
//	
}
