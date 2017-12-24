package com.webrtc.auto.menuhandler;

import java.util.Stack;

import com.webrtc.auto.common.MenuStateType;
import com.webrtc.auto.common.QuestionType;
import com.webrtc.auto.domain.Session;
import com.webrtc.auto.domain.Step;

public class QueryByRealNameMenuHandler extends MenuHandler
{
	
	@Override
	public String[] answerQuestion(Session session, String question) 
	{
		String[] answer = {"","",""};
		
		//获取步骤栈
		Stack<Step> stepStack = session.getStepStack();
		
		if(question.equals(QuestionType.BACKTOLASTMENU) || question.equals(QuestionType.BACKTOFIRSTMENU)) //返回上一级
    	{
			stepStack.pop();
     		answer = moveToFirst();
    	}
     	else //关键字搜索！！！！！！
     	{
     		stepStack.push(new Step(MenuStateType.QUERYBYKEYWORDRESULT, 0 ,1,1,question)); //存入用户选择栈
     		answer = moveToQueryByKeywordResult(session, question,1);
     	}
		
		return answer;
	}

	@Override
	public int getType()
	{
		return MenuStateType.QUERYBYKEYWORD;
	}

}
