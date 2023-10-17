package com.zlennon.string.regex;

import com.zlennon.regex.SubUrl;
import org.junit.Test;

import java.util.List;

public class SubUrlTest {
    @Test
    public void testSubUrl(){
        String urls[]= new String[]{
                "https://www.zlennon.com/article/website/showDetail?id=1001201812060000109",
                "https://www.zlennon.com:8080/article/website/showDetail?id=1001201812060000109"
        };
        SubUrl subUrl = new SubUrl();
       List<String> replaceResult= subUrl.subUrl(urls);
        for (String url:replaceResult
             ) {
            System.out.println(url);
        }
    }
}
