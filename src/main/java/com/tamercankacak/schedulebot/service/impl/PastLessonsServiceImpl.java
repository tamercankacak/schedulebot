package com.tamercankacak.schedulebot.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tamercankacak.schedulebot.Client.LessonClient;
import com.tamercankacak.schedulebot.Entity.ClientLesson;
import com.tamercankacak.schedulebot.Entity.Request;
import com.tamercankacak.schedulebot.Entity.Variables;
import com.tamercankacak.schedulebot.config.AppConfig;
import com.tamercankacak.schedulebot.service.PastLessonsService;
import com.tamercankacak.schedulebot.util.RequestUtil;

import java.io.IOException;
import java.util.List;

public class PastLessonsServiceImpl implements PastLessonsService {
  private AppConfig config;
  private LessonClient lessonClient;

  public PastLessonsServiceImpl() throws IOException {
    config = AppConfig.load();
    lessonClient = new LessonClient(config.cookie);
  }

  public List<ClientLesson> getPastLessons() {
    try {
      Request request = new Request(new Variables(5, 1), config.pastLessonsQuery);
      String responseBody = lessonClient.post(request);

      JsonNode pastLessonsNode =
          RequestUtil.parseJSON(
              responseBody,
              new String[] {"data", "currentUser", "client", "mlLessons", "pastLessons", "nodes"});
      List<ClientLesson> pastPastLessons =
          new ObjectMapper().convertValue(pastLessonsNode, new TypeReference<>() {});
      return pastPastLessons;
    } catch (Exception e) {
      return null;
    }
  }
}
