package com.zlennon;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class LocalDateUsage {

    public LocalDate getLocalDateFromTimeStamp(long timeStamp){
      return  LocalDate.ofInstant(Instant.ofEpochMilli(timeStamp), TimeZone.getDefault().toZoneId());
    }

    public  String localDateToString(LocalDate localDate){
        return  localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public String getMinusMonthThenGetDay(long timeStamp,int month){
        LocalDate localDate = getLocalDateFromTimeStamp(timeStamp);
        LocalDate minusMonths = localDate.minusMonths(month);
        return localDateToString(minusMonths);
    }
}
