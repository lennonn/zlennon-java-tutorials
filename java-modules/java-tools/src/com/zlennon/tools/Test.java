package zlennon.tools;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String test = "йт";
       // System.out.println(test_gbk_utf8);
        new String(test.getBytes(StandardCharsets.UTF_8));
        //System.out.println(test_gbk_utf8.getBytes().length+"=="+test.getBytes(StandardCharsets.UTF_8).length);
        String test_gbk = new String(test.getBytes("gbk"));
        System.out.println(test_gbk.length());
        String sttt = new String(test.getBytes("gbk"), "gbk");

        System.out.println(sttt.getBytes().length);
    }
}
