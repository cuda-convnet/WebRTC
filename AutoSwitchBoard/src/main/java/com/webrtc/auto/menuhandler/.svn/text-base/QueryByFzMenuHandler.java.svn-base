package com.webrtc.auto.menuhandler;

import java.util.Stack;

import com.webrtc.auto.common.MenuStateType;
import com.webrtc.auto.common.QuestionType;
import com.webrtc.auto.domain.Session;
import com.webrtc.auto.domain.Step;
import com.webrtc.auto.manager.EncontactManager;
import com.webrtc.auto.manager.EngroupManager;


public class QueryByFzMenuHandler extends MenuHandler
{
	@Override
	public String[] answerQuestion(Session session, String question) 
	{
		String[] answer = {"","",""};
		
		//获取步骤栈
		Stack<Step> stepStack = session.getStepStack();
		Step curStep = stepStack.peek();
		int curMenu = curStep.getCurMenu();
		
		if(question.equals(QuestionType.TOLASTPAGE))
     	{
    		//检查分页是否在合法范围内
     		int curPage = curStep.getCurPage();
    		if(curPage <= 1)
    		{
    			answer[HEAD] = "已到首页，请重新输入";
    		}
    		else
    		{
    			answer = moveToQueryByFZ(session,curPage - 1);
    		}
     	}
     	else if(question.equals(QuestionType.TONEXTPAGE))
     	{
    		//检查分页是否在合法范围内
     		int curPage = curStep.getCurPage();
    		int totalPage = curStep.getTotalPage();
    		if(curPage >= totalPage)
    		{
    			answer[HEAD] = "已到尾页，请重新输入";
    		}
    		else
    		{
    			answer = moveToQueryByFZ(session,curPage + 1);
    		}
     	}
     	else if(question.equals(QuestionType.SHOWRESULT))
     	{
     		int lfz = curStep.getCurLfz();
     		int totalPage = MenuUtils.getTotalPage(EncontactManager.findEncontactByFz(lfz).size()); //需要分成的总页数
     		String lfzmc = lfz != 0 ? EngroupManager.findEngroupByFz(lfz).getFzmc() : "企业";
     		stepStack.push(new Step(MenuStateType.QUERYBYFZRESULT, lfz, lfzmc,1, totalPage));
     		answer = moveToQueryByFZ(session, 1);
     	}
     	else if(question.equals(QuestionType.BACKTOLASTMENU))
     	{
     		stepStack.pop(); //弹出当前步骤,成为上一步骤
     		if(curMenu == MenuStateType.QUERYBYFZ1)
     		{
     			answer = moveToFirst();
     		}
     		else
     		{
	     		answer = moveToQueryByFZ(session,1);
     		}
     	}
     	else if(question.equals(QuestionType.BACKTOFIRSTMENU)) //返回首页
    	{
     		stepStack.clear();
     		stepStack.push(new Step(MenuStateType.FIRST, 0,"" ,1, 1));
     		answer = moveToFirst();
    	}
     	else
     	{
     		if(curMenu == MenuStateType.QUERYBYFZRESULT)
     		{
     			answer[HEAD] = "信息有误，请重新输入";
     		}
     		else
     		{
     			int lfz = MenuUtils.toIntegerLfz(question);
	    		int totalPage = MenuUtils.getTotalPage(EngroupManager.findEngroupByEidLfz(session.getEid(),lfz).size()); //需要分成的总页数
	    		String lfzmc = EngroupManager.findEngroupByFz(lfz).getFzmc();
	    		stepStack.push(new Step(curMenu + 1, lfz ,lfzmc,1,totalPage)); //存入用户选择栈
	    		answer = moveToQueryByFZ(session,1);
     		}
     	}
		
		return answer;
	}

	@Override
	public int getType()
	{
		return MenuStateType.QUERYBYFZ1;
	}
}
