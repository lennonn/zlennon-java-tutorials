package com.zlennon.string;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FindSameCharacter {
    public void stringTest(){
        List<String> lists =new ArrayList<>();
        lists.add("abc123cc");
        lists.add("ab123cd");
        for (int i = 0; i <lists.size() ; i++) {
            byte[] first = lists.get(i).getBytes(StandardCharsets.UTF_8);
            byte[] second = lists.get(i).getBytes(StandardCharsets.UTF_8);
            for(int j=0;j<first.length;j++){
                if(first[j]==second[j]){

                }
            }
        }
    }
}
