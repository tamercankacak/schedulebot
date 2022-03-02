package com.tamercankacak.schedulebot.util;

import com.tamercankacak.schedulebot.config.AppConfig;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public class DateUtil {

  private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
  private static AppConfig config;

  static {
    try {
      config = AppConfig.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static String getLastSunday() {
    DateTime lastSunday = new DateTime().withDayOfWeek(DateTimeConstants.MONDAY).minusDays(1);
    return lastSunday.toString(formatter);
  }

  public static String getNextMonday() {
    DateTime nextMonday = new DateTime().withDayOfWeek(DateTimeConstants.SUNDAY).plusDays(1);

    return nextMonday.toString(formatter);
  }

  public static String getToday() {
    DateTime today = new DateTime();
    return today.toString(formatter);
  }

  public static String getEndDate() {
    DateTime endDate = new DateTime().plusDays(config.dayLength);
    return endDate.toString(formatter);
  }
}
