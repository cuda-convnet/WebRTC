package com.free4lab.newtest.action.engroups;


//import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EncontactManager;
import com.free4lab.account.manager.EngroupManager;
import com.free4lab.account.model.Encontact;
import com.free4lab.account.model.Engroup;
import com.free4lab.newtest.action.base.BaseAction;


public class FindEngroupAction extends BaseAction {

	/**
	 * 显示专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EngroupListAction.class);
	
	private List<Engroup> engroups;
	private Integer lfz;
	private Integer fz=0;
	private Integer eid = 0;
	private String fzmc;
	private List<Encontact> encontacts;
	private List<Engroup> engroupfathers1;
	private List<Engroup> engroupfathers;
	//private Map<Engroup> engroups1;
	private int page1=1;
	private int page2=1;
	private int size=10;
	private int count1;
	private int count2;
	
	private int total1;
	private int total2;

	
	
	
	@SuppressWarnings("unused")
	public String execute() throws Exception{
		//engroups = EngroupManager.findEngroupByUsernameLfz(getSessionUserEmail(),fz);
		//encontacts = EncontactManager.findEncontactByFz(fz);
		engroups = EngroupManager.findEngroupByEidForPage(eid,fz,page1-1,size);
		encontacts = EncontactManager.findEncontactByFzForPage(fz,page2-1,size);
//		count1=0;
//		count2=0;
		count1=(int) EngroupManager.countEngroupByEidForPage(eid,fz);
		count2=(int) EncontactManager.countEncontactByFzForPage(fz);
//		
//		if(count1>=count2) count=count1;
//		else count=count2;
		if(count1==size) total1=1;
		else total1=count1/size+1;
		if(count2==size) total1=1;
		else total2=count2/size+1;
		logger.info("count1="+count1+",count2="+count2+",size="+size);
		//groupfzmc=EngroupManager.findGroupNameByGroupId(fz);
		logger.info("haha");
		if(fz!=0){
			engroupfathers=EngroupManager.findGroupfatherListById(fz);
			Collections.reverse(engroupfathers);
		    //System.out.println("123"+(engroupfather.get(0)).getFzmc());
			//JSONArray engroupfathers=JSONArray.fromObject(engroupfathers1);
//			for(int i = 0, k = engroupfathers.size(); i < k; i++) {
//				engroupfather[i]=engroupfathers.get(i);
//	            System.out.println(engroupfathers.get(i));
	       // }
		};
		logger.info(getSessionUserEmail());
		logger.info("testfindencontact");
		logger.info("testfindengroup");
		System.out.println("zhaoyixia");
		return SUCCESS;
	}
	

	public List<Engroup> getEngroups() {
		return engroups;
	}

	public void setEngroups(List<Engroup> engroups) {
		this.engroups = engroups;
	}

	public Integer getLfz() {
		return lfz;
	}

	public void setLfz(Integer lfz) {
		this.lfz = lfz;
	}
	
	public List<Encontact> getEncontacts() {
	return encontacts;
	}

	public void setEncontacts(List<Encontact> encontacts) {
		this.encontacts = encontacts;
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

	public List<Engroup> getEngroupfathers() {
		return engroupfathers;
	}

	public void setEngroupfathers(List<Engroup> engroupfathers) {
		this.engroupfathers = engroupfathers;
	}


	public List<Engroup> getEngroupfathers1() {
		return engroupfathers1;
	}


	public void setEngroupfathers1(List<Engroup> engroupfathers1) {
		this.engroupfathers1 = engroupfathers1;
	}

	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}

	public int getCount1() {
		return count1;
	}


	public void setCount1(int count1) {
		this.count1 = count1;
	}


	public int getCount2() {
		return count2;
	}


	public void setCount2(int count2) {
		this.count2 = count2;
	}


	public int getTotal1() {
		return total1;
	}


	public void setTotal1(int total1) {
		this.total1 = total1;
	}


	public int getTotal2() {
		return total2;
	}


	public void setTotal2(int total2) {
		this.total2 = total2;
	}


	public int getPage1() {
		return page1;
	}


	public void setPage1(int page1) {
		this.page1 = page1;
	}


	public int getPage2() {
		return page2;
	}


	public void setPage2(int page2) {
		this.page2 = page2;
	}
	
}

	


