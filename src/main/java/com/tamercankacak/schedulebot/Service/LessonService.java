package com.tamercankacak.schedulebot.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tamercankacak.schedulebot.Client.LessonClient;
import com.tamercankacak.schedulebot.Entity.OpenLessons.OpenLessonRequest;
import com.tamercankacak.schedulebot.Entity.OpenLessons.OpenLessonResponse;
import com.tamercankacak.schedulebot.Entity.OpenLessons.Variables;
import com.tamercankacak.schedulebot.Entity.PastLessons.Node;
import com.tamercankacak.schedulebot.Entity.PastLessons.PastLessonsRequest;
import com.tamercankacak.schedulebot.Entity.PastLessons.PastLessonsResponse;
import com.tamercankacak.schedulebot.Entity.UpcomingLessons.UpcomingLessonsRequest;
import com.tamercankacak.schedulebot.Entity.UpcomingLessons.UpcomingLessonsResponse;
import com.tamercankacak.schedulebot.config.AppConfig;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LessonService {
  private AppConfig config;
  private LessonClient lessonClient;

  public LessonService() throws IOException {
    config = AppConfig.load();
    lessonClient = new LessonClient(config.cookie);
  }

  public OpenLessonResponse getOpenLessons() throws Exception {
    String dateStart = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String dateEnd =
        new SimpleDateFormat("yyyy-MM-dd")
            .format(new Date(new Date().getTime() + (1000L * 60 * 60 * 24 * config.dayLength)));

    OpenLessonRequest openLessonRequest =
        new OpenLessonRequest(
            new Variables(
                config.tutoringId, dateStart, dateEnd, "Europe/Moscow", config.durationHours),
            config.openLessonsQuery);
    return new ObjectMapper()
        .readValue(lessonClient.getOpenLessons(openLessonRequest), OpenLessonResponse.class);
  }

  public UpcomingLessonsResponse getUpcomingLessons() throws Exception {
    UpcomingLessonsRequest upcomingLessonsRequest =
        new UpcomingLessonsRequest("CurrentUserUpcomingLessons", null, config.upcomingLessonsQuery);

    return new ObjectMapper()
        .readValue(
            lessonClient.getUpcomingLessons(upcomingLessonsRequest), UpcomingLessonsResponse.class);
  }

  public PastLessonsResponse getPastLessons() throws Exception {
    PastLessonsRequest pastLessonsRequest =
        new PastLessonsRequest(
            "CurrentUserPastLessons",
            new com.tamercankacak.schedulebot.Entity.PastLessons.Variables(5, 0),
            config.pastLessonsQuery);

    return new ObjectMapper()
        .readValue(lessonClient.getPastLessons(pastLessonsRequest), PastLessonsResponse.class);
  }

  // must be <= 4
  public int getTotalLessonInWeek() throws Exception {
    LocalDate now = new LocalDate();
    LocalDate monday = now.withDayOfWeek(DateTimeConstants.MONDAY);
    LocalDate sunday = now.withDayOfWeek(DateTimeConstants.SUNDAY);
    int totalHoursInWeek = 0;

    for (Node node : getPastLessons().data.currentUser.client.mlLessons.pastLessons.nodes) {
      LocalDate date = new DateTime(node.datetime).toLocalDate();
      if (date.isAfter(monday.minusDays(1)) && date.isBefore(sunday.plusDays(1))) {
        totalHoursInWeek++;
      }
    }

    for (com.tamercankacak.schedulebot.Entity.UpcomingLessons.Node node :
        getUpcomingLessons().data.currentUser.client.mlLessons.upcomingLessons.nodes) {
      LocalDate date = new DateTime(node.datetime).toLocalDate();
      if (date.isAfter(monday.minusDays(1)) && date.isBefore(sunday.plusDays(1))) {
        totalHoursInWeek++;
      }
    }

    return totalHoursInWeek;
  }

  public void schedule() throws Exception{
    if(getTotalLessonInWeek() <= 4){

    }
  }

}
