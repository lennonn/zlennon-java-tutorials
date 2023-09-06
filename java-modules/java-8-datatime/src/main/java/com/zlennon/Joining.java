package com.zlennon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Joining {

    public static String ArrayJoin(String[] arr){
        return Arrays.stream(arr).collect(Collectors.joining("','","'","'"));
    }

    public static String ListJoin(List<String> list){
        return list.stream().collect(Collectors.joining(","));
    }

    public static String CharJoin(List<CharSequence> charList){
        return charList.stream().collect(Collectors.joining());
    }
}
