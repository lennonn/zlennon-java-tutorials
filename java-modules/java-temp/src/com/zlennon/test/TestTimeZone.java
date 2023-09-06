package com.zlennon.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

public class TestTimeZone {
    public static void main(String[] args) {
        long startTime=1678896000000l;
        List<String> timeList = new ArrayList<>();
            for (int i = 1; i <= 7; i++) {
                timeList.add(String.valueOf(startTime - 86400000L * i));
                timeList.add(String.valueOf(startTime - 86400000L * i + 86400000));
            }

        System.out.println(Arrays.deepToString(timeList.toArray()));

        long a=1678896000000L-86400000L * 7 + 86400000;
        //System.out.println(a);
        long current = System.currentTimeMillis();
        long zero = current / 86400000L * 86400000L - TimeZone.getDefault().getRawOffset();
       // System.out.println(zero);
        long zero1 = LocalDateTime.of(LocalDate.now(), LocalTime.MIN).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        //System.out.println(zero1);
    }
}
