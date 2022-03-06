package com.tamercankacak.schedulebot;

import com.tamercankacak.schedulebot.Entity.ClientLesson;
import com.tamercankacak.schedulebot.service.FilterService;
import com.tamercankacak.schedulebot.service.OpenLessonsService;
import com.tamercankacak.schedulebot.service.PastLessonsService;
import com.tamercankacak.schedulebot.service.UpcomingLessonsService;
import com.tamercankacak.schedulebot.service.impl.FilterServiceImpl;
import com.tamercankacak.schedulebot.service.impl.OpenLessonsServiceImpl;
import com.tamercankacak.schedulebot.service.impl.PastLessonsServiceImpl;
import com.tamercankacak.schedulebot.service.impl.UpcomingLessonsServiceImpl;

import java.util.List;

public class Application {
  public static void main(String[] args) throws Exception {
    System.out.println("welcome");
    OpenLessonsService openLessonsService = new OpenLessonsServiceImpl();
    PastLessonsService pastLessonsService = new PastLessonsServiceImpl();
    UpcomingLessonsService upcomingLessonsService = new UpcomingLessonsServiceImpl();
    FilterService filterService =
        new FilterServiceImpl(
            openLessonsService.getOpenLessons(),
            pastLessonsService.getPastLessons(),
            upcomingLessonsService.getUpcomingLessons());
    List<ClientLesson> ccc = filterService.getPastLessonsOfWeek();
  }
}
