package com.tamercankacak.schedulebot.Client;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class BaseClient {
  private OkHttpClient client;
  public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

  public BaseClient() {
    client = new OkHttpClient();
  }

  protected Response post(String url, String json) throws IOException {
    RequestBody body = RequestBody.create(json, JSON); // new
    Request request = new Request.Builder().url(url).post(body).build();
    Response response = client.newCall(request).execute();
    return response;
  }
}
