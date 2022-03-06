package com.tamercankacak.schedulebot.service.impl;

import com.tamercankacak.schedulebot.Entity.ClientLesson;
import com.tamercankacak.schedulebot.Entity.OpenLesson;
import com.tamercankacak.schedulebot.service.FilterService;
import com.tamercankacak.schedulebot.util.DateUtil;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

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

  public List<ClientLesson> getPastLessonsOfWeek() {
    LocalDate startDate = new LocalDate(DateUtil.getLastSunday());
    LocalDate endDate = new LocalDate(DateUtil.getNextMonday());

    return pastLessons.stream()
        .filter(
            x ->
                new LocalDate(x.datetime).isAfter(startDate)
                    && new LocalDate(x.datetime).isBefore(endDate))
        .collect(Collectors.toList());
  }

  public List<ClientLesson> getUpcomingLessonsOfWeek() {
    LocalDate startDate = new LocalDate(DateUtil.getLastSunday());
    LocalDate endDate = new LocalDate(DateUtil.getNextMonday());

    return upcomingLessons.stream()
        .filter(
            x ->
                new LocalDate(x.datetime).isAfter(startDate)
                    && new LocalDate(x.datetime).isBefore(endDate))
        .collect(Collectors.toList());
  }

  public boolean isFullThisWeek() {
    int pastLessonsCount = getPastLessonsOfWeek().size();
    int upcomingLessonsCount = getUpcomingLessonsOfWeek().size();
    return pastLessonsCount + upcomingLessonsCount == 4;
  }
}
