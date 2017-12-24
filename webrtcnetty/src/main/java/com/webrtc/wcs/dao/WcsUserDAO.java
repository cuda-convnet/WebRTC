package com.webrtc.wcs.dao;


import java.util.List;

import com.free4lab.utils.sql.AbstractDAO;
import com.free4lab.utils.sql.IEntityManagerHelper;
import com.free4lab.utils.sql.entitymanager.NoCacheEntityManagerHelper;

public class WcsUserDAO extends AbstractDAO<WcsUser> {
	public String getClassName() {
        return getEntityClass().getName();
    }

    public Class<WcsUser> getEntityClass() {
        return WcsUser.class;
    }
    public static final String PU_NAME = "AccountPU";

    public String getPUName() {
        return PU_NAME;
    }

    public IEntityManagerHelper getEntityManagerHelper() {
        return new NoCacheEntityManagerHelper();
    }
   
	public List<WcsUser> findWcsUserByuserId(String user_id){
		List<WcsUser> WcsUserList = findByProperty("user_id", user_id);
		if(WcsUserList.isEmpty()){
			return null;
		}
		return WcsUserList;
	}

    public static void main(String[] args){
		
    	WcsUserDAO wcsuserDAO = new WcsUserDAO();
		
    	List<WcsUser> wcsuser = wcsuserDAO.findWcsUserByuserId("9999");
		if(wcsuser != null){
			System.out.println(wcsuser.get(0).getStatus());
		}

	}
}
