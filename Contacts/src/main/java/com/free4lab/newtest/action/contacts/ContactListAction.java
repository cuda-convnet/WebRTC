package com.free4lab.newtest.action.contacts;

import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.ContactManager;
import com.free4lab.account.model.Contact;
import com.free4lab.newtest.action.base.BaseAction;

public class ContactListAction extends BaseAction {

	/**
	 * 显示专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ContactListAction.class);
	
	private List<Contact> contacts;
	
	public String execute() throws Exception{
		contacts = ContactManager.getAllContacts();
		logger.info(getSessionUserEmail());
		logger.info("testchakan");
		System.out.println("rxtghf");
		return SUCCESS;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
