package com.free4lab.newtest.api.action.contacts;

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
	private static final Logger logger = Logger.getLogger(FindContactAction.class);
	

	private List<Contact> contacts;
	private Contact contact;
	private int groupId;
	private int contactId;
	
	private String result="error";
	
	//获取指定groupId的所有contact项
	public String execute() throws Exception{
		logger.info(groupId);
		contacts = ContactManager.findContactByFz(groupId);
		if(contacts!=null && contacts.size()>0){
			result = "success";
		}
		return SUCCESS;
	}

	//获取指定contactId的单一项
	public String findSingleContact() throws Exception{
		logger.info(contactId);
		contact = ContactManager.findGroupById(contactId);
		if(contact!=null){
			result = "success";
		}
		return SUCCESS;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
