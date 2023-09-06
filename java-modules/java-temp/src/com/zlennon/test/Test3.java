package com.zlennon.test;

public class Test3 {
	int number[]={31,23,33,43,35,63};
	  static boolean foo(char c)
	    {
	        System.out.print(c);
	        return true;
	    }
	    public static void main( String[] argv )
	    {
	        int i = 0;
	        for ( foo('A'); foo('B') && (i < 2); foo('C'))
	        {
	            i++ ;
	            foo('D');
	        }
	    }
}
