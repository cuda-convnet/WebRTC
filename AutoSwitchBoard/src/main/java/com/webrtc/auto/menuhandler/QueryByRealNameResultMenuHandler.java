package com.webrtc.auto.menuhandler;

import java.util.Stack;

import com.webrtc.auto.common.MenuStateType;
import com.webrtc.auto.common.QuestionType;
import com.webrtc.auto.domain.Session;
import com.webrtc.auto.domain.Step;

public class QueryByRealNameResultMenuHandler extends MenuHandler
{
	@Override
	public String[] answerQuestion(Session session, String question) 
	{
		String[] answer = {"","",""};
		
		//获取步骤栈
		Stack<Step> stepStack = session.getStepStack();
		Step curStep = stepStack.peek();
		
		if(question.equals(QuestionType.BACKTOLASTMENU)) //返回上一级
    	{
			stepStack.pop();
     		answer = moveToQueryByKeyword();
    	}
     	else if(question.equals(QuestionType.BACKTOFIRSTMENU))
     	{
     		stepStack.clear();
     		stepStack.push(new Step(MenuStateType.FIRST, 0,"",1, 1));
     		answer = moveToFirst();
     	}
     	else if(question.equals(QuestionType.TOLASTPAGE))
     	{
    		//检查分页是否在合法范围内
     		int curPage = curStep.getCurPage();
    		if(curPage <= 1)
    		{
    			answer[HEAD] = "已到首页，请重新输入";
    		}
    		else
    		{
    			answer = moveToQueryByKeywordResult(session, curStep.getMessage() ,curPage - 1);
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
    			answer = moveToQueryByKeywordResult(session, curStep.getMessage() ,curPage + 1);
    		}
     	}
     	else 
     	{
    		answer[HEAD] = "信息有误，请重新输入";
		}
		
		return answer;
	}

	@Override
	public int getType()
	{
		return MenuStateType.QUERYBYKEYWORDRESULT;
	}
}
