package com.tamercankacak.schedulebot;


import com.tamercankacak.schedulebot.Service.LessonService;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class Application {
  public static void main(String[] args) throws Exception {
    System.out.println("welcome");
    LessonService service = new LessonService();
    service.getTotalLessonInWeek();
  }
}
