package com.tamercankacak.schedulebot.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tamercankacak.schedulebot.Client.LessonClient;
import com.tamercankacak.schedulebot.Entity.PastLesson;
import com.tamercankacak.schedulebot.Entity.Request;
import com.tamercankacak.schedulebot.Entity.Variables;
import com.tamercankacak.schedulebot.config.AppConfig;
import com.tamercankacak.schedulebot.service.PastLessonsService;

import java.io.IOException;
import java.util.List;

public class PastLessonsServiceImpl implements PastLessonsService {
  private AppConfig config;
  private LessonClient lessonClient;

  public PastLessonsServiceImpl() throws IOException {
    config = AppConfig.load();
    lessonClient = new LessonClient(config.cookie);
  }

  public List<PastLesson> get() {
    try {
      Request request = new Request(new Variables(5, 1), config.pastLessonsQuery);
      String responseBody = lessonClient.post(request);
      ObjectMapper mapper = new ObjectMapper();

      JsonNode jsonNode =
          mapper
              .readTree(responseBody)
              .get("data")
              .get("currentUser")
              .get("client")
              .get("mlLessons")
              .get("pastLessons")
              .get("nodes");

      List<PastLesson> pastLessons = mapper.readValue(jsonNode.toString(), List.class);
      return pastLessons;
    } catch (Exception e) {
      return null;
    }
  }
}
