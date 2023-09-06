package com.zlennon.leetcode;



/* 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 示例 1:输入: 123输出: 321
 示例 2:输入: -123输出: -321
 示例 3:输入: 120输出: 21
 注意:假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 请根据这个假设，如果反转后整数溢出那么就返回 0。*/

public class IntegerReverse {
    public static int reverse(int x) {
        long start =System.nanoTime();
        long res =0;

        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        long end =System.nanoTime();
        System.out.println("reverse execute time:"+(end-start)+" ns");
        return (int)res==res? (int)res:0;
    }

    public static int stringReverse(int x){
        long start =System.nanoTime();
        String str =String.valueOf(x);
        int flag = 1;
        if(x<0){
            flag = -1;
           str= str.substring(1);
        }
        char[] charArr=str.toCharArray();
        int i=0;
        int j=charArr.length-1;
        while(i<j){
            char temp =charArr[i];
            charArr[i]=charArr[j];
            charArr[j]=temp;
            i++;
            j--;
        }
        String newStr =new String(charArr);
        long end =System.nanoTime();
        System.out.println("stringReverse execute time:"+(end-start)+" ns");
         try {
            return  flag*Integer.valueOf(newStr);
         }catch (Exception e){
             return 0;
         }
    }
}
