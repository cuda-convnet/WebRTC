package com.webrtc.auto.menuhandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.webrtc.auto.common.AnswerCompo;
import com.webrtc.auto.common.Constants;
import com.webrtc.auto.common.MenuStateType;
import com.webrtc.auto.dao.Encontact;
import com.webrtc.auto.dao.Engroup;
import com.webrtc.auto.dao.Keyword;
import com.webrtc.auto.dao.KeywordSearcher;
import com.webrtc.auto.domain.Session;
import com.webrtc.auto.domain.Step;
import com.webrtc.auto.manager.EncontactManager;
import com.webrtc.auto.manager.EngroupManager;

/**
 * 在XX菜单状态下接收到信息后的处理
 * 基类
 */
public abstract class MenuHandler 
{
	protected final int HEAD = AnswerCompo.HEAD;
	protected final int BODY = AnswerCompo.BODY;
	protected final int FOOTER = AnswerCompo.FOOTER;
	
	/**
	 * 需被实现的特色方法
	 */
	public abstract String[] answerQuestion(Session session,String question);
	public abstract int getType();
	
	/**
	 * 共用的方法(菜单页面跳转动作)
	 */
	
	//进入首页
	public String[] moveToFirst(){

		String[] answer = {"","",""};
 		answer[FOOTER] = "1按姓名 / 邮箱 / 电话 / 地址等查号,2按分组查号,3直接输入账号查询";
		
		return answer;
	}
	
	//进入输入账号的查询页
	public String[] moveToQueryByUserName()
	{
		String[] answer = {"","",""};
		answer[HEAD] = "请输入您想呼叫的账号：";
		answer[FOOTER] = "#返回上级,&返回首页";
		
		return answer;
	}
	
	//进入账号查询结果页
	public String[] moveToQueryByUserNameResult(Session session,String username)
	{
		String[] answer = {"","",""};
		answer[HEAD] = "查询结果：";
		
		//根据eid查询该企业下的所有分组ids（engroups表）
		List<Integer> fzids = EngroupManager.getFzidsInEnterprise(session.getEid());
		
		//根据查到的分组ids查询有没有一个叫username的用户（encontact表）
		List<Encontact> encontacts = EncontactManager.findEncontactsByUsernameAndFzIds(username, fzids);
		
		if(encontacts.size() > 0) //存在
		{
			Encontact encontact = encontacts.get(0);
			answer[BODY] = encontact.getLname()+encontact.getFname() + ":" + encontact.getEmails()+",";
		}
		else //不存在 
		{
			answer[HEAD] += "<br>抱歉，暂无该账号"; 
		}
		answer[FOOTER] = "#返回上级,&返回首页";
		
		return answer;
	}
	
	//进入查用户名页
	public String[] moveToQueryByKeyword()
	{	
		String[] answer = {"","",""};
		answer[HEAD] = "请输入关键字：";
		answer[FOOTER] = "#返回上级,&返回首页";
		
		return answer;
	}
	
