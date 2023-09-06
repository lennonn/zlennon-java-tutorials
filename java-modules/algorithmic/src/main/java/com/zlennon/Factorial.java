package com.zlennon;

public class Factorial {

    /*
    n=1,return 1;
    n=2,return 1!*2;
    n=3 return 2!*3;
    .
    .
    .
    n return (n-1)!*n;
     */
    public  static  int calNFactorial(int n){
        if(n<0) return -1;
        if(n==1) return 1;
        return n*calNFactorial(n-1);
    }
}
