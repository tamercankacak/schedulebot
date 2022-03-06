package com.tamercankacak.schedulebot.service;

import com.tamercankacak.schedulebot.Entity.ClientLesson;

import java.util.List;

public interface PastLessonsService {
  List<ClientLesson> getPastLessons();
}
