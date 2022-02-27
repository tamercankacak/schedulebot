package com.tamercankacak.schedulebot.Client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BaseClient {
  private OkHttpClient client;

  public BaseClient() {
    client = new OkHttpClient();
  }

  protected Response sendRequest(Request request) throws Exception {
    return client.newCall(request).execute();
  }
}
