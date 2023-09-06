/**
 * 
 */
package com.zlennon.chainofresposibility;

/**
 * @author zlennon
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			Leader groupLeader = new GroupLeader("部门组长");
			Leader  manager = new Manager("部门经理");
			Leader  boss = new Boss("董事长");
			groupLeader.setNextLeader(manager);
			manager.setNextLeader(boss);
			LeaveRequest leaveRequest = new LeaveRequest();
			leaveRequest.setDays(31);
			leaveRequest.setName("张三");
			leaveRequest.setReason("肚子疼");
			groupLeader.handleRequest(leaveRequest);
	}

}
