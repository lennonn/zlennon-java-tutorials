package com.zlennon.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubUrl {
    public List<String> subUrl(String[] urls){
        List list = new ArrayList<>();
        Pattern pattern   =   Pattern.compile("^http[s]?:\\/\\/[^\\/]*?\\.?([^\\/.]+)\\.[^\\/.]+(?::\\d+)?\\/");
        for (String url:urls) {

            Matcher matcher   =   pattern.matcher(url);
            list.add(matcher.replaceAll("http://test.com/").trim());
        }
        return list;
    }

}
