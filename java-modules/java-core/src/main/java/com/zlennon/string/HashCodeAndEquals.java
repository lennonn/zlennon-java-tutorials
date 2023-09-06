package com.zlennon.string;

public class HashCodeAndEquals {
    public static void main(String args[]){
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println("s1_equals_s2 ?::"+s1==s2);
        System.out.println("s1_equals_s2 ?:"+s1.equals(s2));
        System.out.println("s1_hashcode:"+s1.hashCode());
        System.out.println("s2_hashcode:"+s2.hashCode());
    }
}
