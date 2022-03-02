package com.tamercankacak.schedulebot;


import com.tamercankacak.schedulebot.service.OpenLessonsService;
import com.tamercankacak.schedulebot.service.PastLessonsService;
import com.tamercankacak.schedulebot.service.UpcomingLessonsService;
import com.tamercankacak.schedulebot.service.impl.OpenLessonsServiceImpl;
import com.tamercankacak.schedulebot.service.impl.PastLessonsServiceImpl;
import com.tamercankacak.schedulebot.service.impl.UpcomingLessonsServiceImpl;

public class Application {
  public static void main(String[] args) throws Exception {
    System.out.println("welcome");
    OpenLessonsService openLessonsService = new OpenLessonsServiceImpl();
    openLessonsService.get();
  }
}
