package com.webrtc.netty.dao;


import java.util.List;


import com.free4lab.utils.sql.AbstractDAO;
import com.free4lab.utils.sql.IEntityManagerHelper;
import com.free4lab.utils.sql.entitymanager.NoCacheEntityManagerHelper;

public class ReservationConfDAO extends AbstractDAO<ReservationConf>{
	
	@SuppressWarnings("rawtypes")
	@Override
	public Class getEntityClass() {
		return ReservationConf.class;
	}

	public static final String PU_NAME = "WebrtcCSPU";
	@Override
	public String getPUName() {
		return PU_NAME;
	}
		
	@Override
	public IEntityManagerHelper getEntityManagerHelper() {
		return new NoCacheEntityManagerHelper();
	}
	
	public String getClassName() {
		return getEntityClass().getName();
	}
	
	public List<ReservationConf> findConfnameByMembers(String username){
		List<ReservationConf> ReservationConfList = findByProperty2("members",username,"valid",1);
		if(ReservationConfList.isEmpty()){
			return null;
		}
		return ReservationConfList;
	}
	
    public static void main(String[] args){
		
    	ReservationConfDAO ReservationConfDao = new ReservationConfDAO();
		
    	List<ReservationConf> room = ReservationConfDao.findConfnameByMembers("9999");
		if(room != null){
			System.out.println(room.get(0).getConfname());
		}

	}
}
