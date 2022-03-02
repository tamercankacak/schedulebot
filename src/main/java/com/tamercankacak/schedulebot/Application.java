package com.tamercankacak.schedulebot;


import com.tamercankacak.schedulebot.service.OpenLessonsService;
import com.tamercankacak.schedulebot.service.impl.OpenLessonsServiceImpl;

public class Application {
  public static void main(String[] args) throws Exception {
    System.out.println("welcome");
    OpenLessonsService service = new OpenLessonsServiceImpl();
    service.get();
  }
}
