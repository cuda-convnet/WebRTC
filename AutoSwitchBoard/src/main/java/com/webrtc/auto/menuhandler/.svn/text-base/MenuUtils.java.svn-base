package com.webrtc.auto.menuhandler;

import com.webrtc.auto.common.Constants;

/**
 * 工具方法
 */
public class MenuUtils 
{
	//打印分页（只有1页不显示，在第一页不显示<，在最后一页不显示>）
	public static String showPager(int page, int totalPage)
	{
		String answer = "";
		if(totalPage > 1)
		{
			if(page <= 1)
			{
				answer += ")下一页,";
			}
			else if(page >= totalPage)
			{
				answer += "(上一页,";
			}
			else 
			{
				answer += "(上一页,";
				answer += ")下一页,";
			}
		}	
		
		return answer;
	}
	
	//获取当前列表需要被分成的总页数,并存入session中
	public static int getTotalPage(int length)
	{	
		//获取要被分成的总页数
		int totalPage = 1;
		if(length % Constants.AUTO_PAGESIZE == 0)
			totalPage = length / Constants.AUTO_PAGESIZE;
		else
			totalPage = length / Constants.AUTO_PAGESIZE + 1 ;
		
		return totalPage;
	}
	
	public static int toIntegerLfz(String l_fz)
	{
		//得到用户输入的号码
		Integer lfz=-1;
		try {
			lfz = Integer.parseInt(l_fz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lfz;
	}
}
