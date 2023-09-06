/**
 * 
 */
package com.zlennon.chainofresposibility;

/**
 * @author zlennon
 *
 */
public class GroupLeader extends Leader {

	/**
	 * @param name
	 */
	public GroupLeader(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.chainofresposibility.Leader#handleRequest(com.zl.instances.designpattern.chainofresposibility.LeaveRequest)
	 */
	@Override
	public void handleRequest(LeaveRequest request) {
		String name = request.getName();
		String reason = request.getReason();
		int days = request.getDays();
		if (days <= 5) {
			System.out.println(name + "需要请假" + days + "天，请假理由" + reason
					+ "组长同意审批！");
		} else {
			System.out.println("超过5天的假期需要经理审批");
			if (this.nextLeader != null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

}
