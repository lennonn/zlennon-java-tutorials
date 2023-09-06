package com.zlennon.test;

public class Tmp1 {

	void waitForSignal() throws InterruptedException
	{
	    Object obj = new Object();
	    synchronized(Thread.currentThread())
	    {
	        obj.wait();
	        obj.notify();
	    }
	}
	public static void main(String[] args) {
		boolean b=true?false:true==true?false:true;
		System.out.println(b);
	}

}
