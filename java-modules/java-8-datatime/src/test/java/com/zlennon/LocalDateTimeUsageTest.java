package com.zlennon;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LocalDateTimeUsageTest {

    private LocalDateTimeUsage localDateUsage = new LocalDateTimeUsage();

    @Test
    public void testGetMinusMonthThenGetDay(){
        String minusMonthThenGetDay = localDateUsage.getMinusMonthThenGetDay(1677081599000L, 0,"yyyyMMddHH");
        System.out.println(minusMonthThenGetDay);
    }
    @Test
    public void testParseDateTimeThenGetTimeStr(){
        LocalDateTime yyyy = localDateUsage.parseLocalDateTimeFromString("2023060612", "yyyyMMddHH");
        System.out.println(localDateUsage.localDateToString(yyyy,"yyyyMMddHHmmss"));
    }

    @Test
    public void getDayOfMonth(){
        LocalDateTime now = LocalDateTime.parse("2023-03-01 17:07:40", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDateUsage.getDayOfMonth(now));
        LocalDateTime of = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        System.out.println(localDateUsage.localDateToString(of,"yyyyMMddHHmmss"));

    }

    @Test
    public void testBeforeOf7DayTime(){
        System.out.println(Arrays.deepToString(localDateUsage.beforeOf7DayTime().stream().toArray()));
    }
}
