package com.tamercankacak.schedulebot.Client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tamercankacak.schedulebot.Entity.OpenLessons.OpenLessonRequest;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class LessonClient {

  private BaseClient client;
  private String _cookie;

  public LessonClient(String cookie) {
    client = new BaseClient();
    _cookie = cookie;
  }

  public void getOpenLessons(OpenLessonRequest openLessonRequest) throws Exception {
    String json = new ObjectMapper().writeValueAsString(openLessonRequest);
    RequestBody body =
        RequestBody.create(
            new ObjectMapper().writeValueAsString(openLessonRequest),
            MediaType.parse("application/json; charset=utf-8"));
    Request request =
        new Request.Builder()
            .url("https://preply.com/graphql/v2/")
            .post(body)
            .addHeader("content-type", "application/json")
            .addHeader("cookie", _cookie)
            .build();

    client.post(request);
  }
}
