/**
 * 
 */
package com.zlennon.chainofresposibility;

/**
 * @author zlennon
 *
 */
public class Boss extends Leader {

	/**
	 * @param name
	 */
	public Boss(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zl.instances.designpattern.chainofresposibility.Leader#handleRequest
	 * (com.zl.instances.designpattern.chainofresposibility.LeaveRequest)
	 */
	@Override
	public void handleRequest(LeaveRequest request) {
		String name = request.getName();
		String reason = request.getReason();
		int days = request.getDays();
		if (days <= 30) {

			System.out.println(name + "需要请假" + days + "天，请假理由" + reason
					+ " 董事长同意审批！");
		} else {
			System.out.println("我无法处理该请假天数，需要部门商量");
			if (this.nextLeader != null) {
				this.nextLeader.handleRequest(request);
			}else{
				System.out.println("暂时不能请假");
			}
		}
	}

}
