/**
 * 
 */
package com.zlennon.chainofresposibility;

/**
 * @author zlennon
 *
 */
public class LeaveRequest {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private String name;
	private int days;
	private String reason;
	

}
