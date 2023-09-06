package com.zlennon.test;


public class Tmp {
	int a=4;
	public  void chang(int a){
	  a=8;
	  System.out.println(a);
	}
	 void fermin(int i){
	       i++;
	    }
	public static void main(String[] args) {
		Tmp tmp=new Tmp();
		/*	int a=9;
		a=8;
		tmp.chang(a);
		System.out.println(a);*/
		  int i = 0;
	       tmp.fermin(i);
	       i++;
	      int a=i-1;
	      System.out.println(a);
	       System.out.println(i);
	}


}
