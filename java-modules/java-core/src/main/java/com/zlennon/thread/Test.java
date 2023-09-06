/**
 * 
 */
package com.zlennon.thread;

/**
 * @author zlennon
 *
 */
public class Test {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
		StaffA staffA = new StaffA(bank);
		staffA.setAmount(600);
		staffA.setOprType("increase");
		//staffA.setSleepTime(500);
		//staffA.setOprType("reduce");
		StaffB staffB =new StaffB(bank);
		//staffB.setAmount(100);
		//staffB.setOprType("increase");
		staffB.setAmount(1100);
		staffB.setOprType("reduce");
		
		Thread threadA = new Thread(staffA);
		threadA.setName("staffA");
		Thread threadB = new Thread(staffB);
		threadB.setName("staffB");
		//threadA.sleep(1000);
		threadA.start();
		//threadB.sleep(300);
		threadB.start();
	
		
	
	

	}

}
