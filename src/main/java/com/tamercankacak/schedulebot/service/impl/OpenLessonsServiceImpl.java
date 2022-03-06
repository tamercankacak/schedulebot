package com.tamercankacak.schedulebot.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tamercankacak.schedulebot.Client.LessonClient;
import com.tamercankacak.schedulebot.Entity.OpenLesson;
import com.tamercankacak.schedulebot.Entity.Request;
import com.tamercankacak.schedulebot.Entity.Variables;
import com.tamercankacak.schedulebot.config.AppConfig;
import com.tamercankacak.schedulebot.service.OpenLessonsService;
import com.tamercankacak.schedulebot.util.DateUtil;
import com.tamercankacak.schedulebot.util.RequestUtil;

import java.io.IOException;
import java.util.List;

public class OpenLessonsServiceImpl implements OpenLessonsService {

  private AppConfig config;
  private LessonClient lessonClient;

  public OpenLessonsServiceImpl() throws IOException {
    config = AppConfig.load();
    lessonClient = new LessonClient(config.cookie);
  }

  public List<OpenLesson> getOpenLessons() {
    try {
      String dateStart = DateUtil.getToday();
      String dateEnd = DateUtil.getEndDate();
      Request request =
          new Request(
              new Variables(
                  config.tutoringId, dateStart, dateEnd, "Europe/Moscow", config.durationHours),
              config.openLessonsQuery);
      String responseBody = lessonClient.post(request);

      JsonNode openLessonsNode =
          RequestUtil.parseJSON(
              responseBody,
              new String[] {"data", "currentUser", "tutoring", "tutor", "timeslotsForBooking"});
      List<OpenLesson> openLessons =
          new ObjectMapper().convertValue(openLessonsNode, new TypeReference<>() {});

      return openLessons;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}
