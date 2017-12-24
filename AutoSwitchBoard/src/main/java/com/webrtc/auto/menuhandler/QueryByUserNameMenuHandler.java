package com.webrtc.auto.menuhandler;


import java.util.Stack;

import com.webrtc.auto.common.MenuStateType;
import com.webrtc.auto.common.QuestionType;
import com.webrtc.auto.domain.Session;
import com.webrtc.auto.domain.Step;

public class QueryByUserNameMenuHandler extends MenuHandler
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
     	else //输入的账号得到的搜索结果
     	{
     		stepStack.push(new Step(MenuStateType.QUERYBYUSERNAMERESULT, 0 ,1,1,question)); //存入用户选择栈
     		answer = moveToQueryByUserNameResult(session, question);
     	}
		
		return answer;
	}

	@Override
	public int getType()
	{
		return MenuStateType.QUERYBYUSERNAME;
	}

}
