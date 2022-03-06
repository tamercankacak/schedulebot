package com.tamercankacak.schedulebot.service;

import com.tamercankacak.schedulebot.Entity.ClientLesson;

import java.util.List;

public interface UpcomingLessonsService {
  List<ClientLesson> getUpcomingLessons();
}
