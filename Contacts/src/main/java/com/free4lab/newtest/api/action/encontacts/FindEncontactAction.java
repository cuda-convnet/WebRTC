package com.free4lab.newtest.api.action.encontacts;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.omg.CORBA.INTERNAL;

import com.free4lab.newtest.common.Constants;
import com.free4lab.account.manager.EncontactManager;
import com.free4lab.account.manager.EngroupManager;
import com.free4lab.account.model.Encontact;
import com.free4lab.newtest.action.base.BaseAction;
import com.free4lab.utils.recommend.Constant;
import com.free4lab.utils.search.Keyword;
import com.free4lab.utils.search.KeywordSearcher;

public class FindEncontactAction extends BaseAction {

	/**
	 * 显示专业信息
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FindEncontactAction.class);
	
	//返回集
	private List<Encontact> encontacts;
	
	//按分组+页码搜索
	private Encontact encontact;
	private int encontactId;
	private Integer fz;
	private int page; //页数
	private int total;//被分成的总页数
	
	//按关键字搜索
	private int eid;
	private String keyword;
	
	private String result="error";
	
	//获取指定Fz的所有encontact项
	public String execute() throws Exception{
		logger.info(fz);
		logger.info(page);
		
		//计算总页数
		int size = Constants.ENCONTACTS_PAGESIZE;
		int count = EncontactManager.findEncontactByFz(fz).size();//总记录数
		if(count == 0)	total = 1;
		else
		{
			if(count % size == 0) //不多余
				total = count / size;
			else //多余出来几条记录
				total = count / size + 1;
		}
			
		//计算拉取到的第page页的所有成员的通讯信息
		encontacts = EncontactManager.findEncontactByFzForPage(fz, page-1, size);
		if(encontacts!=null && encontacts.size()>0){
			result = "success";
		}
		return SUCCESS;
	}
	
	//根据关键字keyword查询匹配的所有联系人
	public String findEncontactByKeyword() throws Exception
	{
		KeywordSearcher keywordSearcher = new KeywordSearcher();

		//1.获取通讯录中该企业下的所有成员
		List<Integer> fzids = EngroupManager.getFzidsInEnterprise(eid); //eid企业下所有分组的id
		List<Encontact> ectacs = EncontactManager.findEncontactsByFzIds(fzids);

		//2.获取所有成员的id和所有字段 组成的多关键字列表
		for(Encontact ectac:ectacs)
		{
			int id = ectac.getId();
			keywordSearcher.addKeyword(ectac.getLname()+ectac.getFname(), id);
			keywordSearcher.addKeyword(ectac.getSex(), id);
			keywordSearcher.addKeyword(ectac.getNc(), id);
			keywordSearcher.addKeyword(ectac.getBirth(), id);
			keywordSearcher.addKeyword(ectac.getZw(), id);
			keywordSearcher.addKeyword(ectac.getBm(), id);
			keywordSearcher.addKeyword(ectac.getTelp(), id);
			keywordSearcher.addKeyword(ectac.getMobp(), id);
			keywordSearcher.addKeyword(ectac.getEmails(), id);
			keywordSearcher.addKeyword(ectac.getAddress(), id);
			keywordSearcher.addKeyword(ectac.getPostcode(), id);
			keywordSearcher.addKeyword(ectac.getBz(), id);
		}

		//3.产生与keyword匹配的关键字结果
		List<Integer> resultIds = keywordSearcher.searchKeywords(keyword);

		//4.根据ids再次查询Encontact表并返回最终结果
		encontacts = EncontactManager.findEncontactsByIds(resultIds);
		if(encontacts != null  && encontacts.size()>0)
		{
			result = "success";
		}
		return SUCCESS;
	}
	
	//获取指定encontactId的单一项
	public String findSingleEncontact() throws Exception{
		logger.info(encontactId);
		encontact = EncontactManager.findEngroupById(encontactId);
		if(encontact!=null){
			result = "success";
		}
		return SUCCESS;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

	public Encontact getEncontact() {
		return encontact;
	}

	public void setEncontact(Encontact encontact) {
		this.encontact = encontact;
	}

	public int getEncontactId() {
		return encontactId;
	}

	public void setEncontactId(int encontactId) {
		this.encontactId = encontactId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}