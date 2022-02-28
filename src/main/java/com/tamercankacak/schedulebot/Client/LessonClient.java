package com.tamercankacak.schedulebot.Client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tamercankacak.schedulebot.Entity.OpenLessons.OpenLessonRequest;
import com.tamercankacak.schedulebot.Entity.PastLessons.PastLessonsRequest;
import com.tamercankacak.schedulebot.Entity.UpcomingLessons.UpcomingLessonsRequest;
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

  public String getOpenLessons(OpenLessonRequest openLessonRequest) throws Exception {
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

    return client.post(request).body().string();
  }

  public String getUpcomingLessons(UpcomingLessonsRequest upcomingLessonsRequest) throws Exception {
    RequestBody body =
        RequestBody.create(
            new ObjectMapper().writeValueAsString(upcomingLessonsRequest),
            MediaType.parse("application/json; charset=utf-8"));

    Request request =
        new Request.Builder()
            .url("https://preply.com/graphql/v2/")
            .post(body)
            .addHeader("content-type", "application/json")
            .addHeader("cookie", _cookie)
            .build();
    return client.post(request).body().string();
  }

  public String getPastLessons(PastLessonsRequest pastLessonsRequest) throws Exception {
    RequestBody body =
            RequestBody.create(
                    new ObjectMapper().writeValueAsString(pastLessonsRequest),
                    MediaType.parse("application/json; charset=utf-8"));

    Request request =
            new Request.Builder()
                    .url("https://preply.com/graphql/v2/")
                    .post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("cookie", _cookie)
                    .build();
    return client.post(request).body().string();
  }
}
