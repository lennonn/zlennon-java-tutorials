package com.zlennon.interview;

public class StringContainProblem {
    public static void main(String[] args) {
        System.out.println(change("aaa","bbb"));
        System.out.println(Math.round(-2.5));
        System.out.println(2*2<<3);
    }
    public static int change(String a,String b){
            int sub=0;
            while (a.contains(b)){
                sub++;
                a=a.replaceFirst(b,"");
            }
            return sub;
    }
}
