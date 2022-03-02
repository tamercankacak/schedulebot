package com.tamercankacak.schedulebot.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tamercankacak.schedulebot.Client.LessonClient;
import com.tamercankacak.schedulebot.Entity.ClientLesson;
import com.tamercankacak.schedulebot.Entity.Request;
import com.tamercankacak.schedulebot.config.AppConfig;
import com.tamercankacak.schedulebot.service.UpcomingLessonsService;
import com.tamercankacak.schedulebot.util.RequestUtil;

import java.io.IOException;
import java.util.List;

public class UpcomingLessonsServiceImpl implements UpcomingLessonsService {

  private AppConfig config;
  private LessonClient lessonClient;

  public UpcomingLessonsServiceImpl() throws IOException {
    config = AppConfig.load();
    lessonClient = new LessonClient(config.cookie);
  }

  public List<ClientLesson> get() {
    try {
      Request request = new Request(config.upcomingLessonsQuery);
      String responseBody = lessonClient.post(request);

      JsonNode upcomingLessonsNode =
          RequestUtil.parseJSON(
              responseBody,
              new String[] {
                "data", "currentUser", "client", "mlLessons", "upcomingLessons", "nodes"
              });

      List<ClientLesson> upcomingClientLessons =
          new ObjectMapper().convertValue(upcomingLessonsNode, new TypeReference<>() {});
      return upcomingClientLessons;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}
