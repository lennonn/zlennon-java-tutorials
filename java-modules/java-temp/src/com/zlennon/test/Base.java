package com.zlennon.test;

public class Base {
	 private String baseName = "base";
	 short a = 128; byte b = (byte) a;
	    public Base()
	    {
	        callName();
	    }

	    public void callName()
	    {
	        System. out. println(baseName);
	    }

	    static class Sub extends Base
	    {
	        private String baseName = "sub";
	        @Override
			public void callName()
	        {
	            System. out. println (baseName) ;
	        }
	    }
	    public static void main(String[] args)
	    {
	        Base b = new Sub();
	    }
}
