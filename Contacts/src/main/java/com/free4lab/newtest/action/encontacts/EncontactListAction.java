package com.free4lab.newtest.action.encontacts;

import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EncontactManager;
import com.free4lab.account.model.Encontact;
import com.free4lab.newtest.action.base.BaseAction;

public class EncontactListAction extends BaseAction {

	/**
	 * 显示专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EncontactListAction.class);
	
	private List<Encontact> encontacts;
	
	public String execute() throws Exception{
		encontacts = EncontactManager.getAllEncontacts();
		logger.info(getSessionUserEmail());
		logger.info("testchakan");
		System.out.println("rxtghf");
		return SUCCESS;
	}

	public List<Encontact> getEncontacts() {
		return encontacts;
	}

	public void setEncontacts(List<Encontact> encontacts) {
		this.encontacts = encontacts;
	}
	
}
