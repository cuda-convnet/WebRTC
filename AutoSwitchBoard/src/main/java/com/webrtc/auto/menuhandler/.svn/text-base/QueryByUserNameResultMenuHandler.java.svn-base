package com.webrtc.auto.menuhandler;

import java.util.Stack;

import com.webrtc.auto.common.MenuStateType;
import com.webrtc.auto.common.QuestionType;
import com.webrtc.auto.domain.Session;
import com.webrtc.auto.domain.Step;

public class QueryByUserNameResultMenuHandler extends MenuHandler
{
	@Override
	public String[] answerQuestion(Session session, String question) 
	{
		String[] answer = {"","",""};
		
		//获取步骤栈
		Stack<Step> stepStack = session.getStepStack();
		
		if(question.equals(QuestionType.BACKTOLASTMENU)) //返回上一级
    	{
			stepStack.pop();
     		answer = moveToQueryByUserName();
    	}
     	else if(question.equals(QuestionType.BACKTOFIRSTMENU))
     	{
     		stepStack.clear();
     		stepStack.push(new Step(MenuStateType.FIRST, 0,"",1, 1));
     		answer = moveToFirst();
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
		return MenuStateType.QUERYBYUSERNAMERESULT;
	}
}
