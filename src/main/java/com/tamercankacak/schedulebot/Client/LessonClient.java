package com.tamercankacak.schedulebot.Client;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LessonClient {

  private BaseClient client;
  private String BASE_URL;

  public LessonClient() {
    client = new BaseClient();
    BASE_URL = "";
  }

  public void getOpenLessons(Object obj) throws Exception {
    client.post(BASE_URL + "/graphql/v2/", new ObjectMapper().writeValueAsString(obj));
  }
}
