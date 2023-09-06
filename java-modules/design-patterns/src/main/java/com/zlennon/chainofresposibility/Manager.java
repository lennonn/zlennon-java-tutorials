/**
 * 
 */
package com.zlennon.chainofresposibility;

/**
 * @author zlennon
 *
 */
public class Manager extends Leader {

	/**
	 * @param name
	 */
	public Manager(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.chainofresposibility.Leader#handleRequest(com.zl.instances.designpattern.chainofresposibility.LeaveRequest)
	 */
	@Override
	public void handleRequest(LeaveRequest request) {
		String name = request.getName();
		String reason = request.getReason();
		int days = request.getDays();
		if (days <= 15) {
			System.out.println(name + "需要请假" + days + "天，请假理由" + reason
					+ "经理同意审批！");
		} else {
			System.out.println("超过15天的假期需要董事长审批！");
			if (this.nextLeader != null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

}
