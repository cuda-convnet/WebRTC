package com.free4lab.newtest.action.contacts;

import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.ContactManager;
import com.free4lab.account.model.Contact;
import com.free4lab.newtest.action.base.BaseAction;

public class FindContactAction extends BaseAction {

	/**
	 * 显示专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ContactListAction.class);
	
	private int groupId;
	private List<Contact> contacts;
	private String fzmc;
	private int page=1;
	private int size=10;
	private int count;
	private int total;
	
	public String execute() throws Exception{
		//contacts = ContactManager.findContactByFz(fz);
		contacts = ContactManager.findContactByFzForPage(groupId,page-1,size);
		count=(int) ContactManager.countContactByFzForPage(groupId);
		if(count==size) total=1;
		else total=count/size+1;
		logger.info(getSessionUserEmail());
		logger.info("testfindcontact");
		System.out.println("zhaoyixiacontact");
		return SUCCESS;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getFzmc() {
		return fzmc;
	}

	public void setFzmc(String fzmc) {
		this.fzmc = fzmc;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

//	public String getFz() {
//		return fz;
//	}
//
//	public void setFz(String fz) {
//		this.fz = fz;
//	}
	
}