	//进入查用户名结果页(模糊搜索关键字匹配的用户名!!!!!!!!!!!!!!!!!!)
	public String[] moveToQueryByKeywordResult(Session session, String keyword, int page)
	{
		String[] answer = {"","",""};
		answer[HEAD] = "查询结果：";
		
		Step curStep = session.getStepStack().peek();
		
		/*
		 * 调用接口：搜索匹配的关键字
		 */
		KeywordSearcher keywordSearcher = new KeywordSearcher();
		//List<Keyword> keywords = keywordSearcher.searchKeywords(keyword, "com.webrtc.auto.dao", "User", "real_name", "id"); //通用关键字模糊匹配写法
		
		//1.获取通讯录中该企业下的所有成员
		List<Integer> fzids = EngroupManager.getFzidsInEnterprise(session.getEid()); //eid企业下所有分组的id
		List<Encontact> encontacts = EncontactManager.findEncontactsByFzIds(fzids);

		//2.获取所有成员的id和真实姓名组成两个列表
		for(Encontact encontact:encontacts)
		{
			int id = encontact.getId();
			keywordSearcher.addKeyword(encontact.getLname()+encontact.getFname(), id);
			keywordSearcher.addKeyword(encontact.getSex(), id);
			keywordSearcher.addKeyword(encontact.getNc(), id);
			keywordSearcher.addKeyword(encontact.getBirth(), id);
			keywordSearcher.addKeyword(encontact.getZw(), id);
			keywordSearcher.addKeyword(encontact.getBm(), id);
			keywordSearcher.addKeyword(encontact.getTelp(), id);
			keywordSearcher.addKeyword(encontact.getMobp(), id);
			keywordSearcher.addKeyword(encontact.getEmails(), id);
			keywordSearcher.addKeyword(encontact.getAddress(), id);
			keywordSearcher.addKeyword(encontact.getPostcode(), id);
			keywordSearcher.addKeyword(encontact.getBz(), id);
		}
		
		//3.产生与keyword匹配的关键字结果
		List<Integer> resultIds = keywordSearcher.searchKeywords(keyword);
		if(resultIds == null || resultIds.size() <= 0)
		{
			answer[HEAD] += "<br>抱歉，暂无匹配项"; 
		}
		else
		{
			List<Integer> resultIdsForPage = new ArrayList<Integer>();
			int totalRow = resultIds.size(); //搜到的总记录数
			int totalPage = totalRow % Constants.AUTO_PAGESIZE == 0 ? totalRow / Constants.AUTO_PAGESIZE : totalRow / Constants.AUTO_PAGESIZE + 1 ; //总页数	
			int start = (page-1)*Constants.AUTO_PAGESIZE;
	
			for(int i=start; i < resultIds.size() && i < start + Constants.AUTO_PAGESIZE;i++)
				resultIdsForPage.add(resultIds.get(i));
		
			//更新当前所在页及最大页数
			curStep.setCurPage(page);
			curStep.setTotalPage(totalPage);
			
			//打印：
			//根据results中搜索到id查询encontact表中的email并返回结果
			encontacts = EncontactManager.findEncontactsByIds(resultIdsForPage);
			for(int i=0;i<encontacts.size();i++)
			{
				Encontact encontact = encontacts.get(i);
				answer[BODY] += encontact.getLname()+encontact.getFname() + ":" + encontact.getEmails()+",";
			}
			
			//打印分页
			answer[FOOTER] += MenuUtils.showPager(page, totalPage);
		}
		
		answer[FOOTER] += "#返回上级,&返回首页";
		
		return answer;
	}
	
	//进入当前分组里面的所有分组名单
	public String[] moveToQueryByFZ(Session session,int page)
	{
		String[] answer = {"","",""};
		
		Stack<Step> stepStack = session.getStepStack(); //步骤栈
		Step curStep = stepStack.peek(); //当前步骤
		
		//更新当前级菜单的当前页数
		curStep.setCurPage(page);
		
    	//打印用户选择菜单的路径
		answer[HEAD] = "当前分组路径：" ;
		for(Step step : stepStack)
			if(step.getCurMenu() != MenuStateType.FIRST 
			&& step.getCurMenu() != MenuStateType.QUERYBYFZRESULT) //当为首页、一级分组、结果页时不打印
				answer[HEAD] += step.getCurLfzmc() + "//";
		
		//打印当前所在分组的管理员是谁
		int lfz = curStep.getCurLfz();
		
		if(curStep.getCurMenu() == MenuStateType.QUERYBYFZRESULT)
		{
			answer[HEAD] += "</br>当前分组成员情况：";
			
			//获取数据库中lfz旗下所有成员情况
			List<Encontact> encontacts = EncontactManager.findEncontactByFzForPage(lfz, page-1, Constants.AUTO_PAGESIZE);
			if(encontacts != null && encontacts.size() > 0)
			{
				for(int i=0;i<encontacts.size();i++)
				{
					Encontact encontact = encontacts.get(i);
					answer[BODY] += encontact.getLname()+encontact.getFname() + ":"+ encontact.getEmails() + ","; 
				}
			}
			else
				answer[HEAD] += "</br>暂无成员";
	
			//打印分页
			answer[FOOTER] += MenuUtils.showPager(page,curStep.getTotalPage());
		}
		else
		{
			List<Engroup> groups = EngroupManager.findByEidLfzForPage(session.getEid(),lfz,page,Constants.AUTO_PAGESIZE);
			if(groups == null || groups.size() <= 0)
			{
				answer[HEAD] += "</br>已是最底层分组";
			}
			else
			{
				//获取数据库中lfz旗下所有分组情况
				answer[HEAD] += "</br>请点击下列分组进入：";
				for(int i=0;i<groups.size();i++)
				{
					Engroup group = groups.get(i);
					answer[BODY] += group.getFz()+":"+group.getFzmc()+","; 
				}
			}
			//打印分页
			answer[FOOTER] += MenuUtils.showPager(page,curStep.getTotalPage());
			answer[FOOTER] += "@显示当前分组成员,";
		}

		answer[FOOTER] += "#返回上级,&返回首页";
		
		return answer;
	}
}
