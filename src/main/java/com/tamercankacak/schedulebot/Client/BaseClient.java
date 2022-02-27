package com.tamercankacak.schedulebot.Client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BaseClient {
  private OkHttpClient client;

  public BaseClient() {
    client = new OkHttpClient();
  }

  public Response post(Request request) throws IOException {
    Response response = client.newCall(request).execute();
    return response;
  }
}
