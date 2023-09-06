package com.zlennon.test;

public class Tmp2 {

	    public static void main(String[] args) {
	    	 int x = 0;
	         int y = 0;
	         int k = 0;
	         for (int z = 0; z < 5; z++) {
	             if ((++x > 2) && (++y > 2) && (k++ > 2))
	             {
	                 x++;
	                 ++y;
	                 k++;
	             }
	         }
	         System.out.println(x + "" +y + "" +k);
	         int i = 5;
	         int j = 10;
	         System.out.println(i + ~j);
	    }
}
