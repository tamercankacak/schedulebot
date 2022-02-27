package com.tamercankacak.schedulebot.Client;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class LessonClient {

  private BaseClient client;
  private String BASE_URL;

  public LessonClient() {
    client = new BaseClient();
    BASE_URL = "";
  }

  public void getOpenLessons(Object obj) throws Exception {
  }
}
