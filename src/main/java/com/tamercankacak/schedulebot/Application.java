package com.tamercankacak.schedulebot;


import com.tamercankacak.schedulebot.service.PastLessonsService;
import com.tamercankacak.schedulebot.service.impl.PastLessonsServiceImpl;

public class Application {
  public static void main(String[] args) throws Exception {
    System.out.println("welcome");
    PastLessonsService pastLessonsService = new PastLessonsServiceImpl();
    pastLessonsService.get();
  }
}
