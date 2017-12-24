package com.free4lab.webrtc.action.enteruser;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.account.manager.AccountManager;
import com.free4lab.account.manager.EnteruserManager;
import com.free4lab.account.model.Account;
import com.free4lab.account.model.Enteruser;
import com.free4lab.utils.search.KeywordSearcher;
import com.free4lab.webrtc.action.base.BaseAction;
import com.free4lab.webrtc.common.Constants;

/**
 * eid中企业用户的业务配置相关操作（改、查）
 */
public class ExecuteBusinessDeployAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ExecuteBusinessDeployAction.class);
	
	/*
	 * 返回
	 */
	private List<Account> accounts;
	private List<Enteruser> enterusers;
	private Enteruser enteruser; //修改成功后返回，同步更新前台展示
	private String result="error";
	
	/*
	 * 输入
	 */
	private int eid;
	
	//1.按分组+页码搜索
	private int page; //页数
	private int total;//被分成的总页数
	
	//2.按关键字搜索
	private String keyword;
	
	//3.修改配置
	private Integer id;
	private Integer maxcalltime;
	private Integer isadmin;
	private Integer isarti;
	private Integer isbindtimer;
	private Integer priority;	
	private Integer maxservingnum;
	private Time loginTime;
	private Time logoutTime;

	
	
	
	//查(按页数)
	public String queryByPage() throws Exception
	{
		//计算总页数
		int size = Constants.ENTERUSER_PAGESIZE;
		int count = EnteruserManager.getByEid(eid).size();//总记录数
		if(count == 0)	total = 1;
		else
		{
			if(count % size == 0) //不多余
				total = count / size;
			else //多余出来几条记录
				total = count / size + 1;
		}
			
		//计算拉取到的第page页的所有企业成员的信息
		enterusers = EnteruserManager.getByEidForPage(eid, page-1, size);
		if(enterusers != null && enterusers.size() > 0)
		{
			//拉取账户信息（主要是用户名）
			accounts = new ArrayList<Account>();
			for(Enteruser eu:enterusers)
				accounts.add(AccountManager.getAccountByUid(eu.getUid()));
			
			if(accounts != null && accounts.size() > 0)
				result = "success";
		}
		return SUCCESS;
	}
	
	//查(按关键字)
	public String queryByKeyword() throws Exception
	{
		KeywordSearcher keywordSearcher = new KeywordSearcher();

		//1.获取该企业下的所有企业成员
		List<Enteruser> enusers = EnteruserManager.getByEid(eid);
		List<Integer> uids = new ArrayList<Integer>();
		for(Enteruser eu:enusers)
			uids.add(eu.getUid());
		List<Account> accs = AccountManager.getAccountByIds(uids); //获取他们账户，以其中字段作为关键字

		//2.获取所有企业成员的id和邮箱字段 组成的多关键字列表
		for(Account acc:accs)
		{
			int id = acc.getId();
			keywordSearcher.addKeyword(acc.getEmail(), id);
		}

		//3.产生与keyword匹配的关键字结果
		List<Integer> resultIds = keywordSearcher.searchKeywords(keyword);
		
		//4.根据ids再次查询Encontact表并返回最终结果
		enterusers = EnteruserManager.getByUids(resultIds);
		if(enterusers != null  && enterusers.size()>0)
		{
			//拉取账户信息（主要是用户名）
			accounts = new ArrayList<Account>();
			for(Enteruser eu:enterusers)
				accounts.add(AccountManager.getAccountByUid(eu.getUid()));

			if(accounts != null && accounts.size() > 0)
				result = "success";
		}
		return SUCCESS;
	}
	
	//改
	public String modify() throws Exception
	{
		logger.info(id);
		logger.info(maxcalltime);
		logger.info(isadmin);
		logger.info(isarti);
		logger.info(isbindtimer);
		logger.info(priority);
		logger.info(maxservingnum);
		logger.info(loginTime);
		logger.info(logoutTime);
		
		enteruser = EnteruserManager.updateEnteruser(id,maxcalltime,isadmin,isarti,isbindtimer,priority,maxservingnum,loginTime,logoutTime);
		if(enteruser != null)
			result = "success";

		return SUCCESS;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public List<Enteruser> getEnterusers() {
		return enterusers;
	}

	public void setEnterusers(List<Enteruser> enterusers) {
		this.enterusers = enterusers;
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMaxcalltime() {
		return maxcalltime;
	}

	public void setMaxcalltime(Integer maxcalltime) {
		this.maxcalltime = maxcalltime;
	}

	public Integer getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(Integer isadmin) {
		this.isadmin = isadmin;
	}

	public Integer getIsarti() {
		return isarti;
	}

	public void setIsarti(Integer isarti) {
		this.isarti = isarti;
	}

	public Integer getIsbindtimer() {
		return isbindtimer;
	}

	public void setIsbindtimer(Integer isbindtimer) {
		this.isbindtimer = isbindtimer;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getMaxservingnum() {
		return maxservingnum;
	}

	public void setMaxservingnum(Integer maxservingnum) {
		this.maxservingnum = maxservingnum;
	}

	public Time getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Time loginTime) {
		this.loginTime = loginTime;
	}

	public Time getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Time logoutTime) {
		this.logoutTime = logoutTime;
	}
}