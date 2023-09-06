package com.zlennon;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LocalDateTimeUsage {
    private LocalDateTime getLocalDateFromTimeStamp(long timeStamp){
        return  LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStamp), ZoneId.systemDefault());
    }

    public  String localDateToString(LocalDateTime localDate,String pattern){
        return  localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    public String getMinusMonthThenGetDay(long timeStamp,int month,String pattern){
        LocalDateTime localDate = getLocalDateFromTimeStamp(timeStamp);
        LocalDateTime minusMonths = localDate.minusMonths(month);
        return localDateToString(minusMonths,pattern);
    }
    public LocalDateTime parseLocalDateTimeFromString(String str,String pattern){
        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(pattern));
    }

    public void isFirstDayofMonth(LocalDateTime localDateTime){

    }

    public static long localDateToLong(LocalDate localDate){
        return localDate.atTime(LocalTime.now()).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static long localDateTimeToLong(LocalDateTime localDateTime){
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public int getDayOfMonth(LocalDateTime localDateTime){
        return localDateTime.getDayOfMonth();
    }

    public List<String> beforeOf7DayTime(){
        List<String> timeList = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            timeList.add(String.valueOf(localDateTimeToLong(LocalDateTime.now()) - 86400000L * i));
            timeList.add(String.valueOf(localDateTimeToLong(LocalDateTime.now()) - 86400000L * i + 86400000));
        }
        return timeList;
    }

}
