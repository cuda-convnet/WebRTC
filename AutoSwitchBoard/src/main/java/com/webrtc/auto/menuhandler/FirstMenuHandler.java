package com.webrtc.auto.menuhandler;

import java.util.Stack;

import com.webrtc.auto.common.MenuStateType;
import com.webrtc.auto.common.QuestionType;
import com.webrtc.auto.domain.Session;
import com.webrtc.auto.domain.Step;
import com.webrtc.auto.manager.EngroupManager;

public class FirstMenuHandler extends MenuHandler{

	@Override
	public String[] answerQuestion(Session session, String question) 
	{	
		String[] answer = {"","",""};
		
		//获取步骤栈
		Stack<Step> stepStack = session.getStepStack();
		
    	if(question.equals(QuestionType.QUERYBYKEYWORD)) //按姓名/邮箱/电话/地址/等查
    	{
    		stepStack.push(new Step(MenuStateType.QUERYBYKEYWORD, 0 ,"",1,1)); //存入用户选择栈
    		answer = moveToQueryByKeyword();
    	}
    	else if(question.equals(QuestionType.QUERYBYFZ)) //按分组查
    	{
    		int totalPage = MenuUtils.getTotalPage(EngroupManager.findEngroupByEidLfz(session.getEid() ,0).size()); //需要分成的总页数
    		stepStack.push(new Step(MenuStateType.QUERYBYFZ1, 0,"企业",1,totalPage)); //存入用户选择栈
    		answer = moveToQueryByFZ(session,1);
    	}
    	else if(question.equals(QuestionType.QUERYBYUSERNAME)) //直接输入WEBRTC账号查询
    	{
    		stepStack.push(new Step(MenuStateType.QUERYBYUSERNAME, 0 ,"",1,1)); //存入用户选择栈
    		answer = moveToQueryByUserName();
    	}
    	else //输错
    	{
    		answer[HEAD] = "信息有误，请重新输入";
		}
    	
    	return answer;
	}

	@Override
	public int getType() 
	{
		return MenuStateType.FIRST;
	}

}
