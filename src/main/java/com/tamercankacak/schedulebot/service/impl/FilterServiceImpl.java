package com.tamercankacak.schedulebot.service.impl;

import com.tamercankacak.schedulebot.Entity.ClientLesson;
import com.tamercankacak.schedulebot.Entity.OpenLesson;
import com.tamercankacak.schedulebot.service.FilterService;

import java.util.List;

public class FilterServiceImpl implements FilterService {

  private List<OpenLesson> openLessons;
  private List<ClientLesson> pastLessons;
  private List<ClientLesson> upcomingLessons;

  public FilterServiceImpl(
      List<OpenLesson> openLessons,
      List<ClientLesson> pastLessons,
      List<ClientLesson> upcomingLessons) {
    this.openLessons = openLessons;
    this.pastLessons = pastLessons;
    this.upcomingLessons = upcomingLessons;
  }

  // TODO: create past + upcoming lesson

}
