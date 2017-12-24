package com.webrtc.arti.domain;

import java.util.Comparator;

public class ServerComparator implements Comparator<Server> {

	@Override
	public int compare(Server server1, Server server2) {
		
		//比较两个客服被分配的优先级
		int priority1 = server1.getPriority();
		int priority2 = server2.getPriority();

		if(priority1 == priority2) //优先级一样，则判断服务数量，返回数量较少者
		{
			int servingNum1 = server1.getServingClientMap().size();
			int servingNum2 = server2.getServingClientMap().size();
			
			return servingNum1 - servingNum2; 
		}
		
		return priority2 - priority1; //PriorityQueue是最小堆，以此变为最大堆
	}

}
