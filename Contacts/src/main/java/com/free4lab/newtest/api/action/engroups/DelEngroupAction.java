package com.free4lab.newtest.api.action.engroups;

import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.EncontactManager;
import com.free4lab.account.manager.EngroupManager;
import com.free4lab.account.model.Encontact;
import com.free4lab.account.model.Engroup;
import com.free4lab.newtest.action.base.BaseAction;

public class DelEngroupAction extends BaseAction {

	/**
	 * 删除分组信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DelEngroupAction.class);
	
	private Integer fz;
	private String result = "fail";
	
	public String execute() throws Exception{
		logger.info("shanchu");
		
		//1.级联删除旗下的所有子分组和各自的encontacts
		List<Engroup> secondEngroups = EngroupManager.findEngroupByLfz(fz); //获取所有二级分组
		if(secondEngroups != null && secondEngroups.size() > 0)
		{
			for(Engroup secondEngroup : secondEngroups)
			{
				List<Engroup> thirdEngroups = EngroupManager.findEngroupByLfz(secondEngroup.getFz()); //获取所有三级分组
				if(thirdEngroups != null && thirdEngroups.size() > 0)
				{
					for(Engroup thirdEngroup : thirdEngroups)
					{
						delEngroupAndEncontactsByFz(thirdEngroup.getFz());//删除该三级分组
					}
				}
				
				delEngroupAndEncontactsByFz(secondEngroup.getFz());//删除该二级分组
			}
		}
		delEngroupAndEncontactsByFz(fz); //删除一级分组
		
		this.result = "success";
		return SUCCESS;
	}

	//删除fz自身+旗下的所有联系人
	public void delEngroupAndEncontactsByFz(int fz)
	{
		EngroupManager.delEngroup(fz); //删除fz分组
		List<Encontact> encontacts = EncontactManager.findEncontactByFz(fz);
		if(encontacts == null || encontacts.size() <= 0)
			return;
		
		for(Encontact encontact : encontacts)
		{
			EncontactManager.delEncontact(encontact.getId());
		}
	}
	
	
    public Integer getFz() {
		return fz;
	}

	public void setFz(Integer fz) {
		this.fz = fz;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
