/*
package com.zlennon.log4j;

import java.util.HashMap;
import java.util.Map;

public class Log4j2Rule {

    public static Map<String, String> regularMap = new HashMap<>();

    public static final String USER_NAME_STR = "Name,name,联系人,姓名";
    public static final String USER_IDCARD_STR = "empCard,idCard,身份证,证件号";
    public static final String USER_PHONE_STR = "mobile,Phone,phone,电话,手机";
    public static final String USER_PASSWORD_STR = "pwd,password,密码";
    public static final String OTHER = "other";

    private static String IDCARD_REGEXP = "(\\d{17}[0-9Xx]|\\d{14}[0-9Xx])";
    private static String USERNAME_REGEXP = "[\\u4e00-\\u9fa5]{2,4}";
    private static String PHONE_REGEXP = "(?<!\\d)(?:(?:1[3456789]\\d{9})|(?:861[356789]\\d{9}))(?! \\d)";
    private static String OTHER_REGEXP = "";
    static {
        regularMap.put(USER_NAME_STR, USERNAME_REGEXP);
        regularMap.put(USER_IDCARD_STR, IDCARD_REGEXP);
        regularMap.put(USER_PHONE_STR, PHONE_REGEXP);
        regularMap.put(USER_PASSWORD_STR, "ALL");
        regularMap.put(OTHER, OTHER_REGEXP);
    }
}
*/
