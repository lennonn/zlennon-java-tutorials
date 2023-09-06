/**
 * 
 */
package com.zlennon.thread;

/**
 * @author zlennon
 *
 */
public class Bank {
	private static int totalMoney = 500;
	/**
	 * 获取账户金额
	 * @return
	 */
    public  int getTotalMonety(){  	
    		return totalMoney;
    }
    /**
     * 存钱
     * @param amount
     */
    public synchronized  int increase(int amount){
    		totalMoney +=amount;
    		try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		return getTotalMonety();
    }
    
    /**
     * 取钱
     * @param amount
     * @throws InterruptedException 
     */
    public synchronized int reduce(int amount) throws InterruptedException{
    	Thread.currentThread().sleep(1000);
    	if(totalMoney<amount){
    		System.out.println("没有足够的钱");
    		return -1;
    	}else{
    		totalMoney -=amount;
    		return getTotalMonety();
    	}
    	
    }
}
