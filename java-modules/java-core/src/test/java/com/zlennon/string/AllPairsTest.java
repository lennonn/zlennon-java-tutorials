package com.zlennon.string;

import com.zlennon.string.AllPairs;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AllPairsTest {
    @Test
    public void testAllPairs(){
        List<String> first = Arrays.asList("A","B","C");
        List<String> second = Arrays.asList("D","E");
        AllPairs allPairs = new AllPairs();
        List<String[]> all= allPairs.returnAllPairsList(first,second);
        for(String[] arr:all){
            StringBuilder sb = new StringBuilder();
            for(String s:arr){
                sb.append(s);
            }
            System.out.println(sb);
        }
    }

}
