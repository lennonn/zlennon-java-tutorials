/**
 * 
 */
package com.zlennon.thread;

import java.util.Date;


/**
 * @author zlennon
 *
 */
public class StaffB implements Runnable {
	private Bank bank;
	private int amount;
	private String oprType=null;
	private int sleepTime;
	public StaffB(Bank bank){
		this.bank = bank;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	public void setOprType(String oprType){
		this.oprType = oprType;
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
		System.out.println("staffA开始执行时间："+new Date());
		try {
			
			if(null!=oprType){
				if(oprType.equals("increase")){
						int totalMoney=bank.increase(amount);
						Thread.sleep(sleepTime);
						System.out.println(Thread.currentThread().getName()+"线程操作完成时，账户总额为："+totalMoney);
				
				}else if(oprType.equals("reduce")){
						int totalMoney=	bank.reduce(amount);
						Thread.sleep(sleepTime);
						System.out.println(Thread.currentThread().getName()+"线程操作完成时，账户总额为："+totalMoney);
					
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
