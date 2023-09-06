/**
 * 
 */
package com.zlennon.thread;

import java.util.Date;

/**
 * @author zlennon
 *
 */
public class StaffA implements Runnable {
	private Bank bank;
	public int amount;
	private String oprType=null;
	private int sleepTime;
	public StaffA(Bank bank) {
		this.bank=bank;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	public void setOprType(String type){
		this.oprType = type;
	}
	
	/**
	 * @param sleepTime the sleepTime to set
	 */
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("staffB开始执行时间："+new Date());
		try {	
			if(null!=oprType){
				if(oprType.equals("increase")){
						int accountAmount=	bank.increase(amount);
						System.out.println(Thread.currentThread().getName()+"线程操作完成时，账户总额为："+accountAmount);
				}else if(oprType.equals("reduce")){
					
					int accountAmount=	bank.reduce(amount);
						Thread.sleep(sleepTime);
						System.out.println(Thread.currentThread().getName()+"线程操作完成时，账户总额为："+accountAmount);
					
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

}
