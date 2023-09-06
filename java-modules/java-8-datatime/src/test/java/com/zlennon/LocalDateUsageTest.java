package com.zlennon;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class LocalDateUsageTest {

   private LocalDateUsage localDateUsage = new LocalDateUsage();

   @Test
  public void testGetMinusMonthThenGetDay(){
      String minusMonthThenGetDay = localDateUsage.getMinusMonthThenGetDay(1680192000000L, 1);
      System.out.println(minusMonthThenGetDay);
  }

   @Test
  public void equalLocalDate(){
      LocalDate stamp = localDateUsage.getLocalDateFromTimeStamp(1674489600000L);
      System.out.println(stamp.compareTo(LocalDate.now()));
  }
}
