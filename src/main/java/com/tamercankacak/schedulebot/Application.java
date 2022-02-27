package com.tamercankacak.schedulebot;

import com.tamercankacak.schedulebot.Service.LessonService;

public class Application {
  public static void main(String[] args) throws Exception {
    System.out.println("welcome");
    LessonService service = new LessonService();
    service.getOpenLessons();
  }
}
