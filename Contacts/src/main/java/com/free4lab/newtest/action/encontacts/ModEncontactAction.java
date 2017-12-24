package com.free4lab.newtest.action.encontacts;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EncontactManager;
import com.free4lab.newtest.action.base.BaseAction;

public class ModEncontactAction extends BaseAction {

	/**
	 * 修改专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EncontactListAction.class);
	
	private Integer id;

	private String lname;
	private String fname;	
	private String sex;
	private String nc;
	private String birth;
	private String gh;
	private String zw;
	private String bm;
	private String telp;
	private String mobp;
	private String emails;
	private String address;
	private String postcode;
	private Integer fz;
	private String bz;
	
	public String execute() throws Exception{
		
		if(EncontactManager.updateEncontact(id, lname, fname, sex, nc, birth, gh, zw, 
				bm, telp, mobp, emails, address, postcode, fz, bz)){
			logger.info("test");
			System.out.println("aaaaaa");
		}
		return SUCCESS;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getNc() {
		return nc;
	}


	public void setNc(String nc) {
		this.nc = nc;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGh() {
		return gh;
	}
	
	public void setGh(String gh) {
		this.gh = gh;
	}

	public String getZw() {
		return zw;
	}


	public void setZw(String zw) {
		this.zw = zw;
	}


	public String getBm() {
		return bm;
	}


	public void setBm(String bm) {
		this.bm = bm;
	}


	public String getTelp() {
		return telp;
	}


	public void setTelp(String telp) {
		this.telp = telp;
	}


	public String getMobp() {
		return mobp;
	}


	public void setMobp(String mobp) {
		this.mobp = mobp;
	}


	public String getEmails() {
		return emails;
	}


	public void setEmails(String emails) {
		this.emails = emails;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	

	public String getPostcode() {
		return postcode;
	}
	
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
	public Integer getFz() {
		return fz;
	}
	
	
	public void setFz(Integer fz) {
		this.fz = fz;
	}
	

	public String getBz() {
		return bz;
	}


	public void setBz(String bz) {
		this.bz = bz;
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
