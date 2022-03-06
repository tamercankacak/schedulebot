package com.tamercankacak.schedulebot.service;

import com.tamercankacak.schedulebot.Entity.ClientLesson;

import java.util.List;

public interface FilterService {
  List<ClientLesson> getPastLessonsOfWeek();

  List<ClientLesson> getUpcomingLessonsOfWeek();

  boolean isFullThisWeek();
}
