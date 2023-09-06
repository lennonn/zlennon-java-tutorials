package com.zlennon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionTest {
    public static void main(String[] args) {

        ArrayList<String> list  = new ArrayList<>();
        list.add("123abccd");
        list.add("abcdc123");
        list.add("1234abc");
        list.add("ab1234cd");
        list.add("adb1234cd");
        Set<String> remove = new HashSet<>();
        Pattern pattern = Pattern.compile("\\d+");
        for (int i = 0; i <list.size()-1 ; i++) {
            String a = list.get(i);
            Matcher matcher = pattern.matcher(a);
            Integer aStr = null;
            Integer bStr = null;
            if (matcher.find()) {
                aStr=Integer.valueOf(matcher.group(0));
            }
            for (int j = i+1; j <list.size(); j++) {
                String b = list.get(j);
                Matcher matcher1 = pattern.matcher(b);
                if (matcher1.find()) {
                    bStr=Integer.valueOf(matcher1.group(0));
                }

                if(aStr!=null&&bStr!=null&&aStr.equals(bStr))
                    remove.add(b);
            }
        }
        for (String s : remove) {
            list.remove(s);
        }
        System.out.println(list.size());
    }
}
