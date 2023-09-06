package com.zlennon.examples;

public class MyThread implements Runnable {

	@Override
	public void run() {
		for(int i= 0; i<100; i++){
			System.out.println(i);
		}
	}
	public static void main(String args[]){
		MyThread m1 = new MyThread();
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m1);
		t1.start();
		t2.start();
		
	}
}
