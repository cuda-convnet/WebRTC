package com.free4lab.newtest.api.action.engroups;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.From;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EngroupManager;
import com.free4lab.account.model.Engroup;
import com.free4lab.newtest.action.base.BaseAction;

public class FindEngroupAction extends BaseAction {

	/**
	 * 显示专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FindEngroupAction.class);

	private List<Engroup> engroups;
	private Engroup engroup;

	private Integer eid;
	private int fz;
	private int lfz;

	private String result = "fail";
	
	private List<Integer> engroupsSize;

	// 获取eid的所有分组
	public String execute() throws Exception {
		logger.info(eid);
		engroups = EngroupManager.findEngroupByEid(eid);
		if (engroups != null && engroups.size() > 0) {
			
			engroupsSize = findEngroupsSize(engroups);
			result = "success";
		}
		return SUCCESS;
	}

	
	// 获取指定fz的单一分组
	public String findSecondEngroups() throws Exception {
		logger.info(lfz);
		engroups = EngroupManager.findEngroupByLfz(lfz);
		if (engroups != null && engroups.size() > 0) {
			
			engroupsSize = findEngroupsSize(engroups);
			
			result = "success";
		}
		
		return SUCCESS;
	}
	
	//获取eid的各级分组
	public String findFirstEngroups() throws Exception {
		logger.info("eid="+eid+",lfz="+lfz);
		engroups = EngroupManager.findEngroupByEidLfz(eid, 0);
		if (engroups != null && engroups.size() > 0) {
			
			engroupsSize = findEngroupsSize(engroups);
			result = "success";
		}
		return SUCCESS;
	}

	//取得engroups中所有分组旗下分组的数量
	public List<Integer> findEngroupsSize(List<Engroup> engroups)
	{
		List<Integer> egSize = new ArrayList<Integer>();
		
		for(Engroup eg : engroups)
		{
			Integer size = EngroupManager.findEngroupByLfz(eg.getFz()).size();
			egSize.add(size);
		}
		
		return egSize;
	}
	
	public List<Engroup> getEngroups() {
		return engroups;
	}

	public void setEngroups(List<Engroup> engroups) {
		this.engroups = engroups;
	}

	public Engroup getEngroup() {
		return engroup;
	}

	public void setEngroup(Engroup engroup) {
		this.engroup = engroup;
	}

	

//	public Integer getFz() {
//		return fz;
//	}
//
//	public void setFz(Integer fz) {
//		this.fz = fz;
//	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getFz() {
		return fz;
	}

	public void setFz(int fz) {
		this.fz = fz;
	}
	
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public static void main(String[] args) {

//		Engroup engroup = EngroupManager.findEngroupByFz(1);
//		System.out.println(engroup.toString());
		
		List<Engroup> engroups =EngroupManager.findEngroupByEid("rxt2012kc@126.com");
		for(Engroup group : engroups){
			System.out.println(group.getEid()+" "+group.getLfz()+" "+group.getFz()+" "+group.getFzmc());
		}

	}


	public int getLfz() {
		return lfz;
	}


	public void setLfz(int lfz) {
		this.lfz = lfz;
	}
	
	public List<Integer> getEngroupsSize() {
		return engroupsSize;
	}


	public void setEngroupsSize(List<Integer> engroupsSize) {
		this.engroupsSize = engroupsSize;
	}

}
