package com.free4lab.newtest.action.encontacts;

import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EncontactManager;
import com.free4lab.account.model.Encontact;
import com.free4lab.newtest.action.base.BaseAction;

public class FindEncontactAction extends BaseAction {

	/**
	 * 显示专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EncontactListAction.class);
	
	private Integer fz;
	private List<Encontact> encontacts;
	private int page=1;
	private int size=10;
	private int count;
	private int total;
	
	public String execute() throws Exception{
		//encontacts = EncontactManager.findEncontactByFz(fz);
		encontacts = EncontactManager.findEncontactByFzForPage(fz,page-1,size);
		count=(int) EncontactManager.countEncontactByFzForPage(fz);
		if(count==size) total=1;
		else total=count/size+1;
		logger.info(getSessionUserEmail());
		logger.info("testfindencontact");
		System.out.println("zhaoyixiaencontact");
		return SUCCESS;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

//	public String getFz() {
//		return fz;
//	}
//
//	public void setFz(String fz) {
//		this.fz = fz;
//	}
	
}
